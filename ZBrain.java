import java.math.*;

// brain of a zombie and ghost


public class ZBrain extends Brain {
	
	// returns the direction the zombie or ghost has the tendency to walk 
	public int[] getDirr(Tile[][] map, Hero hero, Baddies baddy)
	{	
		int[] dirs = new int[2];
		int dH;
		int dV;
		int hor = hero.x - baddy.x;
		int ver = hero.y - baddy.y;
		if (hor<0)
			dH = 0;
		else if (hor ==0)
			dH = 4;
		else 
			dH = 2;
		if (ver<0)
			dV =1;
		else if (ver ==0)
			dV =4;
		else 
			dV =3;
		
		if(Math.abs(hor) > Math.abs(ver))
		{
			dirs[0] = dH;
			dirs[1] = dV;
		}
		else 
		{
			dirs[0] = dV;
			dirs[1] = dH;
		}
		return dirs;
			
			
			
	}

}
