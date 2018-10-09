import java.util.ArrayList;

public class PathMaker {
	String footName;
	int footIndex;
	int numOfPaths;
	public ArrayList<Path> paths = new ArrayList<Path>();
	public PathMaker() {
		footName = null;
	}
	public ArrayList<Path> MakePaths(ArrayList<Node> nodes){
		
		ArrayList<Path> paths = new ArrayList<Path>();
		boolean isFoot=true;
		for(int i = 0; i<nodes.size(); i++) {			//find foot
			for(int j =0; j<nodes.size(); j++)	{	
				if(nodes.get(i).getName().equals(nodes.get(j).getName())) {
					isFoot=false;
					}
				}
			if(isFoot) {
				footName = nodes.get(i).getName();
				footIndex= i;
			}			
		}												//foot found
		/*numOfPaths=1;
		for(int i = 0; i<nodes.size(); i++) {
			if(nodes.get(i).getDependencies().size()>1) {
				numOfPaths = numOfPaths +nodes.get(i).getDependencies().size()-1;
			}
		}*/
		int i = footIndex;
		//for(int l = 0; l<numOfPaths; l++) {
			Path newPath= new Path();
			while(nodes.get(i).hasDependencies()) {//cycle through nodes to add them to newPath
				
				newPath.addNode(nodes.get(i));
				for(int m =0; m<nodes.size();m++) {
					if(nodes.get(m).getName().equals(nodes.get(i).getDependencies().get(0))) {//replace the 0 later
						i = m;
						
				//create new path every time there is more than 1 dependency
					}
					if(nodes.get(m).getDependencies().size()>1) {
						for(int p = 0; p<nodes.get(m).getDependencies().size();p++) {
							Path copiedPath = copyPath(newPath);
							buildPath(copiedPath, m, nodes);
						}
					}
				}
			}
			paths.add(newPath);
		
		//}
		
		
		
		
		
		
		
		
		
		return paths;
	}
	
	public Path copyPath(Path path) {
		return path;
	}
	public void buildPath(Path path, int currentNodeIndex, ArrayList<Node> nodes) {
		
		Path newPath= new Path();
		while(nodes.get(currentNodeIndex).hasDependencies()) {//cycle through nodes to add them to newPath
			
			newPath.addNode(nodes.get(currentNodeIndex));
			for(int m =0; m<nodes.size();m++) {
				if(nodes.get(m).getName().equals(nodes.get(currentNodeIndex).getDependencies().get(0))) {//replace the 0 later
					currentNodeIndex = m;
					
			//create new path every time there is more than 1 dependency
				}
				if(nodes.get(m).getDependencies().size()>1) {
					for(int p = 0; p<nodes.get(m).getDependencies().size();p++) {
						Path copiedPath = copyPath(newPath);
						buildPath(copiedPath, m, nodes);
					}
					
				}
			}
		}
		
		paths.add(newPath);
	}
}
