/**
 * @author Mark Rustad
 * @version .01
 * @date Nov 14, 2014
 */
package swrpg.model;

/**
 * @author Mark
 *
 */
public class Obligation {
	
	private int charId, obligationId, magnitude;
	private String title, complications, obligationName;
	
	/**
	 * Items are retrieved from the database
	 * @param charId 
	 * @param obId	Unique id of the obligation
	 * @param magnitude
	 * @param obName	Name of the obligation (master name)
	 * @param title
	 * @param comp
	 */
	public Obligation(int charId, int obId, int magnitude, String obName, String title, String comp)
	{
		this.charId = charId;
		this.obligationId = obId;
		this.magnitude = magnitude;
		this.obligationName = obName;
		this.title = title;
		this.complications = comp;
		
	}

	/**
	 * @return the charId
	 */
	public int getCharId() {
		return charId;
	}

	/**
	 * @return the obligationId
	 */
	public int getObligationId() {
		return obligationId;
	}

	/**
	 * @return the magnitude
	 */
	public int getMagnitude() {
		return magnitude;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the complications
	 */
	public String getComplications() {
		return complications;
	}

	/**
	 * @return the obligationName
	 */
	public String getObligationName() {
		return obligationName;
	}

}
