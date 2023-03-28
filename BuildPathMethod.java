package javatest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BuildPathMethod {
	private List<int[]> buildPath(int[] finalNode, Map<String, int[]> closedMap) {
	    List<int[]> path = new ArrayList<>();
	    int[] currentNode = finalNode;

	    
	    while (currentNode != null)
	    {
	        int x = currentNode[0];
	        int y = currentNode[1];
	        int[] point = {x, y};
	        path.add(0, point); 
	        // Add the point to the beginning of the list
	        
	        currentNode = closedMap.get(getKey(currentNode[3] / 1000, currentNode[3] % 1000));
	        
	    }

	    return path;
	}


		// TODO Auto-generated metinhod stub
	
	  private String getKey(int x, int y) {
		  
		  
	   return x + " ," + y;
	
		return null;
	}


}
