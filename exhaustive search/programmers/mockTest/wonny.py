def solution(answers):
    answer = []
    '''
    cnt1 = 0
    cnt2 = 0
    cnt3 = 0
    '''
    
    scores = {1:0,2:0,3:0}
    ans2 = [2, 1, 2, 3, 2, 4, 2, 5]
    ans3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    for ind in range(len(answers)):
        #1번 수포자 정답확인
        if answers[ind]==(ind+1)%5 :
            scores[1] += 1
        
        #2번 수포자 정답확인
        if ans2[ind%8]==answers[ind] :
            scores[2] += 1
        
        #3번 수포자 정답확인
        if ans3[ind%10]==answers[ind] :
            scores[3] += 1
    
    scores = sorted(scores.items(),key=lambda x:x[1],reverse=True)
        
    for score in scores: 
        if score[1] == scores[0][1]:
            answer.append(score[0])
        else:
            break
        
    return sorted(answer)
