package MaterialRefInicial.collectionsEnum;

public class Coche {

	private Marca marcaE;
	private Color colorE;
	
	public Coche(Marca marcaE, Color colorE) {
		this.marcaE = marcaE;
		this.colorE = colorE;
	}

	public Marca getMarcaE() {
		return marcaE;
	}

	public void setMarcaE(Marca marcaE) {
		this.marcaE = marcaE;
	}

	public Color getColorE() {
		return colorE;
	}

	public void setColorE(Color colorE) {
		this.colorE = colorE;
	}

	@Override
	public String toString() {
		return "Coche: " + marcaE + " " + colorE;
	}
	
	
	
	
}
