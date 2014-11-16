import static org.junit.Assert.*;

import org.junit.Test;


public class StringToLongTest 
{
	@Test
	public void stringWithCommasToLongTest() 
	{
		String s = "123,456,789";
		long expectedLong = 123456789;
		long stringToLongValue = StringToLong.stringToLong(s);
		assertEquals(expectedLong, stringToLongValue);
	}
	
	@Test
	public void stringWithCharactersToLongTest()
	{
		String s = "12,..asdf2343";
		long expectedLong = 122343;
		long stringToLongValue = StringToLong.stringToLong(s);
		assertEquals(expectedLong, stringToLongValue);
	}
	
	@Test
	public void stringToLongNegativeNumberTest()
	{
		String s = "-123456789";
		long expectedLong = -123456789;
		long stringToLongValue = StringToLong.stringToLong(s);
		assertEquals(expectedLong, stringToLongValue);
	}
	
	@Test
	public void stringToLongMaxValueTest()
	{
		String s = "9223372036854775807";
		long expectedLong = Long.MAX_VALUE;
		long stringToLongValue = StringToLong.stringToLong(s);
		assertEquals(expectedLong, stringToLongValue);
		
	}
	
	@Test
	public void stringToLongMinValueTest()
	{
		String s = "-9223372036854775808";
		long expectedLong = Long.MIN_VALUE;
		long stringToLongValue = StringToLong.stringToLong(s);
		assertEquals(expectedLong, stringToLongValue);
	}
	
	@Test
	public void stringToLongOverflowTest()
	{
		String s = "999999999999999999999";
		long stringToLongValue = StringToLong.stringToLong(s);
		long compare = Long.MAX_VALUE;
		assertNotEquals(compare, stringToLongValue);
		
	}
	
	@Test
	public void stringToLongLargeNegativeNumberWithCommasTest()
	{
		String s = "-123,456,78,89,";
		long expectedLong = -1234567889;
		long stringToLongValue = StringToLong.stringToLong(s);
		assertEquals(expectedLong, stringToLongValue);
	}
}
