class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        i=0
        while(k>0):
            i+=1
            if i not in arr:
                k-=1
        return i