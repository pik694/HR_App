package pik.pw.recruitme.app;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SampleJunitTests {

    @Test
    public void someSampleTest() {
        assertEquals(1,1);

    }

    @Test(expected = Exception.class)
    public void anotherSampleTest(){

        throw new RuntimeException("Some sample exception");

    }

}

