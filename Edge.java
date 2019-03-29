package ChessPack;

public class Edge implements Comparable<Edge> {
	private TileNode neighbor;
	
	public Edge(TileNode neighbor){
		this.neighbor = neighbor;
	}
	
	/**
	 * Returns the neighbor on the other end of the edge
	 * 
	 * @return the neighbor
	 */
	public TileNode getNeighborNode(){
		return neighbor;
	}

	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return 0;
	}	
}
