import ArrayStack.ArrayStack;

public class Dice{

	private final static int MAX_NUM_ROLLS=5;
	private int dieFace;
	int currentScore=0;
	private ArrayStack<Integer> dieStack= new ArrayStack<>(5);
	private ArrayStack<Integer> freqStack= new ArrayStack<>(6);
	private ArrayStack<String> availableCategories= new ArrayStack<>(13);
	private ArrayStack<Integer> scores= new ArrayStack<>(13);
	String chosenCategory;
	private int freqOne=0;
	private int freqTwo=0;
	private int freqThree=0;
	private int freqFour=0;
	private int freqFive=0;
	private int freqSix=0;

	private ArrayStack<Integer> rollDie(){

		for(int i=0;i<MAX_NUM_ROLLS; i++){
			dieFace=(int) (Math.random() * 6 + 1);
			if(dieFace==1)freqOne++;
			else if(dieFace==2)freqTwo++;
			else if(dieFace==3)freqThree++;
			else if(dieFace==4)freqFour++;
			else if(dieFace==5)freqFive++;
			else if(dieFace==6)freqSix++;
			dieStack.push(dieFace);
		}
		return dieStack;
	}
	public ArrayStack<Integer> getDieStack(){
		dieStack=rollDie();
		return this.dieStack;
	}
	public void rollAgain(int nbOfRolls, boolean again) {
		if (nbOfRolls<3) getDieStack();

	}
	public ArrayStack<Integer> getFrequencies() {
		freqStack.push(freqOne);
		freqStack.push(freqTwo);
		freqStack.push(freqThree);
		freqStack.push(freqFour);
		freqStack.push(freqFive);
		freqStack.push(freqSix);
		return freqStack;
	}
	private void isThreeOfAKind(){	
		if(getFrequencies().contains(3)) {
			availableCategories.push("ThreeOfAKind");
		}
	}

	private void isFourOfAKind(){ 
		if(getFrequencies().contains(4)) {
			availableCategories.push("ThreeOfAKind");	
		}	
	}

	public void scorePoint(String selection) {

		if(chosenCategory=="FourOfAKind" || chosenCategory=="ThreeOfAKind") {
			while(!dieStack.isEmpty()) {
				currentScore=+dieStack.pop();
			}
			scores.push(currentScore);
		}
	}

}

