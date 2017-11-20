import java.util.*;
import java.util.Scanner;

import ArrayBag.ArrayBag;
/**to do:
 * try to use a generic collection instead of array bag
 * use sets for available score,that does not allow duplicates
 * implements all the rules in play or dice
 * no print statements
 * */
public class Play {
	Player p1 = new Player();

ArrayList<String> alreadyChosenCategories=new  ArrayList<String>();	
	private final static  int MAX_TURNS=13;
	private final static int MAX_NUM_ROLLS=3;
	private  static int round=1;
	private static int numberOfRolls=0;
	Scanner key=new Scanner(System.in);
//fix 
	public  void initiate(int round) {
		System.out.println("Round " +round);
		char again='y'; 
		do {
			p1.rollDie().displayAll();
			numberOfRolls++;
			System.out.println(" Do you want to roll again?Y/N");
			again=key.nextLine().charAt(0);
		}while ((again=='y' ||again=='Y') && (numberOfRolls<MAX_NUM_ROLLS));
	}

	public  void playGame(){
		
		do {
			initiate(round);
			ArrayBag<String> cat=p1.getCategories();
			//need to make sure user can't pick the same category twice in one game
			/*for(int i=1;i<alreadyChosenCategories.size();i++) {
				String currentElement=alreadyChosenCategories.get(i);
				if(cat.contains(currentElement)) {
					cat.remove(currentElement);
					}
					
			}*/
			cat.displayAll();
		
			System.out.println();
			String selection;
			do {
			System.out.println("Select the number of the catagory you want to score: ");
			selection=key.nextLine();
			}while (!selection.equals("1")&&!selection.equals("2")&&
					!selection.equals("3")&& !selection.equals("4")&&
					!selection.equals("5")&& !selection.equals("6")&&
					!selection.equals("7")&& !selection.equals("8")&&
					!selection.equals("9")&&!selection.equals("10")&&
					!selection.equals("11")&&!selection.equals("12")&&
					!selection.equals("13")&&!selection.equals("14"));
			
			p1.getRoundScore(selection);
			alreadyChosenCategories.add(selection);
			System.out.println(p1.roundScore(selection));
			round++;
			numberOfRolls=0;
		}while(round<=MAX_TURNS);
		
		p1.getScores();
		System.out.println(p1.finalScore());

	}
	public static void main(String[] args) {
		Play p =new Play();
		p.playGame();
	}
}