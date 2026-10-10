import java.util.Stack;

public class L2390_removeStars {
    public static String removeStars(String s) {
        Stack<Character> st = new Stack<>();

        for(char a: s.toCharArray()){
            if(a=='*'){
                st.pop();
            }
            else{
            st.push(a);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.empty()){
            sb.append(st.pop());
        }

    return sb.reverse().toString();
        
    }
    public static void main(String[] args) {
        String s= "leet**cod*e";
        System.out.println(removeStars(s));
    }
}
