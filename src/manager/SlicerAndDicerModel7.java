package manager;

public final class SlicerAndDicerModel7 extends Blender {
	public static enum ScalableComponent implements ComponentName<SlicerAndDicerModel7Scale>{Speed;
	public Class<SlicerAndDicerModel7Scale> type() {
		return SlicerAndDicerModel7Scale.class;
	}};
	public static enum SlicerAndDicerModel7Scale implements ScaleState, Button{LOW, MID, HIGH,SUPER_HIGH};
	
	SlicerAndDicerModel7(){
		super ();
	}
	SlicerAndDicerModel7(String name){ 
		super (name);
	}
	
	void init(){	
		components.put(StartableComponent.StartBlend, new Component<StartState>(StartState.STOP));
		components.put(ScalableComponent.Speed,  new Component<SlicerAndDicerModel7Scale>(SlicerAndDicerModel7Scale.LOW));
	}
}
