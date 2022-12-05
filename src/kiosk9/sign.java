package kiosk9;

import java.awt.*;
import javax.swing.*;

public class sign extends JDialog{							//JDialog를 상속하는  sign클래스 생성
	public JButton check =new JButton();					//결제버튼 생성
	public JLabel check2=new JLabel("    결제");				//"결제"라벨 생성
	public JTextArea check3=new JTextArea();				//주문내역을 확인할 TextArea를 만든다
	public JScrollPane check3scroll=new JScrollPane(check3);		//TextArea에 많은 주문으로 인해 못볼 수 있기에 스크롤을 만든다
	public JLabel check4=new JLabel();							//총 합계를 위한 라벨 생성
	public signac sig=new signac();								//sign 클래스 객체 생성
	
	
	public sign(JFrame frame,String title) {				//sign 생성자
		super(frame,title);
		setLayout(null);
		check.setBounds(150,500,100,50);					//결제 버튼 크기, 위치 설정
		check.setBackground(new Color(255,228,75));			//결제 버튼 색 설정
		check3scroll.setBounds(10,15,370,120);				//주문내역창 크기, 위치 설정
		check3.setEditable(false);							//주문내역창 편집 금지 설정
		check4.setBounds(10,120,370,100);					//총 합계 크기, 위치 설정
		check2.setFont(check2.getFont().deriveFont(15.0f)); //결제 라벨 폰트 설정
		check3.setFont(check3.getFont().deriveFont(15.0f));	//주문내역 폰트 설정
		check4.setFont(check3.getFont().deriveFont(20.0f));	//총 합계 폰트 설정
		check.add(check2);									//버튼에 결제 라벨 부착
		sig.setBounds(10,250,370,100);						//카드서명을 위한 패널 위치 설정
		sig.setBackground(new Color(0,0,0));				//카드서명 배경 색상 설정
		
		
		add(check4);
		add(check3scroll);
		add(check);
		add(sig);
	}


	public static void main(String[] args) {
	}
}

