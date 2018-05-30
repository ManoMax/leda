package testMain;

import adt.stack.StackDoubleLinkedListImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class testSTDL {

	public static void main(String[] args) throws StackOverflowException, StackUnderflowException {
        StackDoubleLinkedListImpl<Integer> s6 = new StackDoubleLinkedListImpl<>(6);
        System.out.print(s6.isEmpty() == true ? "." : "F");
        try{ s6.pop(); } catch (StackUnderflowException e){System.out.print(".");}
        s6.push(2);
        System.out.print(s6.top() == 2 ? "." : "F");
        s6.push(17);
        System.out.print(s6.top() == 17 ? "." : "F");
        s6.push(4);
        System.out.print(s6.top() == 4 ? "." : "F");
        s6.push(17);
        System.out.print(s6.top() == 17 ? "." : "F");
        s6.pop();
        System.out.print(s6.top() == 4 ? "." : "F");
        s6.pop();
        System.out.print(s6.top() == 17 ? "." : "F");
        s6.pop();
        System.out.print(s6.top() == 2 ? "." : "F");
        s6.pop();
        try{ s6.pop(); } catch (StackUnderflowException e){System.out.print(".");}
        try{ s6.pop(); } catch (StackUnderflowException e){System.out.print(".");}
        s6.push(4);s6.push(1);s6.push(2);s6.push(3);s6.push(5);s6.push(90);
        System.out.print(s6.isFull() == true ? "." : "F");
        try{ s6.push(12); } catch (StackOverflowException e){System.out.print(".");}
        try{ s6.push(92); } catch (StackOverflowException e){System.out.print(".");}
    }
}
