package kiosk7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextArea;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class order {
	/////�����г�(�ֹ�â ÷��)/////
	public JPanel eastp=new JPanel();
	public static String [] names= {"ī��","����","��Ÿ"};               //�������� �޺��ڽ��� ���� �迭����
	public static TextArea ta=new TextArea(35,40); 						//��ٱ��� �ؽ�Ʈ������ ����
	public static JComboBox<String> cashcombo=new JComboBox<String>();  //�޺��ڽ� ��ü ����
	
	public order() {
		eastp.setLayout(new BorderLayout());
		
        /////�ֹ�â ����/////
		ta.setText("      ��ǰ                        ����                      ����\n\n");
		ta.setBackground(Color.LIGHT_GRAY);                  //������ ����
		ta.setEditable(false);                               //�������ɿ���(�Ұ�)
		eastp.add(new JScrollPane(ta),BorderLayout.NORTH);   //��ũ�ѹ� �߰�
		
		
        /////�������� �� ����/////
        JLabel label4=new JLabel("                                   ���������� �����Ͻÿ�");  
        label4.setSize(100,100);                                  //�� ũ�� ����
        eastp.add(label4,BorderLayout.CENTER);                    //�����гο� ÷��
        
        
        /////�������� �޺��ڽ�/////
        for(int i=0;i<names.length;i++) {
        	cashcombo.addItem(names[i]);
        	eastp.add(cashcombo,BorderLayout.SOUTH);              //�����гο� ÷��
        }
    }

	public static void main(String[] args) {

	}

}
