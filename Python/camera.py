def solution(routes):
    answer = 1
    routes=sorted(routes,key=lambda x:x[0])
    leng=len(routes)
    temp=routes[0][1]
    for i in range(leng):
        if temp>=routes[i][0]:
            if temp>routes[i][1]:
                temp=routes[i][1]
            else:
                continue
        else:
            temp=routes[i][1]
            answer+=1

    return answer
print(solution([[-20,-15], [-14,-5], [-18,-13], [-5,-3]]))