import java.util.ArrayList;

public class PathMaker {
	String rootName;
	int rootIndex;
	public PathMaker() {
		rootName = null;
	}
	public ArrayList<Path> MakePaths(ArrayList<Node> nodes){
		
		ArrayList<Path> paths = new ArrayList<Path>();
		
		for(int i = 0; i<nodes.size(); i++) {			//find foot
					
			if(nodes.get(i).isRoot()) {
				rootName = nodes.get(i).getName();
				rootIndex = i;
			}			
		}
		
		
		
		
		
		
		
		
		
		return paths;
	}
	
	public Path copyPath(Path path) {
		return path;
	}
}
