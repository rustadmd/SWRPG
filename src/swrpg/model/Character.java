/**
 * @author Mark Rustad
 * @version .01
 * @date Oct 31, 2014
 */
package swrpg.model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import swrpg.database.CharacterQueries;
import swrpg.database.ItemQueries;
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
	
	//Numerical stats
	private int xpTotal, xpAvailable, credits;
	private int woundMax, strainMax, encumbMax, wound, strain, encumb, soak, def_range, def_melee;
	//Skills
	private ArrayList<Skill> genSkills, combatSkills, knowledgeSkills;
	//items
	private ArrayList<CharItem> itemList;
	private ArrayList<Obligation> obligationList;
	private ArrayList<Motivation> motivationList;
	
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
			credits = charDetails.getInt("credits");
			xpTotal = charDetails.getInt("xpTotal");
			xpAvailable = charDetails.getInt("xpAvailable");
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
			
			//load skills
			genSkills = cq.getSkills(charId, "General");
			combatSkills = cq.getSkills(charId, "Combat");
			knowledgeSkills = cq.getSkills(charId, "Knowledge");
			
			//load stats
			ResultSet stats = cq.getStats(charId);
			while(stats.next())
			{
				String statName = stats.getString("statName");
				switch (statName)
				{
					case "wound": wound = stats.getInt("value"); break;
					case "woundMax": woundMax = stats.getInt("value"); break;
					case "strain": strain = stats.getInt("value"); break;
					case "strainMax": strainMax = stats.getInt("value"); break;
					case "encumb": encumb = stats.getInt("value"); break;
					case "encumbMax": encumbMax = stats.getInt("value"); break;
					case "soak": soak = stats.getInt("value"); break;
					case "def_range": def_range = stats.getInt("value"); break;
					case "def_melee": def_melee = stats.getInt("value"); break;
					default: System.out.println("Stat " + statName +" not found for character " + name	);
				}
			}
			
			//add items
			ItemQueries iq = new ItemQueries();
			itemList = iq.getCharItem(this);
			
			//fill obligations and motivations
			obligationList = cq.getObligations(charId);
			motivationList = cq.getMotivations(charId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//non-sql exception 
		System.out.println("Character created..." + this.getName());
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

	/**
	 * @return the genSkills
	 */
	public ArrayList<Skill> getGenSkills() {
		return genSkills;
	}

	/**
	 * @return the combatSkills
	 */
	public ArrayList<Skill> getCombatSkills() {
		return combatSkills;
	}

	/**
	 * @return the knowledgeSkills
	 */
	public ArrayList<Skill> getKnowledgeSkills() {
		return knowledgeSkills;
	}

	/**
	 * @return the xpTotal
	 */
	public int getXpTotal() {
		return xpTotal;
	}

	/**
	 * @return the xpAvailable
	 */
	public int getXpAvailable() {
		return xpAvailable;
	}

	/**
	 * @return the credits
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * @return the woundMax
	 */
	public int getWoundMax() {
		return woundMax;
	}

	/**
	 * @return the strainMax
	 */
	public int getStrainMax() {
		return strainMax;
	}

	/**
	 * @return the encumbMax
	 */
	public int getEncumbMax() {
		return encumbMax;
	}

	/**
	 * @return the wound
	 */
	public int getWound() {
		return wound;
	}

	/**
	 * @return the strain
	 */
	public int getStrain() {
		return strain;
	}

	/**
	 * @return the encumb
	 */
	public int getEncumb() {
		return encumb;
	}

	/**
	 * @return the soak
	 */
	public int getSoak() {
		return soak;
	}

	/**
	 * @return the def_range
	 */
	public int getDef_range() {
		return def_range;
	}

	/**
	 * @return the def_melee
	 */
	public int getDef_melee() {
		return def_melee;
	}

	/**
	 * @return the itemList
	 */
	public ArrayList<CharItem> getItemList() {
		return itemList;
	}

	/**
	 * @return the obligationList
	 */
	public ArrayList<Obligation> getObligationList() {
		return obligationList;
	}

	/**
	 * @return the motivationList
	 */
	public ArrayList<Motivation> getMotivationList() {
		return motivationList;
	}
}
