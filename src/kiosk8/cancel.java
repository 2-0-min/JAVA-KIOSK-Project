package kiosk8;

import java.awt.*;
import javax.swing.*;

public class cancel {
	/////남쪽패널(주문 초기화)/////
	public JPanel southp=new JPanel(); 							//JPanel 객체 생성
    public static JButton btn1=new JButton();                          //"주문"을 넣을 버튼 생성
    public static JButton btn2=new JButton();    						//"초기화"를 넣을 버튼 생성
    public JLabel la=new JLabel("   주문");								//"주문"라벨 생성
    public JLabel la2=new JLabel(" 초기화");								//"초기화"라벨 생성
    
	public cancel() {
		southp.setLayout(null);									//southp 위치지정자 null로 설정
		southp.setBackground(new Color(200, 100, 215));			//남쪽패널 배경색상 설정
		southp.setPreferredSize(new Dimension(1000,100));		//남쪽패널 크기 설정
		
		la.setFont(la.getFont().deriveFont(30.0f));				//"주문" 폰트 설정  
		la2.setFont(la2.getFont().deriveFont(30.0f)); 			//"초기화"폰트 지정
		
        /////주문,초기화 버튼/////
        btn1.setSize(150,50);                                     //"주문"버튼 크기 설정
        btn1.setLocation(680,25);                                 //"주문"버튼 위치 설정
        btn1.setBackground(Color.GREEN);						  //"주문"버튼 색상 설정
        btn2.setSize(150,50);                                     //"초기화"버튼 크기 설정
        btn2.setLocation(830,25);                                 //"초기화"버튼 위치 설정
        btn2.setBackground(Color.RED);							  //"초기화"버튼 색상 설정
        btn1.add(la);											  //"주문"라벨 버튼에 부착
        btn2.add(la2);											  //"초기화"라벨 버튼에 부착
        
        southp.add(btn1);                                         //남쪽패널에 "주문"버튼 첨가
        southp.add(btn2);                                         //남쪽패널에 "초기화"버튼 첨가
        
	}
	
	public static void main(String[] args) {

	}

}
