package entities;

public class Board {
	
	private String board[][] = new String[4][4];
	
	public Board(){
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if( (i!= 0 && j!=0) || ( i == 0 && j ==0) ) {
					board[i][j] = "  ";
				}
				else {
					if( j!= 0) {
						board[i][j] =  Integer.toString(j)+" ";
					}
					else {
						board[i][j] = Integer.toString(i)+" ";
					}
				}
			}
		}
	}
	
	public String[][] getBoard() {
		return this.board;
	}
	
	public void setBoard(int line, int column, char symbol) {
			board [line][column] = String.valueOf(symbol)+" ";
	}
	
	public String showBoard() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i< 4; i++) {
			for(int j= 0; j<4; j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public boolean finalGame(char symbol) {
		String position = String.valueOf(symbol);
		if((board[1][1].trim().equals(position) && board[1][2].trim().equals(position) && board[1][3].trim().equals(position)) ||  
		   (board[2][1].trim().equals(position) && board[2][2].trim().equals(position) && board[2][3].trim().equals(position)) ||	
		   (board[3][1].trim().equals(position) && board[3][2].trim().equals(position) && board[3][3].trim().equals(position)) ||
		   (board[1][1].trim().equals(position) && board[2][1].trim().equals(position) && board[3][1].trim().equals(position)) ||
		   (board[1][2].trim().equals(position) && board[2][2].trim().equals(position) && board[3][2].trim().equals(position)) ||
		   (board[1][3].trim().equals(position) && board[2][3].trim().equals(position) && board[3][3].trim().equals(position)) ||
		   (board[1][1].trim().equals(position) && board[2][2].trim().equals(position) && board[3][3].trim().equals(position)) ||
		   (board[3][1].trim().equals(position) && board[2][2].trim().equals(position) && board[1][3].trim().equals(position))) {
			return true;
		}
		return false;
		
	}
	
	
}

