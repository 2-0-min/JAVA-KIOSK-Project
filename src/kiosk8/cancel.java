package kiosk8;

import java.awt.*;
import javax.swing.*;

public class cancel {
	/////�����г�(�ֹ� �ʱ�ȭ)/////
	public JPanel southp=new JPanel(); 							//JPanel ��ü ����
    public static JButton btn1=new JButton();                          //"�ֹ�"�� ���� ��ư ����
    public static JButton btn2=new JButton();    						//"�ʱ�ȭ"�� ���� ��ư ����
    public JLabel la=new JLabel("   �ֹ�");								//"�ֹ�"�� ����
    public JLabel la2=new JLabel(" �ʱ�ȭ");								//"�ʱ�ȭ"�� ����
    
	public cancel() {
		southp.setLayout(null);									//southp ��ġ������ null�� ����
		southp.setBackground(new Color(200, 100, 215));			//�����г� ������ ����
		southp.setPreferredSize(new Dimension(1000,100));		//�����г� ũ�� ����
		
		la.setFont(la.getFont().deriveFont(30.0f));				//"�ֹ�" ��Ʈ ����  
		la2.setFont(la2.getFont().deriveFont(30.0f)); 			//"�ʱ�ȭ"��Ʈ ����
		
        /////�ֹ�,�ʱ�ȭ ��ư/////
        btn1.setSize(150,50);                                     //"�ֹ�"��ư ũ�� ����
        btn1.setLocation(680,25);                                 //"�ֹ�"��ư ��ġ ����
        btn1.setBackground(Color.GREEN);						  //"�ֹ�"��ư ���� ����
        btn2.setSize(150,50);                                     //"�ʱ�ȭ"��ư ũ�� ����
        btn2.setLocation(830,25);                                 //"�ʱ�ȭ"��ư ��ġ ����
        btn2.setBackground(Color.RED);							  //"�ʱ�ȭ"��ư ���� ����
        btn1.add(la);											  //"�ֹ�"�� ��ư�� ����
        btn2.add(la2);											  //"�ʱ�ȭ"�� ��ư�� ����
        
        southp.add(btn1);                                         //�����гο� "�ֹ�"��ư ÷��
        southp.add(btn2);                                         //�����гο� "�ʱ�ȭ"��ư ÷��
        
	}
	
	public static void main(String[] args) {

	}

}
