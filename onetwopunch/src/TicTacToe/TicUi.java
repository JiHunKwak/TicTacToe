package TicTacToe;

public class TicUi {
	
	public static final String[] LOC = {"①","②","③","④","⑤","⑥","⑦","⑧","⑨"};
	// 기본적인 바둑판의 모양. 변하지 않는 값이기 때문에 상수로 선언했다.
	
	public static final int[][] CASE 
		= {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
	// 승리하기위한 모든 조건 8가지. 변하지 않는 값이기 때문에 상수로 선언했다.
	
	public void clearScreen(){
		for(int i=0; i<80; i++){
			System.out.println("");
		}
	} // 화면에 빈 줄 80줄을 추가하는 기능
	
	public void exitProgram(){
		System.out.println();
		System.out.println("Program has terminated.");
		System.exit(0);
	} // 프로그램이 종료되었다는 문구와 함께 프로그램 종료하는 기능
	
	public void printBoard(){
		System.out.println();
		System.out.print(TicGame.loc[0]+"    "+TicGame.loc[1]+"    "+TicGame.loc[2]);
		System.out.println();
		System.out.println();
		System.out.print(TicGame.loc[3]+"    "+TicGame.loc[4]+"    "+TicGame.loc[5]);
		System.out.println();
		System.out.println();
		System.out.println(TicGame.loc[6]+"    "+TicGame.loc[7]+"    "+TicGame.loc[8]);
		System.out.println();
	} // 기본적인 바둑판의 모양을 출력하는 기능
	
	public void showMenu(){
		System.out.println("Tic Tac Toe Game!!");
		System.out.println();
		System.out.println("1. VS Com");
		System.out.println("2. VS User");
		System.out.println("3. Socre");
		System.out.println("4. Exit");
	} // 기본적인 메뉴화면을 출력하는 기능
	
	public void showScore(){
		System.out.println("====================SCORE====================");
		System.out.println("--------------------VS Com-------------------");
		System.out.println("  1P Win             DRAW           Com win  ");
		System.out.println("    "+TicMain.score[0]+"                 "+TicMain.score[1]
				+"                "+TicMain.score[2]+"    ");
		System.out.println("-------------------VS User-------------------");
		System.out.println("  1P Win             DRAW            2P win  ");
		System.out.println("    "+TicMain.score[3]+"                 "+TicMain.score[4]
				+"                "+TicMain.score[5]+"    ");
		System.out.println("=============================================");
		System.out.println();
		System.out.print("Press any Key to back to main ");
	} // 기본적인 스코어보드를 출력하는 기능
	

}
