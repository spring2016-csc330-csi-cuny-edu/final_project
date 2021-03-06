package manager;

import manager.behavior.Powerable;
import manager.behavior.Startable;

public class CoffeeMaker extends AbstractAppliance implements Powerable, Startable{
	public static enum PowerComponent implements ComponentName<PowerState>{
		MainPower;
		public Class<PowerState> type() {
			return PowerState.class;
		}
	};
	public static enum StartableComponent implements ComponentName<StartState>{
		BeginBrew, Clean;
		public Class<StartState> type() {
			return StartState.class;
		}
	};
	
	CoffeeMaker(){
		super();	
		init();
	}
	CoffeeMaker(String name){	
		super(name);
		init();
	}
	
	private void init(){
		components.put(PowerComponent.MainPower, new Component<PowerState>(PowerState.OFF));
		components.put(StartableComponent.BeginBrew,  new Component<StartState>(StartState.STOP));
		components.put(StartableComponent.Clean,  new Component<StartState>(StartState.STOP));
	}
	public void foo(){}
}
