package Practice;

class Voter
{
	public static void ValidateAge(int x)
	{
		if(x<18)
		{
			throw new ArithmeticException("Age Not valid");
		}
		else
		{
			System.out.println("You are elligible to vote");
		}
		
		int currentVote=10000;
		int newVote=currentVote+1;
		System.out.println(newVote);
		
		
	}
}




public class Vote {

	public static void main(String[] args) {
		
		
		Voter.ValidateAge(37);
		

	}
}
