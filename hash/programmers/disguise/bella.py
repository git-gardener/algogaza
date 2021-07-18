def solution(clothes):
    tmp = {}
    answer = 1

    for i in clothes:
        key = i.pop()
        if(tmp.get(key) == None): tmp[key] = 1
        else: tmp[key] = tmp.get(key) + 1

    for j in tmp.values():
        answer = answer * (j+1)

    return answer-1


from collections import Counter
from functools import reduce

# 고인물 코드s...
def solution1(clothes):

    cnt = Counter([kind for name, kind in clothes])
    answer = reduce(lambda x, y: x*(y+1), cnt.values(), 1) - 1
    return answer

import collections
def solution2(c):
    return reduce(lambda x,y:x*y,[a+1 for a in collections.Counter([x[1] for x in c]).values()])-1