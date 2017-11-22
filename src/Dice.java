import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dice{

	private final static int NUM_Dice=5;

	private int dieFace;
	private List<Integer> dieList;
	private List<Integer> freqList;
	private Set<String> availableCategories;
	private int freqOne,freqTwo,freqThree,freqFour,freqFive,freqSix;

	public Dice() {
		dieList=  new ArrayList<>();
		freqList=  new ArrayList<>();
		availableCategories= new HashSet<>();
		freqOne= freqTwo=freqThree=freqFour=freqFive=freqSix=0;

	}
	/**roll the dice five time using a random object while checking the
	 *  frequencies of each possible number from one to six
	 *  @return List<Integer> the list of sorted integers representing the die faces   */
	private List<Integer> rollDie(){
		dieList.clear();
		freqOne= freqTwo=freqThree=freqFour=freqFive=freqSix=0;
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
		dieList.sort(Comparator.naturalOrder());
		return dieList;
	}
	/**get a new Die List by calling the local method rollDie
	 * @return List<Integer> the list of integers representing the die faces*/
	public List<Integer> getNewDieList(){
		dieList=rollDie();
		return dieList;
	}
	/**Store the frequencies of each die in freqList
	 * @return List<Integer> the freqList */
	public List<Integer> getFrequencies() {
		freqList.clear();
		freqList.add(freqOne);
		freqList.add(freqTwo);
		freqList.add(freqThree);
		freqList.add(freqFour);
		freqList.add(freqFive);
		freqList.add(freqSix);
		return freqList;
	}
	/** Get the list of possible categories for each round
	 * @return Set<String> a set available categories
	 * */
	public Set<String> getCategories(){
		availableCategories.clear();
		getFrequencies();
		if(dieList.contains(1)) 
			availableCategories.add("1-US1");
		if(dieList.contains(2)) 
			availableCategories.add("2-US2");
		if(dieList.contains(3)) 
			availableCategories.add("3-US3");
		if(dieList.contains(4)) 
			availableCategories.add("4-US4");
		if(dieList.contains(5)) 
			availableCategories.add("5-US5");
		if(dieList.contains(6)) 
			availableCategories.add("6-US6");
		if(freqList.contains(3)) 
			availableCategories.add("7-ThreeOfAKind");
		if(freqList.contains(4)) 
			availableCategories.add("8-FourOfAKind");

		if(freqList.contains(3) && freqList.contains(2)) 
			availableCategories.add("9-FullHouse");

		if((dieList.get(NUM_Dice-1)- dieList.get(0)<=3)&&!freqList.contains(3)&&!freqList.contains(4)&&!freqList.contains(5) 
				&&!freqList.contains(6)) 
			availableCategories.add("10-SmallStraight");

		if((dieList.get(NUM_Dice-1)- dieList.get(0)==4)&&!freqList.contains(2)&&!freqList.contains(3) && !freqList.contains(4) 
				&&!freqList.contains(5)  &&!freqList.contains(6)) 
			availableCategories.add("11-LargeStraight");

		if(freqList.contains(5)) 
			availableCategories.add("12-Yahtzee");
		//availableCategories.add("14-Yahtzee Bonus");
		availableCategories.add("13-Chance");

		return availableCategories;
	}
	/**Calculate the total score of each round
	 * @param selection is the score choice of the user
	 * @return int the currentScore that apply to the selected choice*/
	public int getRoundScore(String selection) {
		int freq=0;
		int currentScore=0;
		//upper Section
		if(selection.equals("1")) {
			for(int i=0;i<dieList.size();i++) {
				if(dieList.get(i)==1) {
					freq++;
				}
			}
			currentScore=1*freq;
		}
		else if(selection.equals("2")) {
			for(int i=0;i<dieList.size();i++) {
				if(dieList.get(i)==2) {
					freq++;
				}
			}
			currentScore=2*freq;
		}
		else if(selection.equals("3")) {
			for(int i=0;i<dieList.size();i++) {
				if(dieList.get(i) ==3) {
					freq++;
				}
			}
			currentScore=3*freq;
		}
		else if(selection.equals("4")) {
			for(int i=0;i<dieList.size();i++) {
				if(dieList.get(i) == 4) {
					freq++;
				}
			}
			currentScore=4*freq;
		}
		else if((selection.equals("5"))) {
			for(int i=0;i<dieList.size();i++) {
				if(dieList.get(i) ==5) {
					freq++;
				}
			}
			currentScore=5*freq;
		}
		else if((selection.equals("6"))) {
			for(int i=0;i<dieList.size();i++) {
				if(dieList.get(i) ==6) {
					freq++;	
				}
			}
			currentScore=6*freq;
		}

		//lower Section
		else if(selection.equals("7")|| selection.equals("8")) {
			for(int i=0;i<dieList.size();i++) {
				currentScore=currentScore+dieList.get(i);
			}
		}
		else if (selection.equals("9"))
			currentScore=25;
		else if (selection.equals("10"))
			currentScore=30;
		else if (selection.equals("11"))


			currentScore=40;

		else if (selection.equals("12"))
			currentScore=50;

		else if (selection.equals("13")) {
			for(int i=0;i<dieList.size();i++) {
				currentScore=currentScore+dieList.get(i);
			}
		}
		//Yahtzee bonus
		else if (selection.equals("14")) currentScore=100;
		return currentScore;
	}
}

