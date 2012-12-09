package collection;

import java.util.ArrayList;
import java.util.Collection;

public class ManyToOneRelation<M, O> {
	class ManyToOne {
		ArrayList<M> sources = new ArrayList<M>();
		O target;
		public ManyToOne(O target) {
			this.target = target;
		}
		public ManyToOne(O target, M source) {
			this.target = target;
			sources.add(source);
		
		}
	}
	ArrayList<ManyToOne> container = new ArrayList<ManyToOne>(); 
	
	/**
	* Connects the given source with the given target. If this source was
	* previously connected with another target the old connection is lost.
	*
	* @param source
	* @param target
	* @return
	*/
	public void connect(M source, O target) {
		boolean check = false;
		for(ManyToOne search : container) {
			if (search.target.equals(target)) {
				search.sources.add(source);
				check = true;
				break;
			}
		}
		if (check == false) {
			container.add(new ManyToOne(target, source));
		}
	}
	/**
	* @param source
	* @return <code>true</code> if the relation contains the given source
	*/
	public boolean containsSource(M source) {
		boolean check = false;
		loops:
		for(ManyToOne search : container) {
			for(M search2 : search.sources) {
				if (search2.equals(source)) {
					if (search2 instanceof Integer) {
						check = CompareInteger(search2, source);
						if (check) break loops;
					}
					else {
						check = true;
						break;
					}
				}
			}
		}
		return check;
	}
	/**
	* @param target
	* @return <code>true</code> if the relation contains the given target
	*/
	public boolean containsTarget(O target) {
		boolean check = false;
		for(ManyToOne search : container) {
				if (search.target.equals(target)) {
					if (search.target instanceof Integer) {
						check = CompareInteger(search.target, target);
						if (check) break;
					}
					else {
						check = true;
						break;
					}
				}
		}
		return check;
	}
	/**
	* @param source
	* @return the target with which this source is connected
	*/
	public O getTarget(M source) {
		if (containsSource(source)) {	
			for(ManyToOne search : container) {
				if (search.sources.contains(source)) {
					return search.target;
				}
			}
		}
		return null;
	}
	/**
	* @param target
	* @return all the sources that are connected with this target or empty
	* collection if there are no sources connected with this target.
	*/
	public Collection<M> getSources(O target) {
		for(ManyToOne search : container) {
			if (search.target.equals(target)) {
				if (search.target instanceof Integer) {
					if (CompareInteger(search.target, target)) {
						return search.sources;
					}
				} 
				else {
					return search.sources; 
				}
			}
		}
		return new ArrayList<M>();
	}
	/**
	* Removes the connection between this source and the corresponding target.
	* Other sources will still point to the same target.
	*
	* The target is removed if this was the only source pointing to it and
	* {@link #containsTarget(Object)} will return false.
	*
	* @param source
	*/
	public void disconnectSource(M source) {
		if (containsSource(source)) {
			O target = getTarget(source);
			for (ManyToOne search : container) {
				if (target.equals(search.target)) {
					if (target instanceof Integer) {
						if (CompareInteger(target, search.target)) {
							search.sources.remove(source);
							break;
						}
					}
					else {
						search.sources.remove(source);
						break;
					}
				}
			}
		}
	}
	/**
	* Removes the given target from the relation. All the sources that are
	* pointing to this target are also removed.
	*
	* If you take the "result" of {@link #getSources(target)} and after that
	* call this method then {@link #containsSource(Object)} will return
	* <code>false</code> for every object in "result".
	*
	* @param target
	*/
	public void disconnect(O target) {
		for (ManyToOne search : container) {
			if (search.target.equals(target)) {
				if (search.target instanceof Integer) {
					if (CompareInteger(search.target, target)) {
						container.remove(search);
						break;
					}
				}
				else {
					container.remove(search);
					break;
				}
			}
		}
	}
	/**
	* @return a collection of the targets.
	*/
	public Collection<O> getTargets() {
		Collection<O> collection= new ArrayList<O>(); 
		for (ManyToOne search : container) {
			collection.add(search.target);
		}
		return collection;
	}

	
	public boolean CompareInteger(Object obj, Object obj2) {
			boolean check;
			if (obj == obj2) {
				check = true;
			}
			else {
				check = false;
			}
			return check;
	}
}

