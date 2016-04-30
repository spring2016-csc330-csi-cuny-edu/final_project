package manager.behavior;
public interface Scalable extends Behavior{
	/**
	 * Marker interface with the intent of making multiple kinds of scales.
	 */
	static public interface ScaleState{};
	static public enum RigidScaleState implements ScaleState, Button{LOW, MID, HIGH};
}
