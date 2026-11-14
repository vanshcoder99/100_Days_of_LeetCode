// Set Rightmost Unset Bit
class Solution {
    public int setBit(int n) {
        return (n | n+1);
    }
}
