~
~

def solution(n, computers):
    answer = 0
    arr = []
    for i in range(0,n):
        result = 0
        for j in range(i,n):
            if(computers[i][j]==1):
                print(i,j,"dfs호출")
                result = dfs(i,j,n,computers)
        arr.append(result)
        
    
    return sum(arr)

def dfs(row,col,n,computers):
    flag = 1
    computers[row][col]=2
    for i in range(0,n):
        if computers[col][i]==1:
            dfs(col,i,n,computers)
    return flag

