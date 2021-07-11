def solution(numbers):
    answer=''
    numbers = map(str,numbers)
    nd=sorted(numbers,key=lambda x:x*3,reverse=True)
    for i in nd:
        answer = answer + i
    print(nd)
    if answer =='000':
        answer = '0'
    return answer

print(solution([15,1515]))
print(solution([0,0,0]))
print(solution([40,404]))