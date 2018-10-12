import java.util.Scanner;

public class backEnd {

	private String name;
	private String duration;
	private String dependencies;
	private int size;
	
	public void setName(String actName)
	{
		name=actName;
	}
	
	public void setDuration(String actDura)
	{
		duration= actDura;
	}
	
	
	public int setDependencies(String actDepen)
	{
		dependencies=actDepen;
		int size=0;
		
		Scanner s = new Scanner(actDepen);
		s.useDelimiter(",");
		while(s.hasNext())
		{
			size++;
		}
		
		return size;
		
	}
	
	
}
