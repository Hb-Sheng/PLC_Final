import java.util.Scanner;
class main{
public static void main(String[] args)
{
   int i,j,n=4,index=-1;
   int[][] x = {{0, 1, 1, 1},{1, 0, 1, 1},{1, 1, 0, 1},{0, 0, 0, 0}};
   for(i=0;i<n;i++)
   {
       for(j=0;j<n;j++)
       {
           if(x[i][j]!=0)
           break;
           else if(j==n-1 && x[i][j]==0)
           {
           index=i;
           break;
           }
       }
   }
   if (index==-1)
   System.out.println("None");
   else
   System.out.println("On Row # "+(index+1));
   }
}
