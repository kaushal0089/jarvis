package in.kkd.programs;

import java.util.Stack;

public class BalancedParenthesis {
    public static void main(String[] args){
        String inputStr = "{}";
        if(checkBalanced(inputStr)){
            System.out.println("Given String is Balanced");
        }
        else System.out.println("Not a balanced String");
    }

    public static Boolean checkBalanced(String inputStr){
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<inputStr.length();i++){
            Character ch = inputStr.charAt(i);
            if(ch=='{' || ch=='[' || ch=='(') {
                stack.push(ch);
            }
            switch (ch){
                case ']' :
                    if(stack.empty() || !stack.pop().equals('['))
                        return false; break;
                case '}' :
                    if(stack.empty() || !stack.pop().equals('{'))
                        return false; break;
                case ')' :
                    if(stack.empty() || !stack.pop().equals('('))
                        return false; break;
            }
        }
        return stack.empty();
    }
}
