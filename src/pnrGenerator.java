import java.util.Random;
public class pnrGenerator {
	private static final String charlist="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private static final int len=6;
	public String generateRandomString() {
		StringBuffer randStr=new StringBuffer();
		for(int i=0;i<len;i++)
		{
			int number=getRandomNumber();
			char ch=charlist.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}
	
	private int getRandomNumber() {
		int randomInt=0;
		Random randomGenerator=new Random();
		randomInt=randomGenerator.nextInt(charlist.length());
		if(randomInt-1==-1)
		{
			return randomInt;
		}
		else
		{
			return randomInt-1;
		}
	}
}
