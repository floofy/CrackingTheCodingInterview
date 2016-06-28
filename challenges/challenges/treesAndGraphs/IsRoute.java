package challenges.treesAndGraphs;

import java.util.LinkedList;

import dataStructures.graph.GraphNode;

public class IsRoute {

	public static void test() {
		int start = 10;
		int end = 16;
		System.out.print("2. isRoute(" + start + ", " + end + "): ");
		GraphNode<Integer> testGraph = GraphNode.createTestGraph();
		LinkedList<Integer> route = isRoute(testGraph, start, end);
		System.out.print(route + "\n");
	}
	
	/*
	 * BFS algorithm to return a node in the grp
	 */
	public static <E> GraphNode<E> search(GraphNode<E> root, E datum) {
		if (root.data == datum)
			return root;

		LinkedList<GraphNode<E>> queue = new LinkedList<GraphNode<E>>();
		GraphNode<E> node;
		root.visited = true;
		queue.add(root);
		
		while (!queue.isEmpty()) {
			node = queue.removeFirst();
			for (GraphNode<E> n : node.children) {
				if (n.data == datum) {
					return n;
				}
				if (!n.visited) {
					n.visited = true;
					queue.add(n);
				}
			}
		}
		
		return null; // placeholder
	}
	
	public static <E> LinkedList<E> isRoute(GraphNode<E> root, E point1, E point2) {
		GraphNode<E> startNode = search(root, point1);
		if (startNode == null) {
			return null;
		}
		return getRoute(startNode, point2);
	}

	/*
	 * Use BFS search until you find node2. Return true or false.
	 */
	public static <E> LinkedList<E> getRoute(GraphNode<E> root, E point2) {

		LinkedList<E> route = new LinkedList<E>();
		LinkedList<GraphNode<E>> queue = new LinkedList<GraphNode<E>>();
		
		if (root.data == point2) {
			route.add(root.data);
			return route;
		}
		root.visited = true;
		route.add(root.data);
		
		for (GraphNode<E> n : root.children) {
			if (n.data == point2) {
				route.add(n.data);
				return route;
			}

			if (!n.visited) {
				queue.add(n);
			}
		}

		while (!queue.isEmpty()) {
			route = getRoute(queue.poll(), point2);
			if (route != null) {
				route.addFirst(root.data);
				return route;
			}
		}
	
		return null;
	}

}
