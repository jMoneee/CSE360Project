import java.util.ArrayList;

public class PathMaker {
	String footName;
	int footIndex;
	int numOfPaths;
	public ArrayList<Path> paths = new ArrayList<Path>();
	Path currentPath = new Path();
	Path tempPath = new Path();
	
	public PathMaker() {
		footName = "";
	}
	
	
	public ArrayList<Path> MakePaths(ArrayList<Node> nodes)
	{
		ArrayList<Path> paths = new ArrayList<Path>();
		ArrayList<Integer> foundDepens = new ArrayList<Integer>();
		ArrayList<Integer> foundDepens2 = new ArrayList<Integer>();
		boolean isDone=false;
		int current = findFirst(nodes);
		//System.out.println("current"+current);
		currentPath.addNode(nodes.get(current));
		foundDepens = findDependencies(current, nodes);
		System.out.println(nodes.get(current).getName()+" has "+foundDepens+" as depedencies\n");
		String output = "";
		while(isDone==false)
		{
			//foundDepens = findDependencies(current, nodes);
			//System.out.println("dependencies" +foundDepens);
			output="";
			if(foundDepens.size()>2)
			{
				int i=1;
				while(i<foundDepens.size())
				{
					tempPath.setActivities(currentPath.getActivities());
					System.out.println("activities "+tempPath.getActivities().size()+"\n");
					tempPath = MakeTempPath(nodes, tempPath,i);
					paths.add(tempPath);
	            	for(int j=0; j<tempPath.getActivities().size();j++)
	            	{
	            		output+=tempPath.getActivities().get(j).getName();
	            	}
	            	System.out.println(output);
	            	output="";
	            	tempPath = new Path();
					i++;
					
					
				}
			}
			else if(foundDepens.size()>1)
			{
				tempPath.setActivities(currentPath.getActivities());
				System.out.println("activities "+tempPath.getActivities().size()+"\n");
				tempPath = MakeTempPath(nodes, tempPath);
				paths.add(tempPath);
            	for(int j=0; j<tempPath.getActivities().size();j++)
            	{
            		output+=tempPath.getActivities().get(j).getName();
            	}
            	System.out.println(output);
            	output="";
            	//problem is here. the second case is not taken care of and is skipped.
            	//there is no get(1) for this section. so add a call to fix this and you should be good.
				tempPath = new Path();
            	tempPath.setActivities(currentPath.getActivities());
				tempPath.addNode(nodes.get(foundDepens.get(1)));
				System.out.println("you are here/n");
				foundDepens2 = findDependencies(foundDepens.get(1), nodes);
				if(foundDepens2.size()>1)
				{
					tempPath.addNode(nodes.get(foundDepens2.get(0)));
					tempPath = MakeTempPath(nodes, tempPath);
					paths.add(tempPath);
	            	for(int j=0; j<tempPath.getActivities().size();j++)
	            	{
	            		output+=tempPath.getActivities().get(j).getName();
	            	}
	            	System.out.println(output);
	            	output="";
				}
			}
			tempPath = new Path();
			currentPath.addNode(nodes.get(foundDepens.get(0)));
		//	System.out.println("adding "+nodes.get(foundDepens.get(0)).getName());
			current = foundDepens.get(0); //change later
			foundDepens = findDependencies(current, nodes);
			if(foundDepens.isEmpty())
			{
				isDone=true;
				//System.out.println("true when current is "+current);
			}
			/* was here before
			if(foundDepens.size()>1)
			{
				Path tempPath = currentPath;
				paths.add(MakeTempPath(nodes, tempPath));
			}*/

		}
    	for(int j=0; j<currentPath.getActivities().size();j++)
    	{
    		output+=currentPath.getActivities().get(j).getName();
    	}
    	System.out.println(output);
		paths.add(currentPath);
		
		return paths;
	}

	public Path MakeTempPath(ArrayList<Node> nodes, Path temp)
	{
		ArrayList<Integer> foundDepens1;
		//System.out.println("temp array "+temp.getActivities().size());
		boolean isDone=false;

		int current1 = temp.getActivities().size()-1;
		//if(temp.getActivities().size()==1)
		//{
		for(int i=0; i<nodes.size(); i++)
		{
			if(nodes.get(i).getName().equals(temp.getActivities().get(current1).getName()))
			{
				current1 = i;
				i=nodes.size();
			}
		}
		//}
		System.out.println("activities "+temp.getActivities().get(0).getName()+"\n");
	//	System.out.println(current1);
	
		while(isDone==false)
		{
			foundDepens1 = findDependencies(current1, nodes);
			System.out.println(nodes.get(current1).getName()+" has "+foundDepens1+" as depedencies\n");
			
			if(foundDepens1.size()==1)
			{
				temp.addNode(nodes.get(foundDepens1.get(0)));
				current1 = foundDepens1.get(0);
			}
			else if(foundDepens1.size()>1)
			{
				temp.addNode(nodes.get(foundDepens1.get(1)));
				current1 = foundDepens1.get(1);
			}
			
			//System.out.println("adding "+nodes.get(foundDepens1.get(1)).getName());
			//System.out.println("1 " +foundDepens1);
			foundDepens1 = findDependencies(current1, nodes);
			if(foundDepens1.isEmpty())
			{
				isDone=true;
				//System.out.println("true");
		
			}
				
		}
		//for(int j=0; j<temp.getActivities().size();j++)
    	//{
    	//	System.out.println(temp.getActivities().get(j).getName());
    	//}
		return temp;
	}
	public Path MakeTempPath(ArrayList<Node> nodes, Path temp, int k)
	{
		ArrayList<Integer> foundDepens1;
		//System.out.println("temp array "+temp.getActivities().size());
		boolean isDone=false;

		int current1 = temp.getActivities().size()-1;
		//if(temp.getActivities().size()==1)
		//{
		for(int i=0; i<nodes.size(); i++)
		{
			if(nodes.get(i).getName().equals(temp.getActivities().get(current1).getName()))
			{
				current1 = i;
				i=nodes.size();
			}
		}
		//}
		System.out.println("activities "+temp.getActivities().get(0).getName()+"\n");
	//	System.out.println(current1);
	
		while(isDone==false)
		{
			foundDepens1 = findDependencies(current1, nodes);
			System.out.println(nodes.get(current1).getName()+" has "+foundDepens1+" as depedencies\n");
			
			if(foundDepens1.size()==1)
			{
				temp.addNode(nodes.get(foundDepens1.get(0)));
				current1 = foundDepens1.get(0);
			}
			else if(foundDepens1.size()>2)
			{
				temp.addNode(nodes.get(foundDepens1.get(k)));
				current1 = foundDepens1.get(k);
			}
			else if(foundDepens1.size()>1)
			{
				temp.addNode(nodes.get(foundDepens1.get(1)));
				current1 = foundDepens1.get(1);
			}
			
			//System.out.println("adding "+nodes.get(foundDepens1.get(1)).getName());
			//System.out.println("1 " +foundDepens1);
			foundDepens1 = findDependencies(current1, nodes);
			if(foundDepens1.isEmpty())
			{
				isDone=true;
				//System.out.println("true");
		
			}
				
		}
		//for(int j=0; j<temp.getActivities().size();j++)
    	//{
    	//	System.out.println(temp.getActivities().get(j).getName());
    	//}
		return temp;
	}
	public ArrayList<Integer> findDependencies(int current,ArrayList<Node> nodes)
	{
		ArrayList<Integer> dependencies = new ArrayList<Integer>();
		for(int i=0; i<nodes.size();i++)
		{
			for(int j=0; j<nodes.get(i).getDependencies().size();j++)
			{	
				if(nodes.get(current).getName().equals(nodes.get(i).getDependencies().get(j)))
				{
					System.out.println(nodes.get(i).getName()+" is a match \n");
					dependencies.add(i);
				}

			}
		}
		return dependencies;
		
	}
	public int findFirst(ArrayList<Node> n)
	{
		
		int numOfFirst=0;
		for(int i=0; i<n.size();i++)
		{
			if(n.get(i).hasDependencies()==false)
				numOfFirst++;
		}
		if(numOfFirst>1) {
			return 8888;
		}
		for(int i=0; i<n.size();i++)
		{
			if(n.get(i).hasDependencies()==false)
				return i;
		}
		
		return 9999;
	}
	public int numberOfPaths(ArrayList<Node> n)
	{
		int numberOfPaths=1;
		int current = 0;
		
		ArrayList<Integer> foundDepens;
		while(current<n.size())
		{	
			foundDepens = findDependencies(current, n);
			//System.out.println(foundDepens);
			if(foundDepens.size()>1)
			{
				numberOfPaths += foundDepens.size();
				System.out.println("increase");
			}
			current++;
		}
		return numberOfPaths;
	}
	public ArrayList<Path> pathSort(ArrayList<Path> input){
		for (int i = 0; i < input.size() - 1; i++) {
			int j = i + 1;
			Path tmp = input.get(j);
			while (j > 0 && tmp.getDuration() > (input.get(j-1).getDuration())) {
				input.set(j, input.get(j-1));
				j--;
			}
			input.set(j, tmp);
			}
        return input;
	}
public String getName()
{
	return footName;
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
						copiedPath.addNode(nodes.get(m));
						buildPath(copiedPath, m, nodes);
					}
					
				}
			}
		}
		
		paths.add(newPath);
	}

	public int findByName(ArrayList<Node> in, String _name) { 	//finds index of a node by name
																//use this for duration changer
																//do the changing of duration in main
		for(int i=0; i<in.size();i++) {
			if(in.get(i).getName().equals(_name)) {
				return i;
			}
		}
		
		return 9999;
	}
	public ArrayList<Path> findCriticalPaths(ArrayList<Path> paths) {
		
		ArrayList<Path> critPaths = new ArrayList<Path>();	
		ArrayList<Path> pathsSorted = pathSort(paths);
		
		int critDuration = pathsSorted.get(0).getDuration();
		
		for(int i =0; i< pathsSorted.size(); i++) {
			if(pathsSorted.get(i).getDuration()==critDuration) {
				critPaths.add(pathsSorted.get(i));
			}
		}
		
		return critPaths;
	}
	public int findUnconnected(ArrayList<Node> nodes) {
		
		for(int i=0; i< nodes.size();i++) {
			
			ArrayList<Integer> dependencies = findDependencies(i, nodes);
			if(!nodes.get(i).hasDependencies() && dependencies.size()==0) {
				return 1;
			}
		}
		
		return 0;
	}
}
