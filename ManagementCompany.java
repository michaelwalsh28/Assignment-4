
public class ManagementCompany
{
	
	
	static final int MAX_PROPERTY = 5;
	static final int MGMT_WIDTH = 10;
	static final int MGMT_DEPTH = 10;
	
	private Property[] properties;
	private Plot plot;
	private String name;
	private String taxID;
	private double mgmFeePer;
	private int x;
	private int y;
	private int width;
	private int depth;
	
	
	ManagementCompany(String name, String taxID, double mgmFeePer)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(0,0,1,1);
	}
	
	ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y,
			int width, int depth)
	{
		this.name = name; 
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
		this.plot = new Plot(x,y,width,depth);
	}
	
	ManagementCompany(ManagementCompany otherCompany)
	{
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.x = otherCompany.x;
		this.y = otherCompany.y;
		this.plot = new Plot(otherCompany.x, otherCompany.y, otherCompany.width, otherCompany.depth);
	}
	
	public int addProperty(String name, String city, double rent, String owner)
	{
		boolean status = true;
		for (int i = 0; i < MAX_PROPERTY; i++)
		{
			if (properties[i] == null)
			{
				status = false;
				break;
			}
		}
		
		if (status == true)
		{
			return -1;
		}
		
		Property property = new Property(name, city, rent, owner);
		
		for (int i = 0; i < MAX_PROPERTY; i++)
		{
			if (properties[i] != null)
			{
				if (properties[i].getPlot().encompasses(property.getPlot()))
				{
					return -3;
				}
				else if (properties[i].getPlot().overlaps(property.getPlot()))
				{
					return -4;
				}
			}

		}
		for (int i = 0; i < MAX_PROPERTY; i++)
		{
			if (properties[i] == null)
			{
				this.properties[i] = property;
				break;
			}
		}
		
		for (int i = 0; i < MAX_PROPERTY; i++)
		{
			if (property == properties[i])
			{
				return i;
			}
		}
		return -1;
	}
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y,
			int width, int depth)
	{
		boolean status = true;
		for (int i = 0; i < MAX_PROPERTY; i++)
		{
			if (properties[i] == null)
			{
				status = false;
				break;
			}
		}
		
		if (status == true)
		{
			return -1;
		}
		
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		
		for (int i = 0; i < MAX_PROPERTY; i++)
		{
			if (properties[i] != null)
			{
				if (properties[i].getPlot().encompasses(property.getPlot()))
				{
					return -3;
				}
				else if (properties[i].getPlot().overlaps(property.getPlot()))
				{
					return -4;
				}
			}
		}
		
		for (int i = 0; i < MAX_PROPERTY; i++)
		{
			if (properties[i] == null)
			{
				this.properties[i] = property;
				break;
			}
		}
		
		for (int i = 0; i < MAX_PROPERTY; i++)
		{
			if (property == properties[i])
			{
				return i;
			}
		}
		
		return -1;
		
	}
	
	public int addProperty(Property property)
	{		
		
		boolean status = true;
		for (int i = 0; i < MAX_PROPERTY; i++)
		{
			if (properties[i] == null)
			{
				status = false;
				break;
			}
		}
		if (status == true)
		{
			return -1;
		}
		
		
		for (int i = 0; i < MAX_PROPERTY; i++)
		{
			if (properties[i] != null)
			{
				if (properties[i].getPlot().encompasses(property.getPlot()))
				{
					return -3;
				}
				else if (properties[i].getPlot().overlaps(property.getPlot()))
				{
					return -4;
				}
			}

		}
		
		for (int i = 0; i < MAX_PROPERTY; i++)
		{
			if (properties[i] == null)
			{
				this.properties[i] = property;
				break;
			}
		}
		
		for (int i = 0; i < MAX_PROPERTY; i++)
		{
			if (property == properties[i])
			{
				return i;
			}
		}
		
		return -1;
	}
	
	
	public Property getHighestRentProperty()
	{
		double highest = 0;
		Property y = properties[0];
		for (int i = 0; i < MAX_PROPERTY; i++)
		{
			double x = properties[i].getRentAmount();
			if(x > highest)
			{
				highest = x;
				y = properties[i];
			}
		}
		return y;
	}
	
	public double getMgmFeePer()
	{
		return mgmFeePer;
	}
	
	public String getName()
	{	
		return name;
	}
	
	public Plot getPlot()
	{
		return plot;
	}
	
	public Property[] getProperties()
	{
		return properties;
	}
	
	public int getPropertiesCount()
	{
		return MAX_PROPERTY;
	}
	
	public String getTaxID()
	{
		return taxID;
	}
	
	public double getTotalRent()
	{
		double total = 0.0;
		for (int i = 0; i < MAX_PROPERTY; i++)
		{
			if (properties[i] != null)
			{
				double x = properties[i].getRentAmount();
				total += x;
			}
		}
		return total;
	}
	
	public boolean isManagementFeeValid()
	{
		boolean status = true;
		if (mgmFeePer > 100 || mgmFeePer < 0)
		{
			status = false;
		}
		return status;
	}
	
	public boolean isPropertiesFull()
	{
		boolean status = true;
		for (int i = 0; i < MAX_PROPERTY; i++)
		{
			if (properties[i] == null)
			{
				status = false;
			}
		}
		return status;
	}
	
	public void removeLastProperty()
	{
		for (int i = MAX_PROPERTY; i > 0; i--)
		{
			if (properties[i] != null)
			{
				properties[i] = null;
				break;
			}
		}
	}
	
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		
		str.append("List of the properties for " + getName() + ", taxID: " + getTaxID() + "\n" +
				"______________________________________________________\n");
		
		for (int i = 0; i < MAX_PROPERTY; i++)
		{
			if (this.properties[i] != null)
			{
				str.append(properties[i].getPropertyName() + ",");
				str.append(properties[i].getCity() + ",");
				str.append(properties[i].getOwner() + ",");
				str.append(properties[i].getRentAmount()  + "\n" +
						"______________________________________________________\n" + "\n");
			}
		}
		
		double totalManagementFee = getTotalRent() * (mgmFeePer/100);
		
		str.append(" total management Fee: " + totalManagementFee);
		String result = str.toString();
		return result;
	}
}
