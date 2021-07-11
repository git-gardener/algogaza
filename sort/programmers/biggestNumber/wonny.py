def solution(numbers):
    
    num_str = []
    num_str2 = {}
    num_str3 = []
    answer = ''    
    
    for x in numbers :
        num_str.append(str(x))
    num_str.sort(reverse=True)

    for x in num_str:
        num_str2[int(''.join(x))/(10**(len(x))-1)] = len(x)
    
    num_str3 = sorted(num_str2.keys(),reverse=True)
      
    for x in num_str3:
        print(x,(10**num_str2[x]),x*(10**num_str2[x]-1),int(x*(10**num_str2[x])))
        answer += str(int(x*(10**num_str2[x])))
                  
    return answer

