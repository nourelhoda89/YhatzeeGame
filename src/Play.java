import java.util.*;

public class Play {
	Player p1= new Player();
	private final static int MAX_NUM_ROLLS=3;
	private final static  int MAX_TURNS=13;
	private int numberOfRolls;
	private Set<String> selectionSet;
	private Set<String> localCat;
	private int round;
	Scanner key= new Scanner(System.in);
	String selection;
	
	public Play() {
		numberOfRolls=0;
		round=1;
		selection=" ";
		localCat=new HashSet<>();
		selectionSet= new HashSet<>();
	}
	/**Initiate the game by rolling the die and keeping track of numberOfRolls
	 * */
	public  void initiate() {
		char again='y'; 
		while ((again=='y' ||again=='Y')) {
			List<Integer> dieList=p1. getNewDieList();
			for(int i = 0; i < dieList.size(); i++) {
				System.out.println(dieList.get(i));
			}
			numberOfRolls++;
			if (numberOfRolls>MAX_NUM_ROLLS){
				again='n';
			}
			else {
				System.out.println(" Do you want to roll again?Y/N");
				again=key.nextLine().charAt(0);
			}
		}
	}
	/**This method prevent the user from scoring the same category twice 
	 * except for Yahtzee which is allowed to be scored up to two times.
	 * @return Set<String> the available categories.
	 * */
	public Set<String> categoriesWithoutRepetition() {
		localCat=p1.getCategories();    
		//keep track of how many time a yahtzee has been scored
		int yahtzeeCount=0;
		if(selection.equals("12") ) {
			yahtzeeCount++;
		}
		//if Yahtzee was selected more than twice it gets removed from the localCat
		if(selection.equals("12")&& yahtzeeCount>2 ){
			localCat.remove(selection);
		}
		
		for (Iterator<String> it = selectionSet.iterator(); it.hasNext(); ) {
			String s = it.next();
			selectionSet.iterator();
			if(s.equals("1")) {
				localCat.remove("1-US1");
			}
			if(s.equals("2")) {
				localCat.remove("2-US2");
			}
			if(s.equals("3")) {
				localCat.remove("3-US3");
			}
			if(s.equals("4")) {
				localCat.remove("4-US4");
			}
			if(s.equals("5")) {
				localCat.remove("5-US5");
			}
			if(s.equals("6")) {
				localCat.remove("6-US6");
			}
			if(s.equals("7")) {
				localCat.remove("7-ThreeOfAKind");
			}
			if(s.equals("8")) {
				localCat.remove("8-FourOfAKind");
			}
			if(s.equals("9")) {
				localCat.remove("9-FullHouse");
			}
			if(s.equals("10")) {
				localCat.remove("10-SmallStraight");
			}
			if(s.equals("11")) {
				localCat.remove("11-LargeStraight");
			}
			if(s.equals("13")) {
				localCat.remove("13-Chance");
			}
		}

		return localCat;
	}
	public  void playGame(){

		do {
			System.out.println("Round " +round);
			initiate();

			do {
				Set<String> categories=categoriesWithoutRepetition();
				System.out.println("Select the number of the catagory you want to score: ");
				categories.forEach(System.out::println);
				selection=key.nextLine();
				//if already exist, selection will not be added 
				selectionSet.add(selection);

			}while (!selection.equals("1")&&!selection.equals("2")&&
					!selection.equals("3")&& !selection.equals("4")&&
					!selection.equals("5")&& !selection.equals("6")&&
					!selection.equals("7")&& !selection.equals("8")&&
					!selection.equals("9")&&!selection.equals("10")&&
					!selection.equals("11")&&!selection.equals("12")&&
					!selection.equals("13")&&!selection.equals("14"));
			int roundScore=0;
			if(selection.equals("12")&&selectionSet.contains("12")) {
				roundScore=p1.roundScore("14");
			}
			else {
				roundScore=p1.roundScore(selection);
			}
			System.out.println("Round score is "+roundScore);
			round++;
			numberOfRolls=0;
		}while(round<=MAX_TURNS);

		System.out.println("final score is "+p1.finalScore());

	}
	public static void main(String[] args) {
		Play p =new Play();
		p.playGame();
	}
}