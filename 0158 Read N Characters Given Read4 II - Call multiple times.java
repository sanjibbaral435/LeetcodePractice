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
    int leftOver = 0, currIndex = 0;
    char[] letters = new char[4];

    public int read(char[] buf, int n) {
        for(int i=0; i<n; i++){
            if(leftOver == 0) {   //need to load new characters
                leftOver = read4(letters);
                currIndex = 0;
                if(leftOver == 0) return i; //if we cannot load anything we will return i
            }
            buf[i] = letters[currIndex++]; //update buf
            leftOver--;
        }
        return n;
    }
}


