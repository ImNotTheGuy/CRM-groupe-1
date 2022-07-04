package model;

public class Orders {

	private long id;
	private Client client;
	private String typePresta;
	private String designation;
	private int nbDays;
	private float unitPrice;
	private int state;
	private float totalExcludeTaxe;
	private float totalWithTaxe;

	public Orders() {
	}

	public Orders(Client client, String typePresta, String designation, int nbDays, 
	float unitPrice, int state, float totalExcludeTaxe, float totalWithTaxe) {
		this.client = client;
		this.typePresta = typePresta;
		this.designation = designation;
		this.nbDays = nbDays;
		this.unitPrice = unitPrice;
		this.state = state;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getTypePresta() {
		return typePresta;
	}

	public void setTypePresta(String typePresta) {
		this.typePresta = typePresta;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getNbDays() {
		return nbDays;
	}

	public void setNbDays(int nbDays) {
		this.nbDays = nbDays;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	public float getTotalExcludeTaxe() {
		return totalExcludeTaxe;
	}
	
	public void setTotalExcludeTaxe(float totalExcludeTaxe) {
		this.totalExcludeTaxe = totalExcludeTaxe;
	}

	public float getTotalWithTaxe() {
		return totalWithTaxe;
	}
	
	public void setTotalWithTaxe(float totalWithTaxe) {
		this.totalWithTaxe = totalWithTaxe;
	}

	@Override
	public String toString() {
		return "Orders{" + "id=" + id + ", clientId=" + client + ", typePresta='" + typePresta 
				+ '\'' + ", designation='" + designation + '\'' + ", nbDays=" + nbDays 
				+ ", unitPrice=" + unitPrice + ", state=" + state + ", totalExcludeTaxe=" 
				+ totalExcludeTaxe + ", totalWithTaxe=" + totalWithTaxe + '}';
	}
}