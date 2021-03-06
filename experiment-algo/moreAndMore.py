#coding:utf-8
'''
问题描述
某公司要求它的一些员工从事若干个项目。因这些项目相当复杂，项目是分期进行的，但每个项目需要熟悉该项目的人数越多越好。当然对人员有一定的要求。
公司的员工很多，达10000000人，编号从1到10000000。员工们中如果有人熟悉这个项目，那么与其认识的人只要讨教一些技巧后也能知道项目如何进行，经过传帮带后所有与其直接或间接认识的人也掌握了从事项目的技巧。为便于交流与项目修改，要求从事项目的人都直接或间接认识。
现在给定直接认识的人员对，您应该做出正确的选择。
输入
有若干个项目。每个项目的数据中第一行是一个整数n (0 ≤ n ≤ 100000) ，即该项目中直接认识的人数对。接下来有n行，每行是一个用空格隔开的数对A和B，表示他们认识，(A ≠ B, 1 ≤ A, B ≤ 10000000) 。
输出
对每个项目输出从事项目的最大人数。
输入样例
4
1 2
3 4
5 6
1 6
4
1 2
3 4
5 6
7 8
输出样例
4
2
'''
def moreAndMore():
    n = raw_input()
    while n!=0 :
        relationList = []
        for i in range(int(n)):
            a,b = raw_input().strip().split()
            a = int(a)
            b = int(b)
            relationList.append([a,b])



# 求有交集集合的并集
def unionListMax(relationList,searchNumber=None):
    for i in range(len(relationList)):
        for one in i:
            if searchNumber!=None and searchNumber==one:
                unionListMax(relationList[i+1:],one)


def test():
    echoList = [[2,4],[5,7],[2,8],[8,5]]
    unionListMax(echoList)

if __name__ == '__main__':
    # moreAndMore()
    test()
