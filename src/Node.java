import java.util.ArrayList;

public class Node 
{
	private int size;
	private ArrayList<String> dependencies;
	private String name;
	private ArrayList<String> nodesThatDependOnThis; //fill once all nodes are entered
	
	public Node(){
		size = 0;
		name = " ";
	}
	
	public Node(int num, int depSize, String newName, ArrayList<String> nodeDependencies){
		size = num;
		name = newName;
		dependencies = new ArrayList<String>();
		for(int i=0; i<depSize-1; i++)
			dependencies.set(i,nodeDependencies.get(i));
	}
	public void setSize(int num){
		
		size = num;
	}

	public void setDependencies(ArrayList<String> nodeDependencies){
		dependencies = new ArrayList<String>();
		for(int i=0; i<(nodeDependencies.size()-1); i++)
			dependencies.set(i,nodeDependencies.get(i));
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
	public boolean isRoot() {
		if(dependencies.size()==0) {
			return true;
		}
		else
			return false;
		
	}
	public Boolean isDependantOn(String name) {
		for(int i = 0; i<dependencies.size(); i++) {
			if(name.equals(dependencies.get(i)))
				return true;
		}
		return false;
	}
	public void addNodeThatDependOnThis(String nodeThatDepends) {
		
			nodesThatDependOnThis.add(nodeThatDepends);
	}
	public boolean hasNodesDependent() {
		if(nodesThatDependOnThis.size()>0)
			return false;
		else 
			return true;
		
	}
	public ArrayList<String> getnodesThatDependOnThis(){
		return nodesThatDependOnThis;
	}
	public int getNumOfDependentOn() {
		return nodesThatDependOnThis.size();)
	}
	
	
}
