package swrpg.model;

public class Motivation {
	
	private String generalType, type, title, description;
	
	public Motivation(String gt, String type, String title, String description)
	{
		this.generalType = gt;
		this.type = type;
		this.title = title;
		this.description = description;
		//System.out.println("Motivation created: " + title);
	}

	/**
	 * @return the generalType
	 */
	public String getGeneralType() {
		return generalType;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

}
