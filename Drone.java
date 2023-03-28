package javatest;

import java.util.*;
class Drone {



	int startX;
	int startY;
	int endX;
	int endY;
	int startTime;

	public Drone(int startX, int startY, int endX, int endY, int startTime) {
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		this.startTime = startTime;
	}

	public List<int[]> findPath(int[][] grid) {
		// A* search algorithm implementation to find the shortest path from start to end
		PriorityQueue<int[]> openList = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		Map<String, int[]> openMap = new HashMap<>();
		Map<String, int[]> closedMap = new HashMap<>();

		int[] startNode = {startX, startY, 0, -1};
		String startKey = getKey(startX, startY);
		openList.add(startNode);
		openMap.put(startKey, startNode);

		int[] endNode = {endX, endY};

		while (!openList.isEmpty()) {

			int[] currentNode = openList.poll();
			openMap.remove(getKey(currentNode[0], currentNode[1]));
			String currentKey = getKey(currentNode[0], currentNode[1]);
			closedMap.put(currentKey, currentNode);

			if (currentNode[0] == endX && currentNode[1] == endY) {
				return buildPath(currentNode, closedMap);
			}

			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					int neighborX = currentNode[0] + i;
					int neighborY = currentNode[1] + j;

					if (neighborX < 0 || neighborX >= grid.length ||
							neighborY < 0 || neighborY >= grid[0].length ||
							(i == 0 && j == 0)) {
						continue;
					}

					if (grid[neighborX][neighborY] == 1) {
						continue;
					}

					String neighborKey = getKey(neighborX, neighborY);
					int[] neighborNode = openMap.get(neighborKey);

					if (neighborNode == null) {
						neighborNode = closedMap.get(neighborKey);
					}

					if (neighborNode == null) {
						neighborNode = new int[]{neighborX, neighborY, Integer.MAX_VALUE, -1};
					}

					int newCost = currentNode[2] + getCost(currentNode[0], currentNode[1], neighborX, neighborY);
					if (newCost < neighborNode[2]) {
						neighborNode[2] = newCost;
						neighborNode[3] = getIndex(currentNode[0], currentNode[1], neighborX, neighborY);
						if (openMap.containsKey(neighborKey)) {
							openList.remove(neighborNode);
						} else {
							openMap.put(neighborKey, neighborNode);
						}
						openList.add(neighborNode);
					}
				}
			}
		}

		return null;
	}

	private int getIndex(int i, int j, int neighborX, int neighborY) {
		// TODO Auto-generated method stub

		return 0;
	}

	private List<int[]> buildPath(int[] currentNode, Map<String, int[]> closedMap) {
		// TODO Auto-generated method stub
		return null;
	}

	private String getKey(int x, int y) {
		return x + "," + y;
	}

	private int getCost(int startX, int startY, int endX, int endY) {
		if (startX != endX && startY != endY) {
			return 14;
		} else {
			return 10;
		}
	}
}
