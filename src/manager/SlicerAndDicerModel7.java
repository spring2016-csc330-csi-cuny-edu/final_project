package manager;

public class SlicerAndDicerModel7 extends Blender {

	protected SlicerAndDicerModel7(){
		super();
	}
	protected SlicerAndDicerModel7(String name){
		super(name);
	}
	
	protected void pushButton(int button) {
		switch(button)
		{
		case ON:
			break;
		case LOW_SPEED:
			System.out.println("Low speed!");
			break;
		case HIGH_SPEED:
			System.out.println("High speed!");
			break;
		default:
			//throw error;
		}
		
	}

}
