class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('b',0);
        map.put('a',0);
        map.put('l',0);
        map.put('o',0);
        map.put('n',0);

         for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            }
        }
        map.put('l', map.get('l') / 2);
        map.put('o', map.get('o') / 2);

        int min = Integer.MAX_VALUE;
        for (char ch : "balon".toCharArray()) {
            min = Math.min(min, map.get(ch));
        }

        return min;
       
    }
}

// optimize version 

class Solution {
    public int maxNumberOfBalloons(String text) {
       
        int b = 0, a = 0, l = 0, o = 0, n = 0;

        for (char ch : text.toCharArray()) {
            switch (ch) {
                case 'b': b++; break;
                case 'a': a++; break;
                case 'l': l++; break;
                case 'o': o++; break;
                case 'n': n++; break;
            }
        }
        l /= 2;
        o /= 2;

        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
    }
}

