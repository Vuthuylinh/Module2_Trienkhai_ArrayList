import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        this.size = capacity;
    }

    public MyList(int size, Object[] elements) {
        this.size = size;
        this.elements = elements;
    }

    private void ensureCapacity(int minCapacity) {
        this.elements = Arrays.copyOf(elements, minCapacity);

    }

    public void add(int index, E element) {
        if (this.size == DEFAULT_CAPACITY) {
            ensureCapacity(size * 2);
        }
        if (index > size) {
            elements[size++] = element;
        } else {
            for (int i = index + 1; i < size; i++) {
                elements[i] = elements[i + 1];
            }
        }
        elements[index] = element;

        size++;
    }

    public void remove(int index) {
        E temp = (E) elements[index];
        if (index > size) {
            throw new IndexOutOfBoundsException("This index out of bound " + size);
        } else {
            for (int i = index; i < size; i++) {
                elements[i] = elements[i + 1];
            }
        }
        size--;
        System.out.println("Value of element was removed: " + temp);
    }

    public int getSize() {
        return this.size;
    }

    public Object clone() {
        MyList<E> myList = new MyList<E>();
        myList.elements = this.elements;
        myList.size = this.size;
        return myList;
    }

    public boolean contains(E o) {
        for (int i = 0; i < size; i++) {
            if (((E) this.elements[i]).equals(o)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E e) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (((E) this.elements[i]).equals(e)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean isAddable(E e) {
        if (this.size == DEFAULT_CAPACITY) {
            ensureCapacity(size * 2);
        }
        if (e == null) {
            return false;
        } else {
            return true;
        }
    }

    public E get(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("out of bound " + size);
        }
        return (E) this.elements[index];
    }

    public void clear() {
        this.size = 0;
        this.elements = null;
        System.out.println("after clear, size ="+ size);
    }
}
