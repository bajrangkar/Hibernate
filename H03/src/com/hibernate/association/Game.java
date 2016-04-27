package com.hibernate.association;

import java.util.Set;

/**
 * Domain class attached to Student - Many to One/One to Many - Join table - Bidirectional
 * @author bkar
 *
 */
public class Game {

	private int gameId;
	private String gameName;
	private String gamePosition;
	// One To Many/Many To One - Join Table - Bidirectional 
	private Set<Student> students;
	
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

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
}
