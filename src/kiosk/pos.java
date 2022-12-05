package kiosk;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import kiosk2.ham;                                         //kiosk2패키지 ham클래스 호출
import kiosk3.rice;                                        //kiosk3패키지 rice클래스 호출
import kiosk4.snack;                                       //kiosk4패키지 snack클래스 호출
import kiosk5.bev;                                         //kiosk5패키지 bev클래스 호출
import kiosk6.Title;									   //kiosk6패키지 Title클래스 호출
import kiosk7.order;									   //kiosk7패키지 order클래스 호출
import kiosk8.cancel;									   //kiosk8패키지 cancel클래스 호출		
import kiosk9.sign;										   //kiosk9패키지 sign클래스 호출	

/////dialog 생성/////
class dialog extends JDialog{					//JDialog를 상속하는  dialog클래스 생성
	public int count=0;								//JDialog 상품 수량을 설정하기 위한 변수 생성
	public static int sum=0;						//선택 상품의 총 합을 구하기 위한 변수 생성
	public JTextField suja[]=new JTextField[8];		//상품 수량을 나타내기위한 JTextField
	public JButton plus[]= new JButton[8];			//상품  + 버튼 
	public JButton minus[]= new JButton[8];			//상품  - 버튼
	public JButton ok[] = new JButton[8];			//상품 담기 버튼

	public dialog(JFrame frame,String title, int i, String []menu, String []price) {				//dialog 생성자
		super(frame,title);
		
		suja[i]=new JTextField(count+"");						//JTextfield 생성
		suja[i].setEditable(false);								//입력 불가하고  +,-로 이용가능하도록
		suja[i].setFont(suja[i].getFont().deriveFont(20.0f)); 		//상품 숫자 폰트 설정
		plus[i]=new JButton(" + ");						
		minus[i]=new JButton(" - ");
		ok[i]=new JButton("담기");
		setLayout(new BorderLayout());
		add(plus[i],BorderLayout.EAST);
		add(minus[i],BorderLayout.WEST);
		add(suja[i],BorderLayout.CENTER);
		add(ok[i],BorderLayout.SOUTH);
		setSize(200,150);

		//+버튼 액션
		plus[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count=count+1;											//수량 +1
				suja[i].setText(count+"");								//텍스트필드에 숫자 추가
				ok[i].setEnabled(true);									//담기 버튼 사용가능
				if(count>0) {											//수량이 0보다 클 때 -버튼 사용가능
					minus[i].setEnabled(true);
				}
			}
		});

		//-버튼 액션
		minus[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count>0) {											//수량이 0 보다 클때
					count=count-1;										//수량 -1
					suja[i].setText(count+"");							//텍스트필드에 숫자 추가
					ok[i].setEnabled(true);								//담기버튼 사용가능
				}else {
					minus[i].setEnabled(false);							//수량이 0 이하일때 - 버튼 사용 불가능
				}
			}
		});

		//담기버튼  액션 
		ok[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count!=0) {
					order.ta.append("     "+menu[i]+"                    "+count+"                          "+Integer.parseInt(price[i])*count+"\n");
				}
				setVisible(false);												//수량이 0이 아닐 때 "상품, 수량, 가격 " 을 장바구니에 출력
				sum=sum+Integer.parseInt(price[i])*count;						//총 주문 금액 합계
				count=0;														//수량을 0 으로 초기화
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
    public sign card=new sign(this,"주문 내역");
	public int j=0;	
	public static String menuname[]=new String[4];  					//메뉴 이름 불러올 배열 선언
	public String menunamestr = ""; 										//메뉴 이름담기
    public dialog hd[]=new dialog[ham.hammenu.length];			//햄버거 다이얼로그를 위한 배열레퍼런스 생성
    public dialog rd[]=new dialog[rice.ricemenu.length];		//라면&밥 다이얼로그를 위한 배열레퍼런스 생성
    public dialog sd[]=new dialog[snack.snackmenu.length];		//간식 다이얼로그를 위한 배열레퍼런스 생성
    public dialog bd[]=new dialog[bev.bevmenu.length];			//음료 다이얼로그를 위한 배열레퍼런스 생성
    public static int index;				//콤보박스의 선택된 값을 불러오기 위한 index 생성
    
	public pos() {
		setTitle("JAVA PC");                               //타이틀 이름
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //프레임이 닫힐때 프로그램도 종료
		Container c=getContentPane();                      //c라는 컨텐트페인을 알아낸다
		c.setLayout(new BorderLayout());                   //c 컨텐트 페인 Layout 설정
        ToolTipManager m= ToolTipManager.sharedInstance();			//툴팁 매니저 객체 생성
        
        /////햄버거 수량조정 다이얼로그/////
        for(int j=0;j<ham.hammenu.length;j++) {
        	int i=j;
        	hd[i]=new dialog(this,ham.hammenu[i],i,ham.hammenu, ham.hamprice);	//햄버거
        	ham.bt[i].addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			hd[i].setVisible(true);
        			hd[i].setLocation(300,250);						//클릭한 메뉴 가깝게 다이얼로그 생성되도록 위치 선정
        		}
        	});
        }
        /////라면&밥 수량조정 다이얼로그/////
        for(int j=0;j<rice.ricemenu.length;j++) {
        	int i=j;
        	rd[i]=new dialog(this,rice.ricemenu[i],i,rice.ricemenu, rice.riceprice);
        	rice.bt2[i].addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			rd[i].setVisible(true);
        			rd[i].setLocation(300,250);						//클릭한 메뉴 가깝게 다이얼로그 생성되도록 위치 선정
        		}
        	});
        }
          /////간식 수량조정 다이얼로그/////
        for(int j=0;j<snack.snackmenu.length;j++) {
        	int i=j;
        	sd[i]=new dialog(this,snack.snackmenu[i],i,snack.snackmenu, snack.snackprice);
        	snack.bt3[i].addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			sd[i].setVisible(true);
        			sd[i].setLocation(300,250);						//클릭한 메뉴 가깝게 다이얼로그 생성되도록 위치 선정
        		}
        	});
        }
        /////음료 수량조정 다이얼로그/////
        for(int j=0;j<bev.bevmenu.length;j++) {
        	int i=j;
        	bd[i]=new dialog(this,bev.bevmenu[i],i,bev.bevmenu, bev.bevprice);
        	bev.bt4[i].addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			bd[i].setVisible(true);
        			bd[i].setLocation(300,250);						//클릭한 메뉴 가깝게 다이얼로그 생성되도록 위치 선정
        		}
        	});
        }

      /////캐시콤보 불러오기 액션/////
		order.cashcombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>)e.getSource();
				index = cb.getSelectedIndex();
				}
		});
		/////주문 버튼 액션/////
		cancel.btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dialog.sum==0) {									//상품이 선택되어야만 주문 버튼 실행
					JOptionPane.showMessageDialog(null, "상품을 선택하시오!!","Message",JOptionPane.ERROR_MESSAGE);
				}
				else {
				card.setVisible(true);;				//주문내역 창
				card.setLocation(400,150);				//주문내역 창 위치 설정
				card.setSize(400,600);					//주문내역 창 크기 설정
				card.check3.setText(order.ta.getText());			//주문내역창에 장바구니 내역 담기
				card.check4.setText("총 주문 금액  = "+dialog.sum+"원");		//총 주문 금액 출력
				if(order.names[index].equals("카드")) 				//콤보박스가 "카드"이면 전자서명 아니면 전자서명을 없앤다.
					card.sig.setVisible(true);
					else
						card.sig.setVisible(false);
				}
			}	
		});

		/////결제 버튼 액션 추가/////
		card.check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.sig.vStart.removeAllElements();								//카드 서명 공간 초기화
				int result = JOptionPane.showConfirmDialog(null, "계속 주문 하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION) {							//팝업다이얼로그 종료시 아무일도 생기지않는다.
					return;}
				else if(result == JOptionPane.YES_OPTION) {							//YES버튼 클릭시 또 다른 팝업메시지 창 출력
					JOptionPane.showMessageDialog(null, order.ta.getText()+"\n총 주문 금액  = "+dialog.sum+"원"+"\n\n결제수단 = "
				+order.names[index]+"\n\n주문이 완료되었습니다.\n\n\n이용해주셔서 감사합니다.");}
				else ;
				order.ta.setText("      상품                        수량                      가격\n\n");			//결제버튼 클릭 후 장바구니 초기화
				dialog.sum=0;														//결제버튼 클릭 후 총 합 금액 초기화
				card.setVisible(false);												//결제버튼 후 다이얼로그 보이지않게 만듦	
			}
		}
		);
        /////초기화 버튼 액션/////
        cancel.btn2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		order.ta.setText("      상품                        수량                      가격\n\n");			//장바구니 초기화
        		dialog.sum=0;														//담았던 상품 총합 초기화
        	}
    	});
    	
        /////파일 입출력을 이용하여 메뉴 제목을 불러온다./////
        try {
        	FileInputStream namefile=new FileInputStream("menu/menuname.txt");		//불러올 파일 객체 생성(경로 정확히 기입)
        	InputStreamReader namein=new InputStreamReader(namefile,"UTF-8");		//입력 스트림 생성(파일을 읽어들임)
        	BufferedReader namereader =new BufferedReader(namein);					//입력버퍼 생성(한줄씩 읽어들이기 위함)

        	while((menunamestr=namereader.readLine())!=null) {						//while문을 사용하여 한줄씩 읽어들이도록 설정
        		menuname[j]=menunamestr;
        		j++;
        	}
        	namein.close();
        }
        catch(IOException e) {
        	System.out.println(e);
        }
        j=0;
        
		/////메뉴 탭팬 생성/////
        JTabbedPane pane=new JTabbedPane(); 
		pane.add(menuname[0],h.centerp);                       //햄버거 패널 첨가
		pane.add(menuname[1],r.centerp2);                    //라면&밥 패널 첨가
		pane.add(menuname[2],s.centerp3);                     //간식 패널 첨가
		pane.add(menuname[3],b.centerp4);                       //음료 패널 첨가
		pane.setSize(700,500);                              //탭팬 크기설정
        c.add(pane,BorderLayout.CENTER);                    //컨텐트패인에 탭팬 첨가
        c.add(o.eastp,BorderLayout.EAST);                       //동쪽패널을 c컨텐트페인에 첨가
        c.add(ca.southp,BorderLayout.SOUTH);                    //남쪽패널을 c컨텐트페인에 첨가
        c.add(t.northp,BorderLayout.NORTH);                     //북쪽패널을 c컨텐트페인에 첨가-큰 타이틀
       

        m.setInitialDelay(0);									//툴팁 최소 지연시간 제어
        m.setDismissDelay(7000);								//툴팁이 켜져있는 지연 시간 제어
        setSize(1000,800);                                        //frame의 크기 설정
        setVisible(true);										  //frame을 보이게 할것인가
	}
	
	public static void main(String[] args) {
		new pos();
		
	}

}

