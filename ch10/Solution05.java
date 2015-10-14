import java.util.*;

public class Solution05
{
	/**
	 *  Solution idea:
	 *  Binary search can be a choice, but maybe not the best solution.
	 *  "for loop" is a easier way to implement.
	 *  
	**/

	//for loop version
	public int search(String[] str, String target)
	{
		for(int i = 0; i < str.length; i++)
		{
			if(str[i].equals(target))
				return i;
		}
		return -1;
	}
	
	//binary search version
      	public static int search(String[] strings, String str, int first, int last) {
    	  if (first > last) 
    		  return -1;
    	  int mid = (first + last) / 2;
    	  //if mid is empty, find the closest non-empty string
    	  if (strings[mid].isEmpty()) {
    		  int left = mid - 1;
    		  int right = mid + 1;
    		  while (true) {
    			  if (left < first && right > last) {
    				  return -1;
    			  } else if (right <= last && !strings[right].isEmpty()) {
    				  mid = right;
    				  break;
    			  } else if (left >= first && !strings[left].isEmpty()) {
    				  mid = left;
    				  break;
    			  }
    			  right++;
    			  left--;
    		  }
    	  }
    	  //check for string, and recurse.
    	  if (str.equals(strings[mid])) {
    		  return mid;           //found
    	  } else if (strings[mid].compareTo(str) < 0) {   //search the right side
    		  return search(strings, str, mid + 1, last);
    	  } else {
    		  return search(strings, str, first, mid - 1); //search the left side
    	  }
	}
	public static int search(String[] strings, String str) {
	      if (strings == null || str == null || str == "") {
	    	  return -1;
	      }
	  return search(strings, str, 0, strings.length - 1);  
	}

}

