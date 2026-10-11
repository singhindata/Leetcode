import java.util.HashMap;
import java.util.Map;

public class L3_longestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for(int right =0;right<s.length();right++){
            char c = s.charAt(right);
            
            if(map.containsKey(c)){

                left = Math.max(left, map.get(c)+1);
            }
            map.put(c,right);

            maxLength = Math.max(maxLength,right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "crow";
        String s3 = "www";

        System.out.println(lengthOfLongestSubstring(s1));
        System.out.println(lengthOfLongestSubstring(s2));
        System.out.println(lengthOfLongestSubstring(s3));
    }
}