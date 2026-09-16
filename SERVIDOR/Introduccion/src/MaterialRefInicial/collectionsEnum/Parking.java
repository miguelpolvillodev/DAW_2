package MaterialRefInicial.collectionsEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Parking {

	private String nombre;
	private Integer totalPlazas;
	private List<Coche> listaCoches;
	private Map<Color, Integer> mapaColores;

	public Parking(String nombre, Integer totalPlazas) {
		this.nombre = nombre;
		this.totalPlazas = totalPlazas;
		this.listaCoches = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getTotalPlazas() {
		return totalPlazas;
	}

	public void setTotalPlazas(Integer totalPlazas) {
		this.totalPlazas = totalPlazas;
	}

	public List<Coche> getListaCoches() {
		return listaCoches;
	}

	public void setListaCoches(List<Coche> listaCoches) {
		this.listaCoches = listaCoches;
	}

	public boolean entraCoche(Coche c) {
		if (totalPlazas < listaCoches.size() && !listaCoches.contains(c)) {
			return true;
		}
		return false;
	}

	public boolean saleCoche(Coche c) {
		if (!listaCoches.contains(c) || totalPlazas == 0) {
			return false;
		}
		return true;

	}

	public boolean saleCocheAlteatorio() {
		if (totalPlazas == 0) {
			return false;
		}

		return true;
	}

	public boolean vaciaParking() {
		if (totalPlazas == 0) {
			return false;
		}
		listaCoches.clear();
		return true;
	}

	public void reportParking() {
		for (Coche c : listaCoches) {
			System.out.println(c.toString());
		}
	}

	@Override
	public String toString() {
		return "Parking: " + nombre;
	}

}
