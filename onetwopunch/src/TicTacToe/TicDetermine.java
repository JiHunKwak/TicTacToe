package TicTacToe;

public class TicDetermine {
	
	public static boolean[] determineFlag;

	public void checkResult(int turn){
		determineFlag = new boolean[9];
//		for(int i=0; i<determineFlag.length; i++)
//			determineFlag[i] = false;
		
		if(turn == 0)
			for(int value : TicGame.select1P) determineFlag[value-1] = true;
		else if(turn == 1)
			for(int value : TicGame.select2P) determineFlag[value-1] = true;
		
		for(int i=0; i<TicUi.CASE.length; i++){
			if(determineFlag[TicUi.CASE[i][0]] == true 
					&& determineFlag[TicUi.CASE[i][1]] == true
					&& determineFlag[TicUi.CASE[i][2]] == true){
				if(turn == 0) TicGame.p1Flag = true;
				else if(turn == 1) TicGame.p2Flag = true;
				break;
			}
		}
	}

}
