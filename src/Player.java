import ArrayStack.ArrayStack;

public class Player extends Dice{
	private final int MAX_TRURNS=13;
	private int numOfTurns;
	String name;
	int finalScore;
	ArrayStack<Integer> scores;
public Player() {
	this(null);
}
public Player(String name) {
	this.name=name;
	finalScore=0;
	 numOfTurns=0;
	 scores= new ArrayStack<>(13);
}

	public void rollPlayerDie() {
		if(numOfTurns<=MAX_TRURNS) {
			getDieStack();
		}
		numOfTurns++;
	}
	public void roundScore(String selection) {
		int score= getRoundScore(selection);
		scores.push(score);
	}
	public int finalScore(){
		while(!scores.isEmpty()) {
			finalScore+=scores.pop();
		}
return finalScore;
	}
}
