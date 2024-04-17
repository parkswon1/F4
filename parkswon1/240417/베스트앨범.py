import heapq

def solution(genres, plays):
    answer = []
    genresDict = {}
    for i in range(len(genres)):
        if genres[i] not in genresDict:
            genresDict[genres[i]] = {"heapq": [], "total": 0}
        heapq.heappush(genresDict[genres[i]]["heapq"], [-plays[i],i])
        genresDict[genres[i]]["total"] += plays[i]

    sorted_keys = sorted(genresDict, key=lambda x: genresDict[x]["total"], reverse=True)
    for key in sorted_keys:
        for j in range(2):
            if genresDict[key]["heapq"]:
                answer.append(heapq.heappop(genresDict[key]["heapq"])[1])

    return answer

genres = ["classic", "pop", "classic", "classic", "pop"]
plays = [500, 600, 150, 800, 2500]
print(solution(genres, plays))

#문제를 풀고나서 프로그래머스에서 푼 다른분의 풀이
def solution(genres, plays):
    answer = []
    d = {e:[] for e in set(genres)}
    for e in zip(genres, plays, range(len(plays))):
        d[e[0]].append([e[1] , e[2]])
    genreSort =sorted(list(d.keys()), key= lambda x: sum( map(lambda y: y[0],d[x])), reverse = True)
    for g in genreSort:
        temp = [e[1] for e in sorted(d[g],key= lambda x: (x[0], -x[1]), reverse = True)]
        answer += temp[:min(len(temp),2)]
    return answe

"""
2개의 코드를 비교해보자
내가 만든코드는
1. 노래 n개를 한번씩 탐색해서 장르를 확인하고, 딕셔너리에 값, 위치번호, 장르별 통합 횟수를 저장한다.0
-> O(n)
2. 장르별 통합 횟수로 정렬한다.
-> O(m log m)
3. 장르별로 상위 2개 노래른 선택해서 반환
-> O(m)
총합 O(n + mlogm)

다른 분의 풀이
1. 노래의 장르 확인, 딕셔너리에 노래 추가
-> O(nlogn)
2. 장르별로 상위 2개 노래 선택
-> O(mlog2)
총합 O(nlogn + mlog2)

회고:
n의 개숫가 많아지면 많아질수록 내가만든 코드가 더빠르고
m의 종류가 다양해지면 다양해 질수록 내가만든 코드가 느리다.

하지만 m의 종류가 증가한다는 뜻은 n의 개수또한 증가한다는 의미이기 때문에 값이 커진다면 내 코드가 더 빠르다
그렇지만 메모리를 덜써야한다면 여러 방식으로 저장해가야하는 내 코드가 불리하다
"""