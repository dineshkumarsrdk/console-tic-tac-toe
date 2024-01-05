package com.dine.tictactoe;

import java.util.Scanner;

public class Tictactoe {
	Player player1;
	Player player2;
	Board board;
	
	public void startGame() {
		inputPlayerDetails();
		this.board = new Board(player1.getSymbol(), player2.getSymbol());
		System.out.println("The game starts now!");
		System.out.println("-----------------------------------------------");
		boolean player1turn=true;
		int status=Board.INCOMPLETE;
		while(status==Board.INCOMPLETE) {
			if(player1turn) {
				System.out.println("Player1's turn now");
				Scanner s = new Scanner(System.in);
				System.out.print("Player1-Enter x coordinate : ");
				int x = s.nextInt();
				System.out.print("Player1-Enter y coordinate : ");
				int y = s.nextInt();
				status=board.move(x, y, player1);
				if(status==Board.INVALID) {
					while(status==Board.INVALID) {
						System.out.println("Please make a valid move");
						System.out.print("Player1-Enter x coordinate : ");
						x = s.nextInt();
						System.out.print("Player1-Enter y coordinate : ");
						y = s.nextInt();
						status=board.move(x, y, player1);
					}
				}
				if(status==Board.PLAYERWINS) {
					System.out.println(player1.getName()+" won the game!");
					board.printBoard();
					return;
				}
				if(status==Board.DRAW) {
					System.out.println("Game draw");
					board.printBoard();
					return;
				}
				board.printBoard();
				System.out.println("-----------------------------------------------");
				player1turn = false;
			} else {
				System.out.println("Player2's turn now");
				Scanner s = new Scanner(System.in);
				System.out.print("Player2-Enter x coordinate : ");
				int x = s.nextInt();
				System.out.print("Player2-Enter y coordinate : ");
				int y = s.nextInt();
				status=board.move(x, y, player2);
				if(status==Board.INVALID) {
					while(status==Board.INVALID) {
						System.out.println("Please make a valid move");
						System.out.print("Player2-Enter x coordinate : ");
						x = s.nextInt();
						System.out.print("Player2-Enter y coordinate : ");
						y = s.nextInt();
						status=board.move(x, y, player2);
					}
				}
				if(status==Board.PLAYERWINS) {
					System.out.println(player2.getName()+" won the game!");
					board.printBoard();
					return;
				}
				if(status==Board.DRAW) {
					System.out.println("Game draw");
					board.printBoard();
					return;
				}
				board.printBoard();
				System.out.println("-----------------------------------------------");
				player1turn=true;
			}
		}
		
	}

	private void inputPlayerDetails() {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter name of player 1 : ");
		String player1Name=s.next();
		System.out.print("Enter symbol for player 1 : ");
		char player1Symbol=s.next().charAt(0);
		System.out.print("Enter name of player 2 : ");
		String player2Name=s.next();
		System.out.print("Enter symbol for player 2 : ");
		char player2Symbol=s.next().charAt(0);
		if(player1Symbol==player2Symbol) {
			while(player1Symbol==player2Symbol) {
				System.out.println("Please choose a different symbol this symbol is already taken by Player1");
				System.out.print("Enter symbol for player 2 : ");
				player2Symbol=s.next().charAt(0);
			}
		}
		this.player1=new Player(player1Name, player1Symbol);
		this.player2=new Player(player2Name, player2Symbol);
	}
	
}
