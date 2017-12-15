import java.util.*;


public final class DSU<T> {
	private static final class Link<T> {
		public T parent;
		public int rank = 0;

		Link(T parent) {
			this.parent = parent;
		}
	}

	private final Map<T, Link<T>> elems = new HashMap<>();

	public DSU() {

	}

	public DSU(Collection<? extends T> elems) {
		for(T elem : elems)
			add(elem);
	}

	public boolean add(T elem) {
		if(elem == null)
			throw new NullPointerException("DSU does not support null.");

		if(elems.containsKey(elem))
			return false;

		elems.put(elem, new Link<>(elem));
		return true;
	}

	public T find(T elem) {
		if(!elems.containsKey(elem))
			throw new NoSuchElementException(elem + " is not an element.");

		return recFind(elem);
	}

	private T recFind(T elem) {
		Link<T> info = elems.get(elem);

		if(info.parent.equals(elem))
			return elem;

		info.parent = recFind(info.parent);
		return info.parent;
	}


	public void union(T one, T two) {
		Link<T> oneLink = elems.get(find(one));
		Link<T> twoLink = elems.get(find(two));

		if(oneLink == twoLink) return;

		if(oneLink.rank > twoLink.rank)
			twoLink.parent = oneLink.parent;
		else if(oneLink.rank < twoLink.rank)
			oneLink.parent = twoLink.parent;
		else {
			twoLink.parent = oneLink.parent;
			oneLink.rank++;
		}
	}
}
