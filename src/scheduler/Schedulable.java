package scheduler;

public interface Schedulable {
	interface EventPackage{};
	boolean fireEvent(EventPackage event);
}
