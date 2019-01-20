import java.util.Random;

/**
 * A deck of 52 standard playing cards
 * @author Catherine Weiss
 *
 */
public class Deck {

    private Card[] deck;	
	private int deckReturnLocation = 0;

	Deck() {
		int cardCount = 52; //Number of cards in standard deck
		deck = new Card[cardCount];		
		String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
		String[] RANKS = {"Ace", "2", "3", "4", "5", "6", "7", "8",
				"9", "10", "Jack", "Queen", "King"};
		int[] RANKVALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
		int cardIndex = 0;	
		for (int j=0; j<SUITS.length; j++) {
			for (int k=0; k<RANKS.length; k++) {
					
				Card c = new Card(SUITS[j], RANKS[k], RANKVALUES[k]);
				deck[cardIndex] = c;
				cardIndex++;
			}
		}
	}	
	

	/**
	 * Simulates shuffling of the deck. Array that holds cards
	 * is re-ordered.
	 */
	public void shuffleDeck() {
		Random rand = new Random ();
		deckReturnLocation = 0; 
		for (int i=0; i<deck.length; i++) {
			int j = rand.nextInt(52);
			Card temp = deck[j];
			deck[j] = deck[i];
			deck[i] = temp;
		}
	}
	
	/**
	 * 
	 * @return next card in array is returned
	 */
	public Card next() {
		int returnLocation = deckReturnLocation;
		deckReturnLocation++;
		return deck[returnLocation];
	}

	/**
	 * 
	 * @return boolean value is returned if there is another
	 * card to draw
	 */
	public boolean hasNextCard() { 
		if(deckReturnLocation < deck.length)
			return true; 
		return false;
	} 
	
	/**
	 * 
	 * @return array of playing cards
	 */
	public Card[] getDeck() {
		return deck;
	}
	
}
