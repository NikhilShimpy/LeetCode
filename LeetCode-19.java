class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode temp = head;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        if (n == len) {
            return head.next;
        }

        temp = head;
        for (int i = 1; i < len - n; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }
}
