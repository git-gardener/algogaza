def solution(answers):
    arr1 = [1,2,3,4,5]
    arr2 = [2,1,2,3,2,4,2,5]
    arr3 = [3,3,1,1,2,2,4,4,5,5]
    answer = []
    number = 0
    numbers = [0,0,0]
    
    for ans in answers:
        if ans == arr1[number%5]:
            numbers[0] = numbers[0] + 1
        if ans == arr2[number%8]:
            numbers[1] = numbers[1] + 1
        if ans == arr3[number%10]:
            numbers[2] = numbers[2] + 1
        number = number + 1
    
    for cnt,num in enumerate(numbers):
        if num == max(numbers):
            answer.append(cnt+1)
    
    return answer
