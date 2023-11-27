package mascot2;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Pulldown2 extends JFrame implements ActionListener , MouseListener ,WindowListener{
	// フィールド宣言
	JComboBox<String> comboBox = new JComboBox<String>();
	// GUI画面の設定
	JFrame menuWindow = new JFrame("メニュー");
	
	//メニューウィンドウ重複チェック、プルダウン側用
	boolean menuWindowCheck_Pulldown;
	
	//サーチメニューチェック
	static boolean searchWindowCheck=false;
	
	int j=0;
	
	//メイン処理 
	
//	public static void main(String[] args) {
//		// プルダウン作成クラスのインスタンス
//		new Pulldown();
//	}
	
	// コンストラクタ
	public Pulldown2(boolean menuWindowCheck_Main){
		
		menuWindowCheck_Pulldown=menuWindowCheck_Main;
		
		//menuWindow.setLayout(new FlowLsayout());
		//getContentPane().setLayout(new FlowLayout());
		
		//レイアウト無効
		menuWindow.setLayout(null);
		//setTitle("メニュー");
		
		
		// ボタンの生成
		JButton btn = new JButton("決定");
		
		
		
		// ボタン押下時の処理を設定
		btn.addActionListener(this);
		
		// プルダウンの追加
		comboBox.addItem("沼情");
		comboBox.addItem("検索");
		comboBox.addItem("電卓");
		comboBox.addItem("メモ帳");
		
		//comboBox.setBounds(100,100,100,100);
		
		// プルダウンを画面に追加
		//getContentPane().add(comboBox);
		menuWindow.add(comboBox);
		comboBox.setBounds(50,20,100,30);
		
		// ボタンを画面に追加
		//getContentPane().add(btn);
		
		menuWindow.add(btn);
		btn.setBounds(170,20,70,30);
		
		
		// GUIを閉じた時、プログラムも終了
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//終了設定
		menuWindow.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				
		//ラベル設定
		//getContentPane().add(menuWindow);
		
		
		// サイズを設定
		//setSize(300, 100);
		menuWindow.setSize(300, 100);
		
		//ウィンドウ位置座標
		//getContentPane().setBounds(100,100,500,300);
		//menuWindow.setBounds(800,200,300,150);
		menuWindow.setLocation(980,410);
		
		// GUI画面の可視化
		//getContentPane().setVisible(true);
		menuWindow.setVisible(true);
		
		menuWindow.addMouseListener(this);
		menuWindow.addWindowListener(this);
		
		// 枠を外す。
		//setUndecorated(true);
		//menuWindow.setUndecorated(true);
        // 背景色を透明にする。
        //setBackground(new Color(0, 0, 0, 0));
        // タスクバーのアイコンを非表示
        //setType(Type.UTILITY) ;
		this.setType(Type.UTILITY) ;
	}
	
	
	
	// ボタンクリック時の処理
	public void actionPerformed(ActionEvent ae) {
		
//		// 選択したプルダウンに応じてメッセージを出力
//		JOptionPane.showMessageDialog(null,
//			"選択項目：" + comboBox.getSelectedItem(),
//			"プルダウン選択内容",
//			JOptionPane.INFORMATION_MESSAGE);
		
		if(comboBox.getSelectedItem()=="沼情") {
			
			//メニューウィンドウ閉じる
			menuWindow.dispose();
			
			Desktop desktop = Desktop.getDesktop();
			try {
				Window.windowCheckReturn(menuWindowCheck_Pulldown);
				Main2.moveStartMain();
				desktop.browse(new URI("https://www.numasen.ac.jp/department/computer/"));
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			
		}else if(comboBox.getSelectedItem()=="検索"){
			
			//メニューウィンドウ閉じる
			menuWindow.dispose();
			
			Window.windowCheckReturn(menuWindowCheck_Pulldown);
			if(searchWindowCheck==false) {
				searchWindowCheck=true;
				new Search2(searchWindowCheck);//.setVisible(true);
			}
			
			
		}else if(comboBox.getSelectedItem()=="電卓") {
			
			//メニューウィンドウ閉じる
			menuWindow.dispose();
			Window.windowCheckReturn(menuWindowCheck_Pulldown);
			Main2.moveStartMain();
			
			try {
			      Runtime rt = Runtime.getRuntime();
			      rt.exec("calc.exe");
			    } catch (IOException ex) {
			      ex.printStackTrace();
			    }
		}else if(comboBox.getSelectedItem()=="メモ帳") {
			
			//メニューウィンドウ閉じる
			menuWindow.dispose();
			Window.windowCheckReturn(menuWindowCheck_Pulldown);
			Main2.moveStartMain();
			
			 try {
			      Runtime rt = Runtime.getRuntime();
			      rt.exec("notepad.exe");
			    } catch (IOException ex) {
			      ex.printStackTrace();
			    }
			  
		}
	}
	
	public static void searchWindowCheckReturn(boolean searchWindowCheck_Search) {
		searchWindowCheck=searchWindowCheck_Search;
		searchWindowCheck=false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("プルダウンメニューをクリックした");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("プルダウンメニューにマウスカーソルが乗った");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
		
		System.out.println("プルダウンメニューからマウスカーソルが離れた");
	}



	@Override
	public void windowOpened(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}



	@Override
	public void windowClosing(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		Window.windowCheckReturn(menuWindowCheck_Pulldown);
		menuWindow.dispose();
		System.out.println("メニューウィンドウ閉じる");
		Main2.closingCheck();
	}



	@Override
	public void windowClosed(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}



	@Override
	public void windowIconified(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}



	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}



	@Override
	public void windowActivated(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}



	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	
	
	
	
	
	
		
		
}
