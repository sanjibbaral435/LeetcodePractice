class Solution {
    public String convertToTitle(int columnNumber) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        StringBuilder sb = new StringBuilder();
        while(columnNumber > 0) {
            columnNumber--;
            int c = columnNumber%26;
            sb = sb.append(alphabet.charAt(c));
            columnNumber = columnNumber/26;
        }
        return sb.reverse().toString();
    }
}
