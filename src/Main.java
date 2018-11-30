
public class Main { 
    public static void main(String[] args) {
    	Node root= new Node(new int[]{2,3});
    	Node node2= new Node(new int[]{3,1});
    	Node node3= new Node(new int[]{4,0});
    	Node node4= new Node(new int[]{5,3});
    	Node node5= new Node(new int[]{3,0});
    	Tree tree=new Tree(root);
    	tree.insert(node2);
    	tree.insert(node3);
    	tree.insert(node4);
    	tree.insert(node5);
    	tree.print();
    	System.out.println(tree.search(root)); 	
    	tree.delete(root);
    	System.out.println("-----------CASO APOS DELETAR------");
    	tree.print();
    }
}