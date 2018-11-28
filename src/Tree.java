import java.util.Arrays;

public class Tree {
	    Node root = null;

	    public Tree() {
	        
	    }

	    public boolean isEmpty() {
	        return root == null;
	    }

	    public boolean insert(Node t) {
	        if (root == null) {
	            root = t;
	            return true;
	        }
	        int aux = 0;
	        Node currNode = root;
	        while (true) {
	            if (t.point[aux] <= currNode.point[aux]) {
	                if (currNode.equals(t)) {
	                    System.err.println("Node already exist in tree");
	                    return false;
	                }
	                if (currNode.left == null) {
	                    currNode.left = t;
	                    break;
	                } else
	                    currNode = currNode.left;
	            } else {
	                if (currNode.right == null) {
	                    currNode.right = t;
	                    break;
	                } else
	                    currNode = currNode.right;
	            }
	            aux = (aux + 1) % 2;
	        }
	        return true;
	    }

	    public boolean search(Node t) {
	        
	        int currDim = 0;
	        Node currNode = root;
	        while (currNode != null) {
	            if (currNode.equals(t))
	                return true;//ou return currRoot;
	            if (t.point[currDim] < currNode.point[currDim])
	                currNode = currNode.left;
	            else
	                currNode = currNode.right;
	            currDim = (currDim + 1) % 2;
	        }
	        return false;
	    }

	    public boolean delete(Node t) {
	        if (root == null)
	            return false;
	        boolean isExist = this.search(t);
	        if (isExist == false)
	            return false;
	        root = delete(root, t, 0);
	        return true;
	    }

	    private Node delete(Node currNode, Node t, int aux) {
	        if (currNode == null)
	            return null;
	        aux = aux % 2;
	        if (t.equals(currNode)) {
	            if (currNode.right != null) {
	                Node rightMin = findMinimum(currNode.right, aux, aux + 1);
	                currNode.point = rightMin.point;
	                currNode.right = delete(currNode.right, rightMin, aux + 1);
	            } else if (currNode.left != null) {
	                Node leftMin = findMinimum(currNode.left, aux, aux + 1);
	                currNode.point = leftMin.point;
	                currNode.right = delete(currNode.left, leftMin, aux + 1);
	                currNode.left = null;
	            } else {
	                return null;
	            }
	            if (currNode.left != null && currNode.left.point[aux] >= currNode.point[aux] ||
	                    currNode.right != null && currNode.right.point[aux] < currNode.point[aux])
	                System.err.println("SOMETHING WRONG");
	            return currNode;
	        }
	        if (t.point[aux] < currNode.point[aux]) {
	            currNode.left = delete(currNode.left, t, aux + 1);
	        } else {
	            currNode.right = delete(currNode.right, t, aux + 1);
	        }
	        return currNode;
	    }

	    private Node findMinimum(Node root, int targetDim, int aux) {
	        if (root == null)
	            return null;
	        if (targetDim == aux) {
	            if (root.left == null)
	                return root;
	            // else
	            return findMinimum(root.left, targetDim, (aux + 1) % 2);
	        }
	        Node rightMin = findMinimum(root.right, targetDim, (aux + 1) % 2);
	        Node leftMin = findMinimum(root.left, targetDim, (aux + 1) % 2);
	        Node res = root;
	        if (rightMin != null && rightMin.point[targetDim] < res.point[targetDim])
	            res = rightMin;
	        if (leftMin != null && leftMin.point[targetDim] < res.point[targetDim])
	            res = leftMin;
	        return res;
	    }
	    private void print(Node node){
	        if(node!=null){
	        	print(node.left);
	            if(node.left!=null || node.right!=null){
	                if(node.left!=null) {
	                   System.out.println("root:"+ Arrays.toString(node.point) +" ");
	                   System.out.println("folhas:");
	                   System.out.println("left:"+Arrays.toString(node.left.point));
	                }
	                if(node.right!=null){
	                	if(node.left==null) {
	                	System.out.println("root:"+ Arrays.toString(node.point) +" ");
	                      System.out.println("right: "+Arrays.toString(node.right.point)+" ");
	                	}else {
	                		System.out.println("right: "+Arrays.toString(node.right.point)+" ");
	                	}
	                }
	            }
	         print(node.right);
	        }
	    }
	    public void print(){
	        print(root);
	    }
	   
}
