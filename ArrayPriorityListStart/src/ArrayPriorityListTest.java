// Unit test for ArrayPriorityList<E> implements PriorityList<E>
import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayPriorityListTest {

	@Test
	public void testInsertToLeft() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		// Must shift array elements in this case
		list.insertElementAt(0, "New First");
		assertEquals("New First", list.getElementAt(0));
		assertEquals("First", list.getElementAt(1));
	}

	// Write short test methods to ensure methods throw exceptions
	// when they are supposed to throw new IllegalArgumentException();
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionGetElementAtZeroWhenSizeIsZero() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.getElementAt(0);
		
	}

	@Test
	public void testinsertAndget() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "second");
		list.insertElementAt(0, "new first");
		assertEquals(3, list.size());
		assertEquals("new first", list.getElementAt(0));
		assertEquals("First", list.getElementAt(1));
		assertEquals("second", list.getElementAt(2));
		PriorityList<String> listt = new ArrayPriorityList<String>();
		listt.insertElementAt(0, "5");
		listt.insertElementAt(0, "4");
		listt.insertElementAt(0, "3");
		listt.insertElementAt(0, "2");
		listt.insertElementAt(0, "1");
		listt.insertElementAt(0, "6");
		assertEquals("6", listt.getElementAt(0));
		assertEquals("1", listt.getElementAt(1));
		assertEquals("2", listt.getElementAt(2));
		assertEquals("3", listt.getElementAt(3));
		assertEquals("4", listt.getElementAt(4));
		assertEquals("5", listt.getElementAt(5));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testInsertThrowsException() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(1, "Must start with 0");

	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetThrowsException() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.getElementAt(-2);
		PriorityList<String> listt = new ArrayPriorityList<String>();
		listt.getElementAt(15);
	}

	@Test
	public void testsize() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(0, "New First");
		assertEquals(2, list.size());
		PriorityList<String> list1 = new ArrayPriorityList<String>();
		assertEquals(0, list1.size());
	}

	@Test
	public void testisEmpty() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(0, "New First");
		assertEquals(false, list.isEmpty());
		PriorityList<String> list1 = new ArrayPriorityList<String>();
		assertEquals(true, list1.isEmpty());

	}

	@Test
	public void testtoArray() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		
		list.insertElementAt(0, "d");
		list.insertElementAt(0, "c");
		list.insertElementAt(0, "b");
		list.insertElementAt(0, "a");
		Object[] Jack = new Object[5];
		Jack = list.toArray();
		assertEquals("a", Jack[0]);
		assertEquals("b", Jack[1]);
		assertEquals("c", Jack[2]);
		assertEquals("d", Jack[3]);
		
	
	}
	
	
	@Test
	public void testtoArraywhennequals0() {
		PriorityList<String> error = new ArrayPriorityList<String>();
		Object[] list = new Object[0];
		list = error.toArray();
	}

	@Test
	public void testremoveElementAt() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "5");
		list.insertElementAt(0, "4");
		list.insertElementAt(0, "3");
		list.insertElementAt(0, "2");
		list.insertElementAt(0, "1");
		list.removeElementAt(2);
		assertEquals("1", list.getElementAt(0));
		assertEquals("2", list.getElementAt(1));
		assertEquals("4", list.getElementAt(2));
		assertEquals("5", list.getElementAt(3));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testremoveThrowsException() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "5");
		list.insertElementAt(0, "4");
		list.insertElementAt(0, "3");
		list.insertElementAt(0, "2");
		list.insertElementAt(0, "1");
		list.removeElementAt(-2);
		PriorityList<String> listt = new ArrayPriorityList<String>();
		listt.insertElementAt(0, "a");
		listt.insertElementAt(0, "b");
		listt.insertElementAt(0, "b");
		listt.insertElementAt(0, "b");
		listt.insertElementAt(0, "v");
		listt.removeElementAt(15);
	}

	@Test
	public void testlowerPriorityOf() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "a");
		list.insertElementAt(0, "b");
		list.lowerPriorityOf(0);
		assertEquals("a", list.getElementAt(0));
		assertEquals("b", list.getElementAt(1));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testlowerPriorityOfThrowsException() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "a");
		list.insertElementAt(0, "b");
		list.lowerPriorityOf(-2);
		PriorityList<String> listt = new ArrayPriorityList<String>();
		listt.insertElementAt(0, "z");
		listt.insertElementAt(0, "x");
		listt.lowerPriorityOf(15);

	}

	@Test
	public void testraisePriorityOf() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "a");
		list.insertElementAt(0, "b");
		list.raisePriorityOf(1);
		assertEquals("a", list.getElementAt(0));
		assertEquals("b", list.getElementAt(1));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testraisePriorityOfThrowsException() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "a");
		list.insertElementAt(0, "b");
		list.insertElementAt(0, "b");
		list.raisePriorityOf(-2);
		PriorityList<String> listt = new ArrayPriorityList<String>();
		listt.insertElementAt(0, "c");
		listt.insertElementAt(0, "b");
		listt.insertElementAt(0, "a");
		listt.raisePriorityOf(15);
	}

	@Test
	public void testmoveToLast() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "e");
		list.insertElementAt(0, "d");
		list.insertElementAt(0, "c");
		list.insertElementAt(0, "b");
		list.insertElementAt(0, "a");
		list.moveToLast(1);
		assertEquals("a", list.getElementAt(0));
		assertEquals("c", list.getElementAt(1));
		assertEquals("d", list.getElementAt(2));
		assertEquals("e", list.getElementAt(3));
		assertEquals("b", list.getElementAt(4));
		PriorityList<String> listt = new ArrayPriorityList<String>();
		listt.insertElementAt(0, "1");
		listt.insertElementAt(0, "2");
		listt.insertElementAt(0, "3");
		listt.insertElementAt(0, "4");
		listt.insertElementAt(0, "5");
		listt.moveToLast(2);
		assertEquals("5", listt.getElementAt(0));
		assertEquals("4", listt.getElementAt(1));
		assertEquals("2", listt.getElementAt(2));
		assertEquals("1", listt.getElementAt(3));
		assertEquals("3", listt.getElementAt(4));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testmoveToLastThrowsException() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "e");
		list.insertElementAt(0, "d");
		list.insertElementAt(0, "c");
		list.insertElementAt(0, "b");
		list.insertElementAt(0, "a");
		list.moveToLast(-2);
		PriorityList<String> listt = new ArrayPriorityList<String>();
		listt.insertElementAt(0, "1");
		listt.insertElementAt(0, "2");
		listt.insertElementAt(0, "3");
		listt.insertElementAt(0, "4");
		listt.moveToLast(15);

	}

	@Test
	public void testmoveToTop() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "e");
		list.insertElementAt(0, "d");
		list.insertElementAt(0, "c");
		list.insertElementAt(0, "b");
		list.insertElementAt(0, "a");
		list.moveToTop(1);
		assertEquals("b", list.getElementAt(0));
		assertEquals("a", list.getElementAt(1));
		assertEquals("c", list.getElementAt(2));
		assertEquals("d", list.getElementAt(3));
		assertEquals("e", list.getElementAt(4));
		PriorityList<String> listt = new ArrayPriorityList<String>();
		listt.insertElementAt(0, "e");
		listt.insertElementAt(0, "d");
		listt.insertElementAt(0, "c");
		listt.insertElementAt(0, "b");
		listt.insertElementAt(0, "a");
		listt.moveToTop(2);
		assertEquals("c", listt.getElementAt(0));
		assertEquals("a", listt.getElementAt(1));
		assertEquals("b", listt.getElementAt(2));
		assertEquals("d", listt.getElementAt(3));
		assertEquals("e", listt.getElementAt(4));
		listt.moveToTop(0);
		assertEquals("c", listt.getElementAt(0));
		assertEquals("a", listt.getElementAt(1));
		assertEquals("b", listt.getElementAt(2));
		assertEquals("d", listt.getElementAt(3));
		assertEquals("e", listt.getElementAt(4));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testmoveToTopThrowsException() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "e");
		list.insertElementAt(0, "d");
		list.insertElementAt(0, "c");
		list.insertElementAt(0, "b");
		list.insertElementAt(0, "a");
		list.moveToTop(-2);

	}

} // End unit test for ArrayPriorityList
