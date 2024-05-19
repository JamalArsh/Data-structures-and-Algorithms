import java.util.Stack;

public class Expression {
    public static boolean isBalance(String input){
        Stack<Character> stack = new Stack<>();

        for (char ch: input.toCharArray()){
            if (ch == '(' || ch == '<' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            if (ch == ')'|| ch == '>' || ch == '}' || ch == ']'){
                if(stack.empty()) return false;
                var top = stack.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == '>' && top != '<') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')
                ){
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static boolean isBalanceRefactored(String input){
        Stack<Character> stack = new Stack<>();

        for (char ch: input.toCharArray()){
            if (isLeftBracket(ch)){
                stack.push(ch);
            }
            if (isRightBracket(ch)){
                if(stack.empty()) return false;
                var top = stack.pop();

                if ( bracketsMatch(top, ch)
                ){
                    return false;
                }
            }
        }
        return stack.empty();
    }

    private static boolean isLeftBracket(char ch){
        return (ch == '(' || ch == '<' || ch == '{' || ch == '[');
    }

    private static boolean isRightBracket(char ch){
        return ch == ')'|| ch == '>' || ch == '}' || ch == ']';
    }

    private static boolean bracketsMatch(char left, char right){
        return (left == ')' && right != '(') ||
                (left == '>' && right != '<') ||
                (left == '}' && right != '{') ||
                (left == ']' && right != '[');
    }

}
