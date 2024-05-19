import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//        MyArray arr = new MyArray(3);
//        arr.insert(10);
//        arr.insert(20);
//        arr.insert(30);
//        arr.insert(40);
//        arr.print();
        String myString = "HelloWorld";

        Stack<Character> stack = new Stack<>();

        for (int i=0; i< myString.length(); i++){
            stack.push(myString.charAt(i));
        }
        System.out.println(stack);

        StringBuilder newString = new StringBuilder();

        while (!stack.isEmpty()){
            newString.append(stack.pop());
        }

        System.out.println(newString);

    }
}
