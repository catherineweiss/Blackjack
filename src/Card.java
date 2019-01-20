/**
 * Playing card with a suit and rank
 * @author Catherine Weiss
 *
 */
public class Card {

	private String suit; 
	private String rank;
	int	rankValue;

	
	Card(String s, String r, int v) {
		suit = s;
		rank = r;
		rankValue = v;
	}

	/**
	 * 
	 * @return suit of playing card
	 */
	public String getCardSuit() {
		return suit;
	}

	/**
	 * 
	 * @return rank of playing card
	 */
	public String getCardRank() {
		return rank;
	}

	/**
	 * 
	 * @return point value of playing card
	 */
	public int getCardValue() {
		return rankValue;
	}
		
}
