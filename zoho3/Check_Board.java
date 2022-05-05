package zoho3;

public class Check_Board {
	public int check_Horizontal(int x, int y,Players p,Board b)
	{
		int flag;
		for(int i=y-3;i<b.getCol()-3;i++)
		{
			if(i>=0)
			{
				flag=1;
				for(int j=0;j<4;j++)
				{
					if( i+j>b.getCol()-1 || b.board[x][i+j]!=p.coin)
					{
						flag=0;
						break;
					}
				}
				if(flag==1)
					return 1;
			}	
		}
		return 0;
	}
	public int check_vertical(int x, int y,Players p,Board b)
	{
		int flag;
		for(int i=x-3;i<b.getRow()-3;i++)
		{
			if(i>=0)
			{
				flag=1;
				for(int j=0;j<4;j++)
				{
					if(i+j>b.getRow()-1 || b.board[i+j][y]!=p.coin)
					{
						flag=0;
						break;
					}
				}
				if(flag==1)
					return 1;
			}
		}
		return 0;
	}
	public int check_Left_Diagonal(int x, int y,Players p,Board b)
	{
		int flag;
		for(int i=x-3,j=y-3;i<b.getRow()-3 && j<b.getCol()-3;i++,j++)
		{
			if(i>=0 && j>=0)
			{
				flag=1;
				for(int z=0;z<4;z++)
				{
					if((i+z>b.getRow()-1 && j+z>b.getCol()-1) || b.board[i+z][j+z]!=p.coin)
					{
						flag=0;
						break;
					}
				}	
				if(flag==1)
					return 1;
			}
		}
		return 0;
	}

	protected int check_Right_Diagonal(int x, int y,Players p,Board b)
	{
		int flag;
		for(int i=x-3,j=y+3;i<b.getRow()-3 && j>=3;i++,j--)
		{
			if(i>=0 && j<b.getCol())
			{
				flag=1;
				for(int z=0;z<4;z++)
				{
					if((i+z>b.getRow()-1 && j-z<0) || b.board[i+z][j-z]!=p.coin)
					{
						flag=0;
						break;
					}
				}	
				if(flag==1)
					return 1;
			}
		}
		return 0;
	}

	public int check(int x,int y,Players p,Board ob)
	{
		Check_Board obj = new Check_Board();
		int a=obj.check_Horizontal(x,y,p,ob);
		if(a==1)
			return 1;
		int b=obj.check_vertical(x,y,p,ob);
		if(b==1)
			return 1;
		int c=obj.check_Left_Diagonal(x, y, p, ob);
		if(c==1)
			return 1;
		int d=obj.check_Right_Diagonal(x, y, p, ob);
		if(d==1)
			return 1;
		return 0;
	}
}
