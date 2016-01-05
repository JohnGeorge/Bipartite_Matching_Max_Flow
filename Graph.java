/**
 * @author John George.
 * Creates a graph represented as an adjancy matrix.
 */
public class Graph {
	private int[][] graph;
	private int leftNodes;
	private int rightNodes;
	private int totalNodes;
	private int source;
	private int sink;

	/**
	 * The constructor creates a bipartite graph with a source and a sink.
	 * @param leftNodes all the left nodes.
	 * @param rightNodes all the right nodes.
	 */
	public Graph(int leftNodes, int rightNodes){
		this.graph = new int[8][8];
		this.leftNodes = leftNodes;
		this.rightNodes = rightNodes;
		this.totalNodes = this.leftNodes + this.rightNodes + 2;
		this.source = 0;
		this.sink = this.totalNodes - 1;
		addSource();
		addSink();
	}

	/**
	 * Add the source node.
	 */
	public void addSource(){
		for (int i = 1; i <= leftNodes; i++) {
			graph[source][i] = 1;
		}
	}

	/**
	 * Add the sink node.
	 */
	public void addSink(){
		for (int i = leftNodes+1; i < sink; i++){
			graph[i][sink] = 1;
		}
	}

	/**
	 * Add edge between nodes.
	 * @param uLeft Connection to left node.
	 * @param vRight Connection to right node.
	 */
	public void addEdge(int uLeft, int vRight){
		graph[uLeft][vRight] = 1;
	}

	/**
	 * Prints out the graph as an adjancy matrix.
	 */
	public void displayGraph(){
		System.out.println("---------------");
		System.out.println("Bipartite graph");
		System.out.println("---------------");

		for(int row = 0; row < graph.length; row++){
			//System.out.print(row+"  ");
			for(int column = 0; column < graph[row].length; column++){
				System.out.print(graph[row][column]+" ");
			}
			System.out.println();
		}
	}

	/**
	 * Checks max flow of the graph.
	 */
	public void checkMaxFlow(){
		MaxFlow m = new MaxFlow(totalNodes, graph, source, sink);

		System.out.println("---------------");
		System.out.println(" Maxflow is " + m.fordFulkerson(source, sink));
		System.out.println("---------------");
	}
}
