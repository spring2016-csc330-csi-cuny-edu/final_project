package manager;

import java.util.HashMap;
import java.util.Map;

import manager.Appliance.ComponentName;
import manager.behavior.Behavior.Button;

public abstract class AbstractAppliance implements Appliance{
	protected int id;
	protected String readableName;
	protected Map<ComponentName,Component> components;
	//public AppInfo info;
	
	AbstractAppliance(){
		init(ApplianceManager.getNextId(),"");
	}
	
	AbstractAppliance(String readableName){
		init(ApplianceManager.getNextId(),readableName);
	}
	
	private void init(int id, String readableName){
		this.id = id;
		this.readableName = readableName;
		this.components = new HashMap<ComponentName,Component>();
		//this.info = new AppInfo((Class<Appliance>) this.getClass());
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
	
	/*
	public AppInfo getAppInfo(){
		return info;
	}*/
}
