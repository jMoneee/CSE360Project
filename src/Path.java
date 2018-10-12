import java.util.ArrayList;

public class Path {

	ArrayList<Node> activities = new ArrayList<Node>();

	int duration;
	
	public Path(/*String rootName, String firstAct, int _duration*/) {
		/*activities = new ArrayList<String>();
		activities.add(rootName);
		activities.add(firstAct);
		duration = _duration;*/
	}
	
	public void addNode(Node node) {

		activities.add(node);
		duration += node.getSize();
	}
	public ArrayList<Node> getActivities() {

		return activities;
	}
	public int getDuration() {
		return duration;
	}
	
	
}
