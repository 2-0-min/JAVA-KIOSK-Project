package kiosk7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextArea;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class order {
	/////동쪽패널(주문창 첨가)/////
	public JPanel eastp=new JPanel();
	public static String [] names= {"카드","현금","기타"};               //결제수단 콤보박스를 위한 배열선언
	public static TextArea ta=new TextArea(35,40); 						//장바구니 텍스트에리아 생성
	public static JComboBox<String> cashcombo=new JComboBox<String>();  //콤보박스 객체 생성
	
	public order() {
		eastp.setLayout(new BorderLayout());
		
        /////주문창 생성/////
		ta.setText("      상품                        수량                      가격\n\n");
		ta.setBackground(Color.LIGHT_GRAY);                  //배경색상 선정
		ta.setEditable(false);                               //편집가능여부(불가)
		eastp.add(new JScrollPane(ta),BorderLayout.NORTH);   //스크롤바 추가
		
		
        /////결제수단 라벨 생성/////
        JLabel label4=new JLabel("                                   결제수단을 선택하시오");  
        label4.setSize(100,100);                                  //라벨 크기 설정
        eastp.add(label4,BorderLayout.CENTER);                    //동쪽패널에 첨가
        
        
        /////결제수단 콤보박스/////
        for(int i=0;i<names.length;i++) {
        	cashcombo.addItem(names[i]);
        	eastp.add(cashcombo,BorderLayout.SOUTH);              //동쪽패널에 첨가
        }
    }

	public static void main(String[] args) {

	}

}
