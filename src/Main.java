
public class Main { 
    public static void main(String[] args) {
    	 Tree tree=new Tree();
    	  int[] arr1 = new int[]{2,3};
    	  int[] arr2 = new int[]{3,1};
    	  int[] arr3 = new int[]{4,2};
    	  Node node1= new Node(arr1);
    	  Node node2= new Node(arr2);
    	  Node node3= new Node(arr3);
    	tree.insert(node1);
    	tree.insert(node2);
    	tree.insert(node3);
    	tree.print(node1);
    	System.out.println(tree.search(node1)); 	
    	tree.delete(node1);
    	tree.print(node1);
    	 
    }


}