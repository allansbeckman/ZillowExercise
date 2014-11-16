
public class TrinaryTree 
{
	///The number of nodes in the tree.
	public int size;
	
	///Root of the tree
	public Node rootNode;
	
	///
	///Construct an empty Trinary Tree
	///
	public TrinaryTree()
	{
		size = 0;
		rootNode = null;
	}
	
	///
	///Add a Node with a key and value to the tree
	///
	public void insert(int key, Object value)
	{
		this.rootNode = insert(this.rootNode, key, value);
		size++;
	}
	
	///
	///Inserts a node with key and value based off how the key
	///compares to the key of the current node.
	///left is key is less, right if key is greater, middle if key is same
	///
	private Node insert(Node node, int key, Object value)
	{
		if(node == null)
		{
			Node n = new Node(key, value);
			return n;
		}
		else
		{
			int compare = Integer.compare(key, node.key);
			
			if(compare > 0)
			{
				node.rightChild = insert(node.rightChild, key, value);
			}
			else if(compare < 0)
			{
				node.leftChild = insert(node.leftChild, key, value);
			}
			else if(compare == 0)
			{
				node.middleChild = insert(node.middleChild, key, value);
			}
		}
		
		return node;
	}
	
	///
	///Print the keys in the tree
	///
	public String print()
	{
		return print(this.rootNode);
	}
	
	///
	///Prints the left child, middle child then right child of the node.
	///
	private String print(Node node)   
    {  
		String printOut = "";
        if (node != null)   
        {  
            printOut += (node.key + " ");  
            printOut += print(node.leftChild);  
            printOut += print(node.middleChild);              
            printOut += print(node.rightChild);  
        }  
        return printOut;
    }  
	
	///
	///Delete a node with given key from the tree
	///
	public void delete(int key)
	{
		this.rootNode = delete(key, this.rootNode);
	}
	
	///
	///Find the node with the key that we are trying to delete.
	///If it has two children then replace its value with the min node of the
	///right child and delete the min node.
	///If one child then replace node to be deleted with child key and value.
	///If no children then delete node.
    private Node delete(int key, Node node)
    {
    	int compare = Integer.compare(key, node.key);
    	
        if(compare > 0) //Node we are deleting is to the right
        {
        	node.rightChild = delete(key, node.rightChild);
        }
        else if(compare < 0) //Node we are deleting is to the left.
        {
        	node.leftChild = delete(key, node.leftChild);
        }   
        else if(node.middleChild != null) //if key we are looking for has a middle child then remove middle child.
        {
        	node.middleChild = delete(key, node.middleChild);
        }
        
        else if(node.leftChild != null && node.rightChild != null) // Node has two children
        {
            node.key = findMin(node.rightChild).key;
            node.rightChild = removeMin(node.rightChild);
        }
        else if(node.leftChild == null && node.rightChild == null && node.middleChild == null) //Node has no children
        {
        	node = null;
        }
        else	// Node has one child
        {
        	node = (node.leftChild != null) ? node.leftChild : node.rightChild;
        }
            
        return node;
    }
    
    ///
    ///Removes the smallest child node from the given node.
    ///
    private Node removeMin(Node node)
    {
        if(node.leftChild != null)
        {
            node.leftChild = removeMin(node.leftChild);
            return node;
        } 
        else if(node.middleChild != null)
        {
        	node.middleChild = removeMin(node.middleChild);
        	return node;
        }
        else
        {
        	return node.rightChild;
        }
    }
    
    ///
    ///Returns the smallest child of a given node. 
    ///If the smallest child has a middle child, return the middle child.
    ///
	private Node findMin(Node node)
	{
		while(node.leftChild != null)
		{
			node = node.leftChild;
		}
		while(node.middleChild != null)
		{
			node = node.middleChild;
		}
		return node;
	}
	
	///Return a string with the key and value of a node with given key.
	public String find(int key)
	{
		return find(key, this.rootNode).toString();
	}
	
	///
	///Use binary search to find a node, given its key.
	///
	private Node find(int key, Node node)
	{
		int compare = Integer.compare(key, node.key);
		
		if(compare > 0)
		{
			return find(key, node.rightChild);
		}
		else if(compare < 0)
		{
			return find(key, node.leftChild);
		}
		else if(compare == 0)
		{
			if(node.middleChild == null)
			{
				return node;
			}
			else
			{
				return find(key, node.middleChild);
			}
		}
		
		return node;
	}
	
	private class Node 
	{

		int key;
		Object value;
		Node leftChild;
		Node rightChild;
		Node middleChild;
		
		///
		///Construct a Node with key, value, 
		///left child, middle child and right child.
		///
		Node(int key, Object value) 
		{
			this.key = key;
			this.value = value;
		}

		public String toString() 
		{
			return "Key: " + key + "\nValue: " + value;
		}
	}
}
