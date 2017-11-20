import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dice{

	private final static int NUM_Dice=5;
	private int dieFace;
	int currentScore;
	private List<Integer> dieList;
	private List<Integer> freqStack;
	private Set<String> availableCategories;
	//private List<String> availableCategories;
	private int freqOne;
	private int freqTwo;
	private int freqThree;
	private int freqFour;
	private int freqFive;
	private int freqSix;

	public Dice() {
		dieList=  new ArrayList<>();
		freqStack=  new ArrayList<>();;
		currentScore=0;
		availableCategories= new HashSet<>();
		freqOne= freqTwo=freqThree=freqFour=freqFive=freqSix=0;

	}
	public List<Integer> rollDie(){
		dieList.clear();
		for(int i=0;i<NUM_Dice; i++){
			dieFace=(int) (Math.random() * 6 + 1);
			if(dieFace==1)freqOne++;
			else if(dieFace==2)freqTwo++;
			else if(dieFace==3)freqThree++;
			else if(dieFace==4)freqFour++;
			else if(dieFace==5)freqFive++;
			else if(dieFace==6)freqSix++;
			dieList.add(dieFace);
		}
		return dieList;
	}


	public List<Integer> getFrequencies() {
		freqStack.add(freqOne);
		freqStack.add(freqTwo);
		freqStack.add(freqThree);
		freqStack.add(freqFour);
		freqStack.add(freqFive);
		freqStack.add(freqSix);
		return freqStack;
	}
	public Set<String> getCategories(){
		availableCategories.add("1-US1");
		availableCategories.add("2-US2");
		availableCategories.add("3-US3");
		availableCategories.add("4-US4");
		availableCategories.add("5-US5");
		availableCategories.add("6-US6");
		if(getFrequencies().contains(3)) 
			availableCategories.add("7-ThreeOfAKind");
		if(getFrequencies().contains(4)) 
			availableCategories.add("8-FourOfAKind");
		if(getFrequencies().contains(3) || getFrequencies().contains(2)) 
			availableCategories.add("9-FullHouse");
		if( !getFrequencies().contains(4)&&!getFrequencies().contains(5) 
				&&!getFrequencies().contains(6)) 
			availableCategories.add("10-SmallStraight");
		if(!getFrequencies().contains(3) && !getFrequencies().contains(4) 
				&&!getFrequencies().contains(5)  &&!getFrequencies().contains(6)) 
			availableCategories.add("11-LargeStraight");
		if(getFrequencies().contains(5)) 
			availableCategories.add("12-Yahtzee");
		//availableCategories.add("14-Yahtzee Bonus");
		availableCategories.add("13-Chance");

		return availableCategories;
	}
	public int getRoundScore(String selection) {
		int freq=0;
		//upper Section
		if(selection=="1") {
			while(!dieList.isEmpty()) {
				for(int i=0;i<dieList.size();i++) {
					if(dieList.get(i) ==1) {
						freq++;
					}
				}
			}
			currentScore=1*freq;
		}
		else if(selection=="2") {
			while(!dieList.isEmpty()) {
				for(int i=0;i<dieList.size();i++) {
					if(dieList.get(i) ==2) {
						freq++;
					}
				}
			}
			currentScore=2*freq;
		}
		else if(selection=="3") {
			while(!dieList.isEmpty()) {
				for(int i=0;i<dieList.size();i++) {
					if(dieList.get(i) ==3) {
						freq++;
					}
				}
			}
			currentScore=3*freq;
		}
		else if(selection=="4") {
			while(!dieList.isEmpty()) {
				for(int i=0;i<dieList.size();i++) {
					if(dieList.get(i) ==4) {
						freq++;
					}
				}
			}
			currentScore=4*freq;
		}
		else if(selection=="5") {
			while(!dieList.isEmpty()) {
				for(int i=0;i<dieList.size();i++) {
					if(dieList.get(i) ==5) {
						freq++;
					}
				}
			}
			currentScore=5*freq;
		}
		else if(selection=="6") {
			while(!dieList.isEmpty()) {
				for(int i=0;i<dieList.size();i++) {
					if(dieList.get(i) ==6) {
						freq++;
					}
				}
			}
			currentScore=6*freq;
		}

		//lower Section
		else if(selection=="7"|| selection=="8") {
			while(!dieList.isEmpty()) {
				for(int i=0;i<dieList.size();i++) {
					currentScore=+dieList.remove(i);
				}	
			}
		}
		else if (selection=="9")
			currentScore=25;
		else if (selection=="10")
			currentScore=30;
		else if (selection=="11")
			currentScore=40;

		else if (selection=="12")
			currentScore=50;

		else if (selection=="13") {
			while(!dieList.isEmpty()) {
				for(int i=0;i<dieList.size();i++) {
					currentScore=+dieList.remove(i);
				}	
			}
		}
		//Yahtzee bonus
		else if (selection=="14")
			currentScore=100;
		return currentScore;
	}
public static void main(String[] arg) {
	Dice a= new Dice();
	a.getCategories();
	
}
}

