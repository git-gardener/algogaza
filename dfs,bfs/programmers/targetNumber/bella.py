# def solution(numbers, target):
#     cnt = len(numbers)
#     answer = 0
#
#     def dfs(index, result):
#         if index == cnt:
#             if result == target:
#                 nonlocal answer
#                 answer = answer + 1
#             return
#         else:
#             dfs(index + 1, result + numbers[index])
#             dfs(index + 1, result - numbers[index])
#
#     dfs(0, 0)
#     return answer

# 고인물 코드
def solution2(numbers, target):
    if not numbers and target == 0 :
        return 1
    elif not numbers:
        return 0
    else:
        return solution2(numbers[1:], target-numbers[0]) + solution2(numbers[1:], target+numbers[0])