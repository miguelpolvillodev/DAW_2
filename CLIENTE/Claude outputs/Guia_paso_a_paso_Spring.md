# Guía paso a paso · Spring Boot + JPA (para mecanizar)

Ejemplo con `Pelicula`. El día del examen cambia el tema: sustituye Pelicula → tu entidad, Genero → tu enum, `enCartelera` → tu boolean. **La estructura es siempre la misma.**

**Reglas de oro**
1. Una sola cosa por vez y **arranca la app tras cada parte**.
2. Solo puedes usar las anotaciones del listado. **No existe `@RequestMapping`**: escribe la ruta completa en cada `@GetMapping`/`@PostMapping`.
3. Orden de trabajo: 0 → 1 → 2 → 3 → 4 → 5 → 6 → 7 (base, ~75 min). Solo con la base ≥ 4,5 entran las opciones: 8 → 9 → 12 → 10 → 11.
4. Tras cada parte, mira la **consola**: si arranca, vas bien; si falla, el error está en las primeras líneas de `Caused by`.

---

## Parte 0 · Puesta en marcha (0,5)
1. start.spring.io → **Maven · Java · Spring Boot (la estable) · Jar · Java 21**.
2. Group `com.ejemplo`, Artifact `cine` (el nombre del enunciado) → el paquete base queda `com.ejemplo.cine`.
3. Dependencias: **Spring Web, Thymeleaf, Spring Data JPA, H2 Database, Validation, Spring Boot DevTools**.
4. Generar, descomprimir, abrir en el IDE, esperar a Maven y ejecutar la clase con `@SpringBootApplication`.
5. Dentro de `com.ejemplo.cine` crea los paquetes: `model`, `repository`, `service`, `controller`.
6. Crea ya las carpetas `templates/pelicula/` y `templates/fragmentos/`.

## Parte 1 · Entidad y conexión (1)
**1. Enum** (`model/Genero.java`):
```java
public enum Genero { ACCION, COMEDIA, DRAMA, TERROR, FANTASIA }
```
**2. Entidad** (`model/Pelicula.java`), un campo por cada columna del enunciado:
```java
@Entity
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // IDENTITY: si no, import.sql falla
    private Long id;
    private String titulo;
    private int anio;
    private long recaudacion;
    private boolean enCartelera;
    @Enumerated(EnumType.STRING)                          // "guardar como texto"
    private Genero genero;
    // constructor vacío + getters y setters de TODOS los campos (Alt+Insert / generar)
}
```
- `enCartelera` se convierte solo en la columna `en_cartelera`. El SQL del enunciado ya usa ese nombre.
- `GenerationType` y `EnumType` no están en el listado, pero se importan solos con `@GeneratedValue` / `@Enumerated`. Si dudas, `@GeneratedValue` a secas también vale con H2, pero entonces comprueba que el import carga.

**3. `application.properties`**:
```properties
spring.datasource.url=jdbc:h2:mem:cinedb
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
spring.h2.console.enabled=true
spring.jpa.properties.hibernate.hbm2ddl.charset_name=UTF-8
```
(`create` = se recrea en cada arranque · `show-sql` = SQL en consola · la última línea evita que `ú`/`ñ` salgan rotos.)

**4. `src/main/resources/import.sql`** (aquí está la trampa: el SQL del enunciado no vale tal cual):
- **Un INSERT por línea**, cada uno terminado en `;`. El INSERT con varias filas repartido en varias líneas puede fallar al cargar.
```sql
INSERT INTO pelicula (titulo, anio, recaudacion, en_cartelera, genero) VALUES ('La última frontera', 2019, 412000000, false, 'ACCION');
INSERT INTO pelicula (titulo, anio, recaudacion, en_cartelera, genero) VALUES ('Cena para once', 2022, 58000000, true, 'COMEDIA');
-- ...una línea por película
```

## Parte 2 · Verificar la base de datos (0,5)
1. Arranca y abre `http://localhost:8080/h2-console`.
2. **JDBC URL** = exactamente la de tu properties (`jdbc:h2:mem:cinedb`), usuario `sa`, contraseña vacía → Connect.
3. `SELECT * FROM PELICULA;` → deben salir las 10.
4. Si sale vacía: revisa el nombre del fichero (`import.sql`, en `resources`, no dentro de una subcarpeta), `ddl-auto=create` y los nombres de columna.

## Parte 3 · Repositorio y servicio (1)
**Repositorio:**
```java
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> { }
```
**Interfaz:**
```java
public interface IPeliculaService {
    List<Pelicula> dameTodas();
    Pelicula damePorId(Long id);
    void guardar(Pelicula pelicula);
    void borrarPorId(Long id);
}
```
**Implementación completa** (`@Service`, el repositorio `protected` para que lo use la hija):
```java
@Service
public class PeliculaServiceImpl implements IPeliculaService {
    @Autowired
    protected PeliculaRepository repo;
    public List<Pelicula> dameTodas() { return repo.findAll(); }
    public Pelicula damePorId(Long id) { return repo.findById(id).orElse(null); }
    public void guardar(Pelicula p) { repo.save(p); }
    public void borrarPorId(Long id) { repo.deleteById(id); }
}
```
**Segunda implementación** (hereda todo, solo cambia `dameTodas`):
```java
@Service
public class PeliculaServiceCarteleraImpl extends PeliculaServiceImpl {
    @Override
    public List<Pelicula> dameTodas() { return repo.findByEnCarteleraTrue(); }
}
```
Y en el repositorio añade: `List<Pelicula> findByEnCarteleraTrue();`

**Controlador:**
```java
@Controller
public class PeliculaController {
    @Autowired
    @Qualifier("peliculaServiceImpl")      // nombre de la clase con la primera letra en minúscula
    private IPeliculaService servicio;
}
```
- Sin `@Qualifier` → *NoUniqueBeanDefinitionException* (dos candidatos).
- El nombre del bean es el de la clase en minúscula inicial: `peliculaServiceImpl`.

## Parte 4 · Listado y ficha (1)
**Controlador:**
```java
@GetMapping("/peliculas")
public String listar(Model model) {
    model.addAttribute("peliculas", servicio.dameTodas());
    return "pelicula/listado";
}

@GetMapping("/peliculas/{id}")
public String ficha(@PathVariable Long id, Model model) {
    model.addAttribute("pelicula", servicio.damePorId(id));
    return "pelicula/ficha";
}
```
**`templates/pelicula/listado.html`** (todas las plantillas empiezan igual):
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head><meta charset="UTF-8"><title>Películas</title></head>
<body>
<h1>Películas</h1>
<table border="1">
  <tr><th>Título</th><th>Año</th><th>Género</th><th>Recaudación</th><th>En cartelera</th><th></th><th></th></tr>
  <tr th:each="p : ${peliculas}">
    <td><a th:href="@{/peliculas/{id}(id=${p.id})}" th:text="${p.titulo}"></a></td>
    <td th:text="${p.anio}"></td>
    <td th:text="${p.genero}"></td>
    <td th:text="${p.recaudacion}"></td>
    <td th:text="${p.enCartelera} ? 'Sí' : 'No'"></td>
    <td><a th:href="@{/peliculas/editar/{id}(id=${p.id})}">Editar</a></td>
    <td>
      <form th:action="@{/peliculas/borrar/{id}(id=${p.id})}" method="post">
        <button type="submit">Borrar</button>
      </form>
    </td>
  </tr>
</table>
<a th:href="@{/peliculas/nueva}">Nueva película</a>
</body>
</html>
```
**`ficha.html`** (cuerpo):
```html
<h1 th:text="${pelicula.titulo}"></h1>
<p>Año: <span th:text="${pelicula.anio}"></span></p>
<p>Género: <span th:text="${pelicula.genero}"></span></p>
<p>Recaudación: <span th:text="${pelicula.recaudacion}"></span> €</p>
<p th:if="${pelicula.enCartelera}">Esta película está en cartelera.</p>
<p th:unless="${pelicula.enCartelera}">Esta película ya no está en cartelera.</p>
<a th:href="@{/peliculas}">Volver</a>
```

## Parte 5 · Borrar (0,5)
El botón ya está en el listado (formulario con `method="post"`). Controlador:
```java
@PostMapping("/peliculas/borrar/{id}")
public String borrar(@PathVariable Long id) {
    servicio.borrarPorId(id);
    return "redirect:/peliculas";
}
```

## Parte 6 · Crear (0,75)
**Controlador:**
```java
@GetMapping("/peliculas/nueva")
public String nueva(Model model) {
    model.addAttribute("pelicula", new Pelicula());
    model.addAttribute("generos", Genero.values());
    return "pelicula/formulario";
}

@PostMapping("/peliculas/guardar")
public String guardar(@ModelAttribute Pelicula pelicula) {
    servicio.guardar(pelicula);
    return "redirect:/peliculas";
}
```
**`formulario.html`** (cuerpo; sirve para crear y editar):
```html
<form th:action="@{/peliculas/guardar}" th:object="${pelicula}" method="post">
  <input type="hidden" th:field="*{id}">
  <p>Título: <input type="text" th:field="*{titulo}"></p>
  <p>Año: <input type="number" th:field="*{anio}"></p>
  <p>Recaudación: <input type="number" th:field="*{recaudacion}"></p>
  <p>Género:
    <select th:field="*{genero}">
      <option value="">-- elige --</option>
      <option th:each="g : ${generos}" th:value="${g}" th:text="${g}"></option>
    </select>
  </p>
  <p><input type="checkbox" th:field="*{enCartelera}"> En cartelera</p>
  <button type="submit">Guardar</button>
</form>
```
- La opción vacía `value=""` es la que hace saltar el `@NotNull` después.
- `th:field` pone solo `name`, `id` y `value`: no los escribas a mano.

## Parte 7 · Editar (0,75)
Solo un método nuevo; el formulario y el `guardar` son los mismos:
```java
@GetMapping("/peliculas/editar/{id}")
public String editar(@PathVariable Long id, Model model) {
    model.addAttribute("pelicula", servicio.damePorId(id));
    model.addAttribute("generos", Genero.values());
    return "pelicula/formulario";
}
```
- Edita en lugar de crear porque el **id oculto** viaja con el formulario: con id, `save` actualiza; sin id, inserta.

---

## Parte 8 · Validación (1,5)
**1. Anotaciones en la entidad:**
```java
@NotBlank
@Size(min = 2, max = 60)
private String titulo;
@Min(1888)
private int anio;
@PositiveOrZero
private long recaudacion;
@NotNull
private Genero genero;
```
**2. Controlador:** `@Valid` + `BindingResult` **justo después** del objeto.
```java
@PostMapping("/peliculas/guardar")
public String guardar(@Valid @ModelAttribute Pelicula pelicula, BindingResult result, Model model) {
    if (result.hasErrors()) {
        model.addAttribute("generos", Genero.values());   // se pierde al volver: ponlo otra vez
        return "pelicula/formulario";
    }
    servicio.guardar(pelicula);
    return "redirect:/peliculas";
}
```
**3. Mensaje junto a cada campo** (misma línea para titulo, anio, recaudacion, genero):
```html
<span th:if="${#fields.hasErrors('titulo')}" th:errors="*{titulo}" style="color:red;font-size:small"></span>
```
Fallos típicos: `BindingResult` en otra posición (da error al enviar) · olvidar `generos` en la rama de error (el select sale vacío o da error) · no poner `th:object` en el form.

## Parte 9 · Filtro (1)
**1. Repositorio** (nombres exactos de campos, Spring genera la consulta):
```java
List<Pelicula> findByGenero(Genero genero);
List<Pelicula> findByGeneroAndEnCarteleraTrue(Genero genero);
// findByEnCarteleraTrue() ya lo tienes de la parte 3
```
**2. Servicio:** añade a la interfaz `List<Pelicula> filtrar(Genero genero, boolean soloCartelera);` e impleméntalo en `PeliculaServiceImpl`:
```java
public List<Pelicula> filtrar(Genero genero, boolean soloCartelera) {
    if (genero != null && soloCartelera) return repo.findByGeneroAndEnCarteleraTrue(genero);
    if (genero != null) return repo.findByGenero(genero);
    if (soloCartelera) return repo.findByEnCarteleraTrue();
    return repo.findAll();
}
```
**3. Controlador:** sustituye el `listar` de la parte 4.
```java
@GetMapping("/peliculas")
public String listar(@RequestParam(required = false) Genero genero,
                     @RequestParam(defaultValue = "false") boolean soloCartelera,
                     Model model) {
    model.addAttribute("peliculas", servicio.filtrar(genero, soloCartelera));
    model.addAttribute("generos", Genero.values());
    return "pelicula/listado";
}
```
**4. Formulario encima de la tabla** (GET, sin `th:object`):
```html
<form th:action="@{/peliculas}" method="get">
  <select name="genero">
    <option value="">Todos</option>
    <option th:each="g : ${generos}" th:value="${g}" th:text="${g}"></option>
  </select>
  <input type="checkbox" name="soloCartelera" value="true"> Solo en cartelera
  <button type="submit">Filtrar</button>
</form>
<p th:if="${peliculas.isEmpty()}">No hay películas con ese filtro.</p>
```
- «Todos» envía `genero=` vacío → llega `null` (por eso `required = false`).
- Comprueba con la URL: `/peliculas?genero=TERROR&soloCartelera=true`.
- (Si en el enunciado se pide sin tocar la interfaz, llama al repositorio desde el controlador con otro `@Autowired`; pero lo limpio es el servicio.)

## Parte 12 · Pie común (0,5) — hazlo antes que logo y estilos
**`templates/fragmentos/comun.html`:**
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<body>
  <footer th:fragment="pie">Cine Nova · Entradas en taquilla · Curso 2026/2027</footer>
</body>
</html>
```
**En las tres plantillas**, antes de `</body>`:
```html
<div th:replace="~{fragmentos/comun :: pie}"></div>
```
(`fragmentos/comun` = ruta bajo `templates` sin `.html` · `pie` = nombre del `th:fragment`.)

## Parte 10 · Logo (0,5)
1. Descomprime el zip y copia `logo.png` a `src/main/resources/static/img/`.
2. En el `<body>` de las tres plantillas, arriba: `<img th:src="@{/img/logo.png}" alt="Logo">`.
3. Prueba directa: `http://localhost:8080/img/logo.png` debe mostrar la imagen.

## Parte 11 · Estilos (0,5)
1. Crea `src/main/resources/static/css/estilos.css`: `h1 { color: red; }`
2. En el `<head>` de las tres plantillas: `<link rel="stylesheet" th:href="@{/css/estilos.css}">`
3. Si no cambia: `Ctrl+F5` o abre `http://localhost:8080/css/estilos.css`.

---

## Checklist final (5 min antes de entregar)
- [ ] Arranca sin errores y `/peliculas` muestra las 10.
- [ ] Ficha, borrar, crear y editar funcionan (editar **no** duplica).
- [ ] Formulario vacío → 4 mensajes rojos y pequeños; no guarda.
- [ ] Filtro `TERROR` + cartelera → solo *Casa sin puertas*; filtro imposible → mensaje.
- [ ] Logo, CSS y pie en **las tres** páginas.
- [ ] `.zip` del proyecto **sin la carpeta `target`**.

## Errores que más tiran puntos
| Síntoma | Causa |
|---|---|
| `NoUniqueBeanDefinitionException` | Falta `@Qualifier` en el controlador |
| H2 sin datos / error al arrancar | `import.sql` mal ubicado, INSERT en varias líneas o columnas mal escritas |
| `null identifier` al cargar | Falta `strategy = GenerationType.IDENTITY` |
| Whitelabel 404 en una ruta | Ruta mal escrita en el `@GetMapping` o plantilla en carpeta equivocada |
| Whitelabel 500 «template might not exist» | `return "pelicula/listado"` no coincide con la ruta bajo `templates` |
| Editar crea otra película | Falta el `<input type="hidden" th:field="*{id}">` |
| Formulario roto tras error de validación | Falta volver a poner `generos` en el model |
| Validación nunca salta | `BindingResult` no está justo detrás de `@Valid ... Pelicula` |

## Para mecanizarlo
Repite 3 veces **desde cero y sin mirar**, cronometrando: la 1.ª con esta guía abierta, la 2.ª con solo el listado de anotaciones y la 3.ª cambiando el dominio (otra entidad, otro enum, otros campos). Objetivo: base completa en menos de 75 min.
