package kiosk4;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class snack {
    public int j=0;												//파일입출력,메뉴버튼,툴팁생성시 반복문을 위한 선언
	public static String snackmenu[]=new String[5];  			//간식 메뉴 불러올 배열 선언
	public static String snackprice[]=new String[5]; 			//간식 가격 불러올 배열 선언
	public String snackstr = "";  								//간식 메뉴담기
	public String snackpricestr=""; 							//간식 가격담기
	public JPanel centerp3=new JPanel(); 				//중앙패널(탭팬3-간식)
	public static JButton  bt3[] = new JButton[5];		//간식 버튼 레퍼런스 선언
///////새로 추가되는 부분%% 14	
	
	
	public snack() {
		centerp3.setLayout(new GridLayout(2,3,10,10));			//Layout 설정
		
        /////파일 입출력을 이용하여 간식의 이름과 가격을 불러온다./////
        try {
        	FileInputStream file5=new FileInputStream("menu/menu3.txt");		//불러올 파일 객체 생성(경로 정확히 기입)
        	InputStreamReader in5=new InputStreamReader(file5,"UTF-8");			//입력 스트림 생성(파일을 읽어들임)
        	BufferedReader reader5 =new BufferedReader(in5);					//입력버퍼 생성(한줄씩 읽어들이기 위함)

        	while((snackstr=reader5.readLine())!=null) {						//while문을 사용하여 한줄씩 읽어들이도록 설정
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
        	FileInputStream file6=new FileInputStream("menu/price3.txt");		//불러올 파일 객체 생성(경로 정확히 기입)
        	InputStreamReader in6=new InputStreamReader(file6,"UTF-8");			//입력 스트림 생성(파일을 읽어들임)
        	BufferedReader reader6 =new BufferedReader(in6);					//입력버퍼 생성(한줄씩 읽어들이기 위함)
        	
        	while((snackpricestr=reader6.readLine())!=null) {					//while문을 사용하여 한줄씩 읽어들이도록 설정
        		snackprice[j]=snackpricestr;
        		j++;
        	}
        	in6.close();
        }
        catch(IOException e) {
        	System.out.println(e);
        }
        j=0;
        
        /////간식 배열/////
        JPanel snack[]=new JPanel[5];			//간식 각각panel 레퍼런스 선언
        JLabel l3[] = new JLabel[5];			//간식 라벨 레퍼런스 선언
        ImageIcon images3[] = new ImageIcon[5];	//간식 이미지아이콘 레퍼런스 선언
        
        
        /////간식 버튼설정/////
        for(int j=0;j<snack.length;j++) {
        	snack[j]=new JPanel();  												//간식 panel내에 메뉴마다 새로운 panel 객체 각각 생성
        	snack[j].setLayout(new BorderLayout());  								// Layout 설정
        	bt3[j]=new JButton(); 													//간식 버튼 객체 생성
            images3[j] = new ImageIcon("images/간식/"+snackmenu[j] + ".jpg");				//간식 이미지 삽입
            bt3[j].setIcon(images3[j]);
        	snack[j].add(bt3[j],BorderLayout.CENTER);
        	l3[j]=new JLabel("        "+snackmenu[j]+"           "+snackprice[j]);   //상품이름 붙이기
        	l3[j].setFont(l3[j].getFont().deriveFont(15.0f)); 						 //상품 글자크기 설정
        	snack[j].add(l3[j],BorderLayout.SOUTH);
        	centerp3.add(snack[j]);
        }
        /////간식 툴팁 달기/////
        for(int j=0;j<snack.length;j++) {
        	bt3[j].setToolTipText(snackmenu[j]+"를 담으시려면 클릭하십시오");
        }
	}
	

	public static void main(String[] args) {

	}

}
