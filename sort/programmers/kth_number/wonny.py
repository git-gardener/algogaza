def solution(array, commands):
    print(len(commands))
    answer = []
    for i in range(len(commands)):
        ar1 = array[commands[i][0]-1:commands[i][1]]
        ar1.sort()
        answer.append(ar1[commands[i][2]-1])
    return answer
