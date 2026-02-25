import java.util.Stack;

class StockSpanner {

    // Stack stores pairs: [price, span]
    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        // Pop all prices <= current price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        // Push current price and its span
        stack.push(new int[]{price, span});

        return span;
    }
}