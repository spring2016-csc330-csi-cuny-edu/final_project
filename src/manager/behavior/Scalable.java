package manager.behavior;
public interface Scalable {
	static public interface ScaleState{};
	static public enum RigidScaleState implements ScaleState, Button{LOW, MID, HIGH};
	//static public enum RangedScaleState implements Button{_1,_2,_3};
	
	public class ScaleableAttr{
		public ScaleState state;
	}
	
	public void changeState(ScaleableAttr attr, ScaleState state);
}
