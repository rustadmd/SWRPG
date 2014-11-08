/**
 * @author Mark Rustad
 * @version .01
 * @date Nov 8, 2014
 */
package swrpg.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import swrpg.database.ItemQueries;

/**
 * @author Mark
 *
 */
public class Item {

	private int id, encumb, price, rarity, hardPoints;
	private String name, description, type;
	
	public Item(int itemId)
	{
		id = itemId;
		
		ItemQueries iq = new ItemQueries();
		try{
			ResultSet details = iq.getItemDetails(id);
			name = details.getString("name");
			description = details.getString("description");
			
			encumb = details.getInt("encumb");
			price = details.getInt("price");
			hardPoints = details.getInt("hardPoints");
			rarity = details.getInt("rarity");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public String toString()
	{
		return name;
	}
	
	/**
	 * @return the itemId
	 */
	public int getItemId() {
		return id;
	}

	/**
	 * @return the encumb
	 */
	public int getEncumb() {
		return encumb;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @return the rarity
	 */
	public int getRarity() {
		return rarity;
	}

	/**
	 * @return the hardPoints
	 */
	public int getHardPoints() {
		return hardPoints;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
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

}
