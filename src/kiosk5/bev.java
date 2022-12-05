package kiosk5;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class bev {
    public int j=0;													    //파일입출력,메뉴버튼,툴팁생성시 반복문을 위한 선언
	public static String bevmenu[]=new String[6];  						//음료 메뉴 불러올 배열 선언
	public static String bevprice[]=new String[6]; 						//음료 가격 불러올 배열 선언
	public String bevstr = "";  										//음료 메뉴담기
	public String bevpricestr=""; 										//음료 가격담기
	public JPanel centerp4=new JPanel(); 						//중앙패널(탭팬4-음료)
    public static JButton  bt4[] = new JButton[6];		//음료 버튼 레퍼런스 선언
	////%% 새로추가되는 부분 14,
	
    public bev() {
		centerp4.setLayout(new GridLayout(2,3,10,10));
    	
        /////파일 입출력을 이용하여 음료의 이름과 가격을 불러온다./////
        try {
        	FileInputStream file7=new FileInputStream("menu/menu4.txt");		//불러올 파일 객체 생성(경로 정확히 기입)
        	InputStreamReader in7=new InputStreamReader(file7,"UTF-8");			//입력 스트림 생성(파일을 읽어들임)
        	BufferedReader reader7 =new BufferedReader(in7);					//입력버퍼 생성(한줄씩 읽어들이기 위함)

        	while((bevstr=reader7.readLine())!=null) {							//while문을 사용하여 한줄씩 읽어들이도록 설정
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
        	FileInputStream file8=new FileInputStream("menu/price4.txt");		//불러올 파일 객체 생성(경로 정확히 기입)
        	InputStreamReader in8=new InputStreamReader(file8,"UTF-8");			//입력 스트림 생성(파일을 읽어들임)
        	BufferedReader reader8 =new BufferedReader(in8);					//입력버퍼 생성(한줄씩 읽어들이기 위함)
        	
        	while((bevpricestr=reader8.readLine())!=null) {						//while문을 사용하여 한줄씩 읽어들이도록 설정
        		bevprice[j]=bevpricestr;
        		j++;
        	}
        	in8.close();
        }
        catch(IOException e) {
        	System.out.println(e);
        }
        j=0;
        
        /////음료 배열/////
        JPanel bev[]=new JPanel[6];				//음료 panel 레퍼런스 선언
        JLabel l4[] = new JLabel[6];			//음료 라벨 레퍼런스 선언
        ImageIcon images4[] = new ImageIcon[6];	//음료 이미지 아이콘 레퍼런스 선언
        
        /////음료 버튼설정/////
        for(int j=0;j<bev.length;j++) {
        	bev[j]=new JPanel();  														//음료  panel내에 메뉴마다 새로운 panel 객체 각각 생성
        	bev[j].setLayout(new BorderLayout());  										//Layout 설정
        	bt4[j]=new JButton();  														//음료 버튼 객체생성
            images4[j] = new ImageIcon("images/음료/"+bevmenu[j] + ".jpg");				//음료 이미지 삽입
            bt4[j].setIcon(images4[j]);
        	bev[j].add(bt4[j],BorderLayout.CENTER);
        	l4[j]=new JLabel("        "+bevmenu[j]+"           "+bevprice[j]); 			//상품이름 붙이기
        	l4[j].setFont(l4[j].getFont().deriveFont(15.0f));  							//상품 글자 크기 설정
        	bev[j].add(l4[j],BorderLayout.SOUTH);
        	centerp4.add(bev[j]);
        }
        /////음료 툴팁 달기/////
        for(int j=0;j<bev.length;j++) {
        	bt4[j].setToolTipText(bevmenu[j]+"를 담으시려면 클릭하십시오");
        }
		
    }

	public static void main(String[] args) {


	}

}
