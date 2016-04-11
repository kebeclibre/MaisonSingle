import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class House {
    
	private Address address;
	private Valeur valeur;
	private int surface;
	private byte sdb;
	private byte otherRoom;
	private byte totalRooms;
	private boolean terrace;
	private boolean balcon;
	private ArrayList<HousePart> houseParts=new ArrayList<HousePart>();
	private byte sdbCounter;
	private byte oRCounter;
	private byte balconCounter;
	
	
// Constructeurs
	
	public House(byte otherRoom, byte sdb, int prix) {
		//this.setOtherRoom(otherRoom);
		//this.setSdb(sdb);
		for (int i=0; i<otherRoom; i++) {
			houseParts.add(new OtherRoom());
		}
		for (int i=0; i<sdb; i++) {
			houseParts.add(new Sdb());
		}
		valeur= new Valeur(prix);
		address = new Address();
		countHouseParts();
		}
	
	public House(byte otherRoom, byte sdb, int prix, boolean terrace, boolean balcon) {
		this(otherRoom,sdb,prix);
		this.terrace=terrace;
		this.balcon=balcon;
	}

	public House(byte otherRoom, byte sdb, int prix, String rue, String numero, String postCode, String commune) {
		this(otherRoom, sdb, prix);
		address.setRue(rue);
		address.setNumero(numero);
		address.setPostCode(postCode);
		address.setCommune(commune);
	}
	
	public House(byte otherRoom, byte sdb, int prix, String rue,String numero, String postCode, String commune, String pays) {
		this(otherRoom,sdb,prix,rue,numero,postCode,commune);
		address.setPays(pays);
    	
    }
	
	public String toString() {
		return "Address: "+address.toString()+" // Total Rooms: "+(sdbCounter+oRCounter)+
				" // Price To Pay: "+valeur.toString();
	}
	
	private void updateRooms() {
		totalRooms = (byte) (sdb+otherRoom);
	}
	
//setters ang getters
	
	public void setSdb(byte sdb) {
		if (sdb > 0) {
			this.sdb = sdb;
			updateRooms();
		}else{
			System.out.println("House should have at least 1 sdb");
		}

	}

	public void setOtherRoom(byte otherRoom) {
		if (otherRoom > 1) {
			this.otherRoom = otherRoom;
			updateRooms();
		}else{
			System.out.println("House should have at least 1 other room");
		}
		

	}
	
	public void setSurface(int x, int y) {
		if (x > 0 && y > 0) { surface =x*y; }else{ System.out.println("Error numbers invalid"); }
	}
	
	public void setTerrace(boolean terrace) {
		this.terrace = terrace;
	}

	public void setBalcon(boolean balcon) {
		this.balcon = balcon;
	}

	// operations on Address	
	public long actualValue(byte years) {
		return valeur.actualiz(years, this.surface, this.balcon, this.terrace);
	}

	private void changeRue(String rue) {
		address.setRue(rue);
	}
	
	private void changeNumero(String numero) {
		address.setNumero(numero);
	}

	private void changeCommune(String commune) {
		address.setCommune(commune);
	}
	
	private void changepostCode(String postCode) {
		address.setPostCode(postCode);
	}
	
	private void changePays(String pays) {
		address.setPays(pays);
	}
	
	public void changeAddress(String rue, String numero, String postCode, String commune) {
		changeRue(rue);
		changeNumero(numero);
		changepostCode(postCode);
		changeCommune(commune);
	}
	
	public void changeAddress(String rue, String numero, String postCode, String commune, String pays) {
		changeAddress(rue,numero,postCode,commune);
		changePays(pays);
	}
// interface surface
	public void askSurface() {
		System.out.print("Choose x: ");
		String xS = System.console().readLine();
		System.out.print("Choose y: ");
		String yS = System.console().readLine();
		
		int x = Integer.parseInt(xS);
		int y = Integer.parseInt(yS);
		setSurface(x, y);
		
	}

	public int getPrice() {
		return valeur.getToPay();
	}
	
	private void countHouseParts () {
		for (int i=0; i<this.houseParts.size();i++) {
				if (this.houseParts.get(i) instanceof Sdb) { sdbCounter += 1; }
				else if (this.houseParts.get(i) instanceof OtherRoom){ oRCounter += 1; }
				else if (this.houseParts.get(i) instanceof Balcon){ balconCounter += 1; }
				//else if (this.houseParts.get(i) instanceof Jardin){ jardinCounter += 1; }
			}
		}

}
