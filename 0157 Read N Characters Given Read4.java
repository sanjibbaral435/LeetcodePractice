/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int total = 0;
        boolean end = false;
        
        char[] tempBuf = new char[4];
        
        while(!end && total < n){
            int count = read4(tempBuf);
            
            if(count < 4) end = true;
            
            // cases like number of char needed more is less than
            // the characters actualread
            count = Math.min(count, n - total);
            
            for(int i = 0; i< count; i++){
                buf[total++] = tempBuf[i];
            }
        }
        
        return total;
    }
}
