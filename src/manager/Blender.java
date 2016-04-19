package manager;
import manager.behavior.Button;
import manager.behavior.Powerable;
import manager.behavior.Scalable;

public class Blender extends AbstractAppliance implements Powerable, Scalable
{	
	protected PowerableAttr mainPower;
	protected ScaleableAttr speed;
	
	protected Blender(){
		super();	
		init();
	}
	protected Blender(String name){
		super(name);
		init();
	}
	
	private void init(){
		mainPower = new PowerableAttr();
		speed = new ScaleableAttr();
		
		mainPower.state = PowerState.OFF;
		speed.state = RigidScaleState.LOW;
	}
	
	public void pushButton(Button button) {
		if (button instanceof PowerState)
			System.out.println("power");//changeState(mainPower, (PowerState) button);
		if (button instanceof Scalable);
			System.out.println("sclae");//changeState(speed, (ScaleState) button);
	}


	public void changeState(PowerableAttr attr, PowerState state) {
		attr.state = state;
		System.out.println("power " + state);
	}

	public void changeState(ScaleableAttr attr, ScaleState state) {
		attr.state = state;
		System.out.println("scaleable " + state);
	}
	
}

