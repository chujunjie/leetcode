package solutions.datastructure;

/**
 * @Description: 常数时间内检索到最小元素的栈
 * @Author: chujunjie
 * @Date: Create in 11:10 2020/2/7
 * @Modified By
 */
public class MinStack {

    private int maxLength = 100;
    private int[] data = new int[maxLength];
    private int[] min = new int[maxLength];
    private int length = 0;

    public void push(int x) {
        if (length >= maxLength) {
            // 扩容
            maxLength = length << 1;

            int[] b = new int[maxLength];
            for (int i = 0; i < data.length; i++) {
                b[i] = data[i];
            }
            data = b;

            int[] c = new int[maxLength];
            for (int i = 0; i < min.length; i++) {
                c[i] = min[i];
            }
            min = c;
        }
        min[length] = length == 0 ? x : Math.min(x, min[length - 1]);
        data[length++] = x;
    }

    public void pop() {
        length--;
    }

    public int top() {
        return data[length - 1];
    }

    public int getMin() {
        return min[length - 1];
    }
}
