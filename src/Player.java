import java.util.ArrayList;
import java.util.List;

public class Player extends Dice{
	private int finalScore;
	private List<Integer> playerScores;


public Player() {
	finalScore=0;
	
	playerScores= new ArrayList<>();
}
/**get the round score for each player and add it to the list of playerScores
 * @return in the current round score*/
	public int roundScore(String selection) {
		int score= getRoundScore(selection);
		playerScores.add(score);
		return score;
	}
	/**gets the list of playerSores
	 * @return List<String> of scores*/
	public List<Integer> getPlayerScores() {
		return playerScores;
	}
	/**Calculate the final score by iterating through the playerScores's list
	 * @return int the final score for the player*/
	public int finalScore(){
			for(int i=0;i<playerScores.size();i++) {
					finalScore=finalScore+playerScores.get(i);
				}
			
		return finalScore;
	}
	
}
