package Ejercicios.OperacionesConEnteros;

import java.util.ArrayList;
import java.util.List;

public class Test3 {

	public static void main(String[] args) {

		List<Integer> listaEnteros = new ArrayList<>();
		listaEnteros.add(1);
		listaEnteros.add(10);
		listaEnteros.add(20);
		listaEnteros.add(30);
		listaEnteros.add(40);

		listaEnteros = actualiza(listaEnteros, w -> w * w);
		for (Integer a : listaEnteros) {
			System.out.println(a);
		}
	}

	private static List<Integer> actualiza(List<Integer> listaEnteros, EntraIntSaleInt interfaz) {
		List<Integer> arrayEnteros = new ArrayList<>();

		for (Integer i = 0; i < listaEnteros.size(); i++) {
			arrayEnteros.add(interfaz.operacion(listaEnteros.get(i)));
		}

		return arrayEnteros;
	}

}
