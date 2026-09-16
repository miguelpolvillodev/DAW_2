package herenciaRepaso;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--CUADRADO--");
		Cuadrado c1 = new Cuadrado("Azul", 5);

		System.out.println("Area " + c1.area());
		System.out.println("Perimetro " + c1.perimetro());

		System.out.println("--RECTÁNGULO--");
		Rectangulo r1 = new Rectangulo("Verde", 5, 2);

		System.out.println("Area " + r1.area());
		System.out.println("Perimetro " + r1.perimetro());

		System.out.println("--CIRCULO--");
		Circulo cir1 = new Circulo("Rojo", 4);

		System.out.println("Area " + cir1.area());
		System.out.println("Perimetro " + cir1.perimetro());
	}

}
