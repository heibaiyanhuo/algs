package leetcode.problems;

public class A157_Read_N_Characters_Given_Read4 {
    private int read4(char[] buf) {
        return 0;
    }

    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int read = 0;
        while (true) {
            int count = read4(buffer);
            count = Math.min(count, n - read);
            if (count == 0) break;
            for (int i = 0; i < count; i++) {
                buf[read++] = buffer[i];
            }
        }
        return read;
    }
}
