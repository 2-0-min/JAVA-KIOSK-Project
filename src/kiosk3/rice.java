package kiosk3;

import java.awt.*;
import java.io.*;
import javax.swing.*;


public class rice {
    public int j=0;											//���������,�޴���ư,���������� �ݺ����� ���� ����
	public static String ricemenu[]=new String[8];  		//���&�� �޴� �ҷ��� �迭 ����
	public static String riceprice[]=new String[8]; 		//���&�� ���� �ҷ��� �迭 ����
	public String ricestr = "";  							//���&�� �޴����
	public String ricepricestr=""; 							//���&�� ���ݴ��
	public JPanel centerp2=new JPanel(); 					//�߾��г�(����2-���&��)
    //�����߰��ȴ� �κ�%%16, 
    public static JButton  bt2[] = new JButton[8];		//���&�� ��ư ���۷��� ����
	
	
	public rice() {
	centerp2.setLayout(new GridLayout(3,3,10,10));			//layout����
	
    /////���� ������� �̿��Ͽ� ���&���� �̸��� ������ �ҷ��´�./////
    try {
    	FileInputStream file3=new FileInputStream("menu/menu2.txt");		//�ҷ��� ���� ��ü ����(��� ��Ȯ�� ����)
    	InputStreamReader in3=new InputStreamReader(file3,"UTF-8");			//�Է� ��Ʈ�� ����(������ �о����)
    	BufferedReader reader3 =new BufferedReader(in3);					//�Է¹��� ����(���پ� �о���̱� ����)

    	while((ricestr=reader3.readLine())!=null) {							//while���� ����Ͽ� ���پ� �о���̵��� ����
    		ricemenu[j]=ricestr;
    		j++;
    	}
    	in3.close();
    }
    catch(IOException e) {
    	System.out.println(e);
    }
    j=0;
    try {
    	FileInputStream file4=new FileInputStream("menu/price2.txt");		//�ҷ��� ���� ��ü ����(��� ��Ȯ�� ����)
    	InputStreamReader in4=new InputStreamReader(file4,"UTF-8");			//�Է� ��Ʈ�� ����(������ �о����)
    	BufferedReader reader4 =new BufferedReader(in4);					//�Է¹��� ����(���پ� �о���̱� ����)
    	
    	while((ricepricestr=reader4.readLine())!=null) {					//while���� ����Ͽ� ���پ� �о���̵��� ����
    		riceprice[j]=ricepricestr;
    		j++;
    	}
    	in4.close();
    }
    catch(IOException e) {
    	System.out.println(e);
    }
    j=0;

    /////���&�� �迭/////
    JPanel rice[]=new JPanel[8];			//���&�� ����panel ���۷��� ����
    JLabel l2[] = new JLabel[8];			//���&�� �� ���۷��� ����
    ImageIcon images2[] = new ImageIcon[8];	//���&�� �̹��������� ���۷��� ����
    
    /////���&�� ��ư����/////
    for(int j=0;j<rice.length;j++) {
    	rice[j]=new JPanel();  																			//���&�� panel���� �޴����� ���ο� panel��ü ���� ����
    	rice[j].setLayout(new BorderLayout());  														// Layout ����
    	bt2[j]=new JButton();  																			//���&�� ��ư ��ü ����
        images2[j] = new ImageIcon("images/���&��/"+ricemenu[j] + ".jpg");									//���&�� �̹��� ����
        bt2[j].setIcon(images2[j]);
    	rice[j].add(bt2[j],BorderLayout.CENTER);
    	l2[j]=new JLabel("        "+ricemenu[j]+"           "+riceprice[j]); 							//��ǰ�̸� ���̱�
    	l2[j].setFont(l2[j].getFont().deriveFont(15.0f));  												//��ǰ ����ũ�� ����
    	rice[j].add(l2[j],BorderLayout.SOUTH);
    	centerp2.add(rice[j]);
    }
    /////���&�� ���� �ޱ�/////
    for(int j=0;j<rice.length;j++) {
    	bt2[j].setToolTipText(ricemenu[j]+"�� �����÷��� Ŭ���Ͻʽÿ�");
    }
	}
	
	
	public static void main(String[] args) {


	}

}
