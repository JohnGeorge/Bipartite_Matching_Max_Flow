import java.util.LinkedList;
import java.util.Queue;

/**
 * @author John George.
 * Checks the max flow of a bipartite graph.
 */
public class MaxFlow {
	private Queue<Integer> q;
	private boolean visited[];
	private int[] path;
	private int[][] graph;
	private int source;
	private int sink;
	private int numberOfNodes;

	public MaxFlow(int numberOfNodes, int[][] graph, int source, int sink){
		this.graph = graph;
		this.source = source;
		this.sink = sink;
		this.numberOfNodes = numberOfNodes;
		visited = new boolean[numberOfNodes];
		path = new int[numberOfNodes];
		q = new LinkedList<>();
	}

	/**
	 * Bredth first search of the graph.
	 * @param resGraph graph that represents the flow after the calculation.
	 * @return true when path is found.
	 */
	public boolean bfs(int[][] resGraph){
		boolean pathFound = false;
		for(int i = 0; i < numberOfNodes; i++){
			visited[i] = false;
		}
		
		q.add(source);
		visited[source] = true;
		path[source] = -1;
		while(q.size() != 0){
			int element = q.remove();
			for(int i = 0; i < numberOfNodes; i++ ){
				if(!visited[i] && resGraph[element][i]==1){
					visited[i] = true;
					path[i]=element;
					q.add(i);
				
				}
			}
		}
		if(visited[sink]){
			pathFound = true;
		}
		return pathFound;
	}

	/**
	 * Ford fulkerson mehod for calculating the max flow.
	 * @param source the start node.
	 * @param sink the end node.
	 * @return max flow in the form of a number.
	 */
	public int fordFulkerson(int source, int sink) {
		int maxFlow = 0;

		int[][] resGraph = new int[numberOfNodes][numberOfNodes];

		for (int i = 0; i < numberOfNodes; i++){
			for(int j = 0; j < numberOfNodes; j++){
				resGraph[i][j] = graph[i][j];
			}
		}

		while(bfs(resGraph)){
			int min = Integer.MAX_VALUE;
			int v = sink;
			while(v != source){
				int u = path[v];
				if(resGraph[u][v] < min){
					min = resGraph[u][v];
				}
				v = path[v];
			}
			v = sink;
			maxFlow += min;
			while(v != source){
				int u = path[v];
				resGraph[u][v] -= min;
				resGraph[v][u] += min;
				v = path[v];	
			}
		}
		return maxFlow;
	}
	
}
