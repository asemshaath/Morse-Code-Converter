import java.util.ArrayList;

/**
 * 
 * This is the data structure class for the tree; however, it only builds the Morse code tree
 * 
 * @author Asem Shaath
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	
	private TreeNode<String> root; // The root (Level 1 node)
	
	/**
	 *  This constructor calls the method that is responsible for building the morse code tree
	 *  Once the class is invoked, the morse code tree will be built
	 */
	public MorseCodeTree()
	{
		buildTree(); 
	}
	
	@Override
	public TreeNode<String> getRoot()
	{
		return new TreeNode<>(root);
	}

	@Override
	public void setRoot(TreeNode<String> newNode) 
	{
		this.root = newNode;
	}

	@Override
	public MorseCodeTree insert(String code, String result) 
	{
		addNode(root, code, result); 
		
		return this;
	}

	@Override
	public void addNode(TreeNode<String> root, String code, String letter) 
	{
		
		// print statements for test purposes
		
		//System.out.println("Root = " + root);
		//System.out.println("Code = " + code);
		//System.out.println("Letter = " + letter);
		
		if(code.length() == 1)
		{
			if(code.equals("."))
			{
				TreeNode<String> leftNode = new TreeNode<String>(letter);
				root.setLeft(leftNode);
				
				//root.getLeft().setData(letter);
			}
			else
			{
				TreeNode<String> rightNode = new TreeNode<String>(letter);
				root.setRight(rightNode);
			}
			
		}
		else
		{
			if(code.charAt(0) == '.')
			{
				addNode(root.getLeft(), code.substring(1), letter); 
			}
			else
			{
				addNode(root.getRight(), code.substring(1), letter);
			}
			
		}
		
	}

	@Override
	public String fetch(String code) 
	{
		return fetchNode(root, code);
	}

	@Override
	public String fetchNode(TreeNode<String> root, String code) 
	{
		if(code.length() == 1)
		{
			if(code.equals("."))
			{
				return root.getLeft().getData();
			}
			else
			{
				return root.getRight().getData();
			}
		}
		else
		{
			
			if(code.charAt(0) == '.')
			{
				return fetchNode(root.getLeft(), code.substring(1)); 
			}
			else
			{
				return fetchNode(root.getRight(), code.substring(1));
			}
			
		}
	}

	@Override
	public MorseCodeTree delete(String data) throws UnsupportedOperationException 
	{
		throw new UnsupportedOperationException("This operation is not supported in the MorseCodeTree"); 
	}

	@Override
	public MorseCodeTree update() throws UnsupportedOperationException 
	{
		throw new UnsupportedOperationException("This operation is not supported in the MorseCodeTree"); 
	}

	@Override
	public void buildTree() 
	{
		
		// level 0
		root = new TreeNode<String>("");
		
		// level 1
		insert(".","e");
		insert("-","t");
		
		// level 2
		insert("..","i");
		insert(".-","a");
		insert("-.","n");
		insert("--","m");
		
		// level 3
		insert("...","s");
		insert("..-","u");
		insert(".-.","r");
		insert(".--","w");
		insert("-..","d");
		insert("-.-","k");
		insert("--.","g");
		insert("---","o");
		
		// level 4
		insert("....","h");
		insert("...-","v");
		insert("..-.","f");
		insert(".-..","l");
		insert(".--.","p");
		insert(".---","j");
		insert("-...","b");
		insert("-..-","x");
		insert("-.-.","c");
		insert("-.--","y");
		insert("--..","z");
		insert("--.-","q");
		
	}

	@Override
	public ArrayList<String> toArrayList() 
	{
		ArrayList<String> toBeReturned = new ArrayList<String>(); 
		
		LNRoutputTraversal(root, toBeReturned); 
		
		return toBeReturned;
	}

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) 
	{
		// return if the current node is empty
		if (root == null)
			return;
	
		// Traverse the left subtree
		LNRoutputTraversal(root.getLeft(), list);
	
		// add the element to the tree
		list.add(root.getData()); 
	
		// Traverse the right subtree
		LNRoutputTraversal(root.getRight(), list);
	}
}
