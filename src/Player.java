/**
 * Player of game
 * @author Catherine Weiss
 *
 */

public class Player {
	
	private String name;
	
	Player (String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return player name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param new player name 
	 */
	public void setName(String newName) {
		if (newName.length()>0) {
			name = newName;
		}
	}


}
