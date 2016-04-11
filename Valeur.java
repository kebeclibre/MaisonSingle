public class Valeur {
	private int prix;
	private float charge= (float) 0.12;
	private int toPay;
	
	public Valeur(int prix) {
		this.setPrix(prix);
	}
	
	public Valeur(int prix,float charge) {
		this(prix);
		this.charge = charge;
	}

	private void updateToPay () {
		this.toPay=(int) (prix*(1+charge));
	}
	
	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
		updateToPay();
	}

	public int getToPay() {
		return toPay;
	}

	public void setCharge(int charge) {
		this.charge = charge;
		updateToPay();
	}

	public String toString() {
		return toPay+"";
	}
	
	public long actualiz(byte years, int surface, boolean balcon, boolean terrace) {
		float r= (float) 0.7;
		double actualized;
		if (balcon) { r+= (float) 0.4; }
		if (terrace) { r+= (float) 0.3; }
		
		actualized = this.prix * Math.pow(1 + r, years);
		if (surface > 150) { actualized += 120 * years; }
		
		return Math.round(actualized);
		}
		
	}

