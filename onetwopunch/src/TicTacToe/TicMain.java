package TicTacToe;

public class TicMain{
	
	static int[] score = new int[6];

	public static void main(String[] args) {
		
		for(int i=0; i<score.length; i++){
			score[i] = 0;
		} // ���ھ�� ���α׷��� ����� ��, �� ó�� �� �ѹ� �ʱ�ȭ �Ǿ�� �� �ڷ� ��� �޼ҵ带 �����ص� �ٽ� �ʱ�ȭ �Ǵ� ���� ������
		  // ���α׷��� ���۵ǰ� ��ó�� �� �ѹ� ����Ǵ� ���ο� �ʱ�ȭ�� ���־���.
		
		TicPrimary primary = new TicPrimary();
		primary.runMain();
		
		
	}

}
