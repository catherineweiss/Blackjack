import java.util.ArrayList;

/**
 * Represents a hand of playing cards in a particular round of a game
 * @author Catherine Weiss
 *
 */
public class Hand {

	private Player player;
	private ArrayList<Card> hand;
	private int currentScore = 0;
	private int finalScore = 0;
	private boolean isBust = false;
	private boolean stands = false;
	private int indexLastCard = 0;
//	private int lastCardPosition;
	
	Hand (Player p){
		player = p;
		hand = new ArrayList<Card>();
		currentScore = 0;
		finalScore = 0;
		isBust = false;
		stands = false;
		indexLastCard = 0;
	}
	/**
	 * Adds a card to the hand and computes the currentScore of cards
	 * in the hand
	 * @param newCard card 
	 */
	public void addCardToHand(Card newCard) {
		currentScore = 0;
		int sumOfNonAces = 0;
		int numOfAces = 0;

		hand.add(newCard);
		
		
		//compute currentScore after new card was added to hand
		
		for (int i=0; i<hand.size();i++) {
			String rank = hand.get(i).getCardRank();
			int value = hand.get(i).getCardValue();
			
			if (!rank.equals("Ace")) {
				sumOfNonAces = sumOfNonAces + value;
			}
			if (rank.equals("Ace")) {
				numOfAces++;
			}			
		}
		
		if (numOfAces==0) {
			currentScore = sumOfNonAces;
		}	
		
		if (numOfAces==1 && sumOfNonAces<=10) {
			currentScore = sumOfNonAces + 11;	
		}
		
		if (numOfAces==1 && sumOfNonAces>10) {
			currentScore = sumOfNonAces + numOfAces;
		}
				
		if (numOfAces==2 && sumOfNonAces<=9) {
			currentScore = sumOfNonAces + 12;	
		}
		if (numOfAces==2 && sumOfNonAces>9) {
			currentScore = sumOfNonAces + numOfAces;
		}
		
		if (numOfAces==3 && sumOfNonAces<=8) {
			currentScore = sumOfNonAces + 13;	
		}	
		if (numOfAces==3 && sumOfNonAces>8) {
			currentScore = sumOfNonAces + numOfAces;
		}
		
		if (numOfAces==4 && sumOfNonAces<=7) {
			currentScore = sumOfNonAces + 14;	
		}	
		if (numOfAces==4 && sumOfNonAces>7) {
			currentScore = sumOfNonAces + numOfAces;
		}
		
		if (currentScore > 21) {
			isBust = true;
		}
	}

	
	
	public void stand() {
		finalScore = currentScore;
		stands = true;
	}

	
	public void clear() {
		for (int i=hand.size()-1; i>=0; i--) {
			hand.remove(i);
		}
		currentScore = 0;
		finalScore = 0;
		isBust = false;
		stands = false;
	}

	
	public String getPlayerName() {
		String name = player.getName();
		return name;
	}

	
	public String getCardRank (int num) {
		int index = num;
		String rank = hand.get(index).getCardRank();
		return rank;
	}

	
	public int getCardValue (int num) {
		int index = num;
		int cardValue = hand.get(index).getCardValue();
		return cardValue;
	}
	

	public String getCardDescription(int num) {
		int index = num;
		String nameOfCard = hand.get(index).getCardRank()+" of "
				+hand.get(index).getCardSuit();
		return nameOfCard;
	}	
	
	public ArrayList<String> getAllCardDescriptions() {
		ArrayList<String> cards = new ArrayList<String>();
		for (int i=0; i<hand.size(); i++) {
			cards.add(hand.get(i).getCardRank()+" of "
				+hand.get(i).getCardSuit());
		}		
		return cards;
	}
	
	
	public int getCurrentScore() {
		return currentScore;
	}


	public int getFinalScore() {
		return finalScore;
	}

	public int getIndexLastCard() {
		indexLastCard = hand.size()-1;
		return indexLastCard;
	}

	public boolean isBust() {
		return isBust;
	}


	public boolean isStands() {
		return stands;
	}

	
}
