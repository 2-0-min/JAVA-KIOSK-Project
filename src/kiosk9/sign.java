package kiosk9;

import java.awt.*;
import javax.swing.*;

public class sign extends JDialog{							//JDialog�� ����ϴ�  signŬ���� ����
	public JButton check =new JButton();					//������ư ����
	public JLabel check2=new JLabel("    ����");				//"����"�� ����
	public JTextArea check3=new JTextArea();				//�ֹ������� Ȯ���� TextArea�� �����
	public JScrollPane check3scroll=new JScrollPane(check3);		//TextArea�� ���� �ֹ����� ���� ���� �� �ֱ⿡ ��ũ���� �����
	public JLabel check4=new JLabel();							//�� �հ踦 ���� �� ����
	public signac sig=new signac();								//sign Ŭ���� ��ü ����
	
	
	public sign(JFrame frame,String title) {				//sign ������
		super(frame,title);
		setLayout(null);
		check.setBounds(150,500,100,50);					//���� ��ư ũ��, ��ġ ����
		check.setBackground(new Color(255,228,75));			//���� ��ư �� ����
		check3scroll.setBounds(10,15,370,120);				//�ֹ�����â ũ��, ��ġ ����
		check3.setEditable(false);							//�ֹ�����â ���� ���� ����
		check4.setBounds(10,120,370,100);					//�� �հ� ũ��, ��ġ ����
		check2.setFont(check2.getFont().deriveFont(15.0f)); //���� �� ��Ʈ ����
		check3.setFont(check3.getFont().deriveFont(15.0f));	//�ֹ����� ��Ʈ ����
		check4.setFont(check3.getFont().deriveFont(20.0f));	//�� �հ� ��Ʈ ����
		check.add(check2);									//��ư�� ���� �� ����
		sig.setBounds(10,250,370,100);						//ī�弭���� ���� �г� ��ġ ����
		sig.setBackground(new Color(0,0,0));				//ī�弭�� ��� ���� ����
		
		
		add(check4);
		add(check3scroll);
		add(check);
		add(sig);
	}


	public static void main(String[] args) {
	}
}

