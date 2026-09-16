package MaterialRefInicial.collectionsEnum;

public class Test {

	public static void main(String[] args) {
		Coche wv1 = new Coche(Marca.WV,Color.AM);
		Coche me1 = new Coche(Marca.ME,Color.AM);
		Coche bm1 = new Coche(Marca.BM,Color.RO);
		Coche wv2 = new Coche(Marca.WV,Color.AM);
		Coche bmw1 = new Coche(Marca.BM,Color.RO);
		
		
		Parking p1 = new Parking("Mi primer Parking", 10);
		
		p1.getListaCoches().add(wv1);
		p1.getListaCoches().add(me1);
		
		
		
		
		System.out.println("LISTADO COCHES \n--------------");
		System.out.println(p1.toString());
		p1.reportParking();
		System.out.println("Total coches: " + p1.getListaCoches().size() + ", plazas libres: " + (p1.getTotalPlazas() - p1.getListaCoches().size()));

	}

}
