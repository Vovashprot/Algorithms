package stringList;

import java.util.Arrays;

public class StringListImpl implements StringList  {
    private final int size = 8;
    private final int cut = 4;
    private String[] array = new String[size];
    private int pointer = -1;

    public int getPointer(){
        return pointer;
    }
     public void resize(int newSize){
    String[] arrayChange = new String[newSize];
        for(int i=0; i <= array.length-1;i++){
            if(array[i]!=null)
            arrayChange[i] = array[i];
        }
        array = arrayChange;
    }
    @Override
    public String add(String item) {

            while (pointer >= array.length-1) {
            resize(array.length+8);
            }

            pointer++;
            array[pointer] = item;
            return item;
    }

    @Override
    public String add(int index, String item) {
        while (index >= array.length-1) {
            resize(array.length+8);
        }
        if ( pointer <= index)
            pointer=index;
        if (array[index]==null){
            array[index] = item;
            return item;
        }
        else throw new RuntimeException();
    }

    @Override
    public String set(int index, String item) {
        if((array[index] == null) || (index> array.length)){
            throw new RuntimeException();
        }
        array[index] = item;
        return item;
    }
//удаления
    @Override
    public String remove(String item) {
        boolean del = false;
        for(int i=0;i<=pointer;i++){
            if (array[i]==item){
                if (pointer <array.length-8){
                    resize(array.length/-8);
                }
                array[i]= null;
                if(i == pointer)
                do {
                    pointer--;
                } while (array[pointer]==null);

                return item;
            }

        }
        //добавить ошибку
        throw new RuntimeException();
    }

    @Override
    public String remove(int index) {
        if (array[index] == null ||index>pointer){
            throw new RuntimeException();
        }
        array[index]= null;
        if (pointer==index){
            while (array[pointer]==null){
            pointer--;
            }
        }
        if (pointer <array.length/-8){
            resize(array.length/-8);
        }
        return array[index];
    }
//инфа
    //test needed
    @Override
    public boolean contains(String item) {
         for (int i=0;i<=pointer;i++)
         {
             if (array[i] == item)
                 return true;
         }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i=0;i<=pointer;i++)
        {
            if (array[i] == item)
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i=pointer;i>=0;i--)
        {
            if (array[i] == item)
                return i;
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if ((pointer < index) || (array[index] == null)){
            throw new RuntimeException();
        }
        return array[index];
    }
//test needed
    @Override
    public boolean equals(StringList otherList) {
         if (otherList == null)
             throw new RuntimeException();
        for (int i=0;i<=pointer;i++)
        {
            if ((array[i] == otherList.get(i))&&(array.length == otherList.size()))
                return true;
        }
        return false;
    }

    @Override
    public int size() {
         int count = 0;
        for (int i=0;i<=pointer;i++){
            if (array[i]!=null)
                count++;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
         for (int i=0;i<pointer;i++){
             if (array[i]!=null)
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
         int g = 0;
         int nSize = 0;
         for (int i=0;i<=pointer;i++){
             if (array[i]!=null)
                 nSize++;
         }
        String[] array2 = new String[nSize];
        for (int i=0;i<=pointer;i++){
            if (array[i]!=null){
                array2[g] = array[i];
            g++;
            }
        }
        return array2;
    }

    @Override
    public String toString() {
        return "StringListImpl{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
