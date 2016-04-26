package manager;

import java.util.HashMap;
import java.util.Map;

import manager.Appliance.ComponentName;
import manager.behavior.Behavior.Button;

abstract class AbstractAppliance implements Appliance{
	protected int id;
	protected String readableName;
	protected Map<ComponentName,Component> components;
	
	AbstractAppliance(){
		init(ApplianceManager.getNextId(),"");
	}
	
	AbstractAppliance(String readableName){
		init(ApplianceManager.getNextId(),readableName);
	}
	
	private void init(int id, String readableName){
		this.id = id;
		this.readableName = readableName;
		components = new HashMap<ComponentName,Component>();
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
	
	
	public <T extends Button> void pushButton(T button, Component<T> component) {
		if (component==null)return;
		component.changeState(button);
	}
	
	public <T extends Button> Component<T> getComponent(ComponentName<T> ac){
		return (Component<T>) components.get(ac);
	}
}
