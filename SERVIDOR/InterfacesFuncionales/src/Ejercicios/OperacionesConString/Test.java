package Ejercicios.OperacionesConString;

public class Test {

	public static void main(String[] args) {

		InterfaceStringBoolean cadenasIguales = (s1, s2) -> s1.equals(s2);
		System.out.println(cadenasIguales.comparar("hola", "Hola"));

		InterfaceStringBoolean iContiene = (s1, s2) -> s1.contains(s2);
		System.out.println(iContiene.comparar("hola", "o"));

		InterfaceStringBoolean iCaracteresMenorTres = (s1, s2) -> s1.length() < 3 && s2.length() < 3;
		System.out.println(iCaracteresMenorTres.comparar("ho", "ho"));

		InterfaceStringBoolean iEmpiezaPor = (s1, s2) -> s1.startsWith("A") && s2.startsWith("A");
		System.out.println(iEmpiezaPor.comparar("Adios", "hola"));

		InterfaceStringBoolean iTerminaPor = (s1, s2) -> s1.endsWith(".") && s2.endsWith(".");
		System.out.println(iTerminaPor.comparar("Adios.", "Hola"));

		String charact = "b";
		InterfaceStringBoolean iTerminaPorCaracter = (s1, s2) -> s1.endsWith(charact) && s2.endsWith(charact);
		System.out.println(iTerminaPorCaracter.comparar("Holab", "uyb"));

	}

}
