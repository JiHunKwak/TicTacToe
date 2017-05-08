package TicTacToe;

public class TicUi {
	
	public static final String[] LOC = {"��","��","��","��","��","��","��","��","��"};
	// �⺻���� �ٵ����� ���. ������ �ʴ� ���̱� ������ ����� �����ߴ�.
	
	public static final int[][] CASE 
		= {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
	// �¸��ϱ����� ��� ���� 8����. ������ �ʴ� ���̱� ������ ����� �����ߴ�.
	
	public void clearScreen(){
		for(int i=0; i<80; i++){
			System.out.println("");
		}
	} // ȭ�鿡 �� �� 80���� �߰��ϴ� ���
	
	public void exitProgram(){
		System.out.println();
		System.out.println("Program has terminated.");
		System.exit(0);
	} // ���α׷��� ����Ǿ��ٴ� ������ �Բ� ���α׷� �����ϴ� ���
	
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
	} // �⺻���� �ٵ����� ����� ����ϴ� ���
	
	public void showMenu(){
		System.out.println("Tic Tac Toe Game!!");
		System.out.println();
		System.out.println("1. VS Com");
		System.out.println("2. VS User");
		System.out.println("3. Socre");
		System.out.println("4. Exit");
	} // �⺻���� �޴�ȭ���� ����ϴ� ���
	
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
	} // �⺻���� ���ھ�带 ����ϴ� ���
	

}
