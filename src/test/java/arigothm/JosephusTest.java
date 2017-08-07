package arigothm;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class JosephusTest {
  public static final Object[][][] tests = {
    {new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new Object[]{1}, new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}},
    {new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new Object[]{2}, new Object[]{2, 4, 6, 8, 10, 3, 7, 1, 9, 5}},
    {new Object[]{"C", "o", "d", "e", "W", "a", "r", "s"}, new Object[]{4}, new Object[]{"e", "s", "W", "o", "C", "d", "r", "a"}},
    {new Object[]{1, 2, 3, 4, 5, 6, 7}, new Object[]{3}, new Object[]{3, 6, 2, 7, 5, 1, 4}},
    {new Object[]{}, new Object[]{3}, new Object[]{}}
  };
  @Parameter
  public Object[] input;
  @Parameter(1)
  public Object[] traceNum;
  @Parameter(2)
  public Object[] result;

  @Parameters
  public static Iterable<Object[]> samples() {
    return Arrays.asList(tests);
  }

  @Test
  public void test() {
    assertThat(Josephus.josephusPermutation(Arrays.asList(input), (Integer) traceNum[0]), is(Arrays.asList(result)));
  }


}
