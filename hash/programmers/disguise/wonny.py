def solution(clothes):
    dic = {}
    for x in clothes :
        if x[1] in dic : dic[x[1]] += 1
        else : dic[x[1]]=1
    
    answer = 1
    
    for x in dic.values():
        answer = answer * (x+1)
    answer = answer - 1
        
    return answer
