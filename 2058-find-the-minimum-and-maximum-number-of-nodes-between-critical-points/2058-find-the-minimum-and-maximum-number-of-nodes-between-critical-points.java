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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int firstcriticalidx = 0;
        int prevcriticalidx = 0;

        int prevval = 0;
        int currval = 0;
        int nextval = 0;

        int mindist = Integer.MAX_VALUE;
        int idx = 0;
        int[] res = {-1, -1};

        while (head != null) {
            prevval = currval;
            currval = nextval;
            nextval = head.val;

            if (prevval != 0 && currval != 0 && nextval != 0 && 
                ((prevval > currval && currval < nextval) ||
                (prevval < currval && currval > nextval))) {
                
                if (firstcriticalidx == 0) {
                    firstcriticalidx = idx;
                } else {
                    mindist = Math.min(mindist, idx - prevcriticalidx);
                    res[0] = mindist;
                    res[1] = idx - firstcriticalidx;
                }
                prevcriticalidx = idx;
            }

            idx++;
            head = head.next;
        }

        return res;
    }
}