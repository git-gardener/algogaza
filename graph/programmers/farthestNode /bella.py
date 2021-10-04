from collections import deque

def solution(n, edge):
    graph = {}
    queue = deque([])
    cntArr = [0 for i in range(n + 1)]
    answer = 100
    cnt = 1

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
    visited[1] = True
    queue.append(1)

    while queue:
        currNode = queue.popleft()
        cnt += 1
        for g in graph[currNode]:
            if not visited[g]:
                queue.append(g)
                visited[g] = True

        if queue.__len__() == 0:
            print(cnt)
        print(queue)

    print(cntArr)

    answer = cnt
    return answer


print(solution(6,[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]))