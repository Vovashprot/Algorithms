package IntList;

import stringList.StringList;

import java.util.Arrays;

public class IntListImpl implements IntList {
    private final int size = 0;
    private Integer[] array = new Integer[size];

    private void resize(int newSize) {
        if (newSize < array.length && array[newSize-1]!= null) {
            throw new RuntimeException();
        }
        array = Arrays.copyOf(array,newSize);
    }

    @Override
    public Integer add(Integer item) {
            resize(array.length + 1);
            array[array.length-1] = item;
            return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if(index > array.length)
        {
            throw new RuntimeException();
        }
        resize(array.length+1);
        for (int i = array.length-1; i>index;i--){
            array[i]=array[i-1];
        }
        array[index] =  item;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if ((array[index] == null) || (index >= array.length)) {
            throw new RuntimeException();
        }
        array[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        if (indexOf(item) ==-1) {
            throw new RuntimeException();
        }
        for (int i = indexOf(item) ; i < array.length-1;i++ ){
            array[i] = array[i+1];
        }
        array[array.length-1] = null;
        resize(array.length-1);
        return item;
    }

    @Override
    public Integer remove(int index) {
        Integer deletedElement = array[index];
        if (index >= array.length || array[index] == null){
            throw new RuntimeException();
        }
        for (int i = index ; i < array.length-1;i++ ){
            array[i] = array[i+1];
        }
        array[array.length-1] = null;
        resize(array.length-1);
        return deletedElement;
    }

    @Override
    public boolean contains(Integer item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(item))
                return true;
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(item))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = array.length-1; i >= 0; i--) {
            if (array[i].equals(item))
                return i;
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if ((index >= array.length) || (array[index] == null)) {
            throw new RuntimeException();
        }
        return array[index];
    }

    @Override
    public boolean equals(IntList otherList) {
        if (otherList == null||array.length != otherList.toArray().length) {
            throw new RuntimeException();
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(otherList.get(i)))
                return true;
        }
        return false;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null)
                return false;
        }
        return true;
    }

    @Override
    public void clear() {
       array = new Integer[size];
    }

    @Override
    public Integer[] toArray() {
        return array;
    }
    @Override
    public String toString() {
        return "IntListImpl{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
