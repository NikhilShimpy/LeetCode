class Solution {
    int search(int[] nd, int day) {
        if (nd[day] != day) {
            nd[day] = search(nd, nd[day]);
        }
        return nd[day];
    }

    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]);

        int[] nd = new int[events[events.length - 1][1] + 2];
        for (int d = 0; d < nd.length; d++) {
            nd[d] = d;
        }

        int count = 0;
        for (int[] evt : events) {
            int s = evt[0];
            int e = evt[1];
            int day = search(nd, s);
            if (day <= e) {
                count++;
                nd[day] = search(nd, day + 1);
            }
        }

        return count;
    }

}
