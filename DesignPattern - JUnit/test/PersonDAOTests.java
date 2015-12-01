/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import mvcDemo1.model.Person;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jose.villagrana
 */
public class PersonDAOTests {
    
    public PersonDAOTests() {
    }
    
    /**
     * @BeforeClass
     * SETUPCLASS will run once before all tests methods.
     */
    @BeforeClass
    public static void setUpClass() {
        System.out.println("setup before class");
    }
    
    /**
     * @AfterClass
     * TEARDOWN will run once after all tests methods are completed.
     */
    @AfterClass
    public static void tearDownClass() {
        System.out.println("teardown after class");
    }
    
    /**
     * @Before
     * SETUP runs before every test method
     */
    @Before
    public void setUp() {
        System.out.println("setup");
    }
    /**
     * @After
     * TEARDOWN will run after every test method
     */
    @After
    public void tearDown() {
        System.out.println("teardown");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testDemo() {
         //assert.fail()
         //fail();
         int value = 7;
         value += 2;
         System.out.println("Running demo tests");
         assertEquals("check arithmitic works in java",9, value);
     }
     
     @Test
     public void testCreate(){
         Person p1 = new Person("Bob", "123");
         Person p2 = new Person("Ed", "hello");
         
     }
}
