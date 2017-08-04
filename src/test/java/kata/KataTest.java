package kata;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by xd031 on 2017/8/4.
 */
@RunWith(Parameterized.class)
public class KataTest {
    public static final int[][][] tests = {
            {new int[]{1, 2, 3, 4, 5}, new int[]{-1, -2, -3, -4, -5}},
            {new int[]{1, -2, 3, -4, 5}, new int[]{-1, 2, -3, 4, -5}},
            {new int[]{}, new int[]{}}
    };
    @Parameter
    public int[] input;
    @Parameter(1)
    public int[] result;

    @Parameters(name = "{index}:invert value")
    public static Iterable<Object[]> iterable() {
        return Arrays.asList(tests);
    }


    @Test
    public void invert() throws Exception {
        assertThat(Kata.invert(input), is(result));
    }

}