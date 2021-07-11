def solution(array, commands):
    answer = []
    for i in commands:
        tmpArr = array[i[0]-1:i[1]]
        tmpArr.sort()
        answer.append(tmpArr[i[2]-1])
    return answer