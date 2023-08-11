package StringListServiceImlTesting;

import ch.qos.logback.core.helpers.ThrowableToStringArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stringList.StringList;
import stringList.StringListImpl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            stringList.add(3,"asdd");
            stringList.add("sadad");
            stringList.add("sadad");
            stringList.add("sadad2");
        stringList.add("sadad");
        stringList.add("sadad");
        stringList.add("sadad");
    }
    @Test
    public void addAndGetTest() {
        stringList.add(10,"asdasdasd");
        assertEquals(stringList.toArray().length, 11);

        System.out.println(stringList.toString());
    }
    // @Test
            // public void removeAndSizeTest() {
        //     System.out.println(stringList.());
        //      stringList.remove(8);
        //      stringList.remove("asdd");
        //     assertEquals(stringList.size(), 8);
        //     System.out.println(stringList.toString());
        //     //(stringList.getPointer(), 2);
        // }
    @Test
    public void ToArrayTest() {
        assertEquals(stringList.size(), 7);
        System.out.println(stringList.toArray());
        String[] example = new String[]{"sadad","sadad","sadad2","asdd","sadad","sadad","sadad2"};
        assertEquals(Arrays.deepToString(stringList.toArray()), Arrays.toString(example));
    }

    @Test
    public void IsEmptyAndClearTest() {
        assertEquals(stringList.size(), 7);
        assertEquals(stringList.isEmpty(),false);
        stringList.clear();
        assertEquals(stringList.isEmpty(),true);
    }

    @Test
    public void setTest() {
        stringList.set (2, "asd");
        try {
            stringList.set (10,"asddasd");
        } catch (RuntimeException exe){}

        System.out.println(stringList.toString());
    }
    @Test
    public void indexOfTest() {
        assertEquals(stringList.indexOf("asdd"),3);
        assertEquals(stringList.indexOf("sadad"),0);
        assertEquals(stringList.lastIndexOf("sadad"),9);
    }
    @Test
    public void containsTest() {
        assertEquals(stringList.contains("asdd"),true);
        assertEquals(stringList.contains("sadadasdadasd"),false);

    }

    @Test
    public void equalsTest() {
        StringList stringList2;
        stringList2 = new StringListImpl();
        stringList.add("asd");
        stringList.add("asd");
        stringList2.add("asd");
        stringList2.add("asd");
        assertEquals(stringList.equals(stringList2),true);
    }

}
