def solution(n, results):
    answer = 0
    graph = [[0 for i in range(n+1)] for j in range(n+1)]

    for r in results:
        graph[r[0]][r[1]] = 1
        graph[r[1]][r[0]] = -1

    # 플로이드 - 와샬 알고리즘 적용
    for k in range(n+1):
        for i in range(n+1):
            for j in range(n+1):
                if graph[i][j] == 0:
                    if graph[i][k] == 1 and graph[k][j] == 1:
                        graph[i][j] = 1
                    elif graph[i][k] == -1 and graph[k][j] == -1:
                        graph[i][j] = -1

    print(graph)
    for i in range(1,n+1):
        # print(graph[i].count(0))
        if graph[i].count(0) == 2:
            answer += 1

    return answer



print(solution(5,[[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]))



# 고인물 코드 줍줍
from collections import defaultdict
def solution2(n, results):
    answer = 0
    win, lose = defaultdict(set), defaultdict(set)
    for result in results:
            lose[result[1]].add(result[0])
            win[result[0]].add(result[1])

    for i in range(1, n + 1):
        for winner in lose[i]: win[winner].update(win[i])
        for loser in win[i]: lose[loser].update(lose[i])

    for i in range(1, n+1):
        if len(win[i]) + len(lose[i]) == n - 1: answer += 1
    return answer