157. Read N Characters Given Read4

The API: int read4(char *buf) reads 4 characters at a time from a file.
The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
Note:
The read function will only be called once for each test case.


public class Solution extends Reader4 {
    public int read(char[] buf, int n) {
        char[] buf4 = new char[4];
        int offset = 0;
        
        while (true) {
            int size = read4(buf4);
            for (int i = 0; i < size && offset < n; i++) {
                buf[offset++] = buf4[i];
            }
            if (size == 0 || offset == n) {
                return offset;
            }
        }
    }
}
