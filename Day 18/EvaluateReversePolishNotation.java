import java.util.Stack;

public class EvaluateReversePolishNotation {

    static String process(Stack<Integer> numStack, String operator) {
        int rhs = numStack.pop();
        int lhs = numStack.pop();

        if(operator.equals("+"))
            return Integer.toString(lhs + rhs);
        else if(operator.equals("-"))
            return Integer.toString(lhs - rhs);
        else if(operator.equals("*"))
            return Integer.toString(lhs * rhs);
        else
            return Integer.toString(lhs/rhs);
        
    }

    static int evalRPN(String[] tokens) {

        Stack<String> tokenStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        for(int i = tokens.length - 1 ; i>=0; i--) {
            tokenStack.push(tokens[i]);
        }

        while(!tokenStack.empty()) {
            String token = tokenStack.pop();
            if(token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")) {
                String op = process(numStack, token);
                tokenStack.push(op); 
            } else {
                numStack.push(Integer.valueOf(token));
            }
        }

        int answer = numStack.pop();
        return answer;
        
    }

    public static void main(String... arg) {
        String[] tokens = new String[]{"2","1","+","3","*"};
        int ans = evalRPN(tokens);
        System.out.println(ans);
    }
}