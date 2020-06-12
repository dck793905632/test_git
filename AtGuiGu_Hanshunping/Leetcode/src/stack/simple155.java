package stack;

public class simple155 {
   /* Stack<Integer> data;
    Stack<Integer> min;
    public simple155() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (min.isEmpty()){
            min.push(x);
        }else {
            int temp;
            if (x>min.peek()){
                //如果x不是最小值，就放一个最小值在最小值栈
                temp = min.peek();
            }else {
                //如果x是新的最小值，将x放在栈顶
                temp = x;
            }
            min.push(temp);
        }
    }

    public void pop() {
        data.pop();
        //栈顶元素永远保持最小值，如果后续进来的有多个不是最小的，重复最小值压入了栈顶
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        //栈顶元素永远保持最小值
        return min.peek();
    }*/
}
