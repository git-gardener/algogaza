def solution(genres, plays):
    answer = []
    rank = {}
    info = {}
    top1 = {}
    top2 = {}

    for i in range(len(genres)):
        if genres[i] in rank : rank[genres[i]] += plays[i]
        else : rank[genres[i]] = plays[i]
        info[i] = [genres[i],plays[i]]
    rank = sorted(rank.items(), key=lambda x:x[1] ,reverse=True)
    for i in range(len(genres)):
        print(info[i])
        if info[i][0] == rank[0][0] : top1[i] = info[i]
        if info[i][0] == rank[1][0] : top2[i] = info[i]
    
    
    top1 = sorted(top1.items(),key=lambda x:x[1][1],reverse=True)
    top2 = sorted(top2.items(),key=lambda x:x[1][1],reverse=True)
    
    for i in range(len(top1)):
        answer.append(top1[i][0])
        if i >= 1 : break
    for i in range(len(top2)):
        answer.append(top2[i][0])
        if i >= 1 : break    

    return answer
