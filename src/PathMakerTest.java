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
		System.out.println("number of paths "+ numberOfPaths(nodes));
		ArrayList<Path> paths = new ArrayList<Path>();
		ArrayList<Integer> foundDepens = new ArrayList<Integer>();
		boolean isDone=false;
		int current = findFirst(nodes);
		int i=0;
		//System.out.println("current"+current);
		currentPath.addNode(nodes.get(current));
		foundDepens = findDependencies(current, nodes);
		
		while(isDone==false)
		{
			//System.out.println("dependencies" +foundDepens);

			while(foundDepens.size()>i)
			{

				tempPath.setActivities(currentPath.getActivities());
				//tempPath.addNode(foundDepens.get(1));
				
				paths.add(tempPath);
				
				i+=2;
				
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
		
		paths.add(currentPath);
		
		return paths;
	}
	public Path MakeTempPath(ArrayList<Node> nodes, Path temp)
	{
		ArrayList<Integer> foundDepens1;
		//System.out.println("temp array "+temp.getActivities().size());
		boolean isDone=false;

		int current = temp.getActivities().size()-1;
		foundDepens1 = findDependencies(current, nodes);
		System.out.println(foundDepens1);
		
		if(foundDepens.size()>1)
		{
			temp.addNode(nodes.get(foundDepens1.get(1)));
			current1 = foundDepens1.get(1);
			
		}
		/*while(isDone==false)
		{
			temp.addNode(nodes.get(foundDepens1.get(i)));
			i++;
			foundDepens = findDependencies(current,nodes);
			if(foundDepens.size()==1)
				isDone==true;
		}
	*/
		return temp;
	}
	/*public Path MakeTempPath(ArrayList<Node> nodes, Path temp, int i)
	{
		ArrayList<Integer> foundDepens1;
		//System.out.println("temp array "+temp.getActivities().size());
		boolean isDone=false;

		int current1 = temp.getActivities().size()-1;
	//	System.out.println(current1);
	
		while(isDone==false)
		{
			foundDepens1 = findDependencies(current1, nodes);
			System.out.println(foundDepens1);
			
			temp.addNode(nodes.get(foundDepens1.get(i)));
			current1 = foundDepens1.get(i);
			if(foundDepens1.size()==1)
			{
				temp.addNode(nodes.get(foundDepens1.get(0)));
				current1 = foundDepens1.get(0);
			}
			else
			{
				temp.addNode(nodes.get(foundDepens1.get(1)));
				current1 = foundDepens1.get(1);
			}  
			System.out.println("adding "+current1);
			
			foundDepens1 = findDependencies(current1, nodes);
			System.out.println("found depens"+foundDepens1);
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
		System.out.println("adding path"+temp);
		return temp;
	}*/
	public ArrayList<Integer> findDependencies(int current,ArrayList<Node> nodes)
	{
		ArrayList<Integer> dependencies = new ArrayList<Integer>();
		for(int i=0; i<nodes.size();i++)
			for(int j=0; j<nodes.get(i).getDependencies().size();j++)
				if(nodes.get(current).getName().equals(nodes.get(i).getDependencies().get(j)))
					dependencies.add(i);
		
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
}
