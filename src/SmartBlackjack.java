/**
 * Models a blackjack game that is played by an automated human 
 * player and a computer player many times. The automated human 
 * player follows a set strategy with the goal of winning more 
 * than 50% of games played.
 * @author Catherine Weiss
 *
 */
public class SmartBlackjack {

	public static void main(String[] args) {

		int numGames = 1000;
		int numGamesPlayerWon = 0;
		int numGamesTied = 0;
		int numGamesComputerWon = 0;
		
		Player computer = new Player("Computer");
		Player p1 = new Player ("Player");
		Deck deck = new Deck();
		deck.shuffleDeck();
		Dealer dealer = new Dealer();
		Hand h0 = new Hand(computer);
		Hand h1 = new Hand(p1);


		for (int i=0; i<numGames; i++) {
		
			dealer.dealInitialHands(deck, h0, h1);

			//Player's strategy:
			//	player stands if their currentScore>=17 
			//  player also stands if their currentScore is between 13 and 
			//    16 (inclusive) and if computer's face up card is a 2, 3, 
			//    4, 5, or 6.
			//	otherwise, player accepts a new card 
			while (!h1.isBust() && !h1.isStands()) {
				if (h1.getCurrentScore()>=17) {
					h1.stand();
				}	else if (h1.getCurrentScore()>=13 && 
						(h0.getCardValue(1)>1 && h0.getCardValue(1)<7)) {
					h1.stand();
				}	else h1.addCardToHand(deck.next());	
			}
	
			//Computer's strategy:
			//  computer accepts a new card until its currentScore >=17
			while (!h0.isBust() && !h0.isStands()) {
				if (h0.getCurrentScore() < 17) {
					h0.addCardToHand(deck.next());
				}	else {
						h0.stand();
					}	
			}
			
			//Player's hand of cards is compared to Computer's hand of cards
			if (h1.isBust()) {
				numGamesComputerWon++;
			}	
				else if (h0.isBust()) {
					numGamesPlayerWon++;
			}	
				else if (h1.getFinalScore()>h0.getFinalScore()) {
					numGamesPlayerWon++;
			}	
				else if (h1.getFinalScore() == h0.getFinalScore()) {
					numGamesTied++;		
			}	else if (h0.getFinalScore() > h1.getFinalScore()){
					numGamesComputerWon++;				
			}
	
			//Both hands of cards are cleared and the deck is reshuffled
			h0.clear();
			h1.clear();
			deck.shuffleDeck();
			
		}
		
		System.out.println("Number of games played: "+numGames);
		System.out.println("Games Player won: "+numGamesPlayerWon);
		System.out.println("Games Player tied: "+numGamesTied);
		System.out.println("Games Player lost: "+numGamesComputerWon);
		double probPlayerWins = (double)numGamesPlayerWon/(double)numGames;
		double probPlayerLosesMoney = (double)numGamesComputerWon/(double)numGames;
		System.out.printf("Player's percentage of winning with current strategy: %.2f ",probPlayerWins);
		System.out.println();
		System.out.printf("Player's percentage of not losing money: %.2f", probPlayerLosesMoney);
		System.out.println();
		
	}
}
