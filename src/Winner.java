
import java.util.PriorityQueue;

public class Winner{
	Player[] players; 
	PriorityQueue<Integer> finalScores;
	public Winner() {
		//fix nb of players
		players=new Player[2];
	}
	public String winner() {
		String winner=null; 
		for (int i=0;i<players.length;i++) {
			finalScores.add(players[i].finalScore());
		}
		int highestScore=finalScores.peek();
		for (int i=0;i<players.length;i++) {
			if (players[i].finalScore()==highestScore);
			winner= players[i].name ;
		}
		return winner;
	
	}
}
	


