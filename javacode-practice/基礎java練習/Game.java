import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game extends Loto{
	
	Game(int n){
		super(n);
		System.out.println("[ Game ]");
	}
	
	public void userInput() throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("請輸入1.自選、2.隨機、3.終極密碼: ");
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
			case 3:
				this.終極密碼();
				break;
			default:
				System.out.println("無"+usr+"選項~");
		}
	}
	public void 終極密碼() throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int A[]= new int[4];
		A[0]=(int)(Math.random()*100+1);
		A[1]=1;
		A[2]=100;
		
		do{
			System.out.print("請輸入"+A[1]+"~"+A[2]+"範圍的一個整數: ");
			A[3]=Integer.parseInt(br.readLine());
			if (A[3]==A[0])
				System.out.println("恭喜答對，pc = "+A[0]);
			else {
				System.out.println("可惜答錯 ~");
				if (A[3]> A[0])
					A[2]=A[3];
				else
					A[1]=A[3];
			}
		}while(A[3]!=A[0]);
	}
}
