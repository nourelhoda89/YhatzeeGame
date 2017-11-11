import ArrayStack.ArrayStack;

public class Dice{

	private final static int NUM_Dice=5;
	private final static int MAX_NUM_ROLLS=3;
	private int numberOfRolls;
	private int dieFace;
	int currentScore;
	private ArrayStack<Integer> dieStack;
	private ArrayStack<Integer> freqStack;
	private ArrayStack<String> availableCategories;
	/*	String[] Selection ={"US1","US2","US3","US4","US5","US6","ThreeOfAKind",
						"FourOfAKind","FullHouse","SmallStraight",
						"LargeStraight","Yahtzee","YahtzeeBonus","Chance"};
    private ArrayStack<Integer> scores= new ArrayStack<>(13);
	private static enum Categories   // An enumuration has been declared
    {US1, US2, US3,  US4, US5, US6, THREE, FOUR,
    SMALLSTRAIGHT, LARGESTRAIGHT, FULLHOUSE, YAHTZEE, CHANCE};*/
	private int freqOne;
	private int freqTwo;
	private int freqThree;
	private int freqFour;
	private int freqFive;
	private int freqSix;
public Dice() {
	dieStack= new ArrayStack<>(5);
	freqStack= new ArrayStack<>(6);
	numberOfRolls=0;
	currentScore=0;
	availableCategories= new ArrayStack<>(13);
	freqOne= freqTwo=freqThree=freqFour=freqFive=freqSix=0;
	
}
	private ArrayStack<Integer> rollDie(){
if(numberOfRolls<=MAX_NUM_ROLLS) {
		for(int i=0;i<NUM_Dice; i++){
			dieFace=(int) (Math.random() * 6 + 1);
			if(dieFace==1)freqOne++;
			else if(dieFace==2)freqTwo++;
			else if(dieFace==3)freqThree++;
			else if(dieFace==4)freqFour++;
			else if(dieFace==5)freqFive++;
			else if(dieFace==6)freqSix++;
			dieStack.push(dieFace);
		}
}
		return dieStack;
	}

	public ArrayStack<Integer> getDieStack(){
		dieStack=rollDie();
		return dieStack;
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
	private ArrayStack<String> getCategories(){	
		if(getFrequencies().contains(3)) 
			availableCategories.push("ThreeOfAKind");

		if(getFrequencies().contains(4)) 
			availableCategories.push("FourOfAKind");	

		if(getFrequencies().contains(3) || getFrequencies().contains(2)) 
			availableCategories.push("FullHouse");

		if( !getFrequencies().contains(4)&&!getFrequencies().contains(5) 
				&&!getFrequencies().contains(6)) 
			availableCategories.push("SmallStraight");

		if(!getFrequencies().contains(3) && !getFrequencies().contains(4) 
				&&!getFrequencies().contains(5)  &&!getFrequencies().contains(6)) 
			availableCategories.push("LargeStraight");

		if(getFrequencies().contains(5)) 
			availableCategories.push("Yahtzee");
		
		availableCategories.push("US6");
		availableCategories.push("US5");
		availableCategories.push("US4");
		availableCategories.push("US3");
		availableCategories.push("US2");
		availableCategories.push("US1");
		return availableCategories;
	}

	public int getRoundScore(String selection) {
		//upper Section
		if(selection=="US1")
			currentScore=1*dieStack.getFrequencyOf(1);
		else if(selection=="US2")
			currentScore=2*dieStack.getFrequencyOf(2);
		else if(selection=="US3")
			currentScore=3*dieStack.getFrequencyOf(3);
		else if(selection=="US4")
			currentScore=3*dieStack.getFrequencyOf(4);
		else if(selection=="US5")
			currentScore=3*dieStack.getFrequencyOf(5);
		else if(selection=="US6")
			currentScore=3*dieStack.getFrequencyOf(6);
		
		//lower Section
		else if(selection=="FourOfAKind" || selection=="ThreeOfAKind") {
			while(!dieStack.isEmpty()) {
				currentScore=+dieStack.pop();
			}

		}
		else if (selection=="FullHouse")
			currentScore=25;
		else if (selection=="SmallStraight")
			currentScore=30;
		else if (selection=="LargeStraight")
			currentScore=40;
		else if (selection=="Yahtzee")
			currentScore=50;
		else if (selection=="YahtzeeBonus")
			currentScore=100;
		
		else if (selection=="Chance") {
			while(!dieStack.isEmpty()) {
				currentScore=+dieStack.pop();
			}
		}
		return currentScore;
	}

}

