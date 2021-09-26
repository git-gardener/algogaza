# -*- coding: utf-8 -*-
def solution(id_list,report,k):
    user_dict = {} # 유저 : [해당 유저를 신고한 유저]
    users_mail = {} # 유저 : 신고 메일을 받는 횟수
    declar_cnt = {} # 유저 : 신고당한 횟수
    answer = []

    for i in id_list:
        user_dict[i] = []
        declar_cnt[i] = 0
        users_mail[i] = 0

    for r in report:
        users = r.split(" ")
        if user_dict[users[1]].__contains__(users[0]) == False:
            user_dict[users[1]].append(users[0])
            declar_cnt[users[1]] += 1

    for d in declar_cnt:
        if declar_cnt[d] >= k:
            for u in user_dict[d]:
                users_mail[u] += 1

    for a in id_list:
        answer.append(users_mail[a])

    return answer


print(solution(["muzi", "frodo", "apeach", "neo"],["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"],2))
# [2,1,1,0]
print(solution(["con", "ryan"],["ryan con", "ryan con", "ryan con", "ryan con"],3))
# [0,0]