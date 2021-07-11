def solution(citations):
    answer = 0
    citations = sorted(citations,reverse=True)
    print(citations)
    if citations[0] == 0: return answer
    for i in range(len(citations)):
        if citations[i] > i:
            answer = answer+1
    return answer

#고인물 코드.....
def solution(citations):
    citations.sort(reverse=True)
    answer = max(map(min, enumerate(citations, start=1)))
    return answer