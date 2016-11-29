import java.util.ArrayList;
import java.util.List;

/**
 *Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 For example, given n = 3, a solution set is:
 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<String>();
        if(n==0)
            return parenthesis;
        if(n==1){
            parenthesis.add("()");
            return parenthesis;
        }

        List<String> prevParenthesis = generateParenthesis(n-1);

        for(int i=0;i<prevParenthesis.size()-1;i++){
            String paren = prevParenthesis.get(i);
            parenthesis.add("("+paren+")");
            parenthesis.add("()"+paren);
            parenthesis.add(paren+"()");
        }

        String paren = prevParenthesis.get(prevParenthesis.size()-1);
        parenthesis.add("("+paren+")");
        parenthesis.add("()"+paren);

        return parenthesis;
    }
}
