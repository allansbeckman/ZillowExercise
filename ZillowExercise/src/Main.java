
public class Main 
{
	public static void main(String args[])
	{
		String st = "-9223372036854775807";
		long toLong = StringToLong.stringToLong(st);
		System.out.println(toLong);
		
		TrinaryTree t = new TrinaryTree();
		t.insert(5, 1);
		t.insert(4, 2);
		t.insert(9, 3);
		t.insert(5, 4);
		t.insert(7, 5);
		t.insert(2, 6);
		t.insert(3, 5);
		t.insert(3,77);
		t.insert(1, 7);
		t.insert(7, 3);
		
		System.out.println(t.print());
		t.delete(5);
		System.out.println("Removed 5");
		System.out.println(t.print());
	}
}
