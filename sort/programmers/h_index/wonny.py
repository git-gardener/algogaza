def solution(citations):
    quote = 0
    num = 0
    answer = 0
    citations.sort(reverse=True)
    
    for i in range(len(citations)):
        if citations[0] == 0:
            break
        print(num, citations[i])
        if citations[i] <= num:
            break
        num += 1
            
    answer = num
    return answer
