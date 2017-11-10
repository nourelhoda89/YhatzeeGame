import java.util.Stack;

public class Dice {
	public final static int MAX_NUM_ROLLS=5;
	private int dieFace;
	Stack<Integer> dieStack= new Stack<>();
	
	public Stack<Integer> rollDice(){
		for(int i=0;i<MAX_NUM_ROLLS; i++){
			dieFace=(int) (Math.random() * 6 + 1);
			dieStack.add(dieFace);
		}
		return dieStack;
	}
public void rollAgain(int nbOfRolls, boolean again) {
	if (nbOfRolls<3) rollDice();

}

}
