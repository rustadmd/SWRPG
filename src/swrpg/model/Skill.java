/**
 * @author Mark Rustad
 * @version .01
 * @date Nov 1, 2014
 */
package swrpg.model;

/**
 * @author Mark
 *
 */
public class Skill {
	
	private String name, baseCharacteristic, type;
	private int rank;
	
	public Skill(String name, String baseChar, String type, int rank)
	{
		this.name = name;
		this.baseCharacteristic = baseChar;
		this.type = type;
		this.rank = rank;
	}

	/**
	 * @return the Skill name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the baseCharacteristic
	 */
	public String getBaseCharacteristic() {
		return baseCharacteristic;
	}

	/**
	 * @param baseCharacteristic the baseCharacteristic to set
	 */
	public void setBaseCharacteristic(String baseCharacteristic) {
		this.baseCharacteristic = baseCharacteristic;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the rank
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}

}
