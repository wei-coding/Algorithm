
public class StopWatch {
	private double run,end;
	private double dur;
	public void start() {
		run = System.nanoTime();
	}
	public double stop() {
		end = System.nanoTime();
		dur = (end-run)/1E9;
		return dur;
	}
	public double getDur() {
		return dur;
	}
}
