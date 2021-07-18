# -*- coding: utf-8 -*-
import operator
from collections import defaultdict
def solution(genres, plays):
    answer = []
    playsTotal = {}
    orderedGenres = []
    infoDict = {}

    # 장르별 total이 가장 큰 장르명 순으로 정렬
    for i in range(len(plays)):
        if(playsTotal.get(genres[i]) == None):
            playsTotal[genres[i]] = plays[i]
            infoDict[genres[i]] = []
        else : playsTotal[genres[i]] = playsTotal[genres[i]] + plays[i]

    # orderedGenres=sorted(playsTotal.items(),key=operator.itemgetter(1), reverse=True)
    orderedGenres = playsTotal = sorted(playsTotal, key=playsTotal.get, reverse=True)
    print(playsTotal)

    # key는 장르 value는 {플레이횟수,인덱스번호}를 가지는 딕셔너리 생성
    for i, genres_plays in enumerate(zip(genres, plays)):
        infoDict[genres_plays[0]].append((genres_plays[1], i))

    # 장르별로 최대 재생횟수 2건 구하기
    for genre in orderedGenres:
        tmp = sorted(infoDict[genre], key=operator.itemgetter(0), reverse=True)
        print(tmp)
        if len(tmp) == 1:
            answer.append(tmp[0][1])
        else:
            answer.append(tmp[0][1])
            answer.append(tmp[1][1])

    return answer


solution(["classic", "pop", "classic", "pop", "classic", "classic"],[400, 600, 150, 600, 500, 500])



#미친 고인물 넘들....
def solution1(genres, plays):
    answer = []
    d = {e:[] for e in set(genres)}
    for e in zip(genres, plays, range(len(plays))):
        d[e[0]].append([e[1] , e[2]])
    genreSort =sorted(list(d.keys()), key= lambda x: sum( map(lambda y: y[0],d[x])), reverse = True)
    for g in genreSort:
        temp = [e[1] for e in sorted(d[g],key= lambda x: (x[0], -x[1]), reverse = True)]
        answer += temp[:min(len(temp),2)]
    return answer