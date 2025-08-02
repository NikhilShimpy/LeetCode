class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int minele = Integer.MAX_VALUE;

        for (int x : basket1) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
            minele = Math.min(minele, x);
        }

        for (int x : basket2) {
            mp.put(x, mp.getOrDefault(x, 0) - 1);
            minele = Math.min(minele, x);
        }

        ArrayList<Integer> finalList = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int cost = entry.getKey();
            int count = entry.getValue();

            if (count == 0) {
                continue;
            }

            if (count % 2 != 0) {
                return -1;
            }

            for (int c = 1; c <= Math.abs(count) / 2; c++) {
                finalList.add(cost);
            }
        }

        Collections.sort(finalList); 
        long res = 0;

        for (int i = 0; i < finalList.size() / 2; i++) {
            res += Math.min(finalList.get(i), minele * 2);
        }

        return res;
    }
}
