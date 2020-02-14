package solutions.easy;

import solutions.datastructure.ListNode;

/**
 * @Description: 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * @Author: chujunjie
 * @Date: Create in 19:28 2020/2/2
 * @Modified By
 */
public class Solution83 {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;

        ListNode listNode = deleteDuplicates(a);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
