package manager;


import manager.behavior.Powerable;
import manager.behavior.Scalable;
import manager.behavior.Schedulable;

public class Light extends AbstractAppliance implements Powerable, Scalable, Schedulable{
	public static enum PowerComponent implements ComponentName<PowerState>{
		MainPower;
	public Class<PowerState> type() {
		return PowerState.class;
	}};
	
	public static enum ScalableComponent implements ComponentName<RigidScaleState>{
		Luminence;
	public Class<RigidScaleState> type() {
		return RigidScaleState.class;
	}};
	
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

	public boolean fireEvent(EventPackage event) {
		if (!(event instanceof AppEventPackage))
			return false;
		this.pushButton(((AppEventPackage)event).button, this.getComponent(((AppEventPackage)event).cname));
		return true;
	}
}
