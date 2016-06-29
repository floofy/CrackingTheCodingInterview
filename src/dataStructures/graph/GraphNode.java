package dataStructures.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphNode<E> {

	public ArrayList<GraphNode<E>> children;
	public E data;
	public boolean visited;
	
	public GraphNode() {
		this.children = new ArrayList<GraphNode<E>>();
		this.data = null;
		this.visited = false;
	}
	
	public GraphNode(E data) {
		this.children = new ArrayList<GraphNode<E>>();
		this.data = data;
		this.visited = false;
	}
	
	public void addChild(E data) {
		GraphNode<E> child = new GraphNode<E>(data);
		this.children.add(child);
	}
	
	public void addChild(GraphNode<E> graphNode) {
		this.children.add(graphNode);
	}
	
	public void addChildren(E[] array) {
		for (E i : array) {
			this.children.add(new GraphNode<E>(i));
		}
	}
	
	public void addChildren(ArrayList<GraphNode<E>> graphNodes) {
		this.children.addAll(graphNodes);
	}
	
	public boolean addChildtoChild(E childData, GraphNode<E> childChild) {
		for (GraphNode<E> i : this.children) {
			if (i.data == childData) {
				i.addChild(childChild);
				return true;
			}
		}
		return false;
	}
	
	public boolean addChildtoChild(E childData, E childChildData) {
		for (GraphNode<E> i : this.children) {
			if (i.data == childData) {
				i.addChild(childChildData);
				return true;
			}
		}
		return false;
	}

	public boolean addChildrentoChild(E[] array) {
		for (GraphNode<E> i : this.children) {
			if (i.data == data) {
				i.addChildren(array);
				return true;
			}
		}
		return false;
	}
	
	public void clearChildren() {
		this.children.clear();
	}
	
	public void printBFS() {
		printBFS(this);
	}
	
	public static <E> void printBFS(GraphNode<E> n) {
		Queue<GraphNode<E>> visited = new LinkedList<GraphNode<E>>();
		System.out.println(n.data + ":");
		for (GraphNode<E> i : n.children) {
			System.out.print(i.data + " ");
			if (!i.visited) {
				i.visited = true;
				visited.add(i);
			}
		}
		
		System.out.println("");

		while (!visited.isEmpty()) {
			printBFS(visited.poll());
		}
		return;
	}
	
	public static GraphNode<Integer> createTestGraph() {
		ArrayList<GraphNode<Integer>> array = new ArrayList<GraphNode<Integer>>();

		GraphNode<Integer> eleven = new GraphNode<Integer>(11);
		GraphNode<Integer> twenty = new GraphNode<Integer>(20);
		twenty.addChild(eleven);
		GraphNode<Integer> steen = new GraphNode<Integer>(16);
		steen.addChild(twenty);
		GraphNode<Integer> nine = new GraphNode<Integer>(9);
		nine.addChild(steen);
		GraphNode<Integer> fteen = new GraphNode<Integer>(15);
		array.add(eleven);
		array.add(twenty);
		array.add(nine);
		fteen.addChildren(array);

		array.clear();
		
		GraphNode<Integer> ten = new GraphNode<Integer>(10);
		ten.addChild(fteen);

		GraphNode<Integer> three = new GraphNode<Integer>(3);
		three.addChild(eleven);
		GraphNode<Integer> eight = new GraphNode<Integer>(8);
		eight.addChild(eleven);
		GraphNode<Integer> seven = new GraphNode<Integer>(7);
		seven.addChild(eight);

		
		GraphNode<Integer> five = new GraphNode<Integer>(5);
		GraphNode<Integer> two = new GraphNode<Integer>(2);
		two.addChild(three);
		GraphNode<Integer> four = new GraphNode<Integer>(4);
		four.addChild(three);
		GraphNode<Integer> six = new GraphNode<Integer>(6);
		six.addChild(seven);
		array.add(ten);
		array.add(two);
		array.add(four);
		array.add(six);
		array.add(five);
		GraphNode<Integer> uno = new GraphNode<Integer>(1);
		uno.addChildren(array);

		array.clear();
		
		return uno;
	}
	
	public static void test() {
		GraphNode<Integer> testGraph = createTestGraph();
		printBFS(testGraph);
	}
}
