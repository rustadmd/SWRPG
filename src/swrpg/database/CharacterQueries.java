/**
 * @author Mark Rustad
 * @version .01
 * @date Nov 1, 2014
 */
package swrpg.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Mark
 *
 */
public class CharacterQueries {
	
	private SqlUtilities su = new SqlUtilities();
	
	public ResultSet getDetails(int charId)
	{
		Connection swdb = su.getDbConnection();
		PreparedStatement query = null;
		ResultSet charDetails = null;
		
		try
		{
			query = swdb.prepareStatement("SELECT c.name, player, gender, age, height"
					+ ", build, hair, eyes, noteableFeatures, history, credits, r.name AS race "
					+ " FROM Character c "
					+ " JOIN Race r ON r.raceId = c.raceId "
					+ " WHERE charId = ? ");
			query.setInt(1, charId);
			charDetails = query.executeQuery();
			//System.out.println("Result test: " + charDetails.getString("name"));
		}
		catch (SQLException e)
		{
			System.out.printf("Possible error, no character found with that id (%s) or DB connection issue", charId);
			e.printStackTrace();
		}
		return charDetails;
	}
	
	public ResultSet getCharacteristics(int charId)
	{
		Connection swdb = su.getDbConnection();
		PreparedStatement query = null;
		ResultSet characteristics = null;
		
		try
		{
			query = swdb.prepareStatement(
					"SELECT brawn, agility, intellect, cunning, willpower, presence "
					+ " FROM Characteristics c "
					+ " JOIN Character c2 ON c.characteristicsId=c2.characteristicsId "
					+ " WHERE charId = ? ");
			query.setInt(1, charId);
			characteristics = query.executeQuery();
			//System.out.println("Result test: " + charDetails.getString("name"));
		}
		catch (SQLException e)
		{
			System.out.printf("Possible error, no character found with that id (%s) or DB connection issue", charId);
			e.printStackTrace();
		}
		
		return characteristics;
	}

}
