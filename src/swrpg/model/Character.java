/**
 * @author Mark Rustad
 * @version .01
 * @date Oct 31, 2014
 */
package swrpg.model;
import java.sql.ResultSet;
import java.sql.SQLException;

import swrpg.database.CharacterQueries;
/**
 * @author Mark
 *
 */
public class Character {
	
	
	
	//Character Fields
	private int charId;
	
	//Narrative elements
	private String name, player, gender, age, height, build, hair, eyes, noteableFeatures, history, race;
	
	//Characteristics stats
	private int brawn, agility, intellect, cunning, willpower, presence;
	
	public Character (int id)
	{
		charId = id;
		
		//Read from database applicable information
		try {
			
			//get generic character details
			CharacterQueries cq = new CharacterQueries();
			ResultSet charDetails = cq.getDetails(charId);
			name = charDetails.getString("name");
			player = charDetails.getString("player");
			gender = charDetails.getString("gender");
			age = charDetails.getString("age");
			height = charDetails.getString("height");
			build = charDetails.getString("build");
			hair = charDetails.getString("hair");
			eyes = charDetails.getString("eyes");
			noteableFeatures = charDetails.getString("noteableFeatures");
			history = charDetails.getString("history");
			race = charDetails.getString("race");
			charDetails.close();
			
			//Load characteristics
			ResultSet charact = cq.getCharacteristics(charId);
			brawn = charact.getInt("brawn");
			agility = charact.getInt("agility");
			intellect = charact.getInt("intellect");
			cunning = charact.getInt("cunning");
			willpower = charact.getInt("willpower");
			presence = charact.getInt("presence");
			charact.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @return the charId
	 */
	public int getCharId() {
		return charId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the player
	 */
	public String getPlayer() {
		return player;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * @return the build
	 */
	public String getBuild() {
		return build;
	}

	/**
	 * @return the hair
	 */
	public String getHair() {
		return hair;
	}

	/**
	 * @return the eyes
	 */
	public String getEyes() {
		return eyes;
	}

	/**
	 * @return the noteableFeatures
	 */
	public String getNoteableFeatures() {
		return noteableFeatures;
	}

	/**
	 * @return the history
	 */
	public String getHistory() {
		return history;
	}

	/**
	 * @return the race
	 */
	public String getRace() {
		return race;
	}

	/**
	 * @return the brawn
	 */
	public int getBrawn() {
		return brawn;
	}

	/**
	 * @return the agility
	 */
	public int getAgility() {
		return agility;
	}

	/**
	 * @return the intellect
	 */
	public int getIntellect() {
		return intellect;
	}

	/**
	 * @return the cunning
	 */
	public int getCunning() {
		return cunning;
	}

	/**
	 * @return the willpower
	 */
	public int getWillpower() {
		return willpower;
	}

	/**
	 * @return the presence
	 */
	public int getPresence() {
		return presence;
	}
}
