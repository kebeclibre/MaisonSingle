public class Address {
    private String rue ;
    private String numero;
    private String postCode;
    private String commune;
    private String pays;
    
    public Address(){}
    
    public Address(String rue,String numero, String postCode, String commune) {
    	this.setRue(rue);
    	this.setNumero(numero);
    	this.setPostCode(postCode);
    	this.setCommune(commune);
    	
    }
    
    public Address(String rue,String numero, String postCode, String commune, String pays) {
    	this(rue,numero,postCode,commune);
    	this.setPays(pays);
    	
    }
    
    
    public void setAddress(String rue, String numero, String postCode, String commune, String pays) {
    	this.setRue(rue);
    	this.setNumero(numero);
    	this.setPostCode(postCode);
    	this.setCommune(commune);
    	this.setPays(pays);
    }

    public String getRue() {
    	return rue;
    }

    public void setRue(String rue) {
    	this.rue = rue;
    }

    public String getNumero() {
    	return numero;
    }

    public void setNumero(String numero) {
    	this.numero = numero;
    }

    public String getPostCode() {
    	return postCode;
    }

    public void setPostCode(String postCode) {
    	this.postCode = postCode;
    }

    public String getCommune() {
    	return commune;
    }

    public void setCommune(String commune) {
    	this.commune = commune;
    }

    public String getPays() {
    	return pays;
    }

    public void setPays(String pays) {
    	this.pays = pays;
    }
    
    public String toString() {
    	return  this.getRue()+", "+this.getNumero()+", "+this.getPostCode()+", "+this.getCommune()+", "+this.getPays();
    }
    
    
    
}
