package manager;


import manager.behavior.Powerable;
import manager.behavior.Scalable;
import manager.behavior.Schedulable;

public class Light extends AbstractAppliance implements Powerable, Scalable, Schedulable{
	public static enum PowerComponent implements ComponentName<PowerState>{MainPower};
	public static enum ScalableComponent implements ComponentName<RigidScaleState>{Luminence};
	
	Light(){
		super();	
		init();
	}
	Light(String name){
		super(name);
		init();
	}
	
	protected void init(){
		components.put(PowerComponent.MainPower, new Component<PowerState>(PowerState.OFF));
		components.put(ScalableComponent.Luminence,  new Component<RigidScaleState>(RigidScaleState.HIGH));		
	}

	public boolean fireEvent(Object event) {
		if (!(event instanceof EventPackage))
			return false;
		this.pushButton(((EventPackage)event).button, this.getComponent(((EventPackage)event).cname));
		return true;
	}
}
