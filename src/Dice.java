import java.util.Stack;

public class Dice{

	public final static int MAX_NUM_ROLLS=5;
	private int dieFace;
	private Stack<Integer> dieStack= new Stack<>();

	private Stack<Integer> rollDie(){

		for(int i=0;i<MAX_NUM_ROLLS; i++){
			dieFace=(int) (Math.random() * 6 + 1);
			dieStack.add(dieFace);
		}
		return dieStack;
	}
	public Stack<Integer> getDieStack(){
		dieStack=rollDie();
		return this.dieStack;
	}
	public void rollAgain(int nbOfRolls, boolean again) {
		if (nbOfRolls<3) getDieStack();

	}
	public void frequency() {
		
	}
}
