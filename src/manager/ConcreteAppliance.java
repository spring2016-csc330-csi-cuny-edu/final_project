package manager;

public abstract class ConcreteAppliance implements Appliance{
	protected int id;
	protected String readableName;
	
	public ConcreteAppliance(){
		init(0,"");
	}
	
	public ConcreteAppliance(String readableName){
		init(ApplianceManager.getNextId(),readableName);
	}
	
	private void init(int id, String readableName){
		this.id = id;
		this.readableName = readableName;
	}
	
	public String getReadableName() {
		return readableName;
	}
	
	public int getId(){
		return id;
	}
	
	public boolean equals(Appliance other) {
		return this.id == other.getId();
	}
}
