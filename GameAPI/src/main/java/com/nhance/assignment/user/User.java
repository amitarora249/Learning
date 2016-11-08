package com.nhance.assignment.user;

import com.nhance.assignment.constants.Constants.UserSkillLevel;
import com.nhance.assignment.datastore.Game;

public class User {

	private int userId;
	private Game currentGame;
	private UserSkillLevel currentSkillLevel;
	private long score;
	private int progressPercentage;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Game getCurrentGame() {
		return currentGame;
	}

	public void setCurrentLevel(Game currentGame) {
		this.currentGame = currentGame;
	}

	public UserSkillLevel getCurrentSkillLevel() {
		return currentSkillLevel;
	}

	public void setCurrentSkillLevel(UserSkillLevel currentSkillLevel) {
		this.currentSkillLevel = currentSkillLevel;
	}

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}

	public int getProgressPercentage() {
		return progressPercentage;
	}

	public void setProgressPercentage(int progressPercentage) {
		this.progressPercentage = progressPercentage;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", currentGame=" + currentGame
				+ ", currentSkillLevel=" + currentSkillLevel + ", score="
				+ score + ", progressPercentage=" + progressPercentage + "]";
	}

}
