
public class Property 
{

	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private int x;
	private int y;
	private int width;
	private int depth;
	
	public Property(String propertyName, String city, double rentAmount, String owner)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner, 
			int x, int y, int width, int depth)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	public Property(Property otherProperty)
	{
		this.propertyName = otherProperty.propertyName;
		this.city = otherProperty.city;
		this.rentAmount = otherProperty.rentAmount;
		this.owner = otherProperty.owner;
		this.x = otherProperty.x;
		this.y = otherProperty.y;
		this.width = otherProperty.width;
		this.depth = otherProperty.depth;
	}
	
	public Plot getPlot()
	{
		Plot plot = new Plot();
		return plot;
	}
	
	public String getPropertyName()
	{
		return propertyName;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public double getRentAmount()
	{
		return rentAmount;
	}
	
	public String getOwner()
	{
		return owner;
	}
	
	public String toString()
	{
		String property = getPropertyName() + "," + getCity() + "," + getOwner() + "," + getRentAmount();
		return property;
	}
}
