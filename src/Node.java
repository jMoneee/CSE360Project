
public class Node 
{
	private int size;
	private char[] dependencies;
	private String name;
	
	public Node(){
		size = 0;
		name = " ";
	}
	
	public Node(int num, int depSize, String newName, char[]nodeDependencies){
		size = num;
		name = newName;
		dependencies = new Char[depSize];
		dependencies = nodeDependencies;
	}
	public void setSize(int num){
		
		size = num;
	}

	public void setDependencies(char[] nodeDependencies, int depSize){
		dependencies = new Char[depSize];
		dependencies = nodeDependencies;
	}
	
	public void setName(String newName){
		name = newName;
	}
	
	public int getSize(){
		return size;
	}
	
	public char[] getDependencies(){
		return dependencies;
	}
	
	public String getName(){
		return name;
	}
	
}
