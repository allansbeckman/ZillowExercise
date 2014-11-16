import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TrinaryTreeTest {

	TrinaryTree tree;
	TrinaryTree bigTree;
	
	@Before
	public void initialize()
	{
		/// A trinary tree with keys 1,2 3.
		tree = new TrinaryTree();
		tree.insert(1, 1);
		tree.insert(2, 2);
		tree.insert(3, 3);
		
		/// A trinary tree with keys 7,4,10,1,2,9,13,8,8,11,14,0,1,3
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
	public void insertNodesTest()
	{
		String nodeOne = tree.find(1);
		assertEquals("Key: 1\nValue: 1", nodeOne);
		String nodeTwo = tree.find(2);
		assertEquals("Key: 2\nValue: 2", nodeTwo);
		System.out.println(tree.print());
	}
	
	@Test
	public void removeRootNodeTest()
	{
		tree.delete(1);
		assertEquals("2 3 ", tree.print());
		System.out.println(tree.print());
	}
	
	@Test
	public void removeNodeWithNoChildren()
	{
		tree.delete(3);
		assertEquals("1 2 ", tree.print());
	}
	
	@Test
	public void removeNodeWithRightChild()
	{
		tree.delete(2);
		assertEquals("1 3 ", tree.print());
	}
	
	@Test
	public void removeNodeWithMiddleChild()
	{
		tree.insert(1, 2);
		tree.delete(1);
		assertEquals("1 2 3 ", tree.print());
	}
	
	@Test
	public void removeRootNodeWithTwoChildren()
	{
		tree.insert(0, 0);
		tree.delete(1);
		assertEquals("2 0 3 ", tree.print());
	}
	
	@Test
	public void initialTreeCreationTest()
	{
		assertEquals("7 4 1 0 1 2 3 10 9 8 8 13 11 14 ", bigTree.print());
	}
	
	@Test
	public void insertMiddleChildTest()
	{
		bigTree.insert(2, 2);
		assertEquals("7 4 1 0 1 2 2 3 10 9 8 8 13 11 14 ", bigTree.print());
	}
	
	@Test
	public void removeRootNodeWithTwoChildrenTest()
	{
		bigTree.delete(7);
		assertEquals("8 4 1 0 1 2 3 10 9 8 13 11 14 ", bigTree.print());
	}
	
	@Test
	public void removeMiddleChildTest()
	{
		bigTree.delete(8);
		assertEquals("7 4 1 0 1 2 3 10 9 8 13 11 14 ", bigTree.print());
	}
	
	@Test
	public void removeNodeWithTwoChildrenBigTreeTest()
	{
		bigTree.delete(10);
		assertEquals("7 4 1 0 1 2 3 11 9 8 8 13 14 ", bigTree.print());
	}
	
	@Test
	public void removeNodeWithLeftChildTest()
	{
		bigTree.delete(9);
		assertEquals("7 4 1 0 1 2 3 10 8 8 13 11 14 ", bigTree.print());
	}
	
	@Test
	public void removeRootThenInsertNodeTest()
	{
		bigTree.delete(7);
		bigTree.insert(7, 7);
		assertEquals("8 4 1 0 1 2 3 7 10 9 8 13 11 14 ", bigTree.print());
	}
	
	@Test
	public void insertNodesUsingArraysOfKeysAndValues()
	{
		TrinaryTree t = new TrinaryTree();
		int[] keys = {1,2,3,4,5};
		int[] values = {5,4,3,2,1};
		t.insertMultiple(keys, values);
		assertEquals("1 2 3 4 5 ", t.print());
	}
}
