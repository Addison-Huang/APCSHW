/*****************************************************
 * class Stckr
* driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 *****************************************************/
/*
Driver Class made by: Addison Huang
*/
public class Stckr 
{
public static void main( String[] args )
{
    Stack<String> cakes = new ALStack<String>();
    System.out.println(cakes.isEmpty()); //true
    cakes.push("zoo");
    cakes.push("moo");
    cakes.push("poo");
    cakes.push("doo");
    cakes.push("coo");
    cakes.push("boo");
    cakes.push("foo");
    cakes.push("goo");
    System.out.println(cakes.peek()); //goo
    System.out.println(cakes.pop()); //goo
    System.out.println(cakes.pop()); //foo
    System.out.println(cakes.pop()); //boo
    System.out.println(cakes.pop()); //coo
    System.out.println(cakes.pop()); //doo
    System.out.println(cakes.pop()); //poo
    System.out.println(cakes.pop()); //moo
    System.out.println(cakes.pop()); //zoo
    Stack<Integer> cake = new LLStack<Integer>();
    System.out.println(cake.isEmpty()); //true
    for (int i = 0; i < 10; i++) {
	cake.push(i);
    }
    System.out.println(cake.peek()); //9
    System.out.println(cake.pop()); //9
    System.out.println(cake.pop()); //8
    System.out.println(cake.pop()); //7
    System.out.println(cake.pop()); //6
    System.out.println(cake.pop()); //5
    System.out.println(cake.pop()); //4
    System.out.println(cake.pop()); //3
    System.out.println(cake.pop()); //2
    System.out.println(cake.pop()); //1
    System.out.println(cake.pop()); //0
}

}//end class

