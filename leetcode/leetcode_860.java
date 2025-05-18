class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        for(int i=0;i<bills.length;i++) {
            if(bills[i] == 5) fives++;
            else if(bills[i] == 10) {
                    tens++;
                    if(fives <= 0) return false;
                    else fives--;
            }
            else {
                if(tens >= 1 && fives >= 1) {
                    tens--;
                    fives--;
                }
                else if(fives >= 3) {
                    fives -= 3;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
//Time Complexity: O(n)
//Space Complexity: O(1)