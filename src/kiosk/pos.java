package kiosk;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import kiosk2.ham;                                         //kiosk2��Ű�� hamŬ���� ȣ��
import kiosk3.rice;                                        //kiosk3��Ű�� riceŬ���� ȣ��
import kiosk4.snack;                                       //kiosk4��Ű�� snackŬ���� ȣ��
import kiosk5.bev;                                         //kiosk5��Ű�� bevŬ���� ȣ��
import kiosk6.Title;									   //kiosk6��Ű�� TitleŬ���� ȣ��
import kiosk7.order;									   //kiosk7��Ű�� orderŬ���� ȣ��
import kiosk8.cancel;									   //kiosk8��Ű�� cancelŬ���� ȣ��		
import kiosk9.sign;										   //kiosk9��Ű�� signŬ���� ȣ��	

/////dialog ����/////
class dialog extends JDialog{					//JDialog�� ����ϴ�  dialogŬ���� ����
	public int count=0;								//JDialog ��ǰ ������ �����ϱ� ���� ���� ����
	public static int sum=0;						//���� ��ǰ�� �� ���� ���ϱ� ���� ���� ����
	public JTextField suja[]=new JTextField[8];		//��ǰ ������ ��Ÿ�������� JTextField
	public JButton plus[]= new JButton[8];			//��ǰ  + ��ư 
	public JButton minus[]= new JButton[8];			//��ǰ  - ��ư
	public JButton ok[] = new JButton[8];			//��ǰ ��� ��ư

	public dialog(JFrame frame,String title, int i, String []menu, String []price) {				//dialog ������
		super(frame,title);
		
		suja[i]=new JTextField(count+"");						//JTextfield ����
		suja[i].setEditable(false);								//�Է� �Ұ��ϰ�  +,-�� �̿밡���ϵ���
		suja[i].setFont(suja[i].getFont().deriveFont(20.0f)); 		//��ǰ ���� ��Ʈ ����
		plus[i]=new JButton(" + ");						
		minus[i]=new JButton(" - ");
		ok[i]=new JButton("���");
		setLayout(new BorderLayout());
		add(plus[i],BorderLayout.EAST);
		add(minus[i],BorderLayout.WEST);
		add(suja[i],BorderLayout.CENTER);
		add(ok[i],BorderLayout.SOUTH);
		setSize(200,150);

		//+��ư �׼�
		plus[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count=count+1;											//���� +1
				suja[i].setText(count+"");								//�ؽ�Ʈ�ʵ忡 ���� �߰�
				ok[i].setEnabled(true);									//��� ��ư ��밡��
				if(count>0) {											//������ 0���� Ŭ �� -��ư ��밡��
					minus[i].setEnabled(true);
				}
			}
		});

		//-��ư �׼�
		minus[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count>0) {											//������ 0 ���� Ŭ��
					count=count-1;										//���� -1
					suja[i].setText(count+"");							//�ؽ�Ʈ�ʵ忡 ���� �߰�
					ok[i].setEnabled(true);								//����ư ��밡��
				}else {
					minus[i].setEnabled(false);							//������ 0 �����϶� - ��ư ��� �Ұ���
				}
			}
		});

		//����ư  �׼� 
		ok[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count!=0) {
					order.ta.append("     "+menu[i]+"                    "+count+"                          "+Integer.parseInt(price[i])*count+"\n");
				}
				setVisible(false);												//������ 0�� �ƴ� �� "��ǰ, ����, ���� " �� ��ٱ��Ͽ� ���
				sum=sum+Integer.parseInt(price[i])*count;						//�� �ֹ� �ݾ� �հ�
				count=0;														//������ 0 ���� �ʱ�ȭ
				suja[i].setText(count+"");
			}
		});
	}
	}

public class pos extends JFrame{
    public ham h=new ham();
    public rice r=new rice();
    public snack s=new snack();
    public bev b=new bev();
    public Title t=new Title();
    public order o=new order();
    public cancel ca=new cancel();
    public sign card=new sign(this,"�ֹ� ����");
	public int j=0;	
	public static String menuname[]=new String[4];  					//�޴� �̸� �ҷ��� �迭 ����
	public String menunamestr = ""; 										//�޴� �̸����
    public dialog hd[]=new dialog[ham.hammenu.length];			//�ܹ��� ���̾�α׸� ���� �迭���۷��� ����
    public dialog rd[]=new dialog[rice.ricemenu.length];		//���&�� ���̾�α׸� ���� �迭���۷��� ����
    public dialog sd[]=new dialog[snack.snackmenu.length];		//���� ���̾�α׸� ���� �迭���۷��� ����
    public dialog bd[]=new dialog[bev.bevmenu.length];			//���� ���̾�α׸� ���� �迭���۷��� ����
    public static int index;				//�޺��ڽ��� ���õ� ���� �ҷ����� ���� index ����
    
	public pos() {
		setTitle("JAVA PC");                               //Ÿ��Ʋ �̸�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //�������� ������ ���α׷��� ����
		Container c=getContentPane();                      //c��� ����Ʈ������ �˾Ƴ���
		c.setLayout(new BorderLayout());                   //c ����Ʈ ���� Layout ����
        ToolTipManager m= ToolTipManager.sharedInstance();			//���� �Ŵ��� ��ü ����
        
        /////�ܹ��� �������� ���̾�α�/////
        for(int j=0;j<ham.hammenu.length;j++) {
        	int i=j;
        	hd[i]=new dialog(this,ham.hammenu[i],i,ham.hammenu, ham.hamprice);	//�ܹ���
        	ham.bt[i].addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			hd[i].setVisible(true);
        			hd[i].setLocation(300,250);						//Ŭ���� �޴� ������ ���̾�α� �����ǵ��� ��ġ ����
        		}
        	});
        }
        /////���&�� �������� ���̾�α�/////
        for(int j=0;j<rice.ricemenu.length;j++) {
        	int i=j;
        	rd[i]=new dialog(this,rice.ricemenu[i],i,rice.ricemenu, rice.riceprice);
        	rice.bt2[i].addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			rd[i].setVisible(true);
        			rd[i].setLocation(300,250);						//Ŭ���� �޴� ������ ���̾�α� �����ǵ��� ��ġ ����
        		}
        	});
        }
          /////���� �������� ���̾�α�/////
        for(int j=0;j<snack.snackmenu.length;j++) {
        	int i=j;
        	sd[i]=new dialog(this,snack.snackmenu[i],i,snack.snackmenu, snack.snackprice);
        	snack.bt3[i].addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			sd[i].setVisible(true);
        			sd[i].setLocation(300,250);						//Ŭ���� �޴� ������ ���̾�α� �����ǵ��� ��ġ ����
        		}
        	});
        }
        /////���� �������� ���̾�α�/////
        for(int j=0;j<bev.bevmenu.length;j++) {
        	int i=j;
        	bd[i]=new dialog(this,bev.bevmenu[i],i,bev.bevmenu, bev.bevprice);
        	bev.bt4[i].addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			bd[i].setVisible(true);
        			bd[i].setLocation(300,250);						//Ŭ���� �޴� ������ ���̾�α� �����ǵ��� ��ġ ����
        		}
        	});
        }

      /////ĳ���޺� �ҷ����� �׼�/////
		order.cashcombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>)e.getSource();
				index = cb.getSelectedIndex();
				}
		});
		/////�ֹ� ��ư �׼�/////
		cancel.btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dialog.sum==0) {									//��ǰ�� ���õǾ�߸� �ֹ� ��ư ����
					JOptionPane.showMessageDialog(null, "��ǰ�� �����Ͻÿ�!!","Message",JOptionPane.ERROR_MESSAGE);
				}
				else {
				card.setVisible(true);;				//�ֹ����� â
				card.setLocation(400,150);				//�ֹ����� â ��ġ ����
				card.setSize(400,600);					//�ֹ����� â ũ�� ����
				card.check3.setText(order.ta.getText());			//�ֹ�����â�� ��ٱ��� ���� ���
				card.check4.setText("�� �ֹ� �ݾ�  = "+dialog.sum+"��");		//�� �ֹ� �ݾ� ���
				if(order.names[index].equals("ī��")) 				//�޺��ڽ��� "ī��"�̸� ���ڼ��� �ƴϸ� ���ڼ����� ���ش�.
					card.sig.setVisible(true);
					else
						card.sig.setVisible(false);
				}
			}	
		});

		/////���� ��ư �׼� �߰�/////
		card.check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.sig.vStart.removeAllElements();								//ī�� ���� ���� �ʱ�ȭ
				int result = JOptionPane.showConfirmDialog(null, "��� �ֹ� �Ͻðڽ��ϱ�?", "Confirm", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION) {							//�˾����̾�α� ����� �ƹ��ϵ� �������ʴ´�.
					return;}
				else if(result == JOptionPane.YES_OPTION) {							//YES��ư Ŭ���� �� �ٸ� �˾��޽��� â ���
					JOptionPane.showMessageDialog(null, order.ta.getText()+"\n�� �ֹ� �ݾ�  = "+dialog.sum+"��"+"\n\n�������� = "
				+order.names[index]+"\n\n�ֹ��� �Ϸ�Ǿ����ϴ�.\n\n\n�̿����ּż� �����մϴ�.");}
				else ;
				order.ta.setText("      ��ǰ                        ����                      ����\n\n");			//������ư Ŭ�� �� ��ٱ��� �ʱ�ȭ
				dialog.sum=0;														//������ư Ŭ�� �� �� �� �ݾ� �ʱ�ȭ
				card.setVisible(false);												//������ư �� ���̾�α� �������ʰ� ����	
			}
		}
		);
        /////�ʱ�ȭ ��ư �׼�/////
        cancel.btn2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		order.ta.setText("      ��ǰ                        ����                      ����\n\n");			//��ٱ��� �ʱ�ȭ
        		dialog.sum=0;														//��Ҵ� ��ǰ ���� �ʱ�ȭ
        	}
    	});
    	
        /////���� ������� �̿��Ͽ� �޴� ������ �ҷ��´�./////
        try {
        	FileInputStream namefile=new FileInputStream("menu/menuname.txt");		//�ҷ��� ���� ��ü ����(��� ��Ȯ�� ����)
        	InputStreamReader namein=new InputStreamReader(namefile,"UTF-8");		//�Է� ��Ʈ�� ����(������ �о����)
        	BufferedReader namereader =new BufferedReader(namein);					//�Է¹��� ����(���پ� �о���̱� ����)

        	while((menunamestr=namereader.readLine())!=null) {						//while���� ����Ͽ� ���پ� �о���̵��� ����
        		menuname[j]=menunamestr;
        		j++;
        	}
        	namein.close();
        }
        catch(IOException e) {
        	System.out.println(e);
        }
        j=0;
        
		/////�޴� ���� ����/////
        JTabbedPane pane=new JTabbedPane(); 
		pane.add(menuname[0],h.centerp);                       //�ܹ��� �г� ÷��
		pane.add(menuname[1],r.centerp2);                    //���&�� �г� ÷��
		pane.add(menuname[2],s.centerp3);                     //���� �г� ÷��
		pane.add(menuname[3],b.centerp4);                       //���� �г� ÷��
		pane.setSize(700,500);                              //���� ũ�⼳��
        c.add(pane,BorderLayout.CENTER);                    //����Ʈ���ο� ���� ÷��
        c.add(o.eastp,BorderLayout.EAST);                       //�����г��� c����Ʈ���ο� ÷��
        c.add(ca.southp,BorderLayout.SOUTH);                    //�����г��� c����Ʈ���ο� ÷��
        c.add(t.northp,BorderLayout.NORTH);                     //�����г��� c����Ʈ���ο� ÷��-ū Ÿ��Ʋ
       

        m.setInitialDelay(0);									//���� �ּ� �����ð� ����
        m.setDismissDelay(7000);								//������ �����ִ� ���� �ð� ����
        setSize(1000,800);                                        //frame�� ũ�� ����
        setVisible(true);										  //frame�� ���̰� �Ұ��ΰ�
	}
	
	public static void main(String[] args) {
		new pos();
		
	}

}

