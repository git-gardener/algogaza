def solution(array, commands):
    idx = 0;
    answerArr = [];
    while idx < len(commands):
        temp = array[commands[idx][0] - 1 : commands[idx][1]]
        temp.sort(reverse = False);
        tempNum = commands[idx][2] - 1;
        answerArr.append(temp[tempNum]);
        idx += 1;
    return answerArr
