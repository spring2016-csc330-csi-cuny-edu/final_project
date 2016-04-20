package manager;

import java.util.HashMap;
import java.util.Map;

import manager.behavior.Powerable;
import manager.behavior.Scalable;

public class Blender extends AbstractAppliance implements Powerable, Scalable
{
	public static enum BlenderComponent implements ApplianceComponent{MainPower,Speed};
	protected Map<BlenderComponent,Component> components;
	
	protected Blender(){
		super();	
		init();
	}
	protected Blender(String name){
		super(name);
		init();
	}
	
	private void init(){	
		components = new HashMap();
		components.put(BlenderComponent.MainPower, new Component<PowerState>(PowerState.OFF));
		components.put(BlenderComponent.Speed,  new Component<RigidScaleState>(RigidScaleState.LOW));
	}
	
	public Component getComponent(ApplianceComponent ac){
		return components.get(ac);
	}
		
	//public void pushButton(Button button, Component component) {
	//	component.changeState(button);
		//if (button instanceof PowerState);
		//else if (button instanceof Scalable);
		//else
		//	System.out.println("invalid button: " + button);
	//}

	
}

