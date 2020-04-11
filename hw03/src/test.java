import java.io.*;
public class test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		StopWatch sw = new StopWatch();
		FileReader fr = new FileReader("C:\\Users\\User\\Desktop\\data.txt");
		BufferedReader bf = new BufferedReader(fr);
		int tot = Integer.parseInt(bf.readLine());
		String[] A2 = new String[tot];
		String[] B2 = new String[tot];
		boolean flag = false;
		int i=0;
		while(bf.ready()){
            String readLine = bf.readLine();
            if(!flag){
                if(readLine.equals("")){
                    flag = !flag;
                    i = 0;
                    continue;
                }

                A2[i++] = String.valueOf(readLine);
            }else{
                B2[i++] = String.valueOf(readLine);
            }
        }
		System.out.println("Data writing finish.");
		sw.start();
		IslandCounting4107056006 obj = new IslandCounting4107056006();
		int ans = obj.count(A2, B2);
		sw.stop();
		System.out.println("ans = "+ans+"\ntotal time = "+sw.getDur()+" seconds");
	}

}
