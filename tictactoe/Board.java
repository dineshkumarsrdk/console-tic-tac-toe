package com.dine.tictactoe;

public class Board {
	private final int boardSize = 3; 
	private char[][] board;
	private int moveCount=0;
	public static final int INCOMPLETE = 1;
	public static final int PLAYERWINS = 2;
	public static final int INVALID = 3;
	public static final int DRAW = 4;
	
	public Board(char player1Symbol, char player2Symbol) {
		board = new char[boardSize][boardSize];
	}
	
	public int move (int x, int y, Player player) {
		if(x<0 || x>=boardSize || y<0 || y>=boardSize || board[x][y]!='\0') {
			return INVALID;
		} else {
			board[x][y] = player.getSymbol();
			moveCount++;
		}
		
		// Checking row
		if(board[x][0] == board[x][1] && board[x][1] == board[x][2]) {
			return PLAYERWINS;
		}
		// Checking column
		if(board[0][y] == board[1][y] && board[1][y] == board[2][y]) {
			return PLAYERWINS;
		}
		// Checking diagonal
		if(board[0][0] != '\0' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			return PLAYERWINS;
		}
		// Checking diagonal
		if(board[0][2] != '\0' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			return PLAYERWINS;
		}
		
		//Match draw
		if(moveCount == boardSize*boardSize) {
			return DRAW;
		}
		return INCOMPLETE;
	}

	public void printBoard() {
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board.length; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
}