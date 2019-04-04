class RandomizedCollection {
    
    HashMap<Integer, Set<Integer>> valToInd;
    List<Integer> list;
    Random rand;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        valToInd = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contains = valToInd.containsKey(val);
        
        if(!contains) valToInd.put(val, new HashSet<Integer>());
        
        valToInd.get(val).add(list.size()); // index of recently added element
        list.add(val);
        
        return !contains;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean contains = valToInd.containsKey(val);
        if ( !contains ) return false;
        
        int loc = valToInd.get(val).iterator().next();
	    valToInd.get(val).remove(loc);
        
        // if it's onot last index element, swap it with the last element
        if (loc < list.size() - 1 ) {
	       int lastone = list.get( list.size()-1 );
	       list.set(loc , lastone );
	       valToInd.get(lastone).remove(list.size()-1);
	       valToInd.get(lastone).add(loc);
	    }
	    list.remove(list.size() - 1);
	   
	    if (valToInd.get(val).isEmpty()) valToInd.remove(val);
	    return true;
        
        
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
