package kata;


public class InvertValues {

    public int[] invertArray(int[] input) {
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = -input[i];
        }
        return result;
    }
}
