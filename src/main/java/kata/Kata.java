package kata;

/**
 * Created by xd031 on 2017/8/4.
 */
public class Kata {
    public static int[] invert(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = ~array[i]+1;
        }
        return result;
    }
}
