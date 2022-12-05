package kiosk6;

import java.awt.*;
import javax.swing.*;

public class Title {
	/////북쪽패널 (JAVA PC 제목)/////
	public JPanel northp=new JPanel();
	
	public Title() {
 
	northp.setLayout(null);
	northp.setBackground(new Color(200, 100, 215));								//북쪽패널 배경색상 설정
	northp.setPreferredSize(new Dimension(1000,100));							//북쪽패널 크기 설정
	
	/////메인 제목 사진 생성/////
	ImageIcon image=new ImageIcon("images//computer.jpg"); 
	Image getImg=image.getImage();
	Image changeImg=getImg.getScaledInstance(60, 60, Image.SCALE_SMOOTH); //사진은 크기에 맞게 resize 해준다.
	ImageIcon newImg=new ImageIcon(changeImg);  
    JLabel label=new JLabel(newImg);                         					//라벨에 이미지 첨가
    label.setSize(60,60);                                    					//라벨 크기 설정
    label.setLocation(440,20);                               					//라벨 위치 선정
    northp.add(label);                                       					//북쪽패널에 첨가
    
    JLabel label2=new JLabel("JAVA PC방");                    					 //메인 제목 생성("JAVA PC방")
    label2.setSize(150,60);                                  					 //라벨 크기 설정
    label2.setLocation(510,20);                              					 //라벨 위치 설정
    label2.setFont(label2.getFont().deriveFont(20.0f));       					//글자 크기설정
    northp.add(label2);                                       					//북쪽패널에 첨가
	}
	
	
	public static void main(String[] args) {

	}

}
