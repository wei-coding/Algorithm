

public class Timer {
	private double run,end;
	private double dur;
	public void start() {
		run = System.nanoTime();
	}
	public double stop() {
		end = System.nanoTime();
		dur = (end-run)/1E9;
		//System.out.println("Used "+dur+" second.");
		return dur;
	}
	public double getDur() {
		return dur;
	}
}
