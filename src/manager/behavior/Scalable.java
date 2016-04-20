package manager.behavior;
public interface Scalable extends Behavior{
	static public interface ScaleState{};
	static public enum RigidScaleState implements ScaleState, Button{LOW, MID, HIGH};
	//static public enum RangedScaleState implements Button{_1,_2,_3};
}
