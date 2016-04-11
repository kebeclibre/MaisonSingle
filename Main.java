public class Main {

	public static void main(String[] args) {
		House myhouse = new House((byte) 2, (byte) 2, 150000);
		System.out.println(myhouse);
		
		System.out.println(myhouse.getPrice());
		System.out.println(myhouse.actualValue((byte)1));
		//myhouse.askSurface();
		myhouse.changeAddress("André Van Hasslet", "23", "1030", "Schaerbeek");
		System.out.println(myhouse);
		//myhouse.valeur.
		
		
		
	}

}
