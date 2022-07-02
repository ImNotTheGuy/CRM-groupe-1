public class Orders{

    private int id;
    private int clientId;
    private String typePresta;
    private String designation;
    private int nbDays;
    private float unitPrice;
    private int state;
    private float totalExcludeTaxe; // no setters because automatically computed
    private float totalWithTaxe;    // no setters because automatically computed

    public Orders(){

    }

    public Orders(
            int clientId,
            String typePresta,
            String designation,
            int nbDays,
            float unitPrice,
            int state
    ){

			this.clientId = clientId;
			this.typePresta = typePresta;
			this.designation = designation;
			this.nbDays = nbDays;
			this.unitPrice = unitPrice;
			this.state = state;
			this.totalExcludeTaxe = nbDays * unitPrice;
			this.totalWithTaxe = nbDays * unitPrice * 1.2;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
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
        return this.nbDays * this.unitPrice;
    }


    public float getTotalWithTaxe() {
        return this.nbDays * this.unitPrice * 1.2;
    }
	
	@Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", typePresta='" + typePresta + '\'' +
                ", designation='" + designation + '\'' +
                ", nbDays=" + nbDays +
                ", unitPrice=" + unitPrice +
                ", state=" + state +
                ", totalExcludeTaxe=" + totalExcludeTaxe +
                ", totalWithTaxe=" + totalWithTaxe +
                '}';
    }
}