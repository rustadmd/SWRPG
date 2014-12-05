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
import java.util.ArrayList;
import java.util.LinkedList;

import swrpg.model.Motivation;
import swrpg.model.Obligation;
import swrpg.model.Skill;
import swrpg.model.Specialization;

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
					+ ", build, hair, eyes, noteableFeatures, history, credits "
					+ ", xpTotal, xpAvailable, r.name AS race, cl.name AS career, c.numBoost, c.numSetback "
					+ " FROM Character c "
					+ " JOIN Race r ON r.raceId = c.raceId "
					+ " JOIN CareerList cl ON cl.careerId = c.careerId "
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
	
	public ResultSet getStats(int charId)
	{
		Connection swdb = su.getDbConnection();
		PreparedStatement query = null;
		ResultSet charDetails = null;
		
		try
		{
			query = swdb.prepareStatement("SELECT * "
					+ " FROM Stats s "
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
	
	public ArrayList<Skill> getSkills(int charId, String type)
	{
		Connection swdb = su.getDbConnection();
		PreparedStatement query = null;
		ResultSet skillsResult = null;
		ArrayList<Skill> skills = new ArrayList<Skill>();//throwaway list, so there can be another
		
		try
		{
			query = swdb.prepareStatement(
					"SELECT s.skillId, name, baseCharacteristic, type, rank "
					+ "FROM Skills s JOIN SkillList sl ON s.skillId = sl.skillId "
					+ " WHERE charId = ? AND type = ? ");
			query.setInt(1, charId);
			query.setString(2, type);
			skillsResult = query.executeQuery();
			//System.out.println("Result test: " + charDetails.getString("name"));
			
			//fill the skills list with new skills
			while(skillsResult.next())
			{
				//System.out.println(skillsResult.getString("name"));
				skills.add(new Skill(skillsResult.getString("name"), 
						skillsResult.getString("baseCharacteristic"),
						skillsResult.getString("type"),
						skillsResult.getInt("rank")));
			}
			skillsResult.close();
			//System.out.println("getSkills() triggered, skills added: " + itemsAdded);
		}
		catch (SQLException e)
		{
			System.out.printf("Possible error, no character found with that id (%s) or DB connection issue", charId);
			e.printStackTrace();
		}
		
		return skills;
	}
	
	public ArrayList<Obligation> getObligations(int charId)
	{
		Connection swdb = su.getDbConnection();
		PreparedStatement query = null;
		ResultSet obligationsResult = null;
		ArrayList<Obligation> obligations = new ArrayList<Obligation>(3);//throwaway list, so there can be another
		
		try
		{
			query = swdb.prepareStatement(
					"SELECT o.obligationTypeId, o.magnitude, ot.name, o.title, o.complications  "
					+ "FROM Obligations o JOIN ObligationType ot ON o.obligationTypeId = ot.obligationTypeId "
					+ " WHERE charId = ? ");
			query.setInt(1, charId);
			obligationsResult = query.executeQuery();
			//System.out.println("Result test: " + charDetails.getString("name"));
			
			//fill the skills list with new skills
			while(obligationsResult.next())
			{
				//System.out.println(skillsResult.getString("name"));
				obligations.add(new Obligation(charId, 
						obligationsResult.getInt("obligationTypeId"),
						obligationsResult.getInt("magnitude"),
						obligationsResult.getString("name"),
						obligationsResult.getString("title"),
						obligationsResult.getString("complications"))
						);
			}
			obligationsResult.close();
			//System.out.println("getSkills() triggered, skills added: " + itemsAdded);
		}
		catch (SQLException e)
		{
			System.out.printf("Possible error, no character found with that id (%s) or DB connection issue", charId);
			e.printStackTrace();
		}
		
		return obligations;
	}
	
	public ArrayList<Motivation> getMotivations(int charId)
	{
		Connection swdb = su.getDbConnection();
		PreparedStatement query = null;
		ResultSet motivationResults = null;
		ArrayList<Motivation> motivations = new ArrayList<Motivation>(3);//throwaway list, so there can be another
		
		try
		{
			query = swdb.prepareStatement(
					"SELECT mt.generalType, mt.name, m.title, m.description  "
					+ "FROM Motivations m JOIN MotivationType mt ON m.motivationTypeId = mt.motivationTypeId "
					+ " WHERE charId = ? ");
			query.setInt(1, charId);
			motivationResults = query.executeQuery();
			//System.out.println("Result test: " + charDetails.getString("name"));
			
			//fill the skills list with new skills
			while(motivationResults.next())
			{
				//System.out.println(skillsResult.getString("name"));
				motivations.add(new Motivation(
						motivationResults.getString("generalType"),
						motivationResults.getString("name"),
						motivationResults.getString("title"),
						motivationResults.getString("description"))
						);
			}
			motivationResults.close();
			//System.out.println("getSkills() triggered, skills added: " + itemsAdded);
		}
		catch (SQLException e)
		{
			System.out.printf("Possible error, no motivations for character found with that id (%s) or DB connection issue", charId);
			e.printStackTrace();
		}
		
		return motivations;
	}
	
	public LinkedList<Specialization> getSpecializations(int charId)
	{
		Connection swdb = su.getDbConnection();
		PreparedStatement query = null;
		ResultSet specResults = null;
		LinkedList<Specialization> specList = new LinkedList<Specialization>();
		
		try
		{
			query = swdb.prepareStatement(
					"SELECT sl.name AS specName  "
					+ "FROM Specializations s "
					+ " JOIN SpecializationList sl ON sl.specId = s.specId "
					+ " WHERE charId = ? ");
			query.setInt(1, charId);
			specResults = query.executeQuery();
			//System.out.println("Result test: " + charDetails.getString("name"));
			
			//fill the skills list with new skills
			while(specResults.next())
			{
				//System.out.println(skillsResult.getString("name"));
				specList.add(new Specialization(specResults.getString("specName")));
			}
			specResults.close();
			//System.out.println("getSkills() triggered, skills added: " + itemsAdded);
		}
		catch (SQLException e)
		{
			System.out.printf("Possible error, no specializations for character found with that id (%s) or DB connection issue\n", charId);
			e.printStackTrace();
		}
		
		return specList;
	}

}
