def solution(n, times):
    leng = len(times)#길이구하기
    answer = bise(n,times,leng)
    return answer
def bise(x,a,y):
    start=0
    end=max(a)*x
    while start<=end:
        li = [0] * y
        li1 = [1] * y
        mid=(start+end)//2
        for i in range(y):
            li[i]=mid//a[i]
            li1[i]=mid%a[i]
        zero=li1.count(0)-1#답을 구할때 동시에 끝나는 경우도 생각하기 위해서
        if sum(li)>=x and sum(li)<=x+zero:
            while sum(li)>=x and sum(li)<=x+zero:#부합하는조건중 가장 최소의 값을 구하기 위해
                li = [0] * y
                mid-=1
                for i in range(y):
                    li[i]=mid//a[i]
            return mid+1
        elif sum(li)<x:
            start=mid+1
        else:
            end=mid-1
    return -1
print(solution(1000000000, [1, 1000000000, 1000000000]))