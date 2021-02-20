package Container;

import java.util.LinkedList;
import java.util.Stack;

import static Container.Countries.print;

/**
 * @Classname Stacks
 * @Description TODO
 * @Date 2019/10/11 16:13
 * @Created by 14241
 */
enum Month {
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE,
    JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER
}

public class Stacks {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        for (Month m : Month.values())
            stack.push(m.toString());
        print("stack = " + stack);
        System.out.println();
        // Treating a stack as a Vector:
        stack.addElement("The last line");
        print("element 5 = " + stack.elementAt(5));
        System.out.println();
        print("popping elements:");
        while (!stack.empty())
            print(stack.pop() + " ");
        System.out.println();
        // Using a LinkedList as a Stack:
        LinkedList<String> lstack = new LinkedList<String>();
        for (Month m : Month.values())
            lstack.addFirst(m.toString());
        print("lstack = " + lstack);
        while (!lstack.isEmpty())
            print(lstack.removeFirst() + " ");
        System.out.println();
        // Using the Stack class from
        // the Holding Your Objects Chapter:
        Stack<String> stack2 =
                new Stack<String>();
        for (Month m : Month.values())
            stack2.push(m.toString());
        print("stack2 = " + stack2);
        System.out.println();
        while (!stack2.empty())
            print(stack2.pop() + " ");
        System.out.println();

    }
} /* Output:
stack = [JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER]
element 5 = JUNE
popping elements:
The last line NOVEMBER OCTOBER SEPTEMBER AUGUST JULY JUNE MAY APRIL MARCH FEBRUARY JANUARY lstack = [NOVEMBER, OCTOBER, SEPTEMBER, AUGUST, JULY, JUNE, MAY, APRIL, MARCH, FEBRUARY, JANUARY]
NOVEMBER OCTOBER SEPTEMBER AUGUST JULY JUNE MAY APRIL MARCH FEBRUARY JANUARY stack2 = [NOVEMBER, OCTOBER, SEPTEMBER, AUGUST, JULY, JUNE, MAY, APRIL, MARCH, FEBRUARY, JANUARY]
NOVEMBER OCTOBER SEPTEMBER AUGUST JULY JUNE MAY APRIL MARCH FEBRUARY JANUARY
*///:~

