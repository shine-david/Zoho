package zoho3;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Scanner;

import zoho3.Conn;

public class Results {
	static Conn c = new Conn();
	static Scanner sc = new Scanner(System.in);
	public void add_Winner(Players p1,Players p2)
	{
		try
		{
			String s="insert into winner values ('"+p1.getName()+"','"+p2.getName()+"','" + LocalDate.now()+"')";
			c.s.executeUpdate(s);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void identify()
	{
		try
		{
			//sc.nextLine();
			System.out.println("Enter player name to known their stats");
			String name=sc.nextLine();
			String s="Select count(*) from winner where winner='" + name + "' or against='" + name + "'";
			ResultSet rs = c.s.executeQuery(s);
			rs.next();
			int total=rs.getInt("count(*)");
			if(total!=0)
			{
				System.out.println("Matches played : " + total);
				String s1="Select count(*) from winner where winner='" + name + "'";
				ResultSet rs1 = c.s.executeQuery(s1);
				rs1.next();
				int won=rs1.getInt("count(*)");
				System.out.println("won : " + won);
				String s2="Select count(*) from winner where against='" + name + "'";
				ResultSet rs2 = c.s.executeQuery(s2);
				rs2.next();
				int loss=rs2.getInt("count(*)");
				System.out.println("loss : " + loss);
				if(total!=0)
				System.out.println("win % : " + won/total*100);
				System.out.println("want to find stats against a particular team ? press 1");
				int x=sc.nextInt();
				if(x==1)
				{
					sc.nextLine();
					System.out.println("Enter against player name");
					String name2=sc.nextLine();
					String s3="Select count(*) from winner where (winner='" + name + "' and against='" + name2 + "') or (winner='" + name2 + "' and against='" + name + "')";
					ResultSet rs3 = c.s.executeQuery(s3);
					rs3.next();
					int total1=rs3.getInt("count(*)");
					if(total1!=0)
					{
						System.out.println("Matches played : " + total1);
						String s4="Select count(*) from winner where winner='" + name + "' and  against='" + name2 + "'";
						ResultSet rs4 = c.s.executeQuery(s4);
						rs4.next();
						int won1=rs4.getInt("count(*)");
						System.out.println("won : " + won1);
						int loss1=total1-won1;
						System.out.println("loss : " + loss1);
						if(total1!=0)
						System.out.println("win % : " + won1/total1*100);
						
					}
					else
					{
						System.out.println("No stats found against this team");
						return;
					}
				}
				else
					return;
			}
			else
			{
				System.out.println("No stats found !!");
				return;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
