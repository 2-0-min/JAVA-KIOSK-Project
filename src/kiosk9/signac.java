package kiosk9;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class signac extends JPanel{
	public Vector<Point> vStart = new Vector<Point>();		//벡터 생성
	public JLabel signature = new JLabel("<서 명>");

	public signac() {
		signature.setBounds(3,1,20,10);						//서명 라벨 위치 설정
		add(signature);
		addMouseMotionListener(new MouseMotionAdapter(){		//마우스 이벤트 설정
			public void mouseDragged(MouseEvent e) {			//마우스를 컴포넌트 위에서 드래그할 때 메소드 호출
				vStart.add(e.getPoint());
				repaint();
			}
		});
	    }
		public void paintComponent(Graphics g) {
			super.paintComponent(g);											//JPanel에 포함된 paintComponent() 호출
			g.setColor(Color.BLUE); 											// 파란색을 선택한다.
			for (int i = 1; i < vStart.size(); i++) {
				if (vStart.get(i - 1) == null) continue;
				else if (vStart.get(i) == null) continue;
				else {
					g.drawLine((int)vStart.get(i - 1).getX(), (int)vStart.get(i - 1).getY(),		//선그리기 메소드
					(int)vStart.get(i).getX(), (int)vStart.get(i).getY());
				}
			}
		}
		public static void main (String[]args) {
		}
}
