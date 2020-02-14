package solutions.easy;

import solutions.datastructure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * @Author: chujunjie
 * @Date: Create in 18:29 2020/2/6
 * @Modified By
 */
public class Solution141 {

    /**
     * 快慢双指针
     *
     * @param head
     * @return
     */
    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * hash表
     *
     * @param head
     * @return
     */
    public static boolean hasCycle1(ListNode head) {
        Set<ListNode> node = new HashSet<>();
        while (head != null) {
            if (node.contains(head)) {
                return true;
            } else {
                node.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = a;

        System.out.println(hasCycle2(a));
    }
}
