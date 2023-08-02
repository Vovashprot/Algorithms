package stringList;

public class StringListImpl implements StringList  {
    private final int size = 16;
    private final int cut = 4;
    private String[] array = new String[size];
    private int pointer = 0;
    public void resize(int newSize){
    String[] arrayChange = new String[newSize];
        for(int i=0; i == size;i++){
            arrayChange[i] = array[i];
        }
        array = arrayChange;
    }
    @Override
    public String add(String item) {
        if(pointer == array.length-1)
            resize(array.length*2);
            array[pointer++] = item;
            return item;
    }

    @Override
    public String add(int index, String item) {
        return null;
    }

    @Override
    public String set(int index, String item) {
        return null;
    }

    @Override
    public String remove(String item) {
        return null;
    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public boolean contains(String item) {
        return false;
    }

    @Override
    public int indexOf(String item) {
        return 0;
    }

    @Override
    public int lastIndexOf(String item) {
        return 0;
    }

    @Override
    public String get(int index) {
        if ((array.length < index-1) || (array[index] == null)){
            throw new RuntimeException();
        }
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String[] toArray() {
        return new String[0];
    }
}
