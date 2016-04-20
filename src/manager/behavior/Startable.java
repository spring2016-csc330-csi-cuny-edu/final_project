package manager.behavior;

public interface Startable extends Behavior{
	static public enum StartState implements Button{STOP,START};
}
