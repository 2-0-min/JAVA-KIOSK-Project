package kiosk2;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class ham {
	public int j=0;													//파일입출력,메뉴버튼,툴팁생성시 반복문을 위한 선언
	public static String hammenu[]=new String[6];  					//햄버거상품 불러올 배열 선언
	public static String hamprice[]=new String[6];  				//햄버거 가격  불러올 배열 선언
	public String hamstr = ""; 										//햄버거 상품담기
	public String hampricestr=""; 									//햄버거 가격담기
	public JPanel centerp=new JPanel();						//중앙패널(탭팬1-햄버거)
	public static JButton bt[] = new JButton[6];			//햄버거 버튼 레퍼런스 선언

	public ham(){
	centerp.setLayout(new GridLayout(2,3,10,10));					//Layout 설정
	
    /////파일 입출력을 이용하여 햄버거의 이름과 가격을 불러온다./////
    try {
    	FileInputStream file=new FileInputStream("menu/menu.txt");		//불러올 파일 객체 생성(경로 정확히 기입)
    	InputStreamReader in=new InputStreamReader(file,"UTF-8");		//입력 스트림 생성(파일을 읽어들임)
    	BufferedReader reader =new BufferedReader(in);					//입력버퍼 생성(한줄씩 읽어들이기 위함)

    	while((hamstr=reader.readLine())!=null) {						//while문을 사용하여 한줄씩 읽어들이도록 설정
    		hammenu[j]=hamstr;
    		j++;
    	}
    	in.close();
    }
    catch(IOException e) {
    	System.out.println(e);
    }
    j=0;
    try {
    	FileInputStream file2=new FileInputStream("menu/price.txt");		//불러올 파일 객체 생성(경로 정확히 기입)
    	InputStreamReader in2=new InputStreamReader(file2,"UTF-8");			//입력 스트림 생성(파일을 읽어들임)
    	BufferedReader reader2 =new BufferedReader(in2);					//입력버퍼 생성(한줄씩 읽어들이기 위함)
    	
    	while((hampricestr=reader2.readLine())!=null) {						//while문을 사용하여 한줄씩 읽어들이도록 설정
    		hamprice[j]=hampricestr;
    		j++;
    	}
    	in2.close();
    }
    catch(IOException e) {
    	System.out.println(e);
    }
    j=0;
    
    /////햄버거 배열/////
    JPanel ham[]=new JPanel[6];				//햄버거 panel 레퍼런스 선언
    JLabel l[] = new JLabel[6];				//햄버거 라벨 레퍼런스 선언
    ImageIcon images[] = new ImageIcon[6];	//햄버거 이미지아이콘 레퍼런스 선언
  
    /////햄버거 버튼설정/////
    for(int j=0;j<ham.length;j++) {
    	ham[j]=new JPanel();  														//햄버거 panel내에 메뉴마다 새로운 panel각각 객체 생성
    	ham[j].setLayout(new BorderLayout());  										// Layout 설정
    	bt[j]=new JButton();  														//햄버거 버튼 객체 생성
        images[j] = new ImageIcon("images/햄버거2/"+hammenu[j] + ".jpg"); 			//햄버거 이미지 삽입
        bt[j].setIcon(images[j]);
    	ham[j].add(bt[j],BorderLayout.CENTER);
    	l[j]=new JLabel("        "+hammenu[j]+"           "+hamprice[j]); 			//상품이름 붙이기
    	l[j].setFont(l[j].getFont().deriveFont(15.0f));  							//상품 글자크기 설정
    	ham[j].add(l[j],BorderLayout.SOUTH);
    	centerp.add(ham[j]);
    }

    /////햄버거 툴팁 달기/////
    for(int j=0;j<ham.length;j++) {
    	bt[j].setToolTipText(hammenu[j]+"를 담으시려면 클릭하십시오");
    }
    }

	public static void main(String[] args) {

	}

}
