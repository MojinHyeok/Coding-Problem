def solution(genres, plays):
    answer=[]
    UniqueNumber=dict()
    set_genres=set(genres)
    set_genres=list(set_genres)#set는 for 문을 못돌기 때문에  for문을 돌게 하기위해
    for i in range(len(set_genres)):
        UniqueNumber[set_genres[i]]=[]
    for i in range(len(genres)):
        UniqueNumber[genres[i]].append([i,plays[i]])
    UniqueTotal=dict()
    for k in set_genres:
        sum=0
        for j in range(len(UniqueNumber[k])):
            sum+=UniqueNumber[k][j][1]
        UniqueTotal[k]=sum
    UniqueTotal=sorted(UniqueTotal, key = lambda x :UniqueTotal[x],reverse=True)
    for k in UniqueTotal:
        for j in range(len(UniqueNumber[k])):
            UniqueNumber[k]=sorted(UniqueNumber[k] , key=lambda x : x[1],reverse=True )
    for k in UniqueTotal:
        if len(UniqueNumber[k])==1:
            answer.append(UniqueNumber[k][0][0])
            continue
        for j in range(2):
            answer.append(UniqueNumber[k][j][0])
    return answer
print(solution(['classic', 'pop', 'classic', 'classic', 'pop','zaz'], [500, 600, 150, 800, 2500,1000000]))