/**
 * @author John George.
 */
public class Main {

	public static void main(String[] args) {
		
		Graph g = new Graph(3, 3);

		g.addEdge(1, 5);
		g.addEdge(2, 6);
		g.addEdge(3, 4);

		g.displayGraph();
		g.checkMaxFlow();

	}
}
