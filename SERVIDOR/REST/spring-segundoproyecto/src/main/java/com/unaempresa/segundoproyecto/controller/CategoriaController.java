package com.unaempresa.segundoproyecto.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unaempresa.segundoproyecto.entity.Categoria;
import com.unaempresa.segundoproyecto.service.ICategoriaService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final ICategoriaService categoriaService;

    @ModelAttribute(name = "titulo")
    public String titulo() {
        return "Categorías";
    }

    public CategoriaController(ICategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/lista")
    public String lista(@RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "10") int size,
                        Model model) {
        Page<Categoria> pagina = categoriaService.findAllPaginado(PageRequest.of(page, size));
        model.addAttribute("cabecera", "Listado de todas las categorías");
        model.addAttribute("intro", "Esta es la lista de todas las categorías:");
        model.addAttribute("categorias", pagina);
        return "categoria/listado";
    }

    @GetMapping("/id/{id}")
    public String elementoPorId(Model model, @PathVariable Long id) {
        model.addAttribute("cabecera", "Información de categoría");
        model.addAttribute("categoria", categoriaService.findById(id));
        model.addAttribute("productos", categoriaService.findProductosByCategoria(id));
        return "categoria/una-categoria";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("cabecera", "Nueva categoría");
        model.addAttribute("categoria", new Categoria());
        return "categoria/form";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Categoria categoria, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("cabecera", "Nueva categoría");
            return "categoria/form";
        }
        categoriaService.save(categoria);
        return "redirect:/categorias/lista";
    }
}
