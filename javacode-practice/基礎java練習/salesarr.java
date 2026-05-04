import java.io.*;
public class salesarr
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		System.out.print("請輸入商品數量: ");
		int n=Integer.parseInt(br.readLine());
		int A[]=new int[n];
		for( int i=0;i<A.length;i++)
		{
			System.out.print("請輸入第"+(i+1)+"個商品價格: ");
			A[i]= Integer.parseInt(br.readLine());
		}
		System.out.print("請輸入業務員人數: ");
		int num=Integer.parseInt(br.readLine());
		int B[][]=new int [num][n];
		
		for( int i=0;i<B.length;i++)
		{
			System.out.println("第"+(i+1)+"個業務員銷售數量: ");
			for(int j=0;j<B[i].length;j++)
			{
				System.out.print("第"+(j+1)+"個商品數量: ");
				B[i][j]=Integer.parseInt(br.readLine());
			}	
		//上方是存入sales資料			
		}
		System.out.println("商品價格:\t");
		for( int i=0;i<A.length;i++)
		{
			System.out.println(A[i]+"\t");
		}
		System.out.println();
		for(int i=0;i<B.length;i++)
		{
			System.out.println("業務員"+(i+1)+"銷售量:\t");
			for(int j=0;j<B[i].length;j++)
			{
				System.out.println(B[i][j]+"\t");
			}
			System.out.println();
		}
		int sum[]=new int[n];
		int max=sum[0],maxI=0;
		for(int i=0;i<B.length;i++)
		{
			for(int j=0;j<A.length;j++)
			{
				sum[i]=sum[i]+A[j]*B[i][j];
			}
			System.out.println("業務員"+(i+1)+"業績:"+sum[i]+"\t"+"達成比率: "+(sum[i]/10000.0*100) +"%");
			if(sum[i]>max)
			{
				max=sum[i];
				maxI=i;
			}
		}
		System.out.println("最佳業務員:"+(maxI+1)+" 業績:"+max);
	}
}