package manager;

import manager.Appliance.ComponentName;
import manager.behavior.Behavior.Button;

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
