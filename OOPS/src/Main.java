//Encapsulation

import java.util.ArrayList;
import java.util.List;

class ScoreBoard{
	private int teamA=0;
	private int teamB=0;
	
	public void setTeamA_Score(int teamA) {
		this.teamA=teamA;
	}
	public void setTeamB_Score(int teamB) {
		this.teamB=teamB;
	}

	public int getTeamA_Score() {
		return teamA;
	}
	public int getTeamB_Score() {
		return teamB;
	}
	
}
//abstraction & Single inheritance
abstract class Game extends ScoreBoard{
	abstract void predictWin();
	public void game(){
		System.out.println("match starts");
	}
}
//multi-level inheritance
class Soccer extends Game{

	@Override
	void predictWin() {
		game();
		if(getTeamA_Score()>getTeamB_Score()) {
			System.out.println("Team A Win");
		}
		else{
			System.out.println("Team B Win");
		}
		
	}
	
}


public class Main {
	public static void main(String[] args) {
		ScoreBoard soccerMatch1=new ScoreBoard();
		soccerMatch1.setTeamA_Score(5);
		soccerMatch1.setTeamB_Score(6);
		System.out.println("Team A = "+soccerMatch1.getTeamA_Score());
		System.out.println("Team B = "+soccerMatch1.getTeamB_Score());
		Soccer soccor1=new Soccer();
		soccor1.predictWin();		

		List list = new ArrayList<>();

		list.add(10,"");
	}

}
