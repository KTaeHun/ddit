package kr.or.ddit.basic;

import java.util.Random;

import javax.swing.JOptionPane;

public class T07ThreadGame {
   
	public static boolean inputCheck = false;
		
	public static void main(String[] args) {
	
	Random random = new Random();
	int num = random.nextInt(3);
	RPSCountDown count = new RPSCountDown();
	
	String[] rpsArr = {"가위", "바위", "보"};
    String computer = rpsArr[num];   
	// String으로 랜덤으로 들어간 난수에 의한 인덱스로 가위바위보 중에 하나를 구할 수있음
    count.start();
    
    String player = JOptionPane.showInputDialog("가위바위보를 입력하세요");
    T07ThreadGame.inputCheck = true;
    
    System.out.println("===결 과===");
    System.out.println("컴퓨터 :" + computer);
    System.out.println("당 신 : " + player);
    
	if(player.contentEquals(computer)) {
		System.out.println("결 과 : 비겼습니다.");
	} else if(computer.equals("가위") && player.equals("바위") || computer.equals("바위") && player.equals("보") 
			|| computer.equals("보") && player.equals("가위")) {
		System.out.println("결 과 : 당신이 이겼습니다.");
	} else { 
		System.out.println("결 과 : 당신이 졌습니다.");		
	}
   }
}
 
class RPSCountDown extends Thread {
	
	@Override
	public void run() {
		
		for (int i = 5; i >= 1; i--) {
			   
			if(T07ThreadGame.inputCheck) {
				return;  
			}
						
			System.out.println(i + "초");
			   
			   try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			  }
		}
		
		System.out.println("5초가 지났습니다. 기권입니다.");
		System.exit(0); 
	}
}