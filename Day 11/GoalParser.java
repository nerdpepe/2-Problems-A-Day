public class GoalParser {
    static String interpret(String command) {
        String ans = "";

        //loop from start to end
        for(int i = 0; i<command.length(); i++) {
            if(command.charAt(i) == 'G')
                ans = ans + "G";
            else if(command.charAt(i+1) == ')') {
                    ans += "o";
                    i += 1;
                } else {
                    ans += "al";
                    i += 3;
                    }
            }
        return ans;
    }

    public static void main(String ...arg) {
        String command = "(al)G(al)()()G";
        System.out.println(interpret(command));
    }
}