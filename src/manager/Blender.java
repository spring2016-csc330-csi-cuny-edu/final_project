package manager;

import java.util.HashMap;
import java.util.Map;

import manager.behavior.Powerable;
import manager.behavior.Scalable;
import manager.behavior.Startable.StartState;

public class Blender extends AbstractAppliance implements Powerable, Scalable
{
	//public static enum BlenderComponent implements ComponentName{MainPower,Speed};
	public static enum PowerComponent implements ComponentName<PowerState>{MainPower};
	public static enum ScalableComponent implements ComponentName<RigidScaleState>{Speed};
	
	protected Blender(){
		super();	
		init();
	}
	protected Blender(String name){
		super(name);
		init();
	}
	
	private void init(){	
		components.put(PowerComponent.MainPower, new Component<PowerState>(PowerState.OFF));
		components.put(ScalableComponent.Speed,  new Component<RigidScaleState>(RigidScaleState.LOW));
	}
		

}

