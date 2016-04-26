package manager;

public final class SlicerAndDicerModel7 extends Blender {
	public static enum ScalableComponent implements ComponentName<SlicerAndDicerModel7Scale>{Speed};
	public static enum SlicerAndDicerModel7Scale implements ScaleState, Button{LOW, MID, HIGH,SUPER_HIGH};
	
	SlicerAndDicerModel7(){
		super ();
	}
	SlicerAndDicerModel7(String name){ 
		super (name);
	}
	
	void init(){	
		components.put(PowerComponent.MainPower, new Component<PowerState>(PowerState.OFF));
		components.put(ScalableComponent.Speed,  new Component<SlicerAndDicerModel7Scale>(SlicerAndDicerModel7Scale.LOW));
	}
}
