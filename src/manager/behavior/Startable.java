package manager.behavior;

public interface Startable {
	static public enum StartState implements Button{START,STOP};
	public class StartableAttr{
		public StartState state;
	}
	
	public void changeState(StartableAttr attr, StartState state);
}
