package MaterialRefInicial.mipaquete;

public class App {

	public static void main(String[] args) {
		Counter c1 = new Counter();

		System.out.println(c1);

		c1.increment();
		System.out.println("- Incremento 1 -" + c1);
		c1.increment(10);
		System.out.println("- Incremento 2 - " + c1);
		c1.reset();
		System.out.println("- Reset -" + c1);

	}

}
