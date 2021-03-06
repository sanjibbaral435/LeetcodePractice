// Will follow the apporach of finding a cycle in linkedList
// fast and slow whenever meet, if the meeting point is 1 then
// it's a happy number else not.

class Solution {
    Set<Integer> set = new HashSet<>();
    Map<Integer, Integer> squares = new HashMap<>();


    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;

        do{
          slow = squareSumOfDigits(slow);
          fast = squareSumOfDigits(squareSumOfDigits(fast));
        } while (fast != slow);

        if(fast == 1) return true;
        return false;

    }

    public int squareSumOfDigits(int n){
        int sum = 0;
        while(n!=0) {
            int x = n%10;
            sum += x*x;
            n = n/10;
        }
        return sum;
    }

    public boolean isHappy1(int n) {

        for(int i=0; i<10; i++) {
            squares.put(i, i*i);
        }

        while(n != 1) {
            n = squareOfDigits1(n);
            if(set.contains(n)) // cycle present
                return false;
            else
                set.add(n);
        }
        return true;
    }

    public int squareOfDigits1(int n) {
        int res = 0;
        while(n != 0) {
            int digit = n%10;
            res = res + squares.get(digit);
            n = n/10;
        }
        return res;
    }
}
