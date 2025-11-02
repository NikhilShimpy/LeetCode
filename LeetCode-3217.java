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
    public ListNode modifiedList(int[] nums, ListNode head) {
        java.util.HashSet<Integer> mpp = new java.util.HashSet<>();
        for (int x : nums) mpp.add(x);
        while (head != null && mpp.contains(head.val)) head = head.next;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            while (curr.next != null && mpp.contains(curr.next.val)) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return head;
    }
}

// solution 2 
class Solution {
    public ListNode modifiedList(List<Integer> v, ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode t = dummy;
        Set<Integer> s = new HashSet<>(v);
        
        while (head != null) {
            if (!s.contains(head.val)) {
                t.next = head;
                t = t.next;
            }
            head = head.next;
        }
        
        t.next = null;
        return dummy.next;
    }
}
