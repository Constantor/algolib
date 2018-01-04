import java.util.*;


public class Graph<T> implements Iterable<T> {
	protected int E = 0;
	protected Map<T, Set<T>> adjacentMap = new HashMap<>();

	public Graph() {

	}

	public Graph(Graph<T> graph) {
		this.E = graph.E();
		for(T v : graph) {
			this.adjacentMap.put(v, graph.adjacent(v));
			this.E += this.adjacentMap.get(v).size();
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private Iterator<T> iterator = adjacentMap.keySet().iterator();

			@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}

			@Override
			public T next() {
				return iterator.next();
			}

			@Override
			/*
			public void remove() {
				iterator.remove();
			}
			*/
			public void remove() {
				throw new UnsupportedOperationException("Removing is not allowed!");
			}

		};
	}

	public int V() {
		return adjacentMap.size();
	}

	public int E() {
		return E;
	}

	public void addEdge(T v, T u) {
		adjacentMap.get(v).add(u);
		E++;
	}

	public void removeEdge(T v, T u) {
		if(this.adjacent(v).contains(u)) {
			adjacentMap.get(v).remove(u);
			E--;
		}
	}

	public void addVertex(T v) {
		if(!this.adjacentMap.containsKey(v))
			this.adjacentMap.put(v, new HashSet<>());
	}

	public void removeVertex(T v) {
		if(this.adjacentMap.containsKey(v)) {
			this.adjacentMap.remove(v);
			for(T u : this)
				this.removeEdge(u, v);
		}
	}

	public Set<T> vertices() {
		return adjacentMap.keySet();
	}

	public Set<T> adjacent(T v) {
		return this.adjacentMap.get(v);
	}

	public int degree(T v) {
		return adjacentMap.get(v).size();
	}
}
