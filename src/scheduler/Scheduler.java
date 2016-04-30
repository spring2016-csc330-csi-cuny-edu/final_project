package scheduler;

import java.util.concurrent.DelayQueue;

/**
 * Handles {@link Event}s: adding, executing, and canceling.
 */
public class Scheduler {
	private final static Scheduler s = new Scheduler();
	private static int nextEID = 0;
	private static DelayQueue<Event> events = new DelayQueue<Event>();
	private static Thread executer;
	
	/**
	 * Static initializer creates and starts thread to execute events.
	 */
	{
	 executer =  new Thread(new Runnable() {
		        public void run() {
		            while (true) {
		                try {
		                	Event e = null;
		                	e = events.take();
		                	if (e!=null)	        		
			                	e.trigger();
		                    Thread.sleep(200);
		                } catch (InterruptedException ex) {
		                    ex.printStackTrace();
		                }
		            }
		        }
		    });
	 executer.setDaemon(true);
	 executer.start();
	}
	private Scheduler(){
		events = new DelayQueue<Event>();
	}
	
	private Event getEvent(int eid){
		for (Event e: events)
			if (e.getEID()==eid)
				return e;
		return null;
	}
	
	public static Scheduler getInstance(){
		return s;
	}
	
	public int addEvent(Event e){
		if (!events.add(e))
			return -1;
		e.setEID(nextEID);
		nextEID++;
		return nextEID -1;
	}
	
	public boolean exeEvent(int eid){
		Event found = getEvent(eid);
		if (found==null) return false;
		found.trigger();
		events.remove(found);
		return true;
	}
	
	public boolean cancelEvent(int eid){
		Event found = getEvent(eid);
		if (found==null) return false;
		events.remove(found);
		return true;
	}
}
