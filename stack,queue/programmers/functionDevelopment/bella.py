import math


def solution(progresses, speeds):
    answer = []
    days = [0] * len(progresses)
    cnt = 1

    for i in range(len(progresses)):
        days[i] = math.ceil((100 - progresses[i]) / speeds[i])

    day = days[0]
    for i in range(1, len(days)):
        if day < days[i]:
            day = days[i]
            answer.append(cnt)
            cnt = 1
        else: cnt += 1

    answer.append(cnt)
    return answer