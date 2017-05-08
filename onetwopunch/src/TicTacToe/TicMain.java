package TicTacToe;

public class TicMain{
	
	static int[] score = new int[6];

	public static void main(String[] args) {
		
		for(int i=0; i<score.length; i++){
			score[i] = 0;
		} // 스코어는 프로그램이 실행될 때, 맨 처음 딱 한번 초기화 되어야 그 뒤로 어느 메소드를 실행해도 다시 초기화 되는 일이 없도록
		  // 프로그램이 시작되고 맨처음 딱 한번 실행되는 메인에 초기화를 해주었다.
		
		TicPrimary primary = new TicPrimary();
		primary.runMain();
		
		
	}

}
