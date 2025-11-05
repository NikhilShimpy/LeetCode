class Solution {
    long sum = 0;
    TreeSet<int[]> main; 
    TreeSet<int[]> sec;  
    Map<Integer, Integer> freq;

    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        sum = 0;
        freq = new HashMap<>();

        Comparator<int[]> comp = (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        };

        main = new TreeSet<>(comp);
        sec = new TreeSet<>(comp);

        List<Long> reslist = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (j < n) {
            int num = nums[j];

            if (freq.getOrDefault(num, 0) > 0) {
                removeFromSet(new int[]{freq.get(num), num}, x);
            }

            freq.put(num, freq.getOrDefault(num, 0) + 1);

            insertInSet(new int[]{freq.get(num), num}, x);

            if (j - i + 1 == k) {
                reslist.add(sum);

                int outNum = nums[i];
                removeFromSet(new int[]{freq.get(outNum), outNum}, x);
                freq.put(outNum, freq.get(outNum) - 1);

                if (freq.get(outNum) == 0) {
                    freq.remove(outNum);
                } else {
                    insertInSet(new int[]{freq.get(outNum), outNum}, x);
                }

                i++;
            }

            j++;
        }

        long[] res = new long[reslist.size()];
        for (int idx = 0; idx < reslist.size(); idx++) {
            res[idx] = reslist.get(idx);
        }
        return res;
    }

    void insertInSet(int[] p, int x) {
        if (main.size() < x || comparePairs(p, main.first()) > 0) {
            sum += 1L * p[0] * p[1];
            main.add(p);

            if (main.size() > x) {
                int[] smallest = main.first();
                sum -= 1L * smallest[0] * smallest[1];
                main.remove(smallest);
                sec.add(smallest);
            }
        } else {
            sec.add(p);
        }
    }

    void removeFromSet(int[] p, int x) {
        if (main.contains(p)) {
            sum -= 1L * p[0] * p[1];
            main.remove(p);

            if (!sec.isEmpty()) {
                int[] largest = sec.last();
                sec.remove(largest);
                main.add(largest);
                sum += 1L * largest[0] * largest[1];
            }
        } else {
            sec.remove(p);
        }
    }

    int comparePairs(int[] a, int[] b) {
        if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
        return Integer.compare(a[1], b[1]);
    }
}
