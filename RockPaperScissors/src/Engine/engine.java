package Engine;

import java.util.Random;
import java.util.Scanner;

public class engine {

	//Main Method
	public static void main(String[] args) {
		System.out.println("Welcome to Rock, Paper, Scissors!");
		System.out.println("By: Jeremias Monteiro Oliveira\n");
		game();
	}
	
	//User's Move Input
	static int userPick() { 
		Scanner scanf = new Scanner(System.in);
		System.out.println("What will you choose?: ");
		System.out.println("(1) - Rock");
		System.out.println("(2) - Paper");
		System.out.println("(3) - Scissors");
		return scanf.nextInt();
	}
	
	//Picks CPU's Move
	static int cpuPick(){
		Random cpuPickGenerator = new Random();
		return cpuPickGenerator.nextInt(3)+1; //1 to 3
	}
	
	//Shows Game Information
	static void showStandings(int winsCpu, int winsUser, int ties, int round) {
		System.out.println("\n\nYour Wins: "+winsUser);
		System.out.println("CPU Wins: "+winsCpu);
		System.out.println("Ties: "+ties);
		System.out.println("--------------------");
		System.out.println("Round: "+round+"\n");
	}
	
	//Executes Game
	static void game() {
		
		//Continue Condition Variable
		int play = 1;
		
		do {
			
			//Game Variables
			int winsUser = 0;
			int winsCpu = 0;
			int ties = 0;
			int round = 1;
			int x; //User's Choice
			int y; //CPU's Choice
			
			//Game
			while(winsUser<5 && winsCpu<5) {
				try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
				showStandings(winsCpu, winsUser, ties, round); 
				x = userPick();
				y = cpuPick();
			
				//Declaration
				System.out.println("\nRock!");
				try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
				System.out.println("Paper!");
				try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
				System.out.println("Scissors!\n");
				try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
				round++;
			
				//User Picked Rock
				if((x==1  || x%3==1) && y==1) {
					System.out.println("User and CPU both picked Rock: Tie");
					ties++;
					continue;
				}
				if((x==1  || x%3==1) && y==2) {
					System.out.println("User picked Rock and CPU picked Paper: CPU Wins");
					winsCpu++;
					continue;
				}
				if((x==1  || x%3==1) && y==3) {
					System.out.println("User picked Rock and CPU picked Scissors: User Wins");
					winsUser++;
					continue;
				}

				//User Picked Paper
				if((x==2  || x%3==2) && y==1) {
					System.out.println("User picked Paper and CPU picked Rock: User Wins");
					winsUser++;
					continue;
				}
				if((x==2  || x%3==2) && y==2) {
					System.out.println("User and CPU both picked Paper: Tie");
					ties++;
					continue;
				}
				if((x==2  || x%3==2) && y==3) {
					System.out.println("User picked Paper and CPU picked Scissors: CPU Wins");
					winsCpu++;
					continue;
				}
			
				//User Picked Scissors
				if((x==3  || x%3==0) && y==1) {
					System.out.println("User picked Scissors and CPU picked Rock: CPU Wins");
					winsCpu++;
					continue;
				}
				if((x==3  || x%3==0) && y==2) {
					System.out.println("User picked Scissors and CPU picked Paper: User Wins");
					winsUser++;
					continue;
				}
				if((x==3  || x%3==0) && y==3) {
					System.out.println("User and CPU both picked Scissors: Tie");
					ties++;
					continue;
				}	
				
			}
			
			try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
			
			//User Won
			if(winsUser==5) {
				System.out.println("\nCongratulations! You Won!");
			}
			
			//CPU Won
			if(winsCpu==5) {
				System.out.println("\nYou Lost! Better Luck Next Time");
			}
			
			try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
			
			//Continue Condition
			System.out.println("Would you like to play again? (1)Yes (2)No");
			Scanner scanf = new Scanner(System.in);
			
			//User Continued
			if(scanf.nextInt()==1){
				play = 1;
			}
			
			//User Didn't Continue
			if(scanf.nextInt()==2){
				play = 2;
			}
			
			//Continue Exception
			else {
				System.out.println("\nInvalid Number, now quitting!");
				break;
			}
			
		//Game Condition	
		}while(play==1);
		
		//Credits
		System.out.println("\nThanks for Playing!\nBy: Jeremias Monteiro Oliveira");
		
	}
	
	
}
