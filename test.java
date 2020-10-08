package test;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runners.JUnit4;

 class DirReduction {
    public static String[] dirReduc(String[] arr) {
  
        Deque<String> tem = new ArrayDeque<>();
      
      for(int i=0; i<arr.length;i++){
      
          String string = arr[i];
		if (string.equals("NORTH")) {
			if( tem.peekLast()=="SOUTH") {
            	  tem.removeLast();
              }else tem.add(arr[i]);
		} else if (string.equals("SOUTH")) {
			if( tem.peekLast()=="NORTH") {
				tem.removeLast();
              }else 
            	  tem.add(arr[i]);
		} else if (string.equals("WEST")) {
			if( tem.peekLast()=="EAST" ) {
				tem.removeLast();
              }else 
            	  tem.add(arr[i]);
		} else if (string.equals("EAST")) {
			if( tem.peekLast()=="WEST" ) {
				tem.removeLast();
              }else 
            	  tem.add(arr[i]);
		} else {
		}    
        
      }
      String[] dir = tem.toArray(new String[tem.size()]);
       
      
      return dir;
    }
}





    public class test {
 
    	@Test
    	  public static void testSimpleDirReduc() {        
    	    assertArrayEquals("\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"",
    	          new String[]{"WEST"},
    	          DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));
    	   
    	    assertArrayEquals("\"NORTH\",\"SOUTH\",\"SOUTH\",\"EAST\",\"WEST\",\"NORTH\"",
    	          new String[]{},
    	          DirReduction.dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"}));
    	  }
	public static void main(String[] args) {
	
	
		testSimpleDirReduc();

		
	
	}
	
}
