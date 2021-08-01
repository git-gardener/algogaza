def solution(numbers, target):
    answer = 0
    resultArr = dfs(numbers,0,0,target,[])
    for i in resultArr:
        if i == target:
            answer += 1
    return answer

def dfs(numbers,currInd,currVal,target,resultArr):
    
    if currInd != len(numbers)-1:
        dfs(numbers,currInd+1,currVal + numbers[currInd],target,resultArr)
        dfs(numbers,currInd+1,currVal - numbers[currInd],target,resultArr)
    else:
        resultArr.append(currVal + numbers[currInd])
        resultArr.append(currVal - numbers[currInd])
    return resultArr
