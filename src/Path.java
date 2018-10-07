import java.util.ArrayList;

public class Path {
	ArrayList<String> activities = new ArrayList<String>();
	int duration;
	
	public Path(/*String rootName, String firstAct, int _duration*/) {
		/*activities = new ArrayList<String>();
		activities.add(rootName);
		activities.add(firstAct);
		duration = _duration;*/
	}
	
	public void addNode(Node node) {
		activities.add(node.getName());
		duration += node.getSize();
	}
	
	public Path copyPath(Path path) {
		return path;
	}
}
