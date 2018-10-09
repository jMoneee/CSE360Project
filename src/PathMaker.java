import java.util.ArrayList;

public class PathMaker {
	String footName;
	int footIndex;
	int numOfPaths;
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
		}
		numOfPaths=1;
		for(int i = 0; i<nodes.size(); i++) {
			if(nodes.get(i).getDependencies().size()>1) {
				numOfPaths = numOfPaths +nodes.get(i).getDependencies().size()-1;
			}
		}
		int i = footIndex;
		for(int l = 0; l<numOfPaths; l++) {
			Path newPath= new Path();
			while(nodes.get(i).hasDependencies()) {//cycle through nodes to add them to newPath
				
				newPath.addNode(nodes.get(i));
				for(int m =0; m<nodes.size();m++) {
					if(nodes.get(m).getName().equals(nodes.get(i).getDependencies().get(0))) {//replace the 0 later
						i = m;
						
				//create new path everytime there is more than 1 dependency
					}
				}
			}
			paths.add(newPath);
		
		}
		
		
		
		
		
		
		
		
		
		return paths;
	}
	
	public Path copyPath(Path path) {
		return path;
	}
}
