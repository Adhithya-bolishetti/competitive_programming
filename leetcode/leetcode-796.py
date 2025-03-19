class Solution:
    def rotateString(self, s: str, goal: str) -> bool:
        l=list(s)
        for _ in range(len(l)):
            f=l[0]
            print(f)
            l.pop(0)
            print(l)
            l.append(f)
            if(goal=="".join(l)):
                return True
        return False