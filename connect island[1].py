def solution(n, costs):
    answer = 0
    costs.sort(key=lambda x: x[2])
    visited = [True] + [False] * (n - 1)

    while not all(visited):
        for cur_node, next_node, cost in costs:
            print(visited)
            if visited[cur_node] and visited[next_node]:
                continue
            if visited[cur_node] or visited[next_node]:
                visited[cur_node] = visited[next_node] = True
                answer += cost
                break
    return answer