public class MyProgram
{
	public static void main(String[] args)
	{
		System.out.println("Hi");
		for(String arg : args)
		{
			System.out.println("Hello, " + arg);
		}
	}
}