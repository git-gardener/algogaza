def solution(progresses, speeds):
    answer=[]
    restlist=[]
    restlist2=[]
    nextcnt = 1 

    for i in progresses:
        restlist.append(100-i)
        
    for x in range(len(speeds)):

        if restlist[x]%speeds[x] != 0:
            restlist2.append(int(restlist[x]/speeds[x])+1)
        else:
            restlist2.append(int(restlist[x]/speeds[x]))

    comp = restlist2[0]
    for i in range(1,len(restlist2)):
        if comp>=restlist2[i]:
            nextcnt += 1
        else:
            answer.append(nextcnt)
            comp = restlist2[i] 
            nextcnt = 1 
        if i == len(restlist2)-1:
            answer.append(nextcnt)

    return answer
