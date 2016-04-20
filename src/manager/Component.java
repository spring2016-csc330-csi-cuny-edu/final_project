package manager;

import java.util.Arrays;

import manager.behavior.Behavior.Button;

public class Component<T extends Button> {
	private T state;
	
	protected Component(T initialState){
		this.state = initialState;
	}
	
	protected void changeState(T state){
		this.state = state;
	}
	
	private void foo(){
		System.out.println(Arrays.toString(state.getClass().getEnumConstants()));
	}
}
