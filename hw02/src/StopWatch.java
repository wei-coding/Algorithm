
public class StopWatch {
	private double run,end;
	public void start() {
		run = System.nanoTime();
	}
	public double stop() {
		end = System.nanoTime();
		return (end-run)/1E9;
	}
}
