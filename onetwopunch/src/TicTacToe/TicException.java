package TicTacToe;

import java.util.Scanner;

public class TicException{
	
	private static Scanner s1;
	private static TicUi ui;
	
	public static int InputExceptionCatch(int mod){
		int buffer = 0;
		boolean flag = true;
		String str = null;
		ui = new TicUi();
		switch(mod){
		case 1:
			while(true){
				flag = true;
				s1 = new Scanner(System.in);
				try{
					buffer = s1.nextInt();
					if(buffer<1 || buffer>4) flag = false;
				}catch(Exception e){
					flag = false;
				}
				if(flag) break;
				System.out.println("Please check your answer");
				try{Thread.sleep(1000);}catch(Exception ex){}
				ui.clearScreen();
				ui.showMenu();
				System.out.println();
				System.out.print("Select Num. ");
			}
			break;
		case 2:
			while(true){
				flag = true;
				s1 = new Scanner(System.in);
				try{
					buffer = s1.nextInt();
					if(buffer<1 || buffer>9){
						flag = false;
						str = "'" + buffer +"' is out of range.";
					}
					for(int i=0; i<TicGame.select.size(); i++){
						if(buffer == TicGame.select.get(i)){
							flag = false;
							str = "'" + buffer +"' is already chosen number.";
						}
					}
				}catch(Exception e){
					flag = false;
					str = "Please check your answer.";
				}
				if(flag) break;
				System.out.println(str);
				try{Thread.sleep(1000);}catch(Exception ex){}
				ui.clearScreen();
				ui.printBoard();
				System.out.print("Select again. ");
			}
			break;
		case 3:
			while(true){
				flag = true;
				s1 = new Scanner(System.in);
				try{
					str = s1.nextLine();
					str = str.toUpperCase();
					if(str.isEmpty() == true) flag = false;
					else if(str.charAt(0) != 'Y' && str.charAt(0) != 'N') flag = false;
					else if(str.length() > 1) flag = false;
				}catch(Exception e){ }
				if(flag) break;
				System.out.println("Please check your answer.");
				try{Thread.sleep(1000);}catch(Exception ex){}
				ui.clearScreen();
				System.out.print("Continue? Y/N ");
			}
			if(str.charAt(0) == 'Y') buffer = 1;
			else if(str.charAt(0) == 'N') buffer = 2;
			break;
		
		}

		return buffer;
	}

}
