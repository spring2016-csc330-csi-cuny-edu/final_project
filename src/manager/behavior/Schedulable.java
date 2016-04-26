package manager.behavior;
import manager.Appliance.ComponentName;

public interface Schedulable extends Behavior{
	public class EventPackage <T extends Button>{
		public ComponentName<T> cname;
		public T button;
	}
	boolean fireEvent(Object event);
}
