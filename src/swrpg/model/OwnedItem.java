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
public class OwnedItem {
	
	private Item item;
	private ItemOwner itemOwner;
	private int count;
	private boolean using;
	private String notes;
	
	public OwnedItem (ItemOwner io, Item i, int count, boolean using, String notes)
	{
		item = i;
		this.itemOwner = io;
		this.count = count;
		this.using = using;
		this.notes = notes;
	}
	
	public String toString()
	{
		return item.getName();
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
	public ItemOwner getItemOwner() {
		return itemOwner;
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
