public class IslandCounting4107056016 extends IslandCounting
{
  private int[] parent;  
     private int[] size;    
     private int[] flag;
     private int num;     
     public int count(String[] A ,String[] B)
     {
      int i;
      flag=new int[100000000];
      parent = new int[100000000];
         size = new int[100000000];
         num=0;
         for (i = 0; i < A.length; i++) 
         {
             parent[Integer.parseInt(A[i])] = Integer.parseInt(A[i]);
             size[i] = i;
         }
         for (i = 0; i < A.length; i++) 
         {
          union(Integer.parseInt(A[i]),Integer.parseInt(B[i]));
         }
      return num;
     }
     public int find(int p) 
     {
         while (p != parent[p])
         {
          if(parent[p]==0)
          {
           parent[p]=p;
           break;
          }
          p = parent[p];
         }
         return p;
     }
     public void union(int p, int q) 
     {
         int rootP = find(p);
         int rootQ = find(q);
         if (rootP == rootQ) return;
         if (size[rootP] < size[rootQ])
         {
          parent[rootP] = rootQ;
             size[rootQ] += size[rootP];
             if(flag[rootP]==0&&flag[rootQ]==0)
             {
              flag[rootQ]=1;
              num++;
              return;
             }
          if(flag[rootP]==1&&flag[rootQ]==0)
          {
           flag[rootQ]=1;
           flag[rootP]=0;
           return;
          }
          if(flag[rootP]==1&&flag[rootQ]==1)
          {
           flag[rootP]=0;
           num--;
           return;
          }
         }
         else 
         {
          parent[rootQ] = rootP;
             size[rootP] += size[rootQ];
             if(flag[rootQ]==0&&flag[rootP]==0)
             {
              flag[rootP]=1;
              num++;
              return;
             }
          if(flag[rootQ]==1&&flag[rootP]==0)
          {
           flag[rootP]=1;
           flag[rootQ]=0;
           return;
          }
          if(flag[rootQ]==1&&flag[rootP]==1)
          {
           flag[rootQ]=0;
           num--;
           return;
          }
         }
     }
}