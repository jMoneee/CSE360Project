import java.util.ArrayList;

public class Node 
{
	private int size;
	private ArrayList<String> dependencies;
	private String name;
	
	public Node(){
		size = 0;
		name = " ";
	}
	
	public Node(int num, String newName, ArrayList<String> nodeDependencies){
		size = num;
		name = newName;

		dependencies = nodeDependencies;

	}
	public void setSize(int num){
		
		size = num;
	}

	public void setDependencies(ArrayList<String> nodeDependencies){
			dependencies = nodeDependencies;
	}
	
	public void setName(String newName){
		name = newName;
	}

	public int getSize(){
		return size;
	}
	
	public ArrayList<String> getDependencies(){
		return dependencies;
	}
	
	public String getName(){
		return name;
	}

		
	
	public Boolean isDependantOn(String name) {
		for(int i = 0; i<dependencies.size(); i++) {
			if(name.equals(dependencies.get(i)))
				return true;
		}
		return false;
	}
	public Boolean hasDependencies() {
		if(this.dependencies.isEmpty())
			return false;
		else 
			return true;
	}


	
	public String printDependencies(){
		String depens="";
		if(this.hasDependencies()==false)
			return depens;
		depens+=dependencies.get(0);
		for(int i=1; i<dependencies.size(); i++)
			depens+=", "+dependencies.get(i);
		return depens;
	}
}
