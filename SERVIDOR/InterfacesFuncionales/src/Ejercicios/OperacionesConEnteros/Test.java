package Ejercicios.OperacionesConEnteros;

public class Test {

	public static void main(String[] args) {
		
		System.out.println("Interfaces");
		EntraIntSaleInt iCuadrado = w -> w * w;
		EntraIntSaleInt iCubo = w -> w * w * w;
		EntraIntSaleInt iDoble = w -> 2 * w;
		EntraIntSaleInt iTriple = w -> 3 * w;
		EntraIntSaleInt iPolinomio = w -> (5 * w * w * w) + (7 * w * w) + 9;
		EntraVariosIntSaleInt iPolinomioVariable = (a, x, b, c) -> (a * x * x * x) + (b * x * x) + c;

		System.out.println(iCuadrado.operacion(5));
		System.out.println(iCubo.operacion(5));
		System.out.println(iDoble.operacion(5));
		System.out.println(iTriple.operacion(5));
		System.out.println(iPolinomio.operacion(5));
		System.out.println(iPolinomioVariable.operacion2(5, 2, 8, 3));

		System.out.println("------------");

		Integer a = 5;
		int b = 8;
		int x = 2;
		int c = 3;

		System.out.println(cuadrado(a));
		System.out.println(cubo(a));
		System.out.println(doble(a));
		System.out.println(triple(a));
		System.out.println(polinomio(a));
		System.out.println(polinomioVariable(a, x, b, c));

	}

	private static Integer cuadrado(int a) {
		Integer res = 0;
		res = (int) Math.pow(a, 2);
		return res;
	}

	private static Integer cubo(int a) {
		Integer res = 0;
		res = (int) Math.pow(a, 3);
		return res;
	}

	private static Integer doble(int a) {
		Integer res = 0;
		res = a * 2;
		return res;
	}

	private static Integer triple(int a) {
		Integer res = 0;
		res = a * 3;
		return res;
	}

	private static Integer polinomio(int a) {
		double res = 0;
		res = (5 * cubo(a)) + (7 * cuadrado(a)) + 9;
		return (int) res;
	}

	private static Integer polinomioVariable(int a, int x, int b, int c) {
		double res = 0;
		res = (a * cubo(x)) + (b * cuadrado(x)) + c;
		return (int) res;
	}

}
