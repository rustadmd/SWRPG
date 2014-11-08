/**
 * @author Mark Rustad
 * @version .01
 * @date Nov 8, 2014
 */
package swrpg.model;

/**
 * @author Mark
 *
 */
public class CharItem {
	
	private Item item;
	private Character c;
	private int count;
	private boolean using;
	private String notes;
	
	public CharItem (Character c, Item i, int count, boolean using, String notes)
	{
		item = i;
		this.c = c;
		this.count = count;
		this.using = using;
		this.notes = notes;
	}

	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * @return the c
	 */
	public Character getC() {
		return c;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @return the using
	 */
	public boolean isUsing() {
		return using;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

}
