package kiosk6;

import java.awt.*;
import javax.swing.*;

public class Title {
	/////�����г� (JAVA PC ����)/////
	public JPanel northp=new JPanel();
	
	public Title() {
 
	northp.setLayout(null);
	northp.setBackground(new Color(200, 100, 215));								//�����г� ������ ����
	northp.setPreferredSize(new Dimension(1000,100));							//�����г� ũ�� ����
	
	/////���� ���� ���� ����/////
	ImageIcon image=new ImageIcon("images//computer.jpg"); 
	Image getImg=image.getImage();
	Image changeImg=getImg.getScaledInstance(60, 60, Image.SCALE_SMOOTH); //������ ũ�⿡ �°� resize ���ش�.
	ImageIcon newImg=new ImageIcon(changeImg);  
    JLabel label=new JLabel(newImg);                         					//�󺧿� �̹��� ÷��
    label.setSize(60,60);                                    					//�� ũ�� ����
    label.setLocation(440,20);                               					//�� ��ġ ����
    northp.add(label);                                       					//�����гο� ÷��
    
    JLabel label2=new JLabel("JAVA PC��");                    					 //���� ���� ����("JAVA PC��")
    label2.setSize(150,60);                                  					 //�� ũ�� ����
    label2.setLocation(510,20);                              					 //�� ��ġ ����
    label2.setFont(label2.getFont().deriveFont(20.0f));       					//���� ũ�⼳��
    northp.add(label2);                                       					//�����гο� ÷��
	}
	
	
	public static void main(String[] args) {

	}

}
