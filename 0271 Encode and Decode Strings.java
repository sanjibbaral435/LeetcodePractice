public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        // encode string with backslash and str length 
        // eg.g {"abc", "def"}) ---> "3/abc3/def"
        // {"abc", "/def"}) ---> "3/abc4//def"
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str.length()).append('/').append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i=0;
        List<String> list = new ArrayList<String>();
        while(i < s.length()){
            // find the first slash starting from ith index
            int slash = s.indexOf('/', i);
            
            // get the length of the current string block
            int size = Integer.valueOf(s.substring(i, slash));
            
            i = slash + size + 1; // position of the end of this string block + 1 i.e. starting index of next block
            
            list.add(s.substring(slash+1, i));
        }
        
        return list;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
