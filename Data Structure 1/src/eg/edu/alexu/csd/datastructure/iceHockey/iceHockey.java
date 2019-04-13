package eg.edu.alexu.csd.datastructure.iceHockey;

import java.awt.Point;
import java.util.ArrayList;

public class iceHockey implements IPlayersFinder{

	public Point[] findPlayers(String[] photo, int team, int threshold) {
		
		if (photo == null) {
			return null;
		}
		ArrayList <Point> playerFinder = new ArrayList(1);
		int[][] visited = new int[photo.length][photo[0].length()];
		int count = 1;
		for (int i = 0; i<photo.length; i++) {
			for (int j = 0; j<photo[0].length(); j++) {
				if (photo[i].charAt(j) - '0' == team) {
					if(dfs(photo, i, j, visited, team, count)) {
						count++;
					}
					
				}
				
			}
		}
		
		int[] countGroups = new int[count-1];
		int[] availableNumbers = new int[count-1];
		for (int k = 0; k<countGroups.length; k++) {
			for (int i = 0; i<visited.length; i++) {
				for (int j = 0; j<visited[0].length; j++) {
					if (visited[i][j] == k+1) {
						countGroups[k]++;
					}
				}
			}
			availableNumbers[k] = k+1;
		}
		
		for (int x =0; x<availableNumbers.length; x++) {
			if (countGroups[x] >= (int)Math.ceil(threshold/4.0)) {
				Point p = new Point();
				int minX = visited[0].length,minY = visited.length,maxX = 0,maxY = 0;
				for (int i = 0; i<visited.length; i++) {
					for (int j = 0; j<visited[0].length; j++) {
						if (visited[i][j] == availableNumbers[x]) {
							if (j<minX)minX = j;
							if (j>maxX)maxX = j;
							if (i<minY)minY = i;
							if (i>maxY)maxY = i;
						}
					}
				}
				p.x = (int)(minX + maxX +1);
				p.y = (int)(minY + maxY +1);
				playerFinder.add(p);
			}
		}
		Point[] players = new Point[playerFinder.size()];
		int x = 0;
		for (Point q : playerFinder) {
			players[x++] = q;
		}
		sort(players);
		return players ;
	}
	
	private static boolean dfs(String[] photo, int row, int column, int[][] visited, int team, int count) {
		if (row<0 || column<0 || row>=photo.length || column>=photo[0].length()) {
			return false;
		}
		if (visited[row][column] != 0) {
			return false;
		}
		if (photo[row].charAt(column) - '0' == team) {
			visited[row][column] = count;
		}else {
			return false;
		}
		dfs(photo,row+1,column,visited,team,count);
		dfs(photo,row-1,column,visited,team,count);
		dfs(photo,row,column+1,visited,team,count);
		dfs(photo,row,column-1,visited,team,count);
		return true;
	}
	
	public static void sort (Point[] p) {
		boolean ifSwap = true;
		for (int i = 0; i<p.length && ifSwap; i++) {
			ifSwap = false;
			for (int j = 0; j<p.length-1-i; j++) {{
				if (p[j].x > p[j+1].x) {
					Point temp = p[j];
					p[j] = p[j+1];
					p[j+1] = temp;
					ifSwap = true;
				}
			}
				
			}
		}
		for (int i = 0; i<p.length; i++) {
			for (int j = 0; j<p.length-1-i;j++) {
				if (p[j].x == p[j+1].x) {
					if (p[j].y > p[j+1].y) {
						Point temp = p[j];
						p[j] = p[j+1];
						p[j+1] = temp;
					}
				}
			}
			
		}
	}

}
