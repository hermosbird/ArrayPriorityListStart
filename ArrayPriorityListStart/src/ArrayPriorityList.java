/**
 * This class implements a generic collection to store elements where indexes
 * represent priorities and the priorities can change in several ways.
 *
 * @author Rick Mercer
 * @param <E>
 *            The type of all elements stored in this collection
 */
public class ArrayPriorityList<E> implements PriorityList<E> {

	public static final int INIITIAL_CAPACITY = 10;

	public static final int GROW_SHRINK_INCREMENT = 10;

	private Object[] data; // The data structure storing elements
	private int n; // The number of meaningful elements

	// Create an empty list with zero elements
	public ArrayPriorityList() {
		data = new Object[INIITIAL_CAPACITY];

		n = 0;
	}

	/**
	 * Return the number of elements currently in this PriorityList
	 *
	 * @return The number of elements in this PriorityList
	 */

	public int size() {

		return n;
	}

	/**
	 * Return true if there are zero elements in this PriorityList
	 *
	 * @return true if size() == 0 or false if size() > 0
	 */
	public boolean isEmpty() {
		boolean result = true;
		if (size() > 0)
			result = false;
		return result;

	}

	/**
	 * If possible, insert the element at the given index. If index is out of
	 * the valid range of 0..size(), throw new IllegalArgumentException(); When
	 * size is 3, the only possible values for index are 0, 1, 2, AND 3 because
	 * you can add an element as the new last.
	 *
	 * @param index
	 *            The index of the element to move.
	 * @param el
	 *            The element to insert
	 * @throws IllegalArgumentException
	 */
	public void insertElementAt(int index, E el)
			throws IllegalArgumentException {
		if (index < 0 || index > size())
			throw new IllegalArgumentException("" + index);

		for (int i = size(); i > index; i--)
			data[i] = data[i - 1];

		data[index] = el;
		n++;

	}

	/**
	 * If possible, return a reference to the element at the given index. If
	 * index is out of the valid range of 0..size()-1, throw new
	 * IllegalArgumentException(); When size is 3, the only possible values for
	 * index are 0, 1, and 2.
	 *
	 * @param index
	 *            The index of the element to move.
	 * @return A reference to the element at index index.
	 * @throws IllegalArgumentException
	 */

	public E getElementAt(int index) throws IllegalArgumentException {

		if (index < 0 || index > size() - 1)
			throw new IllegalArgumentException("" + index);

		return (E) data[index];

	}

	/**
	 * If possible, remove the element at the given index. If index is out of
	 * the valid range of 0..size()-1, throw new IllegalArgumentException();
	 * When size is 3, the only possible values for index are 0, 1, and 2.
	 *
	 * @param index
	 *            The index of the element to move.
	 * @throws IllegalArgumentException
	 */
	public void removeElementAt(int index) throws IllegalArgumentException {
		if (index < 0 || index > size() - 1)
			throw new IllegalArgumentException("" + index);

		for (int i = index; i <= size() - 1; i++) {
			data[i] = data[i + 1];
		}

		n--;
	}

	/**
	 * If possible, swap the element located at index with the element at index
	 * + 1. An attempt to lower the priority of the element at index size()-1
	 * has no effect. If index is out of the valid range of 0..size()-1, throw
	 * new IllegalArgumentException(); When size is 3, the only possible values
	 * for index are 0, 1, and 2.
	 *
	 * @param index
	 *            The index of the element to move
	 * @throws IllegalArgumentException
	 */
	public void lowerPriorityOf(int index) throws IllegalArgumentException {
		if (index < 0 || index > size() - 1)
			throw new IllegalArgumentException("" + index);

		E temp = (E) data[index];

		data[index] = data[index + 1];
		data[index + 1] = temp;

	}

	/**
	 * If possible, swap the element located at index with the element at
	 * index-1. An attempt to raise the priority at index 0 has no effect. If
	 * index is out of the valid range of 0..size()-1, throw new
	 * IllegalArgumentException(); When size is 3, the only possible values for
	 * index are 0, 1, and 2.
	 *
	 * @param index
	 *            The index of the element to move
	 * @throws IllegalArgumentException
	 */
	public void raisePriorityOf(int index) throws IllegalArgumentException {
		if (index < 0 || index > size() - 1)
			throw new IllegalArgumentException("" + index);

		E temp = (E) data[index];
		data[index] = data[index - 1];
		data[index - 1] = temp;

	}

	/**
	 * Return a copy of all elements as an array of Objects that is the size of
	 * this PriorityList and in the same order. If there are no elements in this
	 * list, return new Object[0]; A change to the return value must not affect
	 * this PriorityList object.
	 *
	 * @return An array of Objects where capacity == size()
	 */
	public Object[] toArray() {

		Object[] Jack = new Object[size()];
		if (n > 0) {
			for (int i = 0; i < size(); i++) {
				Jack[i] = data[i];
			}
			return Jack;
		} else {
			return new Object[0];
		}
	}

	/**
	 * If possible, move the element at the given index to the end of this list.
	 * An attempt to move the last element to the last has no effect. If the
	 * index is out of the valid range 0..size()-1 throw new
	 * IllegalArgumentException(); When size is 3, the only possible values for
	 * index are 0, 1, and 2.
	 *
	 * @param index
	 *            The index of the element to move.
	 * @throws IllegalArgumentException
	 */
	public void moveToLast(int index) throws IllegalArgumentException {
		if (index < 0 || index > size() - 1)
			throw new IllegalArgumentException("" + index);

		Object[] temp = new Object[size() + 1];

		for (int i = 0; i <= index - 1; i++) {
			temp[i + 1] = data[i];
		}

		for (int i = index; i <= size() - 2; i++) {
			temp[i + 1] = data[i + 1];
		}
		temp[size()] = data[index];

		for (int i = 0; i <= size() - 1; i++) {
			data[i] = temp[i + 1];
		}

	}

	/**
	 * If possible, move the element at the given index to the front of this
	 * list An attempt to move the top element to the top has no effect. If the
	 * index is out of the valid range of 0..size()-1, throw new
	 * IllegalArgumentException(); When size is 3, the only possible values for
	 * index are 0, 1, and 2.
	 *
	 * @param index
	 *            The index of the element to move.
	 * @throws IllegalArgumentException
	 */
	public void moveToTop(int index) throws IllegalArgumentException {
		if (index < 0 || index > size() - 1)
			throw new IllegalArgumentException("" + index);

		Object[] temp = new Object[size() + 1];
		temp[0] = data[index];
		for (int i = 1; i <= size(); i++) {
			temp[i] = data[i - 1];
		}

		for (int i = 0; i <= index; i++) {
			data[i] = temp[i];
		}
		for (int i = index + 1; i <= size() - 1; i++) {
			data[i] = temp[i + 1];
		}

	}

}