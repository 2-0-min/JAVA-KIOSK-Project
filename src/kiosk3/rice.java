package kiosk3;

import java.awt.*;
import java.io.*;
import javax.swing.*;


public class rice {
    public int j=0;											//파일입출력,메뉴버튼,툴팁생성시 반복문을 위한 선언
	public static String ricemenu[]=new String[8];  		//라면&밥 메뉴 불러올 배열 선언
	public static String riceprice[]=new String[8]; 		//라면&밥 가격 불러올 배열 선언
	public String ricestr = "";  							//라면&밥 메뉴담기
	public String ricepricestr=""; 							//라면&밥 가격담기
	public JPanel centerp2=new JPanel(); 					//중앙패널(탭팬2-라면&밥)
    //새로추가된느 부분%%16, 
    public static JButton  bt2[] = new JButton[8];		//라면&밥 버튼 레퍼런스 선언
	
	
	public rice() {
	centerp2.setLayout(new GridLayout(3,3,10,10));			//layout설정
	
    /////파일 입출력을 이용하여 라면&밥의 이름과 가격을 불러온다./////
    try {
    	FileInputStream file3=new FileInputStream("menu/menu2.txt");		//불러올 파일 객체 생성(경로 정확히 기입)
    	InputStreamReader in3=new InputStreamReader(file3,"UTF-8");			//입력 스트림 생성(파일을 읽어들임)
    	BufferedReader reader3 =new BufferedReader(in3);					//입력버퍼 생성(한줄씩 읽어들이기 위함)

    	while((ricestr=reader3.readLine())!=null) {							//while문을 사용하여 한줄씩 읽어들이도록 설정
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
    	FileInputStream file4=new FileInputStream("menu/price2.txt");		//불러올 파일 객체 생성(경로 정확히 기입)
    	InputStreamReader in4=new InputStreamReader(file4,"UTF-8");			//입력 스트림 생성(파일을 읽어들임)
    	BufferedReader reader4 =new BufferedReader(in4);					//입력버퍼 생성(한줄씩 읽어들이기 위함)
    	
    	while((ricepricestr=reader4.readLine())!=null) {					//while문을 사용하여 한줄씩 읽어들이도록 설정
    		riceprice[j]=ricepricestr;
    		j++;
    	}
    	in4.close();
    }
    catch(IOException e) {
    	System.out.println(e);
    }
    j=0;

    /////라면&밥 배열/////
    JPanel rice[]=new JPanel[8];			//라면&밥 각각panel 레퍼런스 선언
    JLabel l2[] = new JLabel[8];			//라면&밥 라벨 레퍼런스 선언
    ImageIcon images2[] = new ImageIcon[8];	//라면&밥 이미지아이콘 레퍼런스 선언
    
    /////라면&밥 버튼설정/////
    for(int j=0;j<rice.length;j++) {
    	rice[j]=new JPanel();  																			//라면&밥 panel내에 메뉴마다 새로운 panel객체 각각 생성
    	rice[j].setLayout(new BorderLayout());  														// Layout 설정
    	bt2[j]=new JButton();  																			//라면&밥 버튼 객체 생성
        images2[j] = new ImageIcon("images/라면&밥/"+ricemenu[j] + ".jpg");									//라면&밥 이미지 삽입
        bt2[j].setIcon(images2[j]);
    	rice[j].add(bt2[j],BorderLayout.CENTER);
    	l2[j]=new JLabel("        "+ricemenu[j]+"           "+riceprice[j]); 							//상품이름 붙이기
    	l2[j].setFont(l2[j].getFont().deriveFont(15.0f));  												//상품 글자크기 설정
    	rice[j].add(l2[j],BorderLayout.SOUTH);
    	centerp2.add(rice[j]);
    }
    /////라면&밥 툴팁 달기/////
    for(int j=0;j<rice.length;j++) {
    	bt2[j].setToolTipText(ricemenu[j]+"를 담으시려면 클릭하십시오");
    }
	}
	
	
	public static void main(String[] args) {


	}

}
