class RandomizedSet {
    HashMap<Integer, Integer> hm;
    ArrayList<Integer> ls;
    
    public RandomizedSet() {
        hm = new HashMap<>();
        ls = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(hm.containsKey(val)) return false;
        else {
                hm.put(val, ls.size());
                ls.add(val);
             }
        return true;
    }
    
    public boolean remove(int val) {
        if(!hm.containsKey(val)) return false;
        int idx = hm.get(val);
        int lastIdx = ls.size() - 1;
        if (idx != lastIdx) {
            int lastVal = ls.get(lastIdx);
            ls.set(idx, lastVal);
            hm.put(lastVal, idx);
        }
        ls.remove(lastIdx);
        hm.remove(val);
        return true;
    }
    
    public int getRandom() {
        int idx = (int)(Math.random() * ls.size());
        return ls.get(idx);
    }
}