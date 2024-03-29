from collections import deque

def solution(people, limit):
    answer = 0
    people.sort() ##이 문제의 핵심 정렬을 통해서 가벼운거에서 무거운 순으로 바꾸고 가장 무거운 거랑 가장 가벼운거랑 합처보고 limit보다 크가면 불가능하다는 거니까 제거
    people = deque(people)
    while(len(people) > 1): 
        back = people.pop()
        if back + people[0] <= limit: ##가장 큰 값이 리미트보다 클경우도 answer값을 1올려주는데 이것이 반례가 될수 있겠지만 이번 문제에 이런 반례는 없는듯
            people.popleft()
        answer += 1

    if len(people) == 1 and people.pop() <= limit: ##que에 하나 남았을수 있으니 그거 방지
        answer += 1

    return answer

people = [70, 80, 50]
limit = 100
print(solution(people, limit))