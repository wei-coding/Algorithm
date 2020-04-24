public class PCL4107056015 extends PCL {
	int[] a;
	private int[][] res;
	int k=0;
	boolean results=false;	
	public  boolean checkPCL(int[][] array)
	{	
		int i,j,n;
		res=new int[array.length][2];
		outer:for(i=0;i<array.length-1;i++)
		{
			for(j=i+1;j<array.length;j++)
			{
				slope(array[i][0],array[i][1],array[j][0],array[j][1]);
				for(n=0;n<k;n++)
				{	
					if(res[k][0]==res[n][0]&&res[k][1]==res[n][1])
					{
						results=true;
						break outer;
					}
				}
			}
			k=0;
		}			
		return results;		
	}
	public void slope(int x1,int x2,int y1,int y2)
	{
		int m,p;
		m=x1-x2;
		p=y1-y2;
		res[k][0]=m/gcd(m,p);res[k][1]=p/gcd(m,p);
		k++;		
	}
	public static int gcd(int m, int n) {
        return n == 0 ? m : gcd(n, m % n);
    }
}
