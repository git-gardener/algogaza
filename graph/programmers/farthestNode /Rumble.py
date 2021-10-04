from collections import deque
#solution(6, [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]])
def solution(n, edge):
    edgelist = {} 

    for l, r in edge:
        if not l in edgelist:
            edgelist[l] =[]
        if not r in edgelist:
            edgelist[r] =[]    
        edgelist[l].append(r)
        edgelist[r].append(l)

    q = deque(edgelist[1])
    cnt = 1
    cnts = {i:0 for i in range(1, n+1)} 
    print(cnts)

    while q:
        for i in range(len(q)):
            visited = q.popleft()
            if cnts[visited] == 0:
                cnts[visited] = cnt
                for x in edgelist[visited]:
                    q.append(x)
        cnt += 1

    answer = 0

    del cnts[1]
    maxcnt = max(cnts.values())
    for i in cnts.values():
        if i == maxcnt:
            answer += 1
    return print(answer)

solution(6, [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]])
