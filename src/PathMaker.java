import java.util.ArrayList;

public class PathMaker {
	String rootName;
	int rootIndex;
	public PathMaker() {
		rootName = null;
	}
	public ArrayList<Path> MakePaths(ArrayList<Node> nodes){
		
		ArrayList<Path> paths = new ArrayList<Path>();
		
		for(int i = 0; i<nodes.size(); i++) {			//find root
			if(nodes.get(i).isRoot()&&rootName!=null) {
				//error out?
			}			
			if(nodes.get(i).isRoot()) {
				rootName = nodes.get(i).getName();
				rootIndex = i;
			}			
		}
		
		addNodesThatDependOnThis(nodes);
		int i=rootIndex; //current index of node, starts at root
		int pathIndex=0;
		while(nodes.get(i).hasNodesDependent()) { //stops at node that nothing depends on AKA the last node 
			// this loop will create all the paths
			for(int j = 0; j<nodes.get(i).getnodesThatDependOnThis().size(); j++) {
				
			}
			
			
		}
		
		
		
		return paths;
	}
	public void addNodesThatDependOnThis(ArrayList<Node> nodes){	
		
		for(int i = 0; i<nodes.size(); i++) {//cycle through nodes
			for(int j = 0; j<nodes.size(); j++) {//look for nodes that depend on i dependencies
				for(int k = 0; k<nodes.get(j).getDependencies().size();k++) {//cycle through dependency list
					if(nodes.get(i).getName().equals(nodes.get(j).getDependencies().get(j))) {
						nodes.get(i).addNodeThatDependOnThis(nodes.get(j).getDependencies().get(j));
					}
				}
			}
		}
		

	}
}
