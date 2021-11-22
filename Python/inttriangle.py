def solution(triangle):
    answer = 0
    tri=[[0]*i for i in range(1,len(triangle)+1)]
    tri[0][0]=triangle[0][0]
    for i in range(1,len(triangle)):
        length=len(tri[i])
        for j in range(length):
            if j==0:
                tri[i][j]=tri[i-1][j]+triangle[i][j]
            elif j==length-1:
                tri[i][j]=tri[i-1][j-1]+triangle[i][j]
            else:
                tri[i][j]=max(tri[i-1][j-1]+triangle[i][j],tri[i-1][j]+triangle[i][j])
    answer=max(tri[-1])
    return answer
print(solution([[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]	))