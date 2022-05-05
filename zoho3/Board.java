package zoho3;

import java.util.Scanner;

public class Board {
	int[][] board ;
	int[] stack;
	int row;
	int col;
	static Scanner sc = new Scanner(System.in);
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public Board(int row , int col) {
		super();
		this.row=row;
		this.col=col;
		board = new int[row][col];
		stack = new int[col];
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				this.board[i][j]=-1;
			}
		}
		for(int i=0;i<col;i++)
		{
			this.stack[i]=row;
		}
	}
	public void Display(Board ob)
	{
		for(int i=0;i<ob.getRow();i++)
		{
			for(int j=0;j<ob.getCol();j++)
			{
				if(board[i][j]==1)
				{
					System.out.print("R  ");
				}
				else if(board[i][j]==0)
				{
					System.out.print("Y  ");
				}
				else
					System.out.print("*  ");
			}
			System.out.println();
		}
	}
	public int Insert(Board ob ,Players p)
	{
		int flag,column,r;
		do
		{
			flag=1;
			System.out.println(p.getName() + " turn");
			System.out.println("\nAvailable columns");
			for(int i=0;i<ob.getCol();i++)
				if(stack[i]>0)
					System.out.print( (i+1) + " ");
			System.out.println("\n\nselect the column to insert");
			column=sc.nextInt();
			stack[column-1]--;
			r=stack[column-1];
			if(r<0)
			{
				flag=0;
				System.out.println("Invalid column , enter again ");
			}
		}while(flag==0);
		int c=column-1;
		board[stack[column-1]][column-1]=p.getCoin();
		ob.Display(ob);
		Check_Board obj = new Check_Board();
		int i = obj.check(r, c, p, ob);
		return i;
	}
	public void game(Players p1,Players p2,Board ob) {
		System.out.println("hello , welcome to the game \n");
		ob.Display(ob);
		int count=0,x;
		Players p,p0;
		while(count<ob.getCol()*ob.getRow())
		{
			count++;
			if(count%2==1)
			{	p=p1;
			p0=p2;
			}
			else
			{
				p=p2;
				p0=p1;
			}
			x=ob.Insert(ob,p);
			if(x==1)
			{
				System.out.println(p.getName() + "  wins ");
				Results r =new Results();
				r.add_Winner(p,p0);
				return;
			}
		}
		System.out.println("Draw");
	}

}
