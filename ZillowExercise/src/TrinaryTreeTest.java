import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TrinaryTreeTest {

	TrinaryTree tree;
	TrinaryTree bigTree;
	
	@Before
	public void initialize()
	{
		tree = new TrinaryTree();
		tree.insert(1, 1);
		tree.insert(2, 2);
		tree.insert(3, 3);
		
		bigTree = new TrinaryTree();
		bigTree.insert(7, 7);
		bigTree.insert(4, 4);
		bigTree.insert(10, 10);
		bigTree.insert(1, 1);
		bigTree.insert(2, 2);
		bigTree.insert(9, 9);
		bigTree.insert(13, 13);
		bigTree.insert(8, 8);
		bigTree.insert(8, 8);
		bigTree.insert(11, 11);
		bigTree.insert(14, 14);
		bigTree.insert(0, 0);
		bigTree.insert(1, 2);
		bigTree.insert(3, 3);
	}
	
	@Test
	public void InsertNodesTest()
	{
		String nodeOne = tree.find(1);
		assertEquals("Key: 1\nValue: 1", nodeOne);
		String nodeTwo = tree.find(2);
		assertEquals("Key: 2\nValue: 2", nodeTwo);
		System.out.println(tree.print());
	}
	
	@Test
	public void RemoveRootNodeTest()
	{
		tree.remove(1);
		assertEquals("2 3 ", tree.print());
		System.out.println(tree.print());
	}
	
	@Test
	public void RemoveNodeWithNoChildren()
	{
		tree.remove(3);
		assertEquals("1 2 ", tree.print());
	}
	
	@Test
	public void RemoveNodeWithRightChild()
	{
		tree.remove(2);
		assertEquals("1 3 ", tree.print());
	}
	
	@Test
	public void RemoveNodeWithMiddleChild()
	{
		tree.insert(1, 2);
		tree.remove(1);
		assertEquals("1 2 3 ", tree.print());
	}
	
	@Test
	public void RemoveRootNodeWithTwoChildren()
	{
		tree.insert(0, 0);
		tree.remove(1);
		assertEquals("2 0 3 ", tree.print());
		assertEquals(2, tree.rootNode.key);
	}
	
	@Test
	public void RemoveRootNodeWithTwoChildrenTest()
	{
		bigTree.remove(7);
		assertEquals(8, bigTree.rootNode.key);
		System.out.println(bigTree.print());
	}
	
	@Test
	public void RemoveMiddleChildTest()
	{
		bigTree.remove(8);
		assertEquals("7 4 1 0 1 2 3 10 9 8 13 11 14 ", bigTree.print());
	}
	
	@Test
	public void RemoveNodeWithTwoChildrenBigTreeTest()
	{
		bigTree.remove(10);
		assertEquals("7 4 1 0 1 2 3 11 9 8 8 13 14 ", bigTree.print());
	}
	
	@Test
	public void RemoveNodeWithLeftChildTest()
	{
		bigTree.remove(9);
		assertEquals("7 4 1 0 1 2 3 10 8 8 13 11 14 ", bigTree.print());
	}
	
	@Test
	public void RemoveRootThenInsertNodeTest()
	{
		bigTree.remove(7);
		bigTree.insert(7, 7);
		assertEquals("8 4 1 0 1 2 3 7 10 9 8 13 11 14 ", bigTree.print());
	}
}
