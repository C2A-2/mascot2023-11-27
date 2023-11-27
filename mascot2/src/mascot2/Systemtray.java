package mascot2;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Systemtray {
	
	TrayIcon icon;
	
	//public void setup() throws IOException, AWTException {
	
	public Systemtray() throws AWTException, IOException{
//        Image image = Toolkit.getDefaultToolkit().createImage( ClassLoader.getSystemResource("desktop.png") ); // アイコン画像を準備
//        TrayIcon systemIcon = new TrayIcon(image, "Sample Java App"); // ※1 トレイアイコンとして生成
//        systemIcon.setImageAutoSize(true); // リサイズ
//
//        try {
//            SystemTray.getSystemTray().add(systemIcon); // ※2 システムトレイに追加
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
		
		this.setup();
		
        
        
        
    }
	
	public void setup() throws AWTException, IOException {
		
		SystemTray tray = SystemTray.getSystemTray();
		Image image = ImageIO.read(new File("zaka.jpeg"));
        PopupMenu popupmenu = new PopupMenu();
        icon = new TrayIcon(image,"デスクトップマスコット",popupmenu);
        
        icon.setImageAutoSize(true);
        
        MenuItem item1 = new MenuItem("移動停止");
        item1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	Main2.moveStopMain();
                System.out.println("移動停止");
            }
        });
        
        MenuItem item2 = new MenuItem("移動開始");
        item2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	Main2.moveStartMain();
                System.out.println("移動開始");
                
                
            }
        });

        MenuItem item3 = new MenuItem("プログラム終了");
        item3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	//システムトレイを閉じる
                tray.remove(icon);
                System.out.println("システムトレイ閉じる");
                System.exit(0);
                //表示されないよ
                System.out.println("プログラム閉じる");
                
            }
        });
        
        
        popupmenu.add(item1);
        popupmenu.add(item2);
        popupmenu.add(item3);
        //		try {
//			icon = new TrayIcon(ImageIO.read(new File("zaka.jpeg")));
//		} catch (IOException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
        tray.add(icon);
		System.out.println(icon);
	}

}
