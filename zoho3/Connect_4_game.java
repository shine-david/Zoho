package zoho3;
import java.util.*;
public class Connect_4_game {
	public static void main(String[] args)
	{ 
		Scanner sc = new Scanner(System.in);
		char flag='n';
		do
		{
			System.out.println("press 1 to play game");
			System.out.println("Press 2 to fetch player stat");
			int x=sc.nextInt();
			if(x==1)
			{
				Players ob = new Players();
				ob.assign_Players();
			}
			else if(x==2)
			{
				Results ob = new Results();
				ob.identify();
			}
			else
				System.out.println("Invalid input");
			System.out.println("Go to Home page y/n");
			flag = sc.next().charAt(0);
		}while(flag=='y');
		sc.close();
	}
}
