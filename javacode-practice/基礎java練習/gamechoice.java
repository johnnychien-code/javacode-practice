import java.io.IOException;
// A9_1
public class gamechoice {

	public static void main(String[] args) throws IOException {
		Game game= new Game(49);  //要有數字才可以跑有變數的建構元
		game.userInput();
		System.out.println();
	}
//    A8 程式碼:
//		Loto loto=new Loto(38);
//		int usr=loto.userInput();       // 註解: 接到return 的值
//		loto.platform(usr);				// 註解: 傳入platform
//	       流程:
// 			main() 呼叫 userInput()
//  				    ↓
//			 userInput給你一個 usr
//  					↓
//			main() 拿到 usr → 丟到 loto.platform(usr)
//   					↓
//			platform() 用 switch 判斷 1 或 2
}
