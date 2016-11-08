package com.nhance.assignment.user;

import com.nhance.assignment.constants.Constants.GameLevel;
import com.nhance.assignment.constants.Constants.UserSkillLevel;
import com.nhance.assignment.datastore.DataStore;
import com.nhance.assignment.datastore.Threshold;

public class UserResult {

	private static final UserResult result = new UserResult();
	private User user;

	private UserResult() {

	}

	public static UserResult getInstance() {
		return result;
	}

	public User submitScore(int userId, long score) {

		if (score == 0) {
			user = new User();
			user.setUserId(userId);
			user.setCurrentSkillLevel(UserSkillLevel.BEGINNER);
			user.setScore(0);
			return user;

		} else {
			user = getNextGame(score);
			return user;
		}
	}

	private User getNextGame(long score) {

		GameLevel currentLevel = user.getCurrentGame().getGameLevel();

		// get scorebonus
		Threshold threshold = DataStore.getThreshold(currentLevel);
		int goodScore = threshold.getGoodScore();
		int bonus = 0;
		if (score >= goodScore) {
			bonus = threshold.getGoodBonus();
		} else {
			bonus = threshold.getNormalBonus();
		}
		int bonusScore = (int) (score * (bonus / 100.0f));
		score = score + bonusScore + user.getScore();

		// check user skill level:
		setUserSkillLevel(user.getCurrentSkillLevel(), score);
		return null;

		// calculate user progress
		// get current game
		// if current gamelevel and userskilllevel do not match and if the score
		// is reset to 0
		// assign a game from next level.

	}

	private void setUserSkillLevel(UserSkillLevel currentSkillLevel, long userScore) {
		UserSkillLevel nextSkillLevel = null;
		switch (currentSkillLevel) {

		case BEGINNER:
			nextSkillLevel = UserSkillLevel.INTERMEDIATE;
			break;

		case INTERMEDIATE:
			nextSkillLevel = UserSkillLevel.ADVANCED;
			break;

		case ADVANCED:
			nextSkillLevel = UserSkillLevel.COMPLETED;
			break;
		}

		long nextSkillScore = DataStore.getSkillScore(nextSkillLevel);
		if (userScore > nextSkillScore) {
			user.setCurrentSkillLevel(nextSkillLevel);
			user.setScore(0);
		} else {
			user.setScore(userScore);
		}
	}
}
