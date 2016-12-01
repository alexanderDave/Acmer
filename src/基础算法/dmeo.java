package »ù´¡Ëã·¨;
//failed!!
import java.util.Scanner;
import java.util.Stack;

public class dmeo {
	public class dot{
		private int x;
		private int y;
		
		public dot(){
			
		}
		
		public dot(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		public boolean dotEquals(dot d){
			return x == d.x && y == d.y;
		}
		public String toString(){
			return "( "+x+","+y+" )";
		}
	}
	
	Stack<dot> dots = new Stack<dot>();
	int[][] maze = null;
	public dmeo(int[][] maze){
		this.maze = maze;
	}
	
	public void go(){
		dot start = new dot(0, 0);
		dot end = new dot(maze.length-1,maze[0].length-1);
		dot currentDot = start;
		dot nextDot = null;
		
		while (!currentDot.dotEquals(end)) {
			nextDot = new dot(currentDot.x, currentDot.y);
			
		}
	}
	
	public static void main(String[] args) {
		int m = 5, n = 5;
		int[][] maze = new int[m][n];
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				maze[i][j] = in.nextInt();
		
		new dmeo(maze).go();
		
	}
}