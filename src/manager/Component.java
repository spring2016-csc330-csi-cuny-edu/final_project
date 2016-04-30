package manager;

import manager.behavior.Behavior.Button;

/**
 * Tracks the state of a particular component, such as power or speed.
 * Also, handles changing states. Components are unaware of their names.
 * @param <T> Type of Button: PowerState, StartState, ScaleState, etc.
 */
public class Component<T extends Button>{
	private T state;
	
	protected Component(T initialState){
		this.state = initialState;
	}
	
	protected void changeState(T state){
		if (this.state == state) return;
		this.state = state;
		System.out.println(this);
	}
	
	public String toString(){
		return String.format("%s: %s",this.state.getClass().getSimpleName(),this.state);
	}
}
