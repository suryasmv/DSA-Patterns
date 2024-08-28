import java.util.Map;
import java.util.HashMap;

class MinimumWindowSubstring {

    public static String minString(String s, String t){

        Map<Character, Integer> tChars = new HashMap<>();

        for(Character c : t.toCharArray()){
            tChars.put(c, tChars.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int sIndex = -1;

        for(int r = 0; r<s.length(); r++){
            if(!tChars.containsKey(s.charAt(r))){
                continue;
            }

            if(tChars.get(s.charAt(r)) > 0) count++;
            tChars.put(s.charAt(r), tChars.get(s.charAt(r)) - 1);

            while(count == t.length()){
                if(r-l+1 < minLen){
                    minLen = r-l+1;
                    sIndex = l;
                }

                if(tChars.containsKey(s.charAt(l))){
                    tChars.put(s.charAt(l), tChars.get(s.charAt(l)) +1);
                    if(tChars.get(s.charAt(l)) > 0){
                        count--;
                    }
                }
                l++;
            }
        }
        return sIndex == -1 ? "" : s.substring(sIndex, sIndex+minLen);
    }

    public static void main(String[] args) {
        System.out.println(minString("ADOBECODEBANC", "ABC"));
    }
}