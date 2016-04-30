package manager;

import java.util.HashMap;
import java.util.Map;

import manager.behavior.Behavior.Button;

/**
 * Implements most methods outlined in {@link Appliance}.
 * Maps ComponentName to Component.
 * Uses id as unique identifier.
 * @see Component
 */
public abstract class AbstractAppliance implements Appliance{
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
		this.components = new HashMap<ComponentName,Component>();
	}
	
	public String getReadableName() {
		return readableName;
	}
	
	public int getId(){
		return id;
	}
	
	/**
	 * Test if id's are equal
	 */
	public boolean equals(Appliance other) {
		return this.id == other.getId();
	}
	
	/**
	 * An example of the correct way to use pushButton would be
	 * pushing OFF on your MainPower
	 * @param button button to be pushed
	 * @param component Component button can be found on
	 */
	public <T extends Button> void pushButton(T button, Component<T> component) {
		if (component==null)return;
		component.changeState(button);
	}
	
	public <T extends Button> Component<T> getComponent(ComponentName<T> cname){
		return (Component<T>) components.get(cname);
	}
}
