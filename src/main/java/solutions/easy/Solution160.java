package solutions.easy;

import solutions.datastructure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 编写一个程序，找到两个单链表相交的起始节点。
 * @Author: chujunjie
 * @Date: Create in 11:27 2020/2/7
 * @Modified By
 */
public class Solution160 {

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null && headB == null) {
            return null;
        }

        ListNode pA = headA, pB = headB;

        // 指针 pA 指向 A 链表，指针 pB 指向 B 链表，依次往后遍历
        // 如果 pA 到了末尾，则 pA = headB 继续遍历
        // 如果 pB 到了末尾，则 pB = headA 继续遍历
        // 比较长的链表指针指向较短链表head时，长度差就消除了
        // 如此，只需要将最短链表遍历两次即可找到位置
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> nodes = new HashSet<>();
        while (headA != null) {
            nodes.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (nodes.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(1);

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(0);
        ListNode b3 = new ListNode(1);

        ListNode c1 = new ListNode(8);
        ListNode c2 = new ListNode(4);
        ListNode c3 = new ListNode(5);

        a1.next = a2;
        a2.next = c1;

        b1.next = b2;
        b2.next = b3;
        b3.next = c1;

        c1.next = c2;
        c2.next = c3;

        ListNode node = getIntersectionNode2(a1, b1);
        System.out.println(node);
        System.out.println(node.val);
    }
}
