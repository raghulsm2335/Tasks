//Developer: Raghul S M
//Developed on: 20-11-24
//Modified on: 22-11-24
//Reviewed By:

//Encapsulation
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
	public void playerName(String playerName){
		System.out.println("player: "+playerName+" scored");
	}

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
class SoccerPlayer extends Soccer {
	public void playerName(int playerOrder){
		System.out.println("player: " +playerOrder+" scored");
	}
	
}


public class Main {
	public static void main(String[] args) {
		ScoreBoard soccerMatch1=new ScoreBoard();
		soccerMatch1.setTeamA_Score(5);
		soccerMatch1.setTeamB_Score(6);
		Soccer soccor1=new Soccer();
		SoccerPlayer soccor2=new SoccerPlayer();
		soccor1.predictWin();
		soccor2.playerName(1);
		soccor2.playerName("Raghul");

	}

}
