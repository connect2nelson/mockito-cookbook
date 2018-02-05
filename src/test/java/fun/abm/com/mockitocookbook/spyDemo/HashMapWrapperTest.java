package fun.abm.com.mockitocookbook.spyDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HashMapWrapperTest {

    @Spy
    private HashMapWrapper hashMapWrapper;

    @Test
    public void testWhetherHashMapWrapperServesAsAWrapper() {

        hashMapWrapper.put("abm", "not so fun");

        when(hashMapWrapper.get("abm")).thenReturn("fun");

        assertEquals(hashMapWrapper.get("abm"), "fun");
    }
}