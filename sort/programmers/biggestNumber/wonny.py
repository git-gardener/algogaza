def solution(numbers):
    
    answer = ''    
    
    numbers = list(map(str,numbers))
    numbers.sort(reverse=True,key = lambda x:int(x)/(10**len(x)-1))
    
    for x in numbers :
        answer += x
    if answer.replace("0","") == "" :
        answer = "0"

    return answer
