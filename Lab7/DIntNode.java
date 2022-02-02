package lab7;

/******************************************************************************
* DIntNode.java
* 
* A DIntNode provides a node for a doubly linked list with 
* integer data in each node.
*
* Lists of nodes can be made of any length, limited only by the amount of
* free memory in the heap. But beyond Integer.MAX_VALUE 
* 
* @author Huiping Cao 
*
*
******************************************************************************/
public class DIntNode {
	private int data;				//The integer value for the node
	private DIntNode next = null;	//The next node of the current one 
									//For the last node of a list, this is either null
									//or is a reference to the dummy tail node
	private DIntNode prev = null;	//The previous node of the current one
									//For the first node of a list, this is either null
									//or is a reference to the dummy head node

   /**
    * No argument constructor
    */
   public DIntNode() {
	   ;
   }

   /**
   * Initialize a node with a specified initial data 
   * @param initialData: the initial data of this new node
   * @postcondition This node contains the specified data;
   * 				The prev and next are all null references.
   **/   
   public DIntNode(int initialData) {
      data = initialData;
   }
   
   /**
    * Initialize a node with a specified initial data and link to the next and prev 
    * nodes. Note that the initialNext and initialPrev may be null, 
    * which indicates that the new node has nothing before and/or after it.
    * @param initialData: the initial data of this new node
    * @param initialPrev: the previous node reference of this node
    * @param initialNext: the next node reference of this node
    **/   
    public DIntNode(int initialData,DIntNode initialPrev,DIntNode initialNext)
    {
       data = initialData;
       prev = initialPrev;
       next = initialNext;
    }
   
    /**
     * toString method convert this node's information to a String
     */
    public String toString() {
    	String str="";
    	
    	//include previous node's information
    	if(prev==null) str+="(null)";
    	else str += "("+prev.data+")";
    	
    	//include the current data
    	str += data;
    	
    	//include the next node's information
    	if(next==null) str+="(null)";
    	else str += "("+next.data+")";
    	
    	return str;
    }
      
    /** 
     * Accessor method to get data from this node.   
     * @param - none
     * @return the data from this node 
     */
    public int getData( ) {
    	return data;
    }
   
   
   /**
   * Accessor method to get a reference to the next node after this node. 
   * @param - none
   * @return a reference to the node after this node (or the null reference if there
   *         is nothing after this node)
   **/
   public DIntNode getNext( ) {
      return next;                                               
   } 
   
   /**
    * Accessor method to get a reference to the previous node before this node. 
    * @param - none
    * @return a reference to the node before this node (or the null reference if there
    *         is nothing before this node)
    **/
   public DIntNode getPrev( ) {
      return prev;                                               
   }
    

   /**
   * Modification method to set the data in this node.   
   * @param newData: the new data to place in this node
   * @postcondition The data of this node has been set to newData.
   **/
   public void setData(int newData) {
      data = newData;
   }                                                               
   
   
   /**
   * Modification method to set the next link to newnext.
   * @param newnext: a reference to the node that should appear after this node in the linked
   *        list (or the null reference if there is no node after this node)
   * @postcondition The link to the node after this node has been set to newnext.
   **/
   public void setNext(DIntNode newnext) {                    
      next = newnext;
   }
   
   /**
    * Modification method to set the previous link to newprev.
    * @param newprev a reference to the node that should appear before this node in the linked
    *   list (or the null reference if there is no node before this node)
    * @postcondition The link to the node before this node has been set to newprev.
    */
   public void setPrev(DIntNode newprev) {                    
      prev = newprev;
   }
 
   /**
    * This method increase the value of data by doubling its value
    * This can be used for testing the clone method 
    */
   public void dataDouble() {
	   data = 2*data;
   }

}
           
