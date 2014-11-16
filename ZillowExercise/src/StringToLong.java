
public class StringToLong 
{

	///
	///Converts a given string to a long.
	///
	public static long stringToLong(String s)
	{
		long sum = 0;
		
		long powerOfTen = 1;
		String formattedString =  RemoveNonNumbers(s);
		for(int i = formattedString.length()-1; i >= 0; i--)
		{
			int stringValue = CharToInteger(formattedString.charAt(i));
			sum += stringValue * powerOfTen;
			powerOfTen = powerOfTen * 10;
		}
		if(s.charAt(0) == 45)
		{
			sum = sum * -1;
		}
		return sum;
	}
	
	///
	///Removes characters that are not numbers from a string.
	///
	public static String RemoveNonNumbers(String s)
	{
		String formatted = "";
		for(int i = 0; i < s.length(); i++)
		{
			char value = s.charAt(i);
			if(value > 47 && value < 58)
			{
				formatted += value;
			}
		}
		return formatted;
	}
	
	///
	///Returns int value of a character.
	///
	public static int CharToInteger(char c)
	{
		return c - 48;
	}
}
