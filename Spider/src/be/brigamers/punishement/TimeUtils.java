package be.brigamers.punishement;

import java.util.Arrays;
import java.util.List;

public class TimeUtils {
	
	public static final long SECOND = 1000L;
	public static final long MINUTE = SECOND * 60L;
	public static final long HOUR = MINUTE * 60L;
	public static final long DAY = HOUR * 24L;
	public static final long SEMAINE = DAY * 7L;

	public static final List<Character> letters = (List<Character>)Arrays.asList(new Character[]{'s','d', 'h', 'm'});
	public static final long[] values = {SEMAINE, DAY, HOUR, MINUTE};
	
	public static long stringToTime(String str)
	{
		long time = 0;
		char c;
		int i = -1;

		while (++i < str.length())
		{
			c = str.charAt(i);
			if (c >= '0' && c <= '9')
				continue;
			if (!letters.contains(c))
				return -1;
			try
			{
				time += Long.parseLong(str.substring(0, i)) * values[letters.indexOf(c)];
			}
			catch (NumberFormatException e)
			{
				e.printStackTrace();
				return -1;
			}
			str = str.substring(i + 1, str.length());
			i = -1;
		}
		return time;
	}
	
	public static boolean isDuree(String string){
		if(string.matches("[0-9]?[0-9][dhmsDHMS]")) return true ;
		return false ;
	}
	
}