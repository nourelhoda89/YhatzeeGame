import ArrayBag.ArrayBag;

public class Player extends Dice{
	private int finalScore;
	ArrayBag<Integer> scores;

public Player() {
	finalScore=0;
	scores= new ArrayBag<>(13);
}

	public int roundScore(String selection) {
		int score= getRoundScore(selection);
		scores.add(score);
		return score;
	}
	public void getScores() {
		scores.displayAll();
	}
	public int finalScore(){
		while(!scores.isEmpty()) {
			finalScore+=scores.remove();
		}
return finalScore;
	}
}
