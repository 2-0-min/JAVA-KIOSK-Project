package kiosk5;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class bev {
    public int j=0;													    //���������,�޴���ư,���������� �ݺ����� ���� ����
	public static String bevmenu[]=new String[6];  						//���� �޴� �ҷ��� �迭 ����
	public static String bevprice[]=new String[6]; 						//���� ���� �ҷ��� �迭 ����
	public String bevstr = "";  										//���� �޴����
	public String bevpricestr=""; 										//���� ���ݴ��
	public JPanel centerp4=new JPanel(); 						//�߾��г�(����4-����)
    public static JButton  bt4[] = new JButton[6];		//���� ��ư ���۷��� ����
	////%% �����߰��Ǵ� �κ� 14,
	
    public bev() {
		centerp4.setLayout(new GridLayout(2,3,10,10));
    	
        /////���� ������� �̿��Ͽ� ������ �̸��� ������ �ҷ��´�./////
        try {
        	FileInputStream file7=new FileInputStream("menu/menu4.txt");		//�ҷ��� ���� ��ü ����(��� ��Ȯ�� ����)
        	InputStreamReader in7=new InputStreamReader(file7,"UTF-8");			//�Է� ��Ʈ�� ����(������ �о����)
        	BufferedReader reader7 =new BufferedReader(in7);					//�Է¹��� ����(���پ� �о���̱� ����)

        	while((bevstr=reader7.readLine())!=null) {							//while���� ����Ͽ� ���پ� �о���̵��� ����
        		bevmenu[j]=bevstr;
        		j++;
        	}
        	in7.close();
        }
        catch(IOException e) {
        	System.out.println(e);
        }
        j=0;
        try {
        	FileInputStream file8=new FileInputStream("menu/price4.txt");		//�ҷ��� ���� ��ü ����(��� ��Ȯ�� ����)
        	InputStreamReader in8=new InputStreamReader(file8,"UTF-8");			//�Է� ��Ʈ�� ����(������ �о����)
        	BufferedReader reader8 =new BufferedReader(in8);					//�Է¹��� ����(���پ� �о���̱� ����)
        	
        	while((bevpricestr=reader8.readLine())!=null) {						//while���� ����Ͽ� ���پ� �о���̵��� ����
        		bevprice[j]=bevpricestr;
        		j++;
        	}
        	in8.close();
        }
        catch(IOException e) {
        	System.out.println(e);
        }
        j=0;
        
        /////���� �迭/////
        JPanel bev[]=new JPanel[6];				//���� panel ���۷��� ����
        JLabel l4[] = new JLabel[6];			//���� �� ���۷��� ����
        ImageIcon images4[] = new ImageIcon[6];	//���� �̹��� ������ ���۷��� ����
        
        /////���� ��ư����/////
        for(int j=0;j<bev.length;j++) {
        	bev[j]=new JPanel();  														//����  panel���� �޴����� ���ο� panel ��ü ���� ����
        	bev[j].setLayout(new BorderLayout());  										//Layout ����
        	bt4[j]=new JButton();  														//���� ��ư ��ü����
            images4[j] = new ImageIcon("images/����/"+bevmenu[j] + ".jpg");				//���� �̹��� ����
            bt4[j].setIcon(images4[j]);
        	bev[j].add(bt4[j],BorderLayout.CENTER);
        	l4[j]=new JLabel("        "+bevmenu[j]+"           "+bevprice[j]); 			//��ǰ�̸� ���̱�
        	l4[j].setFont(l4[j].getFont().deriveFont(15.0f));  							//��ǰ ���� ũ�� ����
        	bev[j].add(l4[j],BorderLayout.SOUTH);
        	centerp4.add(bev[j]);
        }
        /////���� ���� �ޱ�/////
        for(int j=0;j<bev.length;j++) {
        	bt4[j].setToolTipText(bevmenu[j]+"�� �����÷��� Ŭ���Ͻʽÿ�");
        }
		
    }

	public static void main(String[] args) {


	}

}
