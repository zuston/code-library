#coding:utf-8
'''
输入有多种情况。
每种情况以一行上两个整数n、m开始，其中n是所有人数，m是社团数。可假定0 < n <= 3000、0 <= m <= 100。每个人有0到n-1的唯一一个标号，编号为0的人是怀疑对象。
接着有m行，每行是一个社团的信息。该行的第一个数是整数k，接着有k个整数表示该社团的k个人。所有整数之间有空格隔开。
当输入为n = 0、m = 0时表示输入结束，这种情况不必处理。两组数据之间有一个空行。
Output
对每种情况，一行输出所有被怀疑的人员的总是。
Sample Input
100 4
2 1 2
5 10 13 11 12 14
2 0 1
2 99 2
200 2
1 5
5 1 2 3 4 5
1 0
0 0
Sample Output
4
1
1
'''
def h7n9():
    n,m = raw_input().strip().split()
    n = int(n)
    m = int(m)
    rl = []
    while n!=0 or m!=0:
        # 定义每行的第一个数据
        rowList = []
        # 最后的人数集合
        resSet = set()
        # 数据集合
        dataList = []
        for i in range(m):
            d = raw_input().strip().split()
            k = int(d[0])
            rowList.append(k)
            dataList.append(d[1:])

        for onerow in dataList:
            for one in onerow:
                if one in resSet:
                    resSet = addToSet(resSet,onerow)
                    break
                if one=='0':
                    resSet = addToSet(resSet,onerow)
                    break
        print len(resSet)
        rl.append(resSet)

        dd = raw_input().strip().split()
        if len(dd)!=2:
            break
        n = int(n)
        m = int(m)

    for row in rl:
        print len(row)

def addToSet(resSet,onerow):
    for one in onerow:
        resSet.add(one)
    return resSet


if __name__ == "__main__":
    h7n9()
