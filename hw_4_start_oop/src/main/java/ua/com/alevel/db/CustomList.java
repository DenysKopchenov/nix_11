package ua.com.alevel.db;


import java.util.Arrays;

public class CustomList<E>{
    private Object[] data;
    private int size;

    public CustomList() {
        this.data = new Object[10];
    }

    public void add(E e) {
        if (size == data.length) {
            data = increaseCapacity();
        }
        data[size] = e;
        size++;
    }

    private Object[] increaseCapacity() {
        int newCapacity = data.length * 3 / 2 + 1;
        return Arrays.copyOf(data, newCapacity);
    }

    public E get(int index) {
        if (index < data.length) {
            return (E) data[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void remove(int index) {
        size--;
        if (size > index) {
            System.arraycopy(data, index + 1, data, index, size - index);
        }
        data[size] = null;
    }

    public boolean remove(Object o) {
        if (o != null) {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(o)) {
                    remove(i);
                    return true;
                }
            }
        }
        return false;
    }


    public int size() {
        return size;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomList{");
        sb.append("data=").append(Arrays.toString(data));
        sb.append('}');
        return sb.toString();
    }
}
