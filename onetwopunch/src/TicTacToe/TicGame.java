package TicTacToe;

import java.util.*;

public class TicGame {
	
	private TicUi ui;
	private TicDetermine det;
	private TicPrimary pri;
	private Scanner scan, sc;
	
	public static String[] loc; // ���õ� ������ �ٵ��ǿ� �����ϱ� ���� �迭
	public static int turn; // �� 0~8���� 9���� ������ �Ǿ�������, ��ü ���õ� ������ �����ϱ����� �迭�� index�ε� ���
	public static List<Integer> select, select1P, select2P; // ��ü ���õ� ����� �÷��̾� ���� ������ ������ ����
	public static boolean p1Flag, p2Flag; // �÷��̾��� �¸� ���θ� �Ǵ��ϱ����� �÷���
	public static int buffer; // ���õ� ���ڰ� ����� �������� �Ǻ��ϱ� ���� �ӽ÷� �����ϱ����� ����
	public static boolean flag; // vs com���� ��ǻ�Ͱ� 1~9���� �����ϰ� �� ���� �̹� ���õ� �������� Ȯ���ϱ����� �÷���
	
	public void p1Routine(){
			buffer = 0;
			System.out.print("1P trun. Select Num. ");
			buffer = TicException.InputExceptionCatch(2);
			select.add(buffer);
			loc[select.get(turn)-1] = "��";
			select1P.add(select.get(turn));
			ui.clearScreen();
			ui.printBoard();
			det.checkResult(turn%2); // �� �ϸ��� �¸� ���θ� üũ
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
			loc[select.get(turn)-1] = "��";
			select2P.add(select.get(turn));
			ui.clearScreen();
			if(mode == 0) System.out.println("Computer: " + buffer);
			ui.printBoard();
			det.checkResult(turn%2); // �� �ϸ��� �¸� ���θ� üũ
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
		} // ó���� �ٵ��� ����� ����� TicUi.Loc�� ����Ѵ�.
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
					} // �¸����� ��ƾ
				} // 1P turn
				else if(turn%2 == 1){
					this.p2Routine(turn%2 -1);
					if(p2Flag == true){
						ui.clearScreen();
						ui.printBoard();
						TicMain.score[2]++;
						System.out.println("Computer WIN!");
						break;
					} // �¸����� ��ƾ
				} // Com turn
				turn ++;
			}
			if(p1Flag == false && p2Flag == false){
				TicMain.score[1]++;
				System.out.println("DRAW!");
			} // �ΰ��� �÷��װ� ��� false�� ��� ���º� ó���Ѵ�.
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
					} // �¸����� ��ƾ
				} // 1P turn
				else if(turn%2 == 1){
					this.p2Routine(turn%2);
					if(p2Flag == true){
						ui.clearScreen();
						ui.printBoard();
						TicMain.score[5]++;
						System.out.println("P2 WIN!");
						break;
					} // �¸����� ��ƾ
				} // 2P turn
				turn ++;
			}
			if(p1Flag == false && p2Flag == false){
				TicMain.score[4]++;
				System.out.println("DRAW!");
			} // �� ���� �÷��װ� ��� false�� ��� ���º� ó���Ѵ�.
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
