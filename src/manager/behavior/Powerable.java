package manager.behavior;

public interface Powerable {
	static public enum PowerState implements Button{ON,OFF};
	public class PowerableAttr{
		public PowerState state;
	}
	
	public void changeState(PowerableAttr attr, PowerState state);
}
