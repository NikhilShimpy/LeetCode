class StockSpanner {
    Stack<Integer> stack;
    List<Integer> list;
    public StockSpanner() {
        stack = new Stack<>();
        list = new ArrayList<>();

    }
    
    public int next(int price) {
        list.add(price);
        
        while(!stack.isEmpty() && list.get(stack.peek()) <= price){
            stack.pop();
        }
        int prev = (stack.isEmpty())?-1:stack.peek();
        int curr = list.size()-1;
        
        int ans = curr - prev;
        stack.push(curr);
        return ans;
    }
}
 
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
