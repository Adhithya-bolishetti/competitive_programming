class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs) {
            char[] carr = s.toCharArray();
            Arrays.sort(carr);
            String sortedS = new String(carr);

            if(!map.containsKey(sortedS)) {
                map.put(sortedS, new ArrayList<>());
            }

            map.get(sortedS).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
// Time Complexity: O(N * K log K) where N is the number of strings and K is the maximum length of a string
// Space Complexity: O(N * K) for storing the grouped anagrams in the map