package TicTacToe;

import java.util.Scanner;

public class TicPrimary{
	
	private TicUi ui;
	private TicGame game;
	private TicScoreBoard scoreBoard;
	private int sel;
	
	@SuppressWarnings("resource")
	public void runMain(){
		
		ui = new TicUi();
		game = new TicGame();
		scoreBoard = new TicScoreBoard();
		
		ui.showMenu();
		Scanner s1 = new Scanner(System.in);
		System.out.println();
		System.out.print("Select Num. ");
		
		sel = TicException.InputExceptionCatch(1);
		
		switch(sel){
		case 1:
			game.gameMod(sel);
			break;
		case 2:
			game.gameMod(sel);
			break;
		case 3:
			scoreBoard.scoreBoard();
			break;
		case 4:
			ui.exitProgram();
			break;
		}
		
	}

}
