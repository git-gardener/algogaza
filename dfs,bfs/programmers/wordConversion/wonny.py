def solution(begin, target, words):
    answer = 0
    answerQue = []
        
    def searchWord(currWord,words,depth):
            
        if checkDiff(currWord,begin)==True:
            answerQue.append(depth+1)
        else:
            for word in words:      
                if checkDiff(word,currWord): 
                    searchWord(word,[x for x in words if x!=currWord],depth+1)
                    
      
    searchWord(target,words,0)
    
    if target not in words:
        answer = 0
    else:
        answer = min(answerQue)
    return answer

def checkDiff(word1,word2):
    diff = 0
    for x,y in zip(list(word1),list(word2)):
        if x != y: diff += 1
    
    return diff == 1

