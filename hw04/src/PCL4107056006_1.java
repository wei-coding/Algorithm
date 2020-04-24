
public class PCL4107056006_1 extends PCL{
	public volatile boolean flag = false;
	static Thread[] tarr;
	@Override
	public boolean checkPCL(int[][] array) {
		//n*2 size
		// TODO Auto-generated method stub
		int thread = 4;
		tarr = new Thread[thread];
		for(int i=0;i<thread;i++) {
			tarr[i] = new Thread(new check(array,thread,i+1));
		}
		for(int i=0;i<thread;i++) {
			tarr[i].start();
		}
		for(int i=0;i<thread;i++) {
			try {
				tarr[i].join();
			} catch (InterruptedException e) {}
		}
		return flag;
	}
	class check implements Runnable{
		private int[][] arr;
		private int from,end;
		public check(int[][] arr,int part,int ith) {
			this.arr = arr;
			this.from = arr.length*(ith-1)/part;
			if(part==ith) {
				this.end = arr.length;
			}else {
				this.end = arr.length*ith/part;
			}
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=from;i<end;i++) {
				//System.out.println(i);
				for(int j=i+1;j<arr.length;j++) {
					for(int k=j+1;k<arr.length;k++) {
						if(flag) return;
						if((long)(arr[j][0]-arr[i][0])*(arr[k][1]-arr[i][1]) == (long)(arr[j][1]-arr[i][1])*(arr[k][0]-arr[i][0])) {
							//System.out.printf("(%d,%d),(%d,%d),(%d,%d)\n",arr[i][0],arr[i][1],arr[j][0],arr[j][1],arr[k][0],arr[k][1]);
							flag=true;
							return;
						}
					}
				}
			}
		}
	}
}
