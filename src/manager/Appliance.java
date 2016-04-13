package manager;

abstract public class Appliance{
	static public final int ON = 0;
	static protected final int BASE_EVENT = ON;
	static public int cur_id = 0;
	
	private int id;
	private String readableName;
	
	protected Appliance(){
		init("");
	}
	
	protected Appliance(String readableName){
		init(readableName);
	}
	
	private void init(String readableName){
		id = cur_id;
		cur_id++;		
		this.readableName = readableName;
	}
	
	protected int getId(){
		return id;		
	}
	
	protected String getReadableName(){
		return readableName;		
	}
	
	protected void setReadableName(String readableName){
		this.readableName = readableName;		
	}
	
	protected boolean equals(Appliance other){
		return other.id == this.id;
	};
	
	abstract protected void pushButton(int button);
}
