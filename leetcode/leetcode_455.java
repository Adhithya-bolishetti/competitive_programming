class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for(int j=0;i<g.length && j<s.length;j++) {
            if(s[j] >= g[i]) i++;
        }
        return i;
    }
}
// Time Complexity: O(nlogn + mlogm) where n is the number of children and m is the number of cookies
// Space Complexity: O(1) since we are not using any extra space