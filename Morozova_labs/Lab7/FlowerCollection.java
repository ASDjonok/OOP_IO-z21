import java.util.*;

public class FlowerCollection implements List<Flower> {

	private static final int INITIAL_CAPACITY = 15;
	private static final int CAPACITY_INCREMENT = 30;

	private Flower[] flowers;
	private int size;

	public FlowerCollection() {
		flowers = new Flower[INITIAL_CAPACITY];
		size = 0;
	}

	public FlowerCollection(Flower flower) {
		flowers = new Flower[INITIAL_CAPACITY];
		flowers[0] = flower;
		size = 1;
	}

	public FlowerCollection(Collection<? extends Flower> collection) {
		flowers = new Flower[INITIAL_CAPACITY];
		size = 0;
		addAll(collection);
	}

	public void sortByLength() {
		Arrays.sort(flowers, 0, size, new Comparator<Flower>() {
			@Override
			public int compare(Flower flower1, Flower flower2) {
				return Integer.compare(flower1.getLength(), flower2.getLength());
			}
		});
	}

	// Реалізація методів інтерфейсу List
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		for (int i = 0; i < size; i++) {
			if (flowers[i].equals(o)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<Flower> iterator() {
		return new FlowerIterator();
	}

	@Override
	public Object[] toArray() {
		return Arrays.copyOf(flowers, size);
	}

	@Override
	public <T> T[] toArray(T[] a) {
		if (a.length < size) {
			return (T[]) Arrays.copyOf(flowers, size, a.getClass());
		}
		System.arraycopy(flowers, 0, a, 0, size);
		if (a.length > size) {
			a[size] = null;
		}
		return a;
	}

	@Override
	public boolean add(Flower flower) {
		ensureCapacity(size + 1);
		flowers[size] = flower;
		size++;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		for (int i = 0; i < size; i++) {
			if (flowers[i].equals(o)) {
				removeAtIndex(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object obj : c) {
			if (!contains(obj)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends Flower> c) {
		ensureCapacity(size + c.size());
		for (Flower flower : c) {
			flowers[size] = flower;
			size++;
		}
		return !c.isEmpty();
	}

	@Override
	public boolean addAll(int index, Collection<? extends Flower> c) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		ensureCapacity(size + c.size());
		// Зсув елементів для зроблення місця новим елементам
		System.arraycopy(flowers, index, flowers, index + c.size(), size - index);

		// Додавання нових елементів
		int i = index;
		for (Flower flower : c) {
			flowers[i] = flower;
			i++;
		}

		size += c.size();
		return !c.isEmpty();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean modified = false;
		for (int i = 0; i < size; i++) {
			if (c.contains(flowers[i])) {
				removeAtIndex(i);
				i--;
				modified = true;
			}
		}
		return modified;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		boolean modified = false;
		for (int i = 0; i < size; i++) {
			if (!c.contains(flowers[i])) {
				removeAtIndex(i);
				i--;
				modified = true;
			}
		}
		return modified;
	}

	@Override
	public void clear() {
		Arrays.fill(flowers, null);
		size = 0;
	}

	@Override
	public Flower get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		return flowers[index];
	}

	@Override
	public Flower set(int index, Flower element) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Flower previous = flowers[index];
		flowers[index] = element;
		return previous;
	}

	@Override
	public void add(int index, Flower element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		ensureCapacity(size + 1);
		System.arraycopy(flowers, index, flowers, index + 1, size - index);
		flowers[index] = element;
		size++;
	}

	@Override
	public Flower remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Flower removedElement = flowers[index];
		removeAtIndex(index);
		return removedElement;
	}

	@Override
	public int indexOf(Object o) {
		for (int i = 0; i < size; i++) {
			if (flowers[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		for (int i = size - 1; i >= 0; i--) {
			if (flowers[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public ListIterator<Flower> listIterator() {
		return new FlowerListIterator(0);
	}

	@Override
	public ListIterator<Flower> listIterator(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		return new FlowerListIterator(index);
	}

	@Override
	public List<Flower> subList(int fromIndex, int toIndex) {
		if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
			throw new IndexOutOfBoundsException();
		}

		FlowerCollection subList = new FlowerCollection();
		subList.addAll(Arrays.asList(Arrays.copyOfRange(flowers, fromIndex, toIndex)));

		return subList;
	}

	// Внутрішній метод для видалення елемента за певним індексом
	private void removeAtIndex(int index) {
		System.arraycopy(flowers, index + 1, flowers, index, size - index - 1);
		flowers[size - 1] = null;
		size--;
	}

	// Внутрішній метод для перевірки та збільшення місткості масиву

	private void ensureCapacity(int minCapacity) {
		if (minCapacity > flowers.length) {
			int newCapacity = flowers.length + CAPACITY_INCREMENT;
			flowers = Arrays.copyOf(flowers, newCapacity);
		}
	}

	// Внутрішній клас FlowerIterator для ітерації по колекції
	private class FlowerIterator implements Iterator<Flower> {
		private int cursor;

		public FlowerIterator() {
			cursor = 0;
		}

		@Override
		public boolean hasNext() {
			return cursor < size;
		}

		@Override
		public Flower next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Flower nextElement = flowers[cursor];
			cursor++;
			return nextElement;
		}

		@Override
		public void remove() {
			if (cursor == 0 || cursor > size) {
				throw new IllegalStateException();
			}
			removeAtIndex(cursor - 1);
			cursor--;
		}
	}

	// Внутрішній клас FlowerListIterator для ітерації по колекції з можливістю редагування
	private class FlowerListIterator extends FlowerIterator implements ListIterator<Flower> {
		private int cursor;
		private int lastRet = -1;
		public FlowerListIterator(int index) {
			super();
			cursor = index;
		}

		@Override
		public boolean hasPrevious() {
			return cursor > 0;
		}

		@Override
		public Flower previous() {
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}
			cursor--;
			return flowers[cursor];
		}

		@Override
		public int nextIndex() {
			return cursor;
		}

		@Override
		public int previousIndex() {
			return cursor - 1;
		}


		@Override
		public void set(Flower flower) {
			if (lastRet == -1) {
				throw new IllegalStateException();
			}
			flowers[lastRet] = flower;
		}

		@Override
		public void add(Flower flower) {
			if (cursor < 0 || cursor > size) {
				throw new IndexOutOfBoundsException();
			}
			ensureCapacity(size + 1);
			System.arraycopy(flowers, cursor, flowers, cursor + 1, size - cursor);
			flowers[cursor] = flower;
			size++;
			cursor++;
		}
	}

}
