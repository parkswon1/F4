public static int[] solution(String[] genres, int[] plays) {
    // 결과를 저장할 리스트
    List<Integer> answerList = new ArrayList<>();
    // 장르별로 플레이 리스트와 총 플레이 횟수를 관리하는 맵
    Map<String, PriorityQueue<int[]>> genresMap = new HashMap<>();
    Map<String, Integer> totalPlaysMap = new HashMap<>();

    // 장르와 플레이 횟수를 순회하며 처리
    for (int i = 0; i < genres.length; i++) {
        String genre = genres[i];
        int play = plays[i];

        // 해당 장르가 맵에 없으면 새로운 우선순위 큐를 만들어 추가
        if (!genresMap.containsKey(genre)) {
            genresMap.put(genre, new PriorityQueue<>((a, b) -> b[0] - a[0])); // 최대 힙 구현
            totalPlaysMap.put(genre, 0); // 해당 장르의 총 플레이 횟수를 0으로 초기화
        }

        // 해당 장르의 우선순위 큐에 [플레이 횟수, 곡의 인덱스]를 추가
        genresMap.get(genre).offer(new int[]{play, i});
        // 해당 장르의 총 플레이 횟수 갱신
        totalPlaysMap.put(genre, totalPlaysMap.get(genre) + play);
    }

    // 총 플레이 횟수에 따라 장르를 정렬
    List<String> sortedGenres = new ArrayList<>(totalPlaysMap.keySet());
    Collections.sort(sortedGenres, (a, b) -> totalPlaysMap.get(b) - totalPlaysMap.get(a));

    // 정렬된 장르를 순회하며 각 장르별로 최대 2개의 곡을 선택하여 결과 리스트에 추가
    for (String genre : sortedGenres) {
        PriorityQueue<int[]> pq = genresMap.get(genre);
        for (int j = 0; j < 2 && !pq.isEmpty(); j++) {
            answerList.add(pq.poll()[1]); // 곡의 인덱스를 결과 리스트에 추가
        }
    }

    // 결과 리스트를 배열로 변환하여 반환
    int[] answer = new int[answerList.size()];
    for (int i = 0; i < answerList.size(); i++) {
        answer[i] = answerList.get(i);
    }

    return answer;
}