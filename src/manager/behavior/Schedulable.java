package manager.behavior;
import scheduler.Event;
import manager.Appliance.ComponentName;

/**
 *	Bridges the gap between the scheduler package and schedulable appliances
 */
public interface Schedulable extends Behavior, scheduler.Schedulable{

	/**
	 * Appliance specific twist on {@linkplain scheduler.Schedulable.EventPackage}
	 * @see scheduler.Schedulable.EventPackage
	 */
	public class AppEventPackage <T extends Button> implements scheduler.Schedulable.EventPackage{
		public ComponentName<T> cname;
		public T button;
		
		public AppEventPackage(T button, ComponentName<T> componentName){
			cname = componentName;
			this.button = button;
		}
	}
	/**
	 * Proxy class to shield appliances from use outside the package.
	 */
	public class SchedulableInstance implements Schedulable{
		private Schedulable appliance;
		public SchedulableInstance(Schedulable appliance){
			this.appliance = appliance;
		}
		public boolean fireEvent(EventPackage event) {
			return appliance.fireEvent(event);
		}
		public <T extends Button> Event GenerateEvent(long startTimeOffset,T button, ComponentName<T> componentName){
			return new Event(startTimeOffset,this,new Schedulable.AppEventPackage<T>(button, componentName));
		}
	}
}
