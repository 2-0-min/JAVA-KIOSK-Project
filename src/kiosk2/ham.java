package kiosk2;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class ham {
	public int j=0;													//���������,�޴���ư,���������� �ݺ����� ���� ����
	public static String hammenu[]=new String[6];  					//�ܹ��Ż�ǰ �ҷ��� �迭 ����
	public static String hamprice[]=new String[6];  				//�ܹ��� ����  �ҷ��� �迭 ����
	public String hamstr = ""; 										//�ܹ��� ��ǰ���
	public String hampricestr=""; 									//�ܹ��� ���ݴ��
	public JPanel centerp=new JPanel();						//�߾��г�(����1-�ܹ���)
	public static JButton bt[] = new JButton[6];			//�ܹ��� ��ư ���۷��� ����

	public ham(){
	centerp.setLayout(new GridLayout(2,3,10,10));					//Layout ����
	
    /////���� ������� �̿��Ͽ� �ܹ����� �̸��� ������ �ҷ��´�./////
    try {
    	FileInputStream file=new FileInputStream("menu/menu.txt");		//�ҷ��� ���� ��ü ����(��� ��Ȯ�� ����)
    	InputStreamReader in=new InputStreamReader(file,"UTF-8");		//�Է� ��Ʈ�� ����(������ �о����)
    	BufferedReader reader =new BufferedReader(in);					//�Է¹��� ����(���پ� �о���̱� ����)

    	while((hamstr=reader.readLine())!=null) {						//while���� ����Ͽ� ���پ� �о���̵��� ����
    		hammenu[j]=hamstr;
    		j++;
    	}
    	in.close();
    }
    catch(IOException e) {
    	System.out.println(e);
    }
    j=0;
    try {
    	FileInputStream file2=new FileInputStream("menu/price.txt");		//�ҷ��� ���� ��ü ����(��� ��Ȯ�� ����)
    	InputStreamReader in2=new InputStreamReader(file2,"UTF-8");			//�Է� ��Ʈ�� ����(������ �о����)
    	BufferedReader reader2 =new BufferedReader(in2);					//�Է¹��� ����(���پ� �о���̱� ����)
    	
    	while((hampricestr=reader2.readLine())!=null) {						//while���� ����Ͽ� ���پ� �о���̵��� ����
    		hamprice[j]=hampricestr;
    		j++;
    	}
    	in2.close();
    }
    catch(IOException e) {
    	System.out.println(e);
    }
    j=0;
    
    /////�ܹ��� �迭/////
    JPanel ham[]=new JPanel[6];				//�ܹ��� panel ���۷��� ����
    JLabel l[] = new JLabel[6];				//�ܹ��� �� ���۷��� ����
    ImageIcon images[] = new ImageIcon[6];	//�ܹ��� �̹��������� ���۷��� ����
  
    /////�ܹ��� ��ư����/////
    for(int j=0;j<ham.length;j++) {
    	ham[j]=new JPanel();  														//�ܹ��� panel���� �޴����� ���ο� panel���� ��ü ����
    	ham[j].setLayout(new BorderLayout());  										// Layout ����
    	bt[j]=new JButton();  														//�ܹ��� ��ư ��ü ����
        images[j] = new ImageIcon("images/�ܹ���2/"+hammenu[j] + ".jpg"); 			//�ܹ��� �̹��� ����
        bt[j].setIcon(images[j]);
    	ham[j].add(bt[j],BorderLayout.CENTER);
    	l[j]=new JLabel("        "+hammenu[j]+"           "+hamprice[j]); 			//��ǰ�̸� ���̱�
    	l[j].setFont(l[j].getFont().deriveFont(15.0f));  							//��ǰ ����ũ�� ����
    	ham[j].add(l[j],BorderLayout.SOUTH);
    	centerp.add(ham[j]);
    }

    /////�ܹ��� ���� �ޱ�/////
    for(int j=0;j<ham.length;j++) {
    	bt[j].setToolTipText(hammenu[j]+"�� �����÷��� Ŭ���Ͻʽÿ�");
    }
    }

	public static void main(String[] args) {

	}

}
