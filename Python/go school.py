def solution(m, n, puddles):
    answer = 0
    Board=[ [0]*(m+1) for i in range(n+1)]#시작점이 1,1 이므로 한칸씩 더 추가해주기
    Board[1][1]=1##거리구할때에 맨처음시작점은 1로시작
    for a,b in puddles:
        Board[b][a]="X"
    for i in range(1,n+1):
        for j in range(1,m+1):
            if Board[i][j]==1:#이과정을 하지 않는다면 1,1을 구할 때에 0 +0으로 이것도 사라진다.
                continue
            if Board[i][j]=="X":#웅덩이를 만난다면 그것은 스킾을 진행한다.
                continue
            else:
                if Board[i-1][j]=="X":
                    Board[i][j]=Board[i][j-1]
                elif Board[i][j-1]=="X":
                    Board[i][j]=Board[i-1][j]
                else:
                    Board[i][j]=Board[i-1][j]+Board[i][j-1]
    print(Board)
    return Board[-1][-1]%1000000007
print(solution(4,3,[[2,2]]))
