
public class Plot 
{
	private int x;
	private int y; 
	private int width;
	private int depth; 
	
	public Plot()
	{
		// default plot
		this.x = 0;
		this.y = 0;
		this.depth = 1; 
		this.width = 1;
		
	}
	
	public Plot(int x, int y, int width, int depth)
	{
		this.x = x; 
		this.y = y; 
		this.width = width; 
		this.depth = depth;
	}
	
	public Plot (Plot otherPlot)
	{
		this.x = otherPlot.x;
		this.y = otherPlot.y;
		this.width = otherPlot.width;
		this.depth = otherPlot.depth;
	}
	
	boolean encompasses(Plot plot)
	{
		boolean status = false;
	
		
		if (plot.width > 400 || plot.width < 0 || plot.depth > 400 || plot.depth < 0)
		{
			status = true;
		}
		
		return status;
	}
	
	public int getDepth()
	{
		return depth;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public boolean overlaps(Plot plot)
	{
		boolean status = false;
		
		if (plot.getX() <= this.x + this.width || plot.getY() <= this.y + this.depth)
		{
			status = true;
		}
		
		return status;
	}

	public void setDepth(int depth)
	{
		this.depth = depth;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public String toString()
	{
		String str = "";
		str = getX() + "," + getY() + "," + getWidth() + "," + getDepth();
		return str;
	}
}
