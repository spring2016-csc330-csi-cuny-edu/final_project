package manager.behavior;
import manager.Component;
import manager.Appliance.ComponentName;
import manager.behavior.Behavior.Button;

public interface Schedulable extends Behavior, scheduler.Schedulable{

	public class AppEventPackage <T extends Button> implements scheduler.Schedulable.EventPackage{
		public ComponentName<T> cname;
		public T button;
		
		public AppEventPackage(T button, ComponentName<T> componentName){
			cname = componentName;
			this.button = button;
		}
	}
}
