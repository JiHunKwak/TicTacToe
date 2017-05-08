package TicTacToe;

import java.util.*;

public class TicGame {
	
	private TicUi ui;
	private TicDetermine det;
	private TicPrimary pri;
	private Scanner scan, sc;
	
	public static String[] loc; // 선택된 돌을을 바둑판에 적용하기 위한 배열
	public static int turn; // 총 0~8까지 9번의 턴으로 되어있으며, 전체 선택된 돌들을 저장하기위한 배열의 index로도 사용
	public static List<Integer> select, select1P, select2P; // 전체 선택된 돌들과 플레이어 각각 선택한 돌들을 저장
	public static boolean p1Flag, p2Flag; // 플레이어의 승리 여부를 판단하기위한 플래그
	public static int buffer; // 선택된 숫자가 사용이 가능한지 판별하기 위해 임시로 저장하기위한 변수
	public static boolean flag; // vs com에서 컴퓨터가 1~9까지 랜덤하게 고른 수가 이미 선택된 수인지를 확인하기위한 플래그
	
	public void p1Routine(){
			buffer = 0;
			System.out.print("1P trun. Select Num. ");
			buffer = TicException.InputExceptionCatch(2);
			select.add(buffer);
			loc[select.get(turn)-1] = "●";
			select1P.add(select.get(turn));
			ui.clearScreen();
			ui.printBoard();
			det.checkResult(turn%2); // 매 턴마다 승리 여부를 체크
		}
	
	public void p2Routine(int mode){
			buffer = 0;
			if(mode == 0){
				while(true){
					buffer = new Random().nextInt(9)+1;
					flag = true;
					for(int i=0; i<select.size(); i++){
						if(buffer == select.get(i)) flag = false;
					}
					if(flag == true) break;
				}
			}
			else if(mode == 1){
				System.out.print("Player2 turn. Select Num. ");
				buffer = TicException.InputExceptionCatch(2);
			}
			select.add(buffer);
			loc[select.get(turn)-1] = "○";
			select2P.add(select.get(turn));
			ui.clearScreen();
			if(mode == 0) System.out.println("Computer: " + buffer);
			ui.printBoard();
			det.checkResult(turn%2); // 매 턴마다 승리 여부를 체크
	}
	
	public void gameMod(int mod){
		
		scan = new Scanner(System.in);
		sc = new Scanner(System.in);
		
		select = new ArrayList<>();
		select1P = new ArrayList<>();
		select2P = new ArrayList<>();
		
		loc = new String[9];
		turn = 0;
		p1Flag = false;
		p2Flag = false;
		
		ui = new TicUi();
		det = new TicDetermine();
		pri = new TicPrimary();
		
		buffer = 0; 
		flag = true;
		
		ui.clearScreen();
		for(int i=0; i<loc.length; i++){
			loc[i] = TicUi.LOC[i];
		} // 처음의 바둑판 모양은 상수인 TicUi.Loc를 사용한다.
		ui.printBoard();
		
		switch(mod){
		case 1:
			while(turn != 9){
				if(turn%2 == 0){
					this.p1Routine();
					if(p1Flag == true){
						ui.clearScreen();
						ui.printBoard();
						TicMain.score[0]++;
						System.out.println("You WIN!");
						break;
					} // 승리시의 루틴
				} // 1P turn
				else if(turn%2 == 1){
					this.p2Routine(turn%2 -1);
					if(p2Flag == true){
						ui.clearScreen();
						ui.printBoard();
						TicMain.score[2]++;
						System.out.println("Computer WIN!");
						break;
					} // 승리시의 루틴
				} // Com turn
				turn ++;
			}
			if(p1Flag == false && p2Flag == false){
				TicMain.score[1]++;
				System.out.println("DRAW!");
			} // 두개의 플래그가 모두 false일 경우 무승부 처리한다.
			break; // VS Com
			
		case 2:
			while(turn != 9){
				if(turn%2 == 0){
					this.p1Routine();
					if(p1Flag == true){
						ui.clearScreen();
						ui.printBoard();
						TicMain.score[3]++;
						System.out.println("P1 WIN!");
						break;
					} // 승리시의 루틴
				} // 1P turn
				else if(turn%2 == 1){
					this.p2Routine(turn%2);
					if(p2Flag == true){
						ui.clearScreen();
						ui.printBoard();
						TicMain.score[5]++;
						System.out.println("P2 WIN!");
						break;
					} // 승리시의 루틴
				} // 2P turn
				turn ++;
			}
			if(p1Flag == false && p2Flag == false){
				TicMain.score[4]++;
				System.out.println("DRAW!");
			} // 두 개의 플래그가 모두 false일 경우 무승부 처리한다.
			break; // VS User
		}
		
		System.out.print("Continue? Y/N ");
		int status = TicException.InputExceptionCatch(3);
		if(status == 1){
			ui.clearScreen();
			pri.runMain();
		}
		else if(status == 2) ui.exitProgram();
	}
	
}
