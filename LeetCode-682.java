class Solution {
    public int calPoints(String[] operations) {
        int res = 0;
        List<Integer> list = new ArrayList<>();

        for (String op : operations) {
            if (op.equals("+")) {
                int size = list.size();
                int sum = list.get(size - 1) + list.get(size - 2);
                list.add(sum);
                res += sum;
            } else if (op.equals("D")) {
                int last = list.get(list.size() - 1);
                list.add(last * 2);
                res += last * 2;
            } else if (op.equals("C")) {
                res -= list.remove(list.size() - 1);
            } else {
                int num = Integer.parseInt(op);
                list.add(num);
                res += num;
            }
        }
        return res;
    }
}
