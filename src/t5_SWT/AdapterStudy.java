package t5_SWT;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class AdapterStudy extends JFrame {
  private AdapterStudy() {
    super("SWT Adapter 학습");
    setBounds(100, 50, 1000, 600);
    setVisible(true);
    //Adapter(윈도우 감시자) 사용
    //Adapter는 내가 필요한 것만 직접 관리
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);;
      }
    });//익명클래스 생성
    
  }
  
  public static void main(String[] args) {
    AdapterStudy adapterStudy = new AdapterStudy();
  }
}
