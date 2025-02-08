class NumberContainers {
    HashMap<Integer,TreeSet<Integer>> noToidx;
    HashMap<Integer,Integer> idxTono;


    public NumberContainers() {
        noToidx = new HashMap<>();
        idxTono = new HashMap<>();
        
    }
    
    public void change(int index, int number) {
        if(idxTono.containsKey(index)){
            int prev  = idxTono.get(index);
            noToidx.get(prev).remove(index);
            if(noToidx.get(prev).size()==0) noToidx.remove(prev);
        }
        idxTono.put(index,number);
        if(!noToidx.containsKey(number)){
            noToidx.put(number,new TreeSet<>());

        }
         noToidx.get(number).add(index);
    }
    
    public int find(int number) {
        if(!noToidx.containsKey(number)){
            return -1;
        }
        return noToidx.get(number).first();
        
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
