package com.nhance.assignment.datastore;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.nhance.assignment.constants.Constants;
import com.nhance.assignment.constants.Constants.GameLevel;
import com.nhance.assignment.constants.Constants.UserSkillLevel;

public class DataStore {
	private static Properties prop;
	private static InputStream input;
	private static Map<GameLevel, List<Game>> gameLevelMap = new HashMap<>();
	private static Map<GameLevel, Threshold> thresholdMap = new HashMap<>();
	private static Map<UserSkillLevel, Long> userSkillMap = new HashMap<>();

	public static void init() {
		prop = new Properties();
		try {
			input = new FileInputStream(Constants.PROPERTIES_PATH);
			prop.load(input);
			intializeGameLevelMap();
			initializeGameList();
			initializeThreshold();
			initializeSkillMap();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void initializeSkillMap() {
		for (UserSkillLevel skillLevel : UserSkillLevel.values()) {
			String skillLevelScore = (String) prop.get(skillLevel.toString()
					.toLowerCase());

		}
	}

	private static void initializeThreshold() {
		for (GameLevel gameLevel : GameLevel.values()) {
			String thresholdScore = (String) prop.get(gameLevel.toString()
					.toLowerCase());
			Threshold threshold = new Threshold();
			threshold.setGameLevel(gameLevel);
			threshold.setGoodScore(Integer.parseInt(thresholdScore));
			String goodBonus = null;
			String normalBonus = null;
			if (gameLevel.equals(GameLevel.EASY)) {
				goodBonus = (String) prop.get(Constants.EASY_GOOD_BONUS);
				normalBonus = (String) prop.get(Constants.EASY_NORMAL_BONUS);
			}
			if (gameLevel.equals(GameLevel.MEDIUM)) {
				goodBonus = (String) prop.get(Constants.MEDIUM_GOOD_BONUS);
				normalBonus = (String) prop.get(Constants.MEDIUM_NORMAL_BONUS);
			}
			if (gameLevel.equals(GameLevel.HARD)) {
				goodBonus = (String) prop.get(Constants.HARD_GOOD_BONUS);
				normalBonus = (String) prop.get(Constants.HARD_NORMAL_BONUS);
			}
			if (goodBonus != null) {
				threshold.setGoodBonus(Integer.parseInt(goodBonus));
			}
			if (normalBonus != null) {
				threshold.setNormalBonus(Integer.parseInt(normalBonus));
			}

			thresholdMap.put(gameLevel, threshold);
		}
	}

	private static void intializeGameLevelMap() {
		List<Game> easyGameList = new ArrayList<>();
		List<Game> mediumGameList = new ArrayList<>();
		List<Game> hardGameList = new ArrayList<>();

		for (GameLevel gameLevel : GameLevel.values()) {
			if (gameLevel.equals(GameLevel.EASY))
				gameLevelMap.put(gameLevel, easyGameList);
			if (gameLevel.equals(GameLevel.MEDIUM))
				gameLevelMap.put(gameLevel, mediumGameList);
			if (gameLevel.equals(GameLevel.HARD))
				gameLevelMap.put(gameLevel, hardGameList);
		}

	}

	private static void initializeGameList() {

		String gameIds = (String) (prop.get(Constants.GAME_IDS));
		String[] idArray = gameIds.split(",");
		for (String id : idArray) {
			Game game = new Game();
			game.setGameId(Integer.parseInt(id));
			String gameDetails = (String) prop.get(id);
			String gameName = gameDetails.split(",")[0];
			GameLevel gameLevel = GameLevel.valueOf(gameDetails.split(",")[1]
					.toUpperCase());
			game.setName(gameName);
			game.setGameLevel(gameLevel);
			gameLevelMap.get(gameLevel).add(game);
		}
	}

	public static void main(String[] args) {
		DataStore dataStore = new DataStore();
		dataStore.init();
		dataStore.display();
	}

	private void display() {

		System.out.println(userSkillMap + "\n\n");
		System.out.println(thresholdMap + "\n\n");
		System.out.println(gameLevelMap + "\n\n");
	}
	
	public static List<Game> getGameList(GameLevel level){
		return gameLevelMap.get(level);
	}
	
	public static Threshold getThreshold(GameLevel level){
		return thresholdMap.get(level);
	}
	
	public static long getSkillScore(UserSkillLevel skillLevel){
		return userSkillMap.get(skillLevel);
	}
}
