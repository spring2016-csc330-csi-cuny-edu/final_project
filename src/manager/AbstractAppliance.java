package manager;

public abstract class AbstractAppliance implements Appliance{
	protected int id;
	protected String readableName;
	
	public AbstractAppliance(){
		init(ApplianceManager.getNextId(),"");
	}
	
	public AbstractAppliance(String readableName){
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
	
	
	public void pushButton(manager.behavior.Behavior.Button button, Component component) {
		component.changeState(button);
		//if (button instanceof PowerState);
		//else if (button instanceof Scalable);
		//else
		//	System.out.println("invalid button: " + button);
	}
}
