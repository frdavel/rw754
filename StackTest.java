/** Junit4 test cases for Stack.java
 *  @Author Francois Davel 16119657
 *
 *  General Comments of the test suite.
 *
 *  The implementation of Stack.java is very
 *  naive as it does not throw any exceptions
 *  regarding the stack. Rather it throws
 *  exceptions of the underlying java data
 *  structures which is not good coding
 *  practice.
 *
 *  Assert.fail() can be used if something 
 *  illegal is done but the program keeps on 
 *  executing, so Assert.fail() fails the 
 *  test case immedately.
 *                                          */

import static org.junit.Assert.*;
import org.junit.*;

public class StackTest {
    private Stack stackFull;
    private Stack stackEmpty;
    private final int TEST_STACK_SIZE = 100;
    private char LAST_STACK_ITEM;

    /** 
     * Creating 2 stacks one stack is full 
     * the other is empty, the Before tag 
     * will run this method before every 
     * test to ensure each test is 
     * independant of each other.            */
    @Before
    public void setUp() {
        stackFull = new Stack(TEST_STACK_SIZE);
        
        for (int i = 0; i < TEST_STACK_SIZE; i++) {
            char c = 'A';
            LAST_STACK_ITEM = c;
            stackFull.push(c++);
            if (((int) c) > 90) {
                c = 'A';
            }
        }

        stackEmpty = new Stack(TEST_STACK_SIZE);
    }
    
    /** 
     *  In the following case a stack is 
     *  initialised but it is of length  
     *  0 so this is a trivial example of 
     *  using setup in an incorrect way.      */
/*    @Before
    public void setUp() {
        stackEmpty = new Stack(0);
    }    
*/

    /** In the tear down function the stacks
     *  are made null to ensure the java     
     *  garbage collector removes the stack  
     *  from memory, this function will run  
     *  after every test case.               */
    @After
    public void tearDown() {
        stackEmpty = null;
        stackFull = null;
    }

    /** Test req1_1 tries to pop an element
     *  off an empty stack, this should give 
     *  an empty stack but it gives an error
     *  ArrayOutOfBoundsException as there is
     *  no check in the Stack.                */
    @Test
    public void req1_1() {
        try {
            stackEmpty.pop();
            System.out.println("req1_1: true");
        } catch (Exception e) {
            System.err.print("req1_1: " + (Integer.parseInt(e.getMessage()) == 0));
            System.err.println(" Stack out of bounds at index: "+ e.getMessage());
            Assert.fail();
        }
    }

    /** Test req1_2 tries to pop an element
     *  off a full stack and will throw an
     *  exception if the element cannot be
     *  popped off.                         */
    @Test
    public void req1_2() {
        try {
            stackFull.pop();
            Assert.assertFalse(stackFull.empty());
            System.out.println("req1_2: true");
        } catch (Exception e) {
            System.err.println("req1_2: false");
            System.err.print("Popped an element off a full stack at index: ");
            System.err.println(e.getMessage());
            Assert.fail();
        }

    }

    /** Test req1_3 pops off all the 
     *  elements in the stack, and will
     *  throw an error if the stack does not 
     *  contain all the elements added in 
     *  the setUp function.                 */
    @Test
    public void req1_3() {
        try {
            for (int i = 0; i < TEST_STACK_SIZE; i++) {
                stackFull.pop();
            }
            Assert.assertTrue(stackFull.empty());
            System.out.println("req1_3: true");
        } catch (Exception e) {
            System.err.println("Test: req1_3");
            System.err.print("Popped all elements off a full ");
            System.err.println("stack at out of bounds index: " + e.getMessage());
            Assert.fail();
        }

    }

    /** Test req2_1 pushes an element on the 
     *  stack then pops the element off the
     *  stack, then verifies that the 
     *  elements are the same.              */
    @Test
    public void req2_1() {
        char a = 'A';
        try {
            stackEmpty.push(a);
            Assert.assertTrue(stackEmpty.pop() == a);
            System.out.println("req2_1: true");
        } catch (Exception e) {
            System.err.print("req2_1: false");
            System.err.println(" Element was not the same as pushed on.");
            Assert.fail();
        }
    }

    /** Test req2_2 pops the last element 
     *  off the full stack and checks if
     *  that element is the same as the 
     *  one added at setUp.                 */
    @Test
    public void req2_2() {
        char a = stackFull.pop();
        try {
            Assert.assertTrue("req2_2: ", LAST_STACK_ITEM == a);
            System.out.println("req2_2: true");
        } catch (Exception e) {
            System.err.print("req2_2: false ");
            System.err.println("Element on the end of the stack not the same as the last element added.");
            Assert.fail();
        }
    }

    /** Test req3_1 checks the peek on 
     *  an empty stack, method should
     *  throw an exception.
     *  @answer ArrayOutOfBoundsException  */
    @Test
    public void req3_1() {
        try {
            char a = stackEmpty.peek();
            System.err.println("req3_1: false, method should throw an Exception.");
            Assert.assertTrue(false);
        } catch (Exception e) {
            System.out.println("req3_1: true");
            Assert.assertTrue(true);
        }
    }

    /** Test req3_2 checks the peek on
     *  the full stack with the last 
     *  item added.                         */
    @Test
    public void req3_2() {
        char a = stackFull.peek();
        Assert.assertTrue(a == LAST_STACK_ITEM);
        System.out.println("req3_2: true");
    }

    /** Test req4 pushes an item on
     *  to the stack and checks 
     *  whether the peek and the item
     *  pushed on to the stack are the 
     *  same.                               */
    @Test
    public void req4() {
        char a = 'X';
        stackEmpty.push(a);
        Assert.assertTrue(stackEmpty.peek() == a);
        System.out.println("req4: true");
    }


    /** Test req5_1 checks whether an empty
     *  stack is empty.                     */
    @Test
    public void req5_1() {
        Assert.assertTrue(stackEmpty.empty());
        System.out.println("req5_1: true");
    }

    /** Test req5_2 checks whether an empty
     *  stack is empty after an element is 
     *  pushed to the stack then popped off
     *  the stack.                          */
    @Test
    public void req5_2() {
        stackEmpty.push('a');
        stackEmpty.pop();
        Assert.assertTrue(stackEmpty.empty());
        System.out.println("req5_2: true");
    }


    /** Test req6_1 checks if an item is 
     *  pushed on to the stack must not be
     *  empty anymore.                      */
    @Test
    public void req6_1() {
        stackEmpty.push('a');
        Assert.assertFalse(stackEmpty.empty());
        System.out.println("req6_1: true");
    }

    /** Test req6_2 pushes more items onto
     *  the stack then the size of the stack
     *  will except an error.              */
    @Test
    public void req6_2() {
        try {
            stackFull.push('a');
            Assert.assertTrue(false);
            System.err.println("req6_2: false, stack overfill.");
        } catch (Exception e) {
            System.out.print("req6_2: true ");
            System.out.println("Exception thrown at array index " + e.getMessage());
        }
    }


}
