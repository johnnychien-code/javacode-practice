package mad.nthu.ch3_servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;

/**
 * Servlet implementation class IdentityServlet
 */
@WebServlet("/IdentityServlet")
public class IdentityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public static final char[] CHARS= { '2','3','4','5','6','7','8','9',
    									'A','B','C','D','E','F','G','H',
    									'I','J','K','L','M','N','O','P',
    									'Q','R','S','T','U','V','W','X',
    									'Y','Z' };
	
	public static Random random = new Random();	// 建立一個可以產生隨機數的工具
	
	public static String getRandomString() {
		
		StringBuffer buffer = new StringBuffer();		//建立「可以一直修改的字串」
		for (int i = 0; i < 6; i++) {
			buffer.append(CHARS[random.nextInt(CHARS.length)]);	//xx.nextInt() 產生隨機抽取
		}
		return buffer.toString();	// buffer 是StringBuffer 資料型態
									//但是 getRandomString 方法是 String
									// 需要把 StringBuffer 轉換成 String
									// CHARS[某個數字] 取得字元
	} 
	
	public static Color getRandomColor() {
		return new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
	} 
	
	public static Color getReverseColor(Color c) {
		return new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue());
	} 
	
    public IdentityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("image/jpeg");
		
		String randomString = getRandomString(); //隨機取6字元組成字串
		request.getSession(true).setAttribute("randomString", randomString); //把驗證碼存進session, 存入名稱為randomString
											// 這裡放: ("key", value)
		
		int width = 125;
		int height = 40; //建立一個寬125,高40的圖片
		
		Color color = getRandomColor(); 		//隨即產生RGB顏色，作為背景色
		Color reverse = getReverseColor(color); //根據背景色算出反色，作為文字顏色
		
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); //記憶體建立空白圖片
		Graphics2D g = bi.createGraphics(); 	//從圖片 bi 取得一個畫筆物件 g
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD,22));
		g.setColor(color);
		g.fillRect(0, 0, width, height);
		g.setColor(reverse);
		g.drawString(randomString, 20, 28);  // 將反色文字，也就是驗證碼顯示在(20,28)的位置
		
		for(int i = 0, n = random.nextInt(200); i < n+50; i++) {
			
			g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
		}	// 每次在圖片隨機位置畫一個1x1的小方點，讓驗證碼出現干擾雜訊，增加機器辨識難度
		
		
		ServletOutputStream outStream = response.getOutputStream(); //輸出二進位資料: 圖片
		ImageIO.write(bi, "JPEG", outStream); // 把記憶體中的 BufferedImage  用 JPEG 格式編碼  寫到 outStream
											  // 就是把圖片內容真正放進 HTTP response body
		
		outStream.flush();					  // 把目前 buffer 中的圖片資料送出去，讓瀏覽器收到完整內容
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
