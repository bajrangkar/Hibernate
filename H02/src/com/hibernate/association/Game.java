package com.hibernate.association;

/**
 * Domain class attached to Student - Many to One - Join table - Unidirectional
 * @author bkar
 *
 */
public class Game {

	private int gameId;
	private String gameName;
	private String gamePosition;

	public Game() {
		super();
	}

	public Game(String gameName, String gamePosition) {
		super();
		this.gameName = gameName;
		this.gamePosition = gamePosition;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getGamePosition() {
		return gamePosition;
	}

	public void setGamePosition(String gamePosition) {
		this.gamePosition = gamePosition;
	}
	
}
