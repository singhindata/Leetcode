public class L1119_removeVowels {
   
    public static String removeVowels(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            String vowels = "AEIOUaeiou";
            if(vowels.indexOf(c)==-1){
                sb.append(c);
            }
        }

        return sb.toString();
    }
    public static String noVowels(String s){
        return  s.replaceAll("[AEIOUaeiou]","");
    }
    
    public static void main(String[] args) {
        String str = "cauliflower";
        String str2 = "education";
        // output  = clflwr;

       System.out.println(removeVowels(str));
       System.out.println(noVowels(str2));



    }
}
