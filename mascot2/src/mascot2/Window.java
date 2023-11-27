package mascot2;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window extends JFrame implements MouseMotionListener, MouseListener {
	ImageIcon icon = new ImageIcon("R1.png");
	JLabel label = new JLabel(icon);
	ImageIcon icon2 = new ImageIcon("R2.png");
	JLabel label2 = new JLabel(icon2);
	ImageIcon icon3 = new ImageIcon("R3.png");
	JLabel label3 = new JLabel(icon3);
	ImageIcon icon4 = new ImageIcon("R1R.png");
	JLabel label4 = new JLabel(icon4);
	ImageIcon icon5 = new ImageIcon("R2R.png");
	JLabel label5 = new JLabel(icon5);
	ImageIcon icon6 = new ImageIcon("R3R.png");
	JLabel label6 = new JLabel(icon6);
	ImageIcon icon7 = new ImageIcon("ojousama.png");
	JLabel label7 = new JLabel(icon7);
	ImageIcon icon8 = new ImageIcon("desktop.png");
	JLabel label8 = new JLabel(icon8);
	ImageIcon icon9 = new ImageIcon("gorunai.png");
	JLabel label9 = new JLabel(icon9);
	
	
	
	
	
	//JLabel label = new JLabel("こんにちわ");
	//JFrame frame = new JFrame();
	//Timer timer1;
	Timer timer1= new Timer(true);
	TimerTask task;
	
	//座標初期位置
	int x=1080,y=480;
	
	//移動距離
	int w=10,z=5;
	
	int dx,dy;
	
	//画面端最大値、最小値定数
	final int xMin=-50;
	final int xMax=1140;
	final int yMin=0;
	final int yMax=480;
	
	//画像切り替えチェック
	//boolean check=true;
	int check=0;
	
	//プルダウンメニューチェック
	static boolean windowCheck=false;
	
	
	//マウスカーソル乗る判定用
	int i=0;
	
	//ドラッグ時表示切替用
	int dragged=0;
	

	

	public Window() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		//GraphicsDevice gd = ge.getDefaultScreenDevice();
		//gd.setFullScreenWindow(frame);
		// 3, 画面のウィンドウサイズ指定はこの位置で。
		setSize(1920, 1080);
		getContentPane().setLayout(null);
		// 4, 回答の原因:aの対策
		//label指定
		label.setBounds(x, y, 111, 200);
		// 枠を外す。
        setUndecorated(true);
        // 背景色を透明にする。
        setBackground(new Color(0, 0, 0, 0));
        // タスクバーのアイコンを非表示
        setType(Type.UTILITY) ;
		// 5, 回答の原因:bの対策
		getContentPane().add(label); //引数label
		addMouseMotionListener(this);
		addMouseListener(this);
		
		
		
//		Timer timer = new Timer(true);
//		//timer.schedule(new MyTimer(),0,1000);
//		TimerTask task = new TimerTask() {

//			@Override
//			public void run() {
//				// TODO 自動生成されたメソッド・スタブ
//				System.out.println("111");
//			}
//			
//		};
	}
	
	public void move() {
		task = new TimerTask() {
        public void run(){
        	//x-=10;
        	//y+=10;
        	
        	System.out.println("move_run");
        	
        	//チェック
        	check++;
        	if(3<check) {
        		check=0;
        	}
        	
        	
        	
        	//画像切り替え
        	switch(check) {
        	case 1:
        		System.out.println("check");
        		for(int I=0;I<5;I++) {
        			//移動距離計算
        			x-=w;
        			y-=z;
        			System.out.println(w+","+z);
        			//画面端判定
        			if((x>=xMin && x<=xMax) && (y>=yMin && y<=yMax)) {
        				//左右どちらの移動か判定
        				System.out.println("11");
        				if(w>=1) {
        					drow1();
        					System.out.println("drow1");
        				}else {
        					drow4();
        					System.out.println("drow4");
        				}
        			}else if(x<=xMin || x>=xMax){
	    				w=w*-1;
	    			}else {
	    				z=z*-1;
	    			}
        		}
        		break;
        	
        	case 3:
        		System.out.println("check");
        		for(int I=0;I<5;I++) {
        			x-=w;
        			y-=z;
        			if((x>=xMin && x<=xMax) && (y>=yMin && y<=yMax)) {
        				if(w>=1) {
        					drow3();
        					System.out.println("drow3");
        				}else {
        					drow6();
        					System.out.println("drow6");
        				}
        			}else if(x<=xMin || x>=xMax){
	    				w=w*-1;
	    			}else {
	    				z=z*-1;
	    			}
        		}
        		break;
        	
        	//初期表示は0なのでデフォルト、0と2の描画を兼ねる
        	default:
        		System.out.println("check");
	    		for(int I=0;I<5;I++) {
	    			x-=w;
	    			y-=z;
	    			if((x>=xMin && x<=xMax) && (y>=yMin && y<=yMax)) {
	    				if(w>=0) {
	    					drow2();
	    					System.out.println("drow2");
	    				}else {
	    					drow5();
	    					System.out.println("drow5");
	    				}
	    			}else if(x<=xMin || x>=xMax){
	    				w=w*-1;
	    			}else {
	    				z=z*-1;
	    			}
	    		}
	    		break;
        }
        	
        	
        	
        	
    }
    
        
       
	
};


}
	
	//画像表示1
	public void drow1() {
		label.setIcon(icon);
		label.setBounds(x, y, 200, 200);
    	System.out.println("R1.png表示");
    	System.out.println(x+","+y);
	}
	
	//画像表示2
	public void drow2() {
		label.setIcon(icon2);
		label.setBounds(x, y, 200, 200);
    	System.out.println("R3.png表示");
    	System.out.println(x+","+y);
		}
	
	//画像表示3
	public void drow3() {
		label.setIcon(icon3);
		label.setBounds(x, y, 200, 200);
    	System.out.println("R2.png表示");
    	System.out.println(x+","+y);
	}
	
	//画像表示4
	public void drow4() {
		label.setIcon(icon4);
		label.setBounds(x, y, 200, 200);
    	System.out.println("R1R.png表示");
    	System.out.println(x+","+y);
	}
	
	//画像表示5
	public void drow5() {
		label.setIcon(icon5);
		label.setBounds(x, y, 200, 200);
    	System.out.println("R3R.png表示");
    	System.out.println(x+","+y);
	}
	
	//画像表示6
	public void drow6() {
		label.setIcon(icon6);
		label.setBounds(x, y, 200, 200);
    	System.out.println("R2R.png表示");
    	System.out.println(x+","+y);
	}
		
	//移動停止
	public void moveStop() {
		if(timer1 != null){
			timer1.cancel();
			timer1 = null;
		}
	}
	
	//移動開始
	public void moveStart() {
		if(timer1==null&&windowCheck==false&&Main2.moveCheck==true) {
			timer1=new Timer(true);
			move();
			timer1.schedule(task, 0, 1000);
			System.out.println(timer1);
		}
	}
	
	
	
	
	//プルダウンメニュー重複チェック
	public static void windowCheckReturn(boolean windowCheckReturn) {
		windowCheck=windowCheckReturn;
		windowCheck=false;
	}
	
//	public static void checkreturn(boolean menuWindowCheck_Pulldown) {
//		windowCheck=menuWindowCheck_Pulldown;
//		windowCheck=false;
//	}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//コンポーネント上でクリックして離す
		System.out.println("クリックして離す");
		
		 
		
		

		
		moveStop();
		
		
		
		if(windowCheck==false) {
			windowCheck=true;
			//Main2.moveCheck=false;
			new Pulldown2(windowCheck);//.setVisible(true);
		}
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//コンポーネント上でクリックする
		
		dx=e.getXOnScreen()-label.getX();
		dy=e.getYOnScreen()-label.getY();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//マウスクリックが離されると呼出し
		x=e.getX();
		y=e.getY();
		
		
		
		label.setIcon(icon);
		
		System.out.print(x+","+y);
		
//		//画面外にドラッグした場合の処理
		if(x<xMin || x>xMax || y<yMin || y>yMax) {
			System.out.print("画面外です");
			if((x<xMin && y<yMin) || (x>xMax && y<yMin) || (x<xMin && y>yMax) || (x>xMax && y>yMax)) {//x軸y軸両方範囲外（右上右下左上左下）
				System.out.print("x軸y軸両方範囲外");
				if(x<xMin && y<yMin) {//右上左上か右下左下の判定
					//左上
					System.out.println("左上");
					x=xMin;
					y=yMin;
				}else if(x>xMax && y<yMin) {
					//右上
					System.out.println("右上");
					x=xMax;
					y=yMin;
				}else if(x<xMin && y>yMax) {
					//左下
					System.out.println("左下");
					x=xMin;
					y=yMax;
				}else {
					//右下
					System.out.println("右下");
					x=xMax;
					y=yMax;
				}
			}else if(x<xMin || x>xMax){//x軸のみ超えているかどうか
				if(x<xMin) {//x軸のどっちが超えてるか判定
					//x軸左
					System.out.println("//x軸左");
					x=xMin;
				}else {
					//x軸右
					System.out.println("//x軸右");
					x=xMax;
				}
			}else if(y<yMin) {//y軸のどっちが超えているか判定
				//y軸上
				System.out.println("//y軸上");
				y=yMin;
			}else {
				//y軸下
				System.out.println("//y軸下");
				y=yMax;
			}
		
		}
		
		
		System.out.println("if抜けた");
		System.out.println(timer1);
		
		moveStart();
		
		System.out.print("クリック離す");
				
				
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//コンポーネントにマウスが入る
		System.out.println("カーソルがコンポーネントに乗った");
		
		
		//起動時カーソルは乗る判定が入るので1回目は除外する
		i++;
		if(1!=i) {
			label.setIcon(icon8);
			
		}
		
		moveStop();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//コンポーネントからマウスが出る
		
		label.setIcon(icon);
		
		moveStart();
		
		System.out.println("移動開始");
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//クリックしてドラッグする
		
		moveStop();
		 
        
		 System.out.println("停止後");
		// 7, サイズが変わらないのであれば、setBoundsではなくsetLocationを呼び出す。
//		switch (i){
	//		case 1:
	//			label.setLocation(e.getPoint());
	//		case 3:
	//			label3.setLocation(e.getPoint());
	//		default:
	//			label2.setLocation(e.getPoint());
//		}
		 
		 x=e.getXOnScreen()-dx;
		 y=e.getYOnScreen()-dy;
		 
		 //表示切替
		 if(dragged<19) {
			 label.setIcon(icon9);
			 //label.setLocation(e.getPoint());
			 label.setLocation(x,y);
			 System.out.println("再描画");
			 dragged++;
		 }else {
			 label.setIcon(icon7);
			 label.setLocation(e.getPoint());
			 //label.setLocation(e.getPoint());
			 label.setLocation(x,y);
			 System.out.println("再描画2");
			 dragged++;
			 if(dragged==40) {
				 dragged=0;
			 }
		 }
		 
		 // 8, repaintは呼び出さない。
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
}
