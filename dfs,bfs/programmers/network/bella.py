def dfs(computers, i, check):
  check[i] = True
  for j in range(len(computers)):

    if (i != j and computers[i][j] == 1 and check[j] == False):
      print(computers[i][j])
      check = dfs(computers, j, check)
  return check

def solution(n, computers):
  answer = 0
  check = []
  for a in range(0,n):
    check.append(False)

  for i in range(0,n):
    if(check[i] == False):
      dfs(computers,i,check)
      answer = answer + 1

  return answer

print(solution(3,[[1, 1, 0], [1, 1, 0], [0, 0, 1]]))

# bfs로 푼 다른 사람 코드
def solution2(n, computers):
  def BFS(node, visit):
    que = [node]
    visit[node] = 1
    while que:
      v = que.pop(0)
      for i in range(n):
        if computers[v][i] == 1 and visit[i] == 0:
          visit[i] = 1
          que.append(i)
    return visit

  visit = [0 for i in range(n)]
  answer = 0
  for i in range(n):
    try:
      visit = BFS(visit.index(0), visit)
      answer += 1
    except:
      break
  return answer