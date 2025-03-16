class Solution:
    def reverseWords(self, s: str) -> str:
        sl=list(s.split())
        lst=[]
        for i in range(len(sl)-1,-1,-1):
            print(i)
            lst.append(sl[i])
        return " ".join(lst)