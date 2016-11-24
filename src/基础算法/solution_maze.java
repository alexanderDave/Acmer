package 基础算法;

import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * @author daiw
 * @see 利用二维数组模拟迷宫地图（0表示路，1表示墙），从左上角进入到右下角出
 * 计算出最短路径，并将最短路径写出
 * @version 1.0.0
 * 
 */
public class solution_maze {
	
	public class point{
		public int x;
		public int y;
		
		public point() {
			this(0,0);
		}
		
		public point(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		public boolean equals(point p){
			return x==p.x && y == p.y;
		}
		
		public String tosString(){
			return "("+x+","+y+")";		
		}
	}
	public int[][] maze = null;
	public Stack<point> stack = new Stack<point>();
	
	public solution_maze(int[][] maze){
		this.maze = maze;
	}
	
	public void go(){
		point out = new point(maze.length -1, maze[0].length -1);
		point in = new point(0, 0);
		point currentNode = in;
		point nextNode = null;
		
		while (!currentNode.equals(out)) {
			nextNode = new point(currentNode.x, currentNode.y);
			if ((currentNode.x+1)< maze.length && maze[currentNode.x+1][currentNode.y] == 0) {
				nextNode.x++;
			}else if ((currentNode.y+1)< maze[0].length && maze[currentNode.x][currentNode.y+1] == 0) {
				nextNode.y++;
			}else if ((currentNode.x-1)>= 0 && maze[currentNode.x-1][currentNode.y] == 0) {
				nextNode.x--;
			}else if ((currentNode.y-1)>= 0 && maze[currentNode.x][currentNode.y-1] == 0) {
				nextNode.y--;
			} else {
				maze[currentNode.x][currentNode.y]  = 3;
				if (stack.isEmpty()) {
					System.out.println("no solution");
					return;
				}
				currentNode = stack.pop();
				continue;
			}
			
			stack.push(currentNode);
			maze[currentNode.x][currentNode.y] =2;
			currentNode = nextNode;
		}
		
		if (nextNode.equals(out)) {
			stack.push(nextNode);
			maze[nextNode.x][nextNode.y] = 2;
		}
		
		for (int i = 0; i < stack.size(); i++) {
			System.out.println(stack.elementAt(i).tosString());
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] maze = new int[5][5];
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				maze[i][j] = scanner.nextInt();
		
		new solution_maze(maze).go();
		
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				System.out.println(maze[i][j]); 
	}
	
	
	
}
