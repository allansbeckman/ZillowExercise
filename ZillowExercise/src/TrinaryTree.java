
public class TrinaryTree 
{

	public int size;
	public Node rootNode;
	
	public TrinaryTree()
	{
		size = 0;
		rootNode = null;
	}
	
	public void insert(int key, Object value)
	{
		this.rootNode = insert(this.rootNode, key, value, this.rootNode);
		size++;
	}
	
	private Node insert(Node node, int key, Object value, Node parentNode)
	{
		if(node == null)
		{
			Node n = new Node(key, value);
			n.parent = parentNode;
			return n;
		}
		else
		{
			int compare = Integer.compare(key, node.key);
			
			if(compare > 0)
			{
				node.rightChild = insert(node.rightChild, key, value, node);
			}
			else if(compare < 0)
			{
				node.leftChild = insert(node.leftChild, key, value, node);
			}
			else if(compare == 0)
			{
				node.middleChild = insert(node.middleChild, key, value, node);
			}
		}
		
		return node;
	}

	public void delete(int key)
	{
		this.rootNode = delete(key, this.rootNode);	
	}
	
	private Node delete(int key, Node node)
	{
		Node parent = node.parent;
		int compare = Integer.compare(key, node.key);
		
		if(compare > 0)
		{
			node.rightChild = delete(key, node.rightChild);
		}
		else if(compare < 0)
		{
			node.leftChild = delete(key, node.leftChild);
		}
		else if(compare == 0)
		{
			if(node.leftChild == null && node.rightChild == null && node.middleChild == null)
			{
				node = null;
			}
		}
		return parent;
	}
	
	public String print()
	{
		return Print(this.rootNode);
	}
	
	private String Print(Node root)   
    {  
		String printOut = "";
        if (root != null)   
        {  
            printOut += (root.key + " ");  
            printOut += Print(root.leftChild);  
            printOut += Print(root.middleChild);              
            printOut += Print(root.rightChild);  
        }  
        return printOut;
    }  
	
	
	
	
	public void remove(int key)
	{
		this.rootNode = remove(key, this.rootNode);
	}

	///NEED TO FIX THIS
	///IF ROOT HAS A MIDDLE CHILD AND WE REMOVE THE KEY
	///THEN THE SMALLEST NODE ON THE RIGHT BECOMES THE ROOT AND THE MIDDLE
	///CHILD IS STILL THE ROOT'S MIDDLE CHILD WHICH IS WRONG.
	
    private Node remove(int key, Node node)
    {
    	int compare = Integer.compare(key, node.key);
    	
        if(compare > 0)
        {
        	node.rightChild = remove(key, node.rightChild);
        }
        else if(compare < 0)
        {
        	node.leftChild = remove(key, node.leftChild);
        }   
        else if(node.middleChild != null) //if key we are looking for has a middle child then remove it.
        {
        	node.middleChild = remove(key, node.middleChild);
        }
        
        else if(node.leftChild != null && node.rightChild != null) // Two children
        {
            node.key = findMin(node.rightChild).key;
            node.rightChild = removeMin(node.rightChild);
        }
        else if(node.leftChild == null && node.rightChild == null && node.middleChild == null) //no children
        {
        	node = null;
        }
        
        else	// one child
        {
        	node = (node.leftChild != null) ? node.leftChild : node.rightChild;
        }
            
        return node;
    }
    
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
    	
    
	public int min()
	{
		return findMin(this.rootNode).key;
	}
	
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
	
	public String find(int key)
	{
		return find(key, this.rootNode).toString();
	}
	
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
	
	public class Node 
	{

		int key;
		Object value;
		Node leftChild;
		Node rightChild;
		Node middleChild;
		Node parent;
		
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
