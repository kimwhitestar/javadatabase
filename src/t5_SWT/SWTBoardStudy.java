package t5_SWT;

import javax.swing.JFrame;

public class SWTBoardStudy {
  private JFrame frame = null;
  public SWTBoardStudy() {
    frame = new JFrame();//프레임은 컨테이너 역할
    frame.setSize(1000, 600);//프레임 크기
    frame.setTitle("Swing 게시판 학습");
    frame.setVisible(true);//프레임을 화면에 출력
  }
}
