package kata;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class InvertValuesTest {
    public static final int[][][] tests = {
            {new int[]{1, 2, 3, 4, 5}, new int[]{-1, -2, -3, -4, -5}},
            {new int[]{1, -2, 3, -4, 5}, new int[]{-1, 2, -3, 4, -5}},
            {new int[]{}, new int[]{}}
    };
    @Parameter
    public int[] input;
    @Parameter(1)
    public int[] result;
    private InvertValues demo;

    @Parameters(name = "{index}:invert value")
    public static Iterable<Object[]> iterable() {
        return Arrays.asList(tests);
    }

    @Before
    public void setUp() {
        demo = new InvertValues();
    }

    @Test
    public void invertArray() throws Exception {
        assertThat(demo.invertArray(input), is(result));
    }
}