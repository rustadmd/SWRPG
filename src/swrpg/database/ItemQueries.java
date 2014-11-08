/**
 * @author Mark Rustad
 * @version .01
 * @date Nov 8, 2014
 */
package swrpg.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import swrpg.model.Character;
import swrpg.model.CharItem;
import swrpg.model.Item;

/**
 * @author Mark
 *
 */
public class ItemQueries {
	
	private SqlUtilities su = new SqlUtilities();
	
	public ResultSet getItemDetails(int itemId)
	{
		Connection swdb = su.getDbConnection();
		PreparedStatement query = null;
		ResultSet itemDetails = null;
		
		try
		{
			query = swdb.prepareStatement(
					"SELECT * "
					+ " FROM Item i "
					+ " WHERE itemId = ? ");
			query.setInt(1, itemId);
			itemDetails = query.executeQuery();
			//System.out.println("Result test: " + itemDetails.getString("name"));
		}
		catch (SQLException e)
		{
			System.out.printf("Possible error, no item found with that id (%s) or DB connection issue", itemId);
			e.printStackTrace();
		}
		return itemDetails;
	}
	
	public ArrayList<CharItem> getCharItem(Character c)
	{
		ArrayList<CharItem> charItemList = new ArrayList<CharItem>();
		Connection swdb = su.getDbConnection();
		PreparedStatement query = null;
		ResultSet itemList = null;
		
		try{
			//query sql for the list
			query = swdb.prepareStatement(
					"SELECT itemId, number, use, notes "
					+ " FROM CharacterItem ci "
					+ " WHERE ci.charId = ? ");
			query.setInt(1, c.getCharId());
			itemList = query.executeQuery();
			
			//create list
			while(itemList.next())
			{
				Item i = new Item(itemList.getInt("itemId"));
				int number = itemList.getInt("number");
				String using = itemList.getString("use");
				boolean usingBool;
				if(using == "Y")
				{
					usingBool = true;
				}
				else{
					usingBool= false;
				}
				String notes = itemList.getString("notes");
				CharItem ci = new CharItem(c, i, number, usingBool, notes);
				charItemList.add(ci);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Problem adding item to list, with character " + c.getName());
			e.printStackTrace();
		}
		
		return charItemList;
	}

}
