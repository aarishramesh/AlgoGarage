package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.interviewbit.com/problems/knight-on-chess-board/
 * 
 * @author polymath
 *
 */
public class KnightMinimumMoves {

	public static void main(String[] args) {
		KnightMinimumMoves inst = new KnightMinimumMoves();
		System.out.println(inst.knight(2, 20, 1, 18, 1, 5));
		System.out.println(inst.knightNew(2, 20, 1, 18, 1, 5));
	}

	public int knight(int A, int B, int C, int D, int E, int F) {
		if (A > 0 && B > 0 && C > 0 && D > 0 && C <= A && D <= B && E > 0 && F > 0 && E <= A && F <= B) {
			movesQueue.add(new Move(C, D, 0));
			boolean[][] visited = new boolean[A + 1][B + 1];
			while (!movesQueue.isEmpty()) {
				Move move = movesQueue.remove();
				visited[move.x][move.y] = true;
				int moveCount = move.moveCount + 1;
				if (move.x == E && move.y == F)
					return moveCount - 1;
				if (move.x + 2 <= A && move.y + 1 <= B && visited[move.x + 2][move.y + 1] != true) {
					movesQueue.add(new Move(move.x + 2, move.y + 1, moveCount));
				}
				if (move.x + 1 <= A && move.y + 2 <= B && visited[move.x + 1][move.y + 2] != true) {
					movesQueue.add(new Move(move.x + 1, move.y + 2, moveCount));
				}
				if (move.x - 1 > 0 && move.y + 2 <= B && visited[move.x - 1][move.y + 2] != true) {
					movesQueue.add(new Move(move.x - 1, move.y + 2, moveCount));
				}
				if (move.x - 2 > 0 && move.y + 1 <= B && visited[move.x - 2][move.y + 1] != true) {
					movesQueue.add(new Move(move.x - 2, move.y + 1, moveCount));
				}
				if (move.x - 2 > 0 && move.y - 1 > 0 && visited[move.x - 2][move.y - 1] != true) {
					movesQueue.add(new Move(move.x - 2, move.y - 1, moveCount));
				}
				if (move.x - 1 > 0 && move.y - 2 > 0 && visited[move.x - 1][move.y - 2] != true) {
					movesQueue.add(new Move(move.x - 1, move.y - 2, moveCount));
				}
				if (move.x + 1 <= A && move.y - 2 > 0 && visited[move.x + 1][move.y - 2] != true) {
					movesQueue.add(new Move(move.x + 1, move.y - 2, moveCount));
				}
				if (move.x + 2 <= A && move.y - 1 > 0 && visited[move.x + 2][move.y - 1] != true) {
					movesQueue.add(new Move(move.x + 2, move.y - 1, moveCount));
				}
			}
		}
		return -1;
	}

	public int knightNew(int N, int M, int x1, int y1, int x2, int y2) {
		// The 8 positions a knight could move to for the current position.
		int[] dx = {-1, -2, -1, -2, 1, 2, 1, 2};
		int[] dy = {-2, -1, 2, 1, -2, -1, 2, 1};
		boolean[][] isVisited = new boolean[N+1][M+1];
		Queue<Coordinate> queue = new LinkedList<Coordinate>();
		queue.add(new Coordinate(x1, y1));
		isVisited[x1][y1] = true;
		int moveCount = 0;

		// BFS to find the minimum number of steps.
		while (!queue.isEmpty()) {
			int nodesAtCurrentBreadth = queue.size();
			// Iterate over the coordinates at current breadth, as moveCount would be 
			// incremented by 1 per breadth level.
			for (int count = 0; count < nodesAtCurrentBreadth; count++) {
				Coordinate currPos = queue.remove();
				if (currPos.x == x2 && currPos.y == y2) {
					return moveCount;
				}

				for (int i = 0; i < dx.length; i++) {
					if (isValid(currPos.x + dx[i], currPos.y + dy[i], N, M) && isVisited[currPos.x + dx[i]][currPos.y + dy[i]] == false) {
						queue.add(new Coordinate(currPos.x + dx[i], currPos.y + dy[i]));
						isVisited[currPos.x + dx[i]][currPos.y + dy[i]] = true;
					}
				}                
			}
			moveCount++;
		}

		return -1;
	}

	private boolean isValid(int x, int y, int N, int M) {
		if (x <= 0 || y <= 0 || x > N || y > M) {
			return false;
		}

		return true;
	}


	static class Coordinate {
		int x, y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private Queue<Move> movesQueue = new LinkedList<Move>();

	static class Move {
		int x = 0, y = 0, moveCount = 0;

		Move(int x, int y, int moveCount) {
			this.x = x;
			this.y = y;
			this.moveCount = moveCount;
		}
	}
}