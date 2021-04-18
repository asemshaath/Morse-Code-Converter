/**
 * This is the data element class and all the methods and the fields supports the node of the tree
 * 
 * @author Asem Shaath
 *
 * @param <Thing>
 */
public class TreeNode<Thing> {

	// data inside the node
	private Thing data;
	
	// right node address
	private TreeNode<Thing> right; 
	
	// left node address
	private TreeNode<Thing> left; 
	
	/**
	 * 
	 * This is a constructor that takes the data as a parameter and sets the left and the right nodes to null
	 * 
	 * @param dataNode
	 */
	public TreeNode(Thing dataNode) 
	{
		this.data = dataNode; 
		right = left = null;
	}
	
	/**
	 * This constructor is to make a shallow copy of the node
	 * 
	 * @param node
	 */
	public TreeNode(TreeNode<Thing> node)
	{
		this.data = node.getData();
		right = new TreeNode<Thing>(node.right);
		left = new TreeNode<Thing>(node.left);
	}
	
	/**
	 * This is getter method that is used to get the data
	 * 
	 * @return data
	 */
	public Thing getData()
	{
		return this.data; 
	}

	/**
	 * This is getter method that is used to get the right node
	 * 
	 * @return right
	 */
	public TreeNode<Thing> getRight() {
		return right;
	}

	/**
	 * This is setter method that is used to set the address of right node
	 * 
	 * @param right
	 */
	public void setRight(TreeNode<Thing> right) {
		this.right = right;
	}

	/**
	 * This is getter method that is used to get the left node
	 * 
	 * @return
	 */
	public TreeNode<Thing> getLeft() {
		return left;
	}

	/**
	 * This is setter method that is used to set the address of left node
	 * 
	 * @param left
	 */
	public void setLeft(TreeNode<Thing> left) {
		this.left = left;
	}

	/**
	 * This is setter method that is used to set the data of the node
	 * 
	 * @param data
	 */
	public void setData(Thing data) {
		this.data = data;
	}
	
	/**
	 * 
	 * This is a method that is used to get the node as a string
	 * 
	 * 					left node data <-- data --> right node data 
	 * 
	 * @return node as a string
	 */
	public String toString()
	{
		String s = ""; 
		
		if(left == null) 
		{
			s += "null";
		}
		else
		{
			s+= left.getData();
		}
		
		s += "<- " + getData() + " ->";
		
		if(right == null) 
		{
			s += "null";
		}
		else
		{
			s+= right.getData();
		}
		
		return s;
	}

	
}
