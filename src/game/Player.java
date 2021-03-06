package game;

import java.util.ArrayList;

import javax.sound.midi.VoiceStatus;

import card.Card;
import card.Property;
import enumeration.Token;

public class Player {
	
	boolean bankrupt;
	int balance, location, turn;
	final Token token;
	final String name;
	int inJailTurns = 0;
	boolean isInJail = false;
	public Card[] jailCardOwned = new Card[2]; // Array to hold the jail free cards
	ArrayList<Property> propertiesOwned = new ArrayList<Property>(); // Array to hold the property cards

	/**
	 * Constructor for the player class
	 * 
	 * @param name  of the player
	 * @param token selected by the player
	 */
	public Player(String name, Token token, int balance, int turn, int location) {
		this.name = name;
		this.token = token;
		this.balance += balance;
		this.turn = turn;
		this.location = location;
		this.bankrupt = false;
	}

	/**
	 * @param amount money added to the balance
	 */
	public void addMoney(int amount) {
		this.balance += amount;
	}

	public Token getToken() {
		return this.token;
	}

	public String getName() {
		return this.name;
	}

	public int getBalance() {
		return this.balance;
	}
	
	public void substractBalance(int amount) {
		balance -= amount;
	}

	public void setBalance(int balance) {
		this.balance += balance;
	}

	public int getLocation() {
		return this.location;
	}

	public void addLocation(int location) {
		this.location += location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int getTurn() {
		return this.turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public void isInJail(boolean isInJail) {
		this.isInJail = isInJail;
	}

	public ArrayList<Property> getPropertiesOwned() {
		
		return this.propertiesOwned;
	}
	
	public int getTurnInJail() {
		return this.inJailTurns;
	}
	
	public void setTurnInJail(int inJailTurns) {
		this.inJailTurns = inJailTurns;
	}
	
	public boolean isBankrupt() {
		return false;
	}
	
	public void mortage(Property toMortgage) {
		toMortgage.setMortgage(true);
		this.addMoney(toMortgage.getCost() / 2);
		System.out.println("\nYou received $" + (toMortgage.getCost() / 2) + " extra.\n");
	}

	public void buyAgain(Property selected) {
		selected.setMortgage(false);
		this.substractBalance(selected.getCost());
		System.out.println("\nYou paid $" + selected.getCost() + " to get the property back.\n");
		
	}
	

}