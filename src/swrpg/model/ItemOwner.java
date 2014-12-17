/**
 * 
 */
package swrpg.model;

import java.util.ArrayList;

/**
 * @author Mark
 *
 */
public interface ItemOwner {
	
	public ArrayList<OwnedItem> getItemList();
	
	public int getCredits();

}
