package zoho3;

import java.util.Random;
import java.util.Scanner;

public class Players {
	String name;
	int coin;
	Scanner sc = new Scanner(System.in);
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCoin() {
		return coin;
	}
	public void setCoin(int coin) {
		this.coin = coin;
	}
	public void assign_Players()
	{
		char flag='n';
		String name1,name2;
		int color1 = -1,color2=-1;
		String co1,co2;
		System.out.println("Enter player 1 name ");
		name1=sc.nextLine();
		System.out.println("Enter player 2 name ");
		name2=sc.nextLine();
		System.out.println("Enter row size of the board ");
		int row=sc.nextInt();
		System.out.println("Enter column size of the board ");
		int col=sc.nextInt();
		if(row<4 || col<4)
		{
			System.out.println("Invalid board dimensions");
			return;
		}
		do {
		Players player1 = new Players();
		Players player2 = new Players();
		Random r=new Random();
		int x=r.nextInt(2);
		if(x==1)
		{
			color1=1;
			color2=0;
			co1="Red";
			co2="Yellow";
		}
		else
		{
			color1=0;
			color2 =1;
			co1="Yellow";
			co2="Red";
		}
		player1.setName(name1);
		player1.setCoin(color1);
		player2.setName(name2);
		player2.setCoin(color2);
		System.out.println("\n" +player1.getName() + "'s color is " +
				co1 + " and " +
				player2.getName() + "'s color is " +
				co2);
		Board play = new Board(row,col);
		//       play.setRow(row);
		//       play.setCol(col);
		play.game(player1,player2,play);
		System.out.println("Do you want to play again with same player and board (y/n)");
		flag = sc.next().charAt(0);
		}while(flag=='y');
	}
}
