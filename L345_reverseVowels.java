class L345_reverseVowels {
    public static String reverseVowels(String s) {
        if (s == null || s.length() <= 1)
            return s;
        char[] c = s.toCharArray();

        int left = 0;
        int right = c.length - 1;
        String vowels = "AEIOUaeiou";

        while (left < right) {

            while (left < right && vowels.indexOf(c[left]) == -1)
                left++;
            while (left < right && vowels.indexOf(c[right]) == -1)
                right--;

            if (left < right) {
                char temp = c[left];
                c[left] = c[right];
                c[right] = temp;
                left++;
                right--;
            }
        }
        return new String(c);
    }

    public static void main(String[] args) {
        String s = "IceCreAm";
        System.out.println(reverseVowels(s));

        /*
         * Approach:
         * Approach: Two-pointer strategy (optimal solution).
         * First, I stored all vowels in a lookup string and used indexOf() to check if
         * the current characters are vowels. Then, I incremented/decremented the
         * pointers
         * to find matches and swapped them.
         * time complexity O(N) and space complexity O(N)
         */

    }
}