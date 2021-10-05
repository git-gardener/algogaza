from collections import deque

def bfs(info,fieldGraph,sheep,wolf,visited,root):
    queue = deque([])
    visitedQueue = deque([])
    queue.append(root)
    cnt = 0

    while queue:
        # print(queue, sheep, wolf, visitedQueue)
        currNode = queue.popleft()
        if visited[root] == True:
            visitedQueue.append(currNode)
            return visitedQueue
        if cnt > len(queue):
            cnt = 0
            sheep = 0
            wolf = 0
            for v in range(len(visited)):
                visited[v] = False
            visited[visitedQueue.pop()] = True
            queue.clear()
            visitedQueue.clear()
            queue.append(root)
            continue

        visitedQueue.append(currNode)

        if info[currNode] == 0:
            sheep += 1
            cnt = 0
        else:
            if sheep-wolf == 1:
                cnt += 1
                queue.append(currNode)
                visitedQueue.pop()
                continue
            else:
                wolf += 1

        if fieldGraph.__contains__(currNode):
            for e in fieldGraph[currNode]:
                if not visited[e]:
                    visited[e] = True
                    if not fieldGraph.__contains__(e) and info[e]:
                        continue
                    else : queue.append(e)

    return visitedQueue

def solution(info,edges):
    answer = 0
    answerArr = []
    sheep = 0
    wolf = 0
    visited = [False] * len(info)
    fieldGraph = {}

    for e in edges:
        if fieldGraph.__contains__(e[0]) == False: fieldGraph[e[0]] = [e[1]]
        else: fieldGraph[e[0]].append(e[1])

    answerArr = bfs(info,fieldGraph,sheep,wolf,visited,0)

    for a in answerArr:
        if info[a] == 0:
            answer += 1

    return answer


print(solution([0,0,1,1,1,0,1,0,1,0,1,1],[[0,1],[1,2],[1,4],[0,8],[8,7],[9,10],[9,11],[4,3],[6,5],[4,6],[8,9]]))
# 5
print(solution([0,1,0,1,1,0,1,0,0,1,0],[[0,1],[0,2],[1,3],[1,4],[2,5],[2,6],[3,7],[4,8],[6,9],[9,10]]))

print(solution([0,1,1,1,0,0,1,0],[[0,1],[1,2],[1,3],[2,4],[0,5],[5,6],[6,7]]))