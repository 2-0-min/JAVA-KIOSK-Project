package kiosk4;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class snack {
    public int j=0;												//���������,�޴���ư,���������� �ݺ����� ���� ����
	public static String snackmenu[]=new String[5];  			//���� �޴� �ҷ��� �迭 ����
	public static String snackprice[]=new String[5]; 			//���� ���� �ҷ��� �迭 ����
	public String snackstr = "";  								//���� �޴����
	public String snackpricestr=""; 							//���� ���ݴ��
	public JPanel centerp3=new JPanel(); 				//�߾��г�(����3-����)
	public static JButton  bt3[] = new JButton[5];		//���� ��ư ���۷��� ����
///////���� �߰��Ǵ� �κ�%% 14	
	
	
	public snack() {
		centerp3.setLayout(new GridLayout(2,3,10,10));			//Layout ����
		
        /////���� ������� �̿��Ͽ� ������ �̸��� ������ �ҷ��´�./////
        try {
        	FileInputStream file5=new FileInputStream("menu/menu3.txt");		//�ҷ��� ���� ��ü ����(��� ��Ȯ�� ����)
        	InputStreamReader in5=new InputStreamReader(file5,"UTF-8");			//�Է� ��Ʈ�� ����(������ �о����)
        	BufferedReader reader5 =new BufferedReader(in5);					//�Է¹��� ����(���پ� �о���̱� ����)

        	while((snackstr=reader5.readLine())!=null) {						//while���� ����Ͽ� ���پ� �о���̵��� ����
        		snackmenu[j]=snackstr;
        		j++;
        	}
        	in5.close();
        }
        catch(IOException e) {
        	System.out.println(e);
        }
        j=0;
        try {
        	FileInputStream file6=new FileInputStream("menu/price3.txt");		//�ҷ��� ���� ��ü ����(��� ��Ȯ�� ����)
        	InputStreamReader in6=new InputStreamReader(file6,"UTF-8");			//�Է� ��Ʈ�� ����(������ �о����)
        	BufferedReader reader6 =new BufferedReader(in6);					//�Է¹��� ����(���پ� �о���̱� ����)
        	
        	while((snackpricestr=reader6.readLine())!=null) {					//while���� ����Ͽ� ���پ� �о���̵��� ����
        		snackprice[j]=snackpricestr;
        		j++;
        	}
        	in6.close();
        }
        catch(IOException e) {
        	System.out.println(e);
        }
        j=0;
        
        /////���� �迭/////
        JPanel snack[]=new JPanel[5];			//���� ����panel ���۷��� ����
        JLabel l3[] = new JLabel[5];			//���� �� ���۷��� ����
        ImageIcon images3[] = new ImageIcon[5];	//���� �̹��������� ���۷��� ����
        
        
        /////���� ��ư����/////
        for(int j=0;j<snack.length;j++) {
        	snack[j]=new JPanel();  												//���� panel���� �޴����� ���ο� panel ��ü ���� ����
        	snack[j].setLayout(new BorderLayout());  								// Layout ����
        	bt3[j]=new JButton(); 													//���� ��ư ��ü ����
            images3[j] = new ImageIcon("images/����/"+snackmenu[j] + ".jpg");				//���� �̹��� ����
            bt3[j].setIcon(images3[j]);
        	snack[j].add(bt3[j],BorderLayout.CENTER);
        	l3[j]=new JLabel("        "+snackmenu[j]+"           "+snackprice[j]);   //��ǰ�̸� ���̱�
        	l3[j].setFont(l3[j].getFont().deriveFont(15.0f)); 						 //��ǰ ����ũ�� ����
        	snack[j].add(l3[j],BorderLayout.SOUTH);
        	centerp3.add(snack[j]);
        }
        /////���� ���� �ޱ�/////
        for(int j=0;j<snack.length;j++) {
        	bt3[j].setToolTipText(snackmenu[j]+"�� �����÷��� Ŭ���Ͻʽÿ�");
        }
	}
	

	public static void main(String[] args) {

	}

}
