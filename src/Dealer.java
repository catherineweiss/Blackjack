import java.util.ArrayList;

/**
 * Models dealer in Blackjack game. Dealer deals initial hands,
 * evaluates initial hands for blackjack, and declares winner. 
 * @author Catherine Weiss
 *
 */
public class Dealer {

	private boolean blackjack = false;

	Dealer (){
		blackjack = false;
	}
	

	/**
	 * Deals two initial cards to computer and then to player.
	 * @param d deck of playing cards
	 * @param h0 computer's hand (arrayList) of cards
	 * @param h1 player's hand (arrayList) of cards
	 */
	public void dealInitialHands(Deck d, Hand h0, Hand h1) {
		Deck deck = d;
		Hand dealerHand = h0;
		Hand playerHand = h1;
		if (deck.hasNextCard()) {
			h0.addCardToHand(deck.next());//computer's card face down
		}
		if (deck.hasNextCard()) {
			h0.addCardToHand(deck.next());//computer's card face up
		}
		if (deck.hasNextCard()) {
			h1.addCardToHand(deck.next()); //player's first card
		}	
		if (deck.hasNextCard()) {
			h1.addCardToHand(deck.next()); //player's second card
		}
	}

	
	/**
	 * Evaluates first two cards in hand for blackjack	
	 * @param h	player's hand of cards
	 * @return	blackjack (true for blackjack; false for not blackjack)
	 */
	public boolean evaluateBlackjack(Hand h) {
		Hand hand = h;
		boolean blackjack = false;
		
		if (hand.getCardRank(0).equals("Ace") && 
				hand.getCardValue(1)==10) {
			blackjack = true;		
		}	
			else if (hand.getCardRank(1).equals("Ace") && 
					hand.getCardValue(0)==10) {
				blackjack = true;
			}
		return blackjack;			
		
	}
	
	/**
	 * 
	 * @param h0 computer's hand (arrayList) of cards
	 * @param h1 h1 player's hand (arrayList) of cards
	 * @return name of winner
	 */
	public String declareWinner(Hand h0, Hand h1) {
		String winner;
		if (h0.getFinalScore() > h1.getFinalScore()) {
			winner = h0.getPlayerName()+" wins!";
		} else if (h0.getFinalScore() == h1.getFinalScore()) {
			winner = "It's a tie";
		} else {
			winner = h1.getPlayerName()+" wins!";
		}
		return winner;
	}
	
}
