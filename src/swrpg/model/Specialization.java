/**
 * 
 */
package swrpg.model;

/**
 * @author Mark
 *
 */
public class Specialization {
	
	private String name;
	
	public Specialization(String name)
	{
		this.setName(name);
	}
	
	public String toString()
	{
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
