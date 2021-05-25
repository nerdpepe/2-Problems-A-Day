import java.util.Stack;

public class EvaluateRPNBetterSolution {

    static int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            
            if (!"+-*/".contains(token)) {
                stack.push(Integer.valueOf(token));
                continue;
            }
            
            int number2 = stack.pop();
            int number1 = stack.pop();
            
            int result = 0;
            
            switch (token) {
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":
                    result = number1 / number2;
                    break;
            }
            
            stack.push(result);
            
        }
        
        return stack.pop();
    }

    public static void main(String... arg) {
        String[] tokens = new String[]{"2","1","+","3","*"};
        int ans = evalRPN(tokens);
        System.out.println(ans);
    }
}