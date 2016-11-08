package com.nhance.assignment.datastore;

import com.nhance.assignment.constants.Constants.GameLevel;

public class Game {

	private int gameId;
	private GameLevel gameLevel;
	private String name;
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public GameLevel getGameLevel() {
		return gameLevel;
	}
	public void setGameLevel(GameLevel gameLevel) {
		this.gameLevel = gameLevel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "GameDetails [gameId=" + gameId + ", gameLevel=" + gameLevel
				+ ", name=" + name + "]";
	}
	
}
