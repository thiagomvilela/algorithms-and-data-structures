import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class AdjacencyListGraph {

	private Vertex[] vertexes;
	private boolean directed;
	private int lastIndexVertex;

	public AdjacencyListGraph(boolean directed) {
		this.vertexes = new Vertex[10];
		this.lastIndexVertex = 0;
		this.directed = directed;
	}

	public void addVertex(String value) {
		this.vertexes[this.lastIndexVertex] = new Vertex(this.lastIndexVertex, value);
		this.lastIndexVertex++;
	}

	public void removeVertex(String value) {
		for (int i = 0; i < this.lastIndexVertex; i++) {
			Vertex vertex = this.vertexes[i];
			if (vertex != null && vertex.getValue().equals(value)) {
				this.vertexes[i] = null;

				for (int j = 0; j < this.lastIndexVertex; j++) {
					Vertex sourceVertex = this.vertexes[j];
					if (sourceVertex != null) {
						List<Edge> adjacencyListsDest = sourceVertex.getAdjacencyList();
						for (Edge edge : adjacencyListsDest) {
							if (edge.getDestionationVertex() == vertex.getIndex()) {
								adjacencyListsDest.remove(edge);
								break;
							}
						}
					}
				}
			}
		}
	}

	public void addEdge(int sourceVertex, int destinationVertex) {
		addEdge(sourceVertex, destinationVertex, 1);
	}

	public void addEdge(int sourceVertex, int destinationVertex, double weight) {
		if (!constainsEdge(sourceVertex, destinationVertex)) {
			Vertex vertex = this.vertexes[sourceVertex];
			if (vertex != null) {
				List<Edge> adjacencyLists = vertex.getAdjacencyList();
				adjacencyLists.add(new Edge(sourceVertex, destinationVertex, weight));
				if (!directed) {
					Vertex vertexSource = this.vertexes[destinationVertex];
					List<Edge> adjacencyListsDest = vertexSource.getAdjacencyList();
					adjacencyListsDest.add(new Edge(destinationVertex, sourceVertex, weight));
				}
			}
		}
	}

	public void removeEdge(int sourceVertex, int destinationVertex) {
		Vertex vertex = this.vertexes[sourceVertex];
		if (vertex != null) {
			List<Edge> adjacencyList = vertex.getAdjacencyList();
			for (Edge edge : adjacencyList) {
				if (edge.getDestionationVertex() == destinationVertex) {
					adjacencyList.remove(edge);

					if (!directed) {
						AdjacencyListGraph.Vertex vertexSource = this.vertexes[destinationVertex];
						List<Edge> adjacencyListDest = vertexSource.getAdjacencyList();
						for (Edge edge2 : adjacencyListDest) {
							if (edge2.getDestionationVertex() == sourceVertex) {
								adjacencyListDest.remove(edge2);
							}
						}
					}
				}
			}
		}
	}

	private boolean constainsEdge(int sourceVertex, int destinationVertex) {
		Vertex vertex = this.vertexes[sourceVertex];
		if (vertex != null) {
			List<Edge> adjacencyLists = vertex.getAdjacencyList();
			for (Edge edge : adjacencyLists) {
				if (edge.getDestionationVertex() == destinationVertex) {
					return true;
				}
			}
		}
		return false;
	}

	public void breadthFirstTraversal() {
		Vertex firstVertex = null;
		for (Vertex vertex : this.vertexes) {
			if (vertex != null) {
				firstVertex = vertex;
				break;
			}
		}

		Queue<Vertex> toBeVisitedQueue = new LinkedList<Vertex>();
		toBeVisitedQueue.offer(firstVertex);

		Set<Vertex> visitedIdentifiedVertex = new HashSet<Vertex>();
		visitedIdentifiedVertex.add(firstVertex);

		while (toBeVisitedQueue.peek() != null) {
			Vertex vertex = toBeVisitedQueue.poll();
			for (Edge edge : vertex.getAdjacencyList()) {
				Vertex adjacentVertex = getVertex(edge.getDestionationVertex());
				if (!visitedIdentifiedVertex.contains(adjacentVertex)) {
					toBeVisitedQueue.offer(adjacentVertex);
					visitedIdentifiedVertex.add(adjacentVertex);
				}
			}
			System.out.print(vertex.getValue() + ", ");
		}
	}

	private Vertex getVertex(int index) {
		for (Vertex vertex : this.vertexes) {
			if (vertex.getIndex() == index) {
				return vertex;
			}
		}

		return null;
	}

	public String toString() {
		String toReturn = "Directed=" + this.directed + "\n";
		for (Vertex vertex : this.vertexes) {
			if (vertex != null) {
				toReturn += vertex.toString() + "\n";
			}
		}
		return toReturn;
	}

	public static void main(String[] args) {
		AdjacencyListGraph graph = new AdjacencyListGraph(false);
		graph.addVertex("C");
		graph.addVertex("Z");
		graph.addVertex("F");
		graph.addVertex("H");
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(1, 3);
		System.out.println(graph);

		graph.breadthFirstTraversal();

//		System.out.println();
//		
//		graph.removeVertex("B");
//		System.out.println(graph);

//		System.out.println();
//		graph.removeEdge(0, 2);
	}

	class Vertex {

		private int index;
		private String value;
		private List<Edge> adjacencyLists;

		public Vertex(int index, String value) {
			this.index = index;
			this.value = value;
			this.adjacencyLists = new ArrayList<Edge>();
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public List<Edge> getAdjacencyList() {
			return adjacencyLists;
		}

		public void setAdjacencyLists(List<Edge> adjacencyLists) {
			this.adjacencyLists = adjacencyLists;
		}

		public boolean equals(Object obj) {
			if (obj instanceof Vertex) {
				Vertex otherVertex = (Vertex) obj;
				return this.index == otherVertex.index;
			}

			return false;
		}

		public String toString() {
			return "{" + this.index + ", " + this.value + " - " + this.adjacencyLists.toString() + "}";
		}

	}

	class Edge {

		private int sourceVertex;
		private int destionationVertex;
		private double weight;

		public Edge(int sourceVertex, int destionationVertex, double weight) {
			this.sourceVertex = sourceVertex;
			this.destionationVertex = destionationVertex;
			this.weight = weight;
		}

		public Edge(int sourceVertex, int destionationVertex) {
			this.sourceVertex = sourceVertex;
			this.destionationVertex = destionationVertex;
			this.weight = 1;
		}

		public int getSourceVertex() {
			return sourceVertex;
		}

		public void setSourceVertex(int sourceVertex) {
			this.sourceVertex = sourceVertex;
		}

		public int getDestionationVertex() {
			return destionationVertex;
		}

		public void setDestionationVertex(int destionationVertex) {
			this.destionationVertex = destionationVertex;
		}

		public double getWeight() {
			return weight;
		}

		public void setWeight(double weight) {
			this.weight = weight;
		}

		public boolean equals(Object obj) {
			if (obj instanceof Edge) {
				Edge otherEdge = (Edge) obj;
				return this.sourceVertex == otherEdge.sourceVertex
						&& this.destionationVertex == otherEdge.getDestionationVertex();
			}

			return false;
		}

		public String toString() {
			return "(" + this.sourceVertex + ", " + this.destionationVertex + ", " + this.weight + ")";
		}

	}

}
