package mascot2;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Timer;

public class Main2 {
	
	public static Window window;
	static boolean moveCheck=true;
	

	public static void main(String[] args) throws IOException, AWTException {
		// 1, SwingUtilities.invokeLaterを使う。
		// 2, mouseExecのコンストラクタ内ではsetVisible(true);を行わない。
		//SwingUtilities.invokeLater(() -> {
		window=new Window();//.setVisible(true);
		//});
		
		window.setVisible(true);
		
		
		window.move();
		window.timer1.schedule(window.task, 0, 1000);
		
		Systemtray systemtray = new Systemtray();
		//systemtray.setup();
		System.out.println("sss");
	}	
		
	//各ウィンドウを閉じたら呼び出し
	public static void closingCheck(){
		window.moveStart();
	}
	
	public static void moveStopMain(){
		//システムトレイ移動停止押したら呼び出し
		//移動停止
		if(window.timer1 != null&&moveCheck==true){
			window.timer1.cancel();
			window.timer1 = null;
			moveCheck=false;
		}
	}
	
	public static void moveStartMain(){
		//システムトレイ移動停止押したら呼び出し
		//移動開始
		
		if(window.timer1==null ) {
			window.timer1=new Timer(true);
			window.move();
			window.timer1.schedule(window.task, 0, 1000);
			System.out.println(window.timer1);
			moveCheck=true;
		}
	}
	
	
	    
	    
}

	