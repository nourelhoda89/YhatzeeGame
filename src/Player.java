import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Player extends Dice{
	private int finalScore;
	private List<Integer> playerScores;


public Player() {
	finalScore=0;
	playerScores= new ArrayList<>();
}

	public int roundScore(String selection) {
		int score= getRoundScore(selection);
		playerScores.add(score);
		return score;
	}
	public List<Integer> getPlayerScores() {
		return playerScores;
	}
	public int finalScore(){
			for(int i=0;i<playerScores.size();i++) {
					finalScore=finalScore+playerScores.get(i);
				}
			
		return finalScore;
	}
	
}
