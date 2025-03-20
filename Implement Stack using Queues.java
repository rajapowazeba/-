import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.offer(x);
    }

    public int pop() {
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        int topElement = queue1.poll();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return topElement;
    }

    public int top() {
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        int topElement = queue1.peek();
        queue2.offer(queue1.poll());
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return topElement;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
