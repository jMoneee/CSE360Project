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
		
		/*int i=rootIndex; //current index of node, starts at root
		int pathIndex=0;
		while(nodes.get(i).hasNodesDependent()) { //stops at node that nothing depends on AKA the last node 
			// this loop will create all the paths
			paths.get(pathIndex).addNode(nodes.get(i));//continue existing path
			for(int j = 1; j<nodes.get(i).getnodesThatDependOnThis().size(); j++) {
				paths.add(copyPath(paths.get(pathIndex)));
				//add info to the paths
			}
			pathIndex++;
			
			
		}*/
		
		//find max # of dependencies in a node and run through path making that # of times
		int maxDependencies=0;
		for(int i = 0; i<nodes.size();i++) {
			if(nodes.get(i).getNumOfDependentOn()>maxDependencies) {
				maxDependencies=nodes.get(i).getNumOfDependentOn();
			}
		}
		//starting from the root, cycle through the nodes list in order of dependencies n-1 times
		//where n is max # of dependencies changing index of the NodeThatDepnd you access to
		for(int j = 0; j< maxDependencies; j++) {
			paths.add(new Path());
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
	public Path copyPath(Path path) {
		return path;
	}
}
