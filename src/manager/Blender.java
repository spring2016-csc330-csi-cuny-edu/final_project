package manager;

import manager.behavior.Powerable;
import manager.behavior.Scalable;
import manager.behavior.Startable;

public class Blender extends AbstractAppliance implements Powerable, Scalable
{
	public static enum PowerComponent implements ComponentName<PowerState>{
		MainPower;
		public Class<PowerState> type() {
			return PowerState.class;
		}
	};
	public static enum ScalableComponent implements ComponentName<RigidScaleState>{
		Speed;
		public Class<RigidScaleState> type() {
			return RigidScaleState.class;
		}
	};
	
	Blender(){
		super();	
		init();
	}
	Blender(String name){
		super(name);
		init();
	}
	
	void init(){	
		components.put(PowerComponent.MainPower, new Component<PowerState>(PowerState.OFF));
		components.put(ScalableComponent.Speed,  new Component<RigidScaleState>(RigidScaleState.LOW));
	}
		

}

