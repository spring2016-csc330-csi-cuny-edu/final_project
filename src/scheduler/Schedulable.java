package scheduler;

public interface Schedulable {
	/**
	 * the message to be received by the listener
	 */
	interface EventPackage{};
	boolean fireEvent(EventPackage event);
}
