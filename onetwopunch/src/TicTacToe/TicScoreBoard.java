package TicTacToe;

import java.util.Scanner;

public class TicScoreBoard {
	
	private TicUi ui;
	private TicPrimary pri;
	
	@SuppressWarnings("resource")
	public void scoreBoard(){
		ui = new TicUi();
		pri = new TicPrimary();
		ui.clearScreen();
		ui.showScore();
		new Scanner(System.in).nextLine();
		ui.clearScreen();
		pri.runMain();
		
	}

}
