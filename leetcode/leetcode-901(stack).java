class Pair {
        int price;
        int index;
        public Pair(int price,int index) {
            this.price = price;
            this.index = index;
        }

    }
class StockSpanner {
    ArrayList<Integer> list;
    Stack<Pair> st;
    int index;
    public StockSpanner() {
        index = -1;
        st = new Stack<>();
    }
    
    public int next(int price) {
        index++;
        while(!st.isEmpty() && st.peek().price <= price) {
            st.pop();
        }
        int ans = index - (st.isEmpty() ? -1 : st.peek().index);
        st.push(new Pair(price,index));
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */