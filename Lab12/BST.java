package lab12;

/**
 * The class for Binary Search Tree
 * @author Huiping Cao
 *
 */
public class BST {
	protected BSTNode root; //the tree root
	
	
	/**
	 * Get the left subtree of this tree
	 * @return the left subtree of this tree
	 */
	private BST getLeftSubtree(){
		return root.getLeft();
	}
	
	/**
	 * Get the right subtree of this tree
	 * @return the right subtree of this tree
	 */
	private BST getRightSubtree(){
		return root.getRight();
	}
	
	/**
	 * Print the tree using in-order traversal strategy
	 */
	public void inOrderPrt(){
		inOrderPrt(0);
	}
	
	/**
	 * private, recursive function
	 *     I slightly changed the method to print right subtree first
	 *     It is to make the display more easier to read
	 * 
	 * @param node
	 * @param indentation
	 * @param branch
	 */
	private void inOrderPrt(int indentation){
		if(root!=null){
			if(getRightSubtree()!=null) getRightSubtree().inOrderPrt(indentation+1);
			
			for(int i=0;i<indentation*4;i++) System.out.print(" ");
			
			System.out.println(root.getData());
			
			if(getLeftSubtree()!=null) getLeftSubtree().inOrderPrt(indentation+1);
		}
	}
	
	
	/**
	 * Debug function, print the tree for debugging purpose
	 */
	public String toString()
	{
		if(root!=null) return root.toString();
		else return null;
	}
	
	///////////////////////////////////////
    ///////////////////////////////////////
	// Please add the functions required for your lab homework here.
	
	
	// Insert a new element e into the binary search tree.
	// NO duplicate values are allowed in the tree.
	// When e exists in the tree, return false; Otherwise, insert e to the tree and return true.
	public boolean insert (int e) {
		
		// Case 1: the current tree root is empty, create a new root
		if (root == null)
			root = new BSTNode(e, new BST(), new BST());
		
		// Case 2: duplicate
		else if (e == root.getData())
			return false;
		
		// Case 3 & 4: the current tree root is not empty
		else if (e <= root.getData())
			root.getLeft().insert(e);
		else
			root.getRight().insert(e);
		
		return true;
		
	}
	
	// Remove a specified element from the binary search tree.
	// When e exists in the tree and one instance is successfully removed, return true
	// Otherwise, return false.
	public boolean remove (int e) {
		boolean result = true;
		if (this.root == null){
		    result = false;
		} else {
		    if (e == this.root.getData()){
			result = true;
			if ((this.root.getLeft().root == null) && (this.root.getRight().root == null)){
			    this.root = null;
			    return false;
			}
			if ((this.root.getLeft().root == null) && (this.root.getRight().root != null)){
			    this.root = this.root.getRight().root;
			    return result;
			}
			if ((this.root.getLeft().root != null) && (this.root.getRight().root == null)){
			    this.root = this.root.getLeft().root;
			    return result;
			}
			if ((this.root.getLeft().root != null) && (this.root.getRight().root != null)){
			    int maxData = this.root.getLeft().removeMax();
			    this.root.setData(maxData);
			    return result;
			}
		}
		if (e < this.root.getData()){
		  	this.root.getLeft().remove(e);
		}
		if (e > this.root.getData()){
		   	this.root.getRight().remove(e);
		}
		}
		return result;
	}
	
	// the removeMax() method
	public int removeMax() {
		int maxValue;
        if (root.getRight().root == null) {
        	maxValue = root.getData();
        	root = root.getLeft().root;
        } else 
        	return root.getRight().removeMax();
        return maxValue;
	}
	
	
	// A recursive function to search whether an element exists in a binary search tree.
	// If e exists, return the node that contains this element; Otherwise, return null.
	public BSTNode searchRecursion(int e) {
		
		if (root == null)
			return null;
		else if (e == root.getData())
			return root;
		else if (e < root.getData())
			return root.getLeft().searchRecursion(e);
		else if (e > root.getData())
			return root.getRight().searchRecursion(e);
		return null;
	}
	
	// A non-recursive function to search whether an element exists in a binary search tree.
	// If e exists, return the node that contains this element; Otherwise, return null.
	public BSTNode searchNonRecursion(int e) {
		BSTNode node = root;
		if (root == null)
			return null;
		else {
			while (node != null) {
				if (e == node.getData())
					return node;
				else {
					if (e < node.getData())
						node = node.getLeft().root;
					else
						node = node.getRight().root;
				}
			}
			return null;
		}
	}
	
	// A recursive function to add up all the elements in this binary search tree.
	// Return the summation of all the elements. 
	public int sum() {
		if (root == null)
			return 0;
		return root.getData() + root.getLeft().sum() + root.getRight().sum();
	}
	
	
	
	
	/**
	 * Test cases provided by the instructor
	 * @throws Exception
	 */
	private static void test1() throws Exception{
		BST tree = new BST();
		System.out.println("Initial tree:");
		tree.inOrderPrt(); //test inOrder traversal
		
		boolean rc = true;
		
		//test 1: insert method, and test 2 in-order traversal
		rc = tree.insert(12); System.out.println("\nInsert 12, inserted="+rc+", after adding 12:"); tree.inOrderPrt();
		rc = tree.insert(6);  System.out.println("\nInsert 6, inserted="+rc+", after adding 6:"); tree.inOrderPrt();
		rc = tree.insert(19); System.out.println("\nInsert 19, inserted="+rc+", after adding 19:"); tree.inOrderPrt();
		rc = tree.insert(4);  System.out.println("\nInsert 4, inserted="+rc+", after adding 4:"); tree.inOrderPrt();
		rc = tree.insert(8);  System.out.println("\nInsert 8, inserted="+rc+", after adding 8:"); tree.inOrderPrt();
		rc = tree.insert(16); System.out.println("\nInsert 16, inserted="+rc+", after adding 16:"); tree.inOrderPrt();
		rc = tree.insert(8);  System.out.println("\nInsert 8 (second), inserted="+rc+", after adding 8:"); tree.inOrderPrt();
		rc = tree.insert(5);  System.out.println("\nInsert 5, inserted="+rc+", after adding 5:"); tree.inOrderPrt();
		rc = tree.insert(9);  System.out.println("\nInsert 9, inserted="+rc+", after adding 9:"); tree.inOrderPrt();
		rc = tree.insert(20);  System.out.println("\nInsert 20, inserted="+rc+", after adding 20:"); tree.inOrderPrt();
		
		System.out.println("Inorder traversal results:");
		tree.inOrderPrt(); 
		System.out.print("\n\n");
		
		//test 3: search method
		BSTNode node = tree.searchRecursion(6);
		System.out.println("searchRecursion 6, node="+node);
		node = tree.searchRecursion(22);
		System.out.println("searchRecursion 22, node="+node);
		node = tree.searchRecursion(8);
		System.out.println("searchRecursion 8, node="+node+"\n");
		
		node = tree.searchNonRecursion(6);
		System.out.println("searchNonRecursion 6, node="+node);
		node = tree.searchNonRecursion(22);
		System.out.println("searchNonRecursion 22, node="+node);
		node = tree.searchNonRecursion(8);
		System.out.println("searchNonRecursion 8, node="+node);
		
		//test 4: remove method
		rc = tree.remove(30); //test case 0: e does not exist
		System.out.println("\nRemove 30, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(20); //test case 1: leaf
		System.out.println("\nRemove 20, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(4); //test case 2: left is empty
		System.out.println("\nRemove 4, rc="+rc);
		tree.inOrderPrt();
		
		
		rc = tree.remove(19); //test case 3: right is empty
		System.out.println("\nRemove 19, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(6); //test case 4: no subtree is empty
		System.out.println("\nRemove 6, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(12); //more tests: remove root
		System.out.println("\nRemove 12, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(8); //more tests
		System.out.println("\nRemove 8, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(5); //more tests
		System.out.println("\nRemove 5, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(8); //more tests
		System.out.println("\nRemove 8, rc="+rc);
		tree.inOrderPrt();
		rc = tree.remove(16); //more tests
		System.out.println("\nRemove 16, rc="+rc);
		tree.inOrderPrt();
		System.out.print("sum="+tree.sum()+"\n");
		
		System.out.println("\nAdding a series of numbers:");
		tree.insert(30);
		tree.insert(20);tree.insert(10);tree.insert(25);tree.insert(28);tree.insert(24);
		tree.insert(11);tree.insert(5);tree.insert(11);tree.insert(12);
		tree.insert(50);tree.insert(40);tree.insert(35);
		tree.inOrderPrt();
		System.out.print("sum="+tree.sum()+"\n");
		
		System.out.print("sum="+tree.sum()+"\n");
		System.out.print("\n\n");
		
		System.out.println("\nRemove 20 (removeNode case 4):");
		tree.remove(20);
		tree.inOrderPrt();
		System.out.print("sum="+tree.sum()+"\n");
		
		System.out.println("Inorder traversal results: ");
		tree.inOrderPrt();
		System.out.print("\n");
		System.out.print("sum="+tree.sum()+"\n");
	}
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		//You need to let your program pass the  test cases in this function
		test1(); 
		
		//You can add your own test cases here. 
		
	}

}