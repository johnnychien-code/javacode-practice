import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Loto {
	private int num;
	protected BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private int A[]=new int[6];
	
	Loto(int n){
		num = n;
		System.out.println("[ Loto Game ] 數值範圍:1 ~"+num);
	}
	public void userInput() throws IOException{
		System.out.print("請輸入1.自選、2.隨機: ");
		int usr=Integer.parseInt(br.readLine());
		this.platform(usr);
	}
	protected void platform(int usr) throws IOException{
		switch(usr){
			case 1:
				this.自選();
				break;
			case 2:
				隨機();
				break;
			default:
				System.out.println("無"+usr+"選項~");
		}
	}
	protected void 自選()throws IOException{
		for (int i=0;i<A.length;i++){
			System.out.print("請輸入第"+(i+1)+"個號碼: ");
			A[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(A);
		for(int i=0;i<A.length;i++){
			System.out.print(A[i]+"\t");
		}
	}
	protected void 隨機() throws IOException {
		System.out.print("請輸入隨機組數: ");
		int n=Integer.parseInt(br.readLine());
		int A[]=new int[6];
		for(int i=1; i<=n;i++){
			A[0]=(int)(Math.random()*num+1);
			A[1]=(int)(Math.random()*this.num+1);
			while(A[1]==A[0]){
				A[1]=(int)(Math.random()*num+1);
			}
			do{
				A[2]=(int)(Math.random()*num+1);
			}while(A[2]==A[1] || A[2]==A[0]);
			do{
				A[3]=(int)(Math.random()*num+1);
			}while( A[3]==A[2] || A[3]==A[1] || A[3]==A[0]);
			do{
				A[4]=(int)(Math.random()*num+1);
			}while( A[4]==A[3] || A[4]==A[2] || A[4]==A[1] || A[4]==A[0]);
			do{
				A[5]=(int)(Math.random()*num+1);
			}while( A[5]==A[4] || A[5]==A[3] || A[5]==A[2] || A[5]==A[1] || A[5]==A[0]);
			System.out.print("第"+i+"組: ");
			for(int j=0; j<A.length;j++){
				System.out.print(A[j]+"\t");
				while(j == 0 && A[0]<=10)
				{
					System.out.print("\t");
					break;
				}
			}
			System.out.println();
			Arrays.sort(A);
			System.out.print("小-->大: ");
			for(int j=0;j<A.length;j++){
				System.out.print(A[j]+"\t");
			}
			System.out.println();
			System.out.print("大-->小: ");
			for(int j=A.length-1;j>=0;j--){
				System.out.print(A[j]+"\t");
			}
			System.out.println();
		} 
	}
}
