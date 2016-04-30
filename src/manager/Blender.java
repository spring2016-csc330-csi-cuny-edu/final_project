package manager;

import manager.behavior.Scalable;
import manager.behavior.Startable;

public class Blender extends AbstractAppliance implements Startable, Scalable
{
	public static enum StartableComponent implements ComponentName<StartState>{
		StartBlend;
		public Class<StartState> type() {
			return StartState.class;
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
		components.put(StartableComponent.StartBlend, new Component<StartState>(StartState.STOP));
		components.put(ScalableComponent.Speed,  new Component<RigidScaleState>(RigidScaleState.LOW));
	}
		

}

