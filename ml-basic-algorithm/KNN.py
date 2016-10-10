#coding:utf-8
import numpy as np

def knn(exmpleSet,dataset,labelset,k):
        if len(dataset)!=len(labelset):
            print '检查参数，标记数和数据集不对等'
            return

        dset = np.array(dataset)
        # 一维数组
        eset = np.array(exmpleSet)

        res = (((dset-eset)**2).sum(axis=1))**0.5
        index = np.argsort(res)
        resCount = {0:0,1:0}
        for c in range(k):
            labelFlag = labelset[index[c]]
            resCount[labelFlag] += 1

        # print resCount
        return 0 if resCount[0]>resCount[1] else 1


if __name__ == '__main__':
    '''
    电影场景的判断：x参数为打斗出现场景次数
                 y参数为吻戏出现场景次数
                 labelset 标记为0为打斗戏，1为爱情戏

                 来自《machine learning in action》
    '''
    exmpleSet = [3,2]
    dataset = [[8,3],[10,1],[45,32],[78,34],[9,18],[23,45],[34,45],[12,19]]
    labelset = [0,0,0,0,1,1,1,1]
    print knn(exmpleSet,dataset,labelset,5)
