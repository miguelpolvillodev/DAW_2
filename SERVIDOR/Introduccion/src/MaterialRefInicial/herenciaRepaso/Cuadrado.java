package MaterialRefInicial.herenciaRepaso;

public class Cuadrado extends Figura {

	private int lado;

	public Cuadrado(String color, int lado) {
		super(color);
		this.lado = lado;
	}

	public int getLado() {
		return this.lado;
	}
	
	
	public void setLado(int lado) {
		this.lado = lado;
	}

	@Override
	public double area() {
		double res = 0;
		int ladosTotal = 4;

		res = this.lado * ladosTotal;
		return res;
	}

	@Override
	public double perimetro() {
		double res = 0;

		res = lado * lado;
		return res;
	}

	@Override
	public String toString() {

		return "Cuadrado de lado: " + lado;
	}

}
