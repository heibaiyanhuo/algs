package leetcode.problems;

public class A158_Read_N_Characters_Given_Read4_II {
    char[] prevBuf = new char[4];
    int prevSize = 0;
    int prevIndex = 0;

    private int read4(char[] buf) {
        return 0;
    }

    public int read(char[] buf, int n) {
        int counter = 0;

        while (counter < n) {
            if (prevIndex < prevSize) {
                buf[counter++] = prevBuf[prevIndex++];
            } else {
                prevSize = read4(prevBuf);
                prevIndex = 0;
                if (prevSize == 0) {
                    // no more data to consume from stream
                    break;
                }
            }
        }
        return counter;
    }
}
