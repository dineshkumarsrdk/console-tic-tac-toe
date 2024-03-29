package com.dine.tictactoe;

public class Player {
	private String name;
	private char symbol;
	
	public Player(String name, char symbol) {
		this.name=name;
		this.symbol=symbol;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setSymbol(char symbol) {
		this.symbol=symbol;
	}
	
	public char getSymbol() {
		return this.symbol;
	}
}
