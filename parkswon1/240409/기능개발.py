from collections import deque

def solution(progresses, speeds):
    # 각 기능의 완료 상태를 저장할 리스트
    answer = []

    # 입력된 진도와 완료 속도를 양방향큐로 변환
    progresses = deque(progresses)
    speeds = deque(speeds)

    # 진도를 계산할 날짜 초기화
    day = 1

    # 하루씩 증가하면서 각 기능의 진도를 확인하여 처리
    count = 0
    while(progresses):
        # 가장 앞에 있는 기능의 진도가 100 이상인지 확인하여 처리
        if progresses[0] + speeds[0] * day >= 100:
            # 완료된 기능을 양뱡향큐의 앞에서 제거하고 카운트 증가
            progresses.popleft()
            speeds.popleft()
            count += 1
        else:
            # 이전에 완료된 기능이 있었다면, 그때의 카운트를 정답 리스트에 추가하고 카운트 초기화
            if count != 0:
                answer.append(count)
                count = 0
            # 다음 날로 진도를 계산하기 위해 날짜 증가
            day += 1

    # 마지막으로 완료된 기능이 있을 경우에 대한 처리
    if count != 0:
        answer.append(count)

    return answer
