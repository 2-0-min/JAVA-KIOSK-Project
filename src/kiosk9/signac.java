package kiosk9;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class signac extends JPanel{
	public Vector<Point> vStart = new Vector<Point>();		//���� ����
	public JLabel signature = new JLabel("<�� ��>");

	public signac() {
		signature.setBounds(3,1,20,10);						//���� �� ��ġ ����
		add(signature);
		addMouseMotionListener(new MouseMotionAdapter(){		//���콺 �̺�Ʈ ����
			public void mouseDragged(MouseEvent e) {			//���콺�� ������Ʈ ������ �巡���� �� �޼ҵ� ȣ��
				vStart.add(e.getPoint());
				repaint();
			}
		});
	    }
		public void paintComponent(Graphics g) {
			super.paintComponent(g);											//JPanel�� ���Ե� paintComponent() ȣ��
			g.setColor(Color.BLUE); 											// �Ķ����� �����Ѵ�.
			for (int i = 1; i < vStart.size(); i++) {
				if (vStart.get(i - 1) == null) continue;
				else if (vStart.get(i) == null) continue;
				else {
					g.drawLine((int)vStart.get(i - 1).getX(), (int)vStart.get(i - 1).getY(),		//���׸��� �޼ҵ�
					(int)vStart.get(i).getX(), (int)vStart.get(i).getY());
				}
			}
		}
		public static void main (String[]args) {
		}
}
