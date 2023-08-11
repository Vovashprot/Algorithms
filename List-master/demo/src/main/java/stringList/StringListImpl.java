package stringList;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private final int size = 0;
    private String[] array = new String[size];
    // private int pointer = -1;

  //  public int getPointer() {
   //     return pointer;
   // }

    private void resize(int newSize) {
        if (newSize < array.length && array[newSize-1]!= null) {
            throw new RuntimeException();
        }
       array = Arrays.copyOf(array,newSize);
       //for (int i = 0; i <= array.length - 1; i++) {

    }

   // public void reverse(int[] s){
   //     int storage;
   //     for (int i = 0; i<s.length/2;i++){
   //         storage = s[s.length-1-i];
   //         s[s.length-1-i] = s[i];
   //         s[i] = storage;
   //     }
   //     //сделать без storage;
   // }

    @Override
    public String add(String item) {
            resize(array.length + 1);
        array[array.length-1] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
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
    public String set(int index, String item) {
        if ((array[index] == null) || (index >= array.length)) {
            throw new RuntimeException();
        }
        array[index] = item;
        return item;
    }

    //удаления
    @Override
    public String remove(String item) {
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
    public String remove(int index) {
        String deletedElement = array[index];
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

    //инфа
    //test needed
    @Override
    public boolean contains(String item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(item))
                return true;
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(item))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = array.length-1; i >= 0; i--) {
            if (array[i].equals(item))
                return i;
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if ((index >= array.length) || (array[index] == null)) {
            throw new RuntimeException();
        }
        return array[index];
    }

    //test needed
    @Override
    public boolean equals(StringList otherList) {
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
        array = new String[size];
    }

    @Override
    public String[] toArray() {
        return array;
    }

    @Override
    public String toString() {
        return "StringListImpl{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
