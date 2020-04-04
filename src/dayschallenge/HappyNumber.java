package dayschallenge;

import java.util.HashSet;

public class HappyNumber{
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n != 1){
            int sum = 0;
            while(n != 0){
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
            if(set.contains(n)) break;
            set.add(n);
        }
        return n == 1;
        
    }
}