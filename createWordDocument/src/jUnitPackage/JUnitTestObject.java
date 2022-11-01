package jUnitPackage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.TestObject;

public class JUnitTestObject {

	/*
	
	Error:			Something went wrong - Exception or else
	Failure:		Test case fail
	 
	
	
	The order for tests are:
	
	@BeforeClasse:	The annotation "@BeforeClasse" executes methods before a certain class
					Available in JUnit 5
	
	Start - Test of one method
	@Before:		The annotation "@Before" indicates, that this test has to be executed before every other test
					This is good for initialize variables and objects that are needed for other tests
				
	@Test:			The actual test case
	
	@After:			Runs after completion of testcase
					Similiar to "@Before" the "@After" indicates, that this test has to be executed after every other test
					This is good for cleaning up like free memory, delete all instances
	End - Test of one Method				
	
	
	@Before
	@Test
	@After
	
	
	@AfterClass:	Runs after each test case is finished
	
	
	*/
	
	
	private TestObject jUnitTestObject = null;
	
	@Before
	public void createObject() throws Exception {
		
		System.out.println("Create tests for class TestObject");
		
		jUnitTestObject = new TestObject();
		jUnitTestObject.setObjectText("Hello World");
		
	}
	
	
	@Test
	public void isObjectCreated() {
		
		assertNotNull(jUnitTestObject);
		System.out.println("TestObject created");
		
	}
	
	@Test
	public void isObjectNotCreated() {
		
		// Will fail
		assertNull(jUnitTestObject);
		System.out.println("TestObject not created yet");
		
	}
	

	@Test
	public void testBooleanVariableIfTrue() {
		
		boolean testVariable = jUnitTestObject.isCreated();
		assertTrue(testVariable);
		System.out.println("is boolean variable true?");
		
	}
	
	@Test
	public void testBooleanVariableIfFalse() {
		
		boolean testVariable = jUnitTestObject.isCreated();
		assertFalse(testVariable);
		System.out.println("is boolean variable true?");
		
	}
	
	@Test
	public void compareObjectText() {
		
		System.out.println("Test object's text");
		
		String testText = "Hello World";
		String objectText = jUnitTestObject.getObjectText();
		
		assertEquals(testText, objectText);
		
	}
	
	@Test
	public void areTwoObjectsIdentical() {
		
		TestObject expectedObject = jUnitTestObject;
		assertSame(expectedObject, jUnitTestObject);
		
	}
	
	@Test
	public void areTwoObjectsNotIdentical() {
		
		TestObject expectedObject = jUnitTestObject;
		assertNotSame(expectedObject, jUnitTestObject);
		
	}
	
	@After
	public void tearDown() throws Exception {
		/*
		System.out.println("Test whether test object is deleted");
		
		boolean isDeleted = jUnitTestObject.isDeleted();
		
		assertTrue(isDeleted);
		*/
	}
	
	
}
