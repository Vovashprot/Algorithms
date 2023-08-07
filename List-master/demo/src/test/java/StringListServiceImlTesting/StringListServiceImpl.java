package StringListServiceImlTesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stringList.StringList;
import stringList.StringListImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringListTest {
    private StringList stringList;
    int elementsQuantity = 18;
    @BeforeEach
    public void SetUp(){
        stringList = new StringListImpl();
            stringList.add("sadad");
            stringList.add("sadad");
            stringList.add("sadad2");
            stringList.add(5,"asdd");
            stringList.add("sadad");
            stringList.add("sadad");
            stringList.add("sadad2");
    }
    @Test
    public void addAndGetTest() {
        assertEquals(stringList.size(), 3);
    }
    @Test
    public void removeAndSizeTest() {
        stringList.remove("sadad2");
        //assertEquals(stringList.get(1), "sadad2");
        //assertEquals(stringList.get(2), "asdd");
        assertEquals(stringList.size(), 6);
        System.out.println(stringList.toArray());
        //(stringList.getPointer(), 2);
    }


}
