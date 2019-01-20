import java.util.Random;
import java.util.Scanner;

/**
 * Plays a game of blackjack between a user and the computer
 * @author Catherine Weiss
 *
 */
public class Blackjack {

	public static void main(String[] args) {
	
		//Game Setup: 	
		//	Create player to be computer.
		//	Create player with a name that is entered.
		
		Player computer = new Player("Computer");
		Scanner scan = new Scanner(System.in);
		System.out.print("Welcome to the Blackjack game. What is your name? ");
		String name = scan.nextLine();
		Player p1 = new Player (name);
		System.out.println();
		System.out.println();
		System.out.println("Are you ready to play, "+name+"?");
		System.out.print("Type d and I will deal the cards ");

		String start = scan.nextLine();
		while(!start.equalsIgnoreCase("d")) {
			System.out.print("Sorry. Input not recognized. Type d to start the game.");
			System.out.println();
			start = scan.nextLine();
		}
		System.out.println();

			
		//Game Start:
		//	Player starts the game.
		//	Create and shuffle deck.
		//	Create a dealer.
		//	Create a hand for the computer and for the player.
		//	Deal the initial hands.
		
		
		Deck deck = new Deck();
		deck.shuffleDeck();
		Dealer dealer = new Dealer();
		Hand h0 = new Hand(computer);
		Hand h1 = new Hand(p1);
		dealer.dealInitialHands(deck, h0, h1);
		
		System.out.println("The computer was dealt one card face down and "
				+ h0.getCardDescription(1));
		System.out.println();
		System.out.println("You were dealt "+ h1.getCardDescription(0)
				+" and "+h1.getCardDescription(1));

		
		//Evaluate Player's Initial Hand for Blackjack:
		
		if (dealer.evaluateBlackjack(h1)) {
			
			System.out.println("Blackjack! Let's see what computer got.");
			System.out.println();
			
			if (dealer.evaluateBlackjack(h0)) {
				System.out.println("Amazing! Computer got a blackjack too. You tie.");
				System.exit(1);
			}	else {
				System.out.println("Computer got " +h0.getAllCardDescriptions()+". You win!");
				System.exit(1);
			}
		}
		

		//Allow player to hit (until they bust) or stand:
		
		while (!h1.isBust() && !h1.isStands()) {
					//System.out.println("You have a score of ");
					//Add tally of current score
					System.out.print("Type h to hit or s to stand ");			
						
			String input = scan.nextLine();
			System.out.println();
	
			if (input.equalsIgnoreCase("h")) {
				h1.addCardToHand(deck.next());
				System.out.println("You got a "+h1.getCardDescription(h1.getIndexLastCard()));
				if (h1.isBust()) {
					System.out.println("Your current score is "+h1.getCurrentScore()+". ");
					System.out.println("You bust.");
					System.exit(1);
				} 	
			}
			
			if (input.equalsIgnoreCase("s")) {
					h1.stand();
					System.out.println("You stand at "+h1.getFinalScore());
			}		
		
		} 
			
		System.out.println("Let's see how the computer does");
		
			
		//Computer takes its turn	
		
		System.out.println();
		System.out.println("The computer's first two cards are "
				+h0.getAllCardDescriptions());
		System.out.println();
		
		
		while (!h0.isBust() && !h0.isStands()) {
			if (h0.getCurrentScore() < 17) {
				h0.addCardToHand(deck.next());
				System.out.println("Computer drew a "+h0.getCardDescription(h0.getIndexLastCard()));
			}	else {
					h0.stand();
					System.out.println("Computer stands at "+h0.getFinalScore());
				}	
		}
		
		if (h0.isBust()) {
			System.out.println("Computer busts. You win.");
			System.exit(1);
		}	

		System.out.println();
		
		System.out.println(dealer.declareWinner(h0, h1));
		
	}
	
}

