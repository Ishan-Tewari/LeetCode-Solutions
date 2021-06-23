/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    ListNode curr;
    ListNode prev;

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head.next == null) return head;

        ListNode prevStart = null;
        ListNode start = head;

        int size = right - left;

        while (left-- >= 2){
            prevStart = start;
            start = start.next;
        }

        System.out.println(size + " " + (right) + " " + (left));
        ListNode reversedSection = reverseList(start, size+1);

        if (prevStart == null){
            start.next = curr;
            prevStart = prev;
            head = prev;
        }

        else{
            start.next = curr;
            prevStart.next = prev;
        }

        return head;
    }

    public ListNode reverseList(ListNode head, int size){
        prev = null;
        curr = head;
        ListNode next = curr.next;

        while (size-- != 0){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
        return head;
    }
}
