package solutions.easy;

import java.util.Stack;

/**
 * @Description: 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * @Author: chujunjie
 * @Date: Create in 10:54 2020/2/7
 * @Modified By
 */
public class Solution155 {

    // 数据栈
    private Stack<Integer> data;
    // 辅助栈
    private Stack<Integer> helper;

    /**
     * initialize your data structure here.
     */
    public Solution155() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        // 数据栈和辅助栈一定会增加元素
        data.add(x);
        if (helper.isEmpty() || helper.peek() >= x) {
            helper.add(x);
        } else {
            helper.add(helper.peek());
        }
    }

    public void pop() {
        // 两个栈都得 pop
        if (!data.isEmpty()) {
            helper.pop();
            data.pop();
        }
    }

    public int top() {
        if (!data.isEmpty()) {
            return data.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    public int getMin() {
        if (!helper.isEmpty()) {
            return helper.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    public static void main(String[] args) {
        Solution155 obj = new Solution155();
        obj.push(4);
        obj.push(5);
        obj.push(6);
        obj.push(7);
        obj.push(3);
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }
}
