from collections import deque

def solution(n, edge):
    graph = {}
    cnt = 1
    answer = 0
    cntArr = [-1 for i in range(n+1)]

    for e in edge:
        if not graph.__contains__(e[0]):
            graph[e[0]] = []
        graph[e[0]].append(e[1])
        graph[e[0]].sort()
        if not graph.__contains__(e[1]):
            graph[e[1]] = []
        graph[e[1]].append(e[0])
        graph[e[1]].sort()

    visited = [False for i in range(n + 1)]

    queue = deque([[1, cnt]])
    while queue:
        arr = queue.popleft()
        currNode = arr[0]
        cnt = arr[1]
        if visited[currNode] == False:
            visited[currNode] = True
            cntArr[currNode] = cnt
            cnt += 1
            for g in graph[currNode]:
                queue.append([g, cnt])

    for c in cntArr:
        if c == max(cntArr):
            answer += 1

    return answer


print(solution(6,[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]))