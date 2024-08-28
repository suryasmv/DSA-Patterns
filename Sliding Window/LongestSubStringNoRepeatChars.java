import java.util.Set;
import java.util.HashSet;

public class LongestSubStringNoRepeatChars {
    
    public static int findSubString(String s){
        if(s.length() == 0) return 0;

        int start = 0;
        int end = 0;
        int max = 0;

        Set<Character> seen = new HashSet<>();

        while(end < s.length()){
            if(!seen.contains(s.charAt(end))){
                seen.add(s.charAt(end));
                max = Math.max(max, end - start + 1);
                end++;
            }else{
                seen.remove(s.charAt(start));
                start++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(findSubString("abcabcbb"));
    }
}
