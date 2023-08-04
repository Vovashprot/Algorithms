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

        for (int i = 0;i >=elementsQuantity;i++){
            stringList.add("sadad");
        }
    }
    @Test
    void addTest() {
        
    }

}
