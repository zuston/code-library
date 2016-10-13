#coding:utf-8
from numpy import *
import time
import matplotlib.pyplot as plt


#计算距离
def euclDistance(vector1, vector2):
    return sqrt(sum(power(vector2 - vector1, 2)))

#初始新质心,选择样本点
def initCentroids(dataSet, k):
    # numSamples为维度，dim为列数
    numSamples, dim = dataSet.shape
    # 创建一个向量,全部初始化为0
    centroids = zeros((k, dim))
    for i in range(k):
        index = int(random.uniform(0, numSamples))
        # 从数据集赋值到样本点list
        centroids[i, :] = dataSet[index, :]
    return centroids

# k-means具体方法
def kmeans(dataSet, k):
    # 获取数据集维度，即行数
    numSamples = dataSet.shape[0]
    # first column stores which cluster this sample belongs to,
    # second column stores the error between this sample and its centroid
    clusterAssment = mat(zeros((numSamples, 2)))
    clusterChanged = True

    ## 初始化样本点数据集
    centroids = initCentroids(dataSet, k)

    # 建立迭代中心的变化
    loopCount=0
    while clusterChanged:
        clusterChanged = False
        for i in xrange(numSamples):
            minDist  = 100000.0
            minIndex = 0
            # 对于每一组样本点与余下的点进行距离比较，最近的distance与样本点记录下来
            for j in range(k):
                distance = euclDistance(centroids[j, :], dataSet[i, :])
                if distance < minDist:
                    minDist  = distance
                    minIndex = j

            ## 更新原有的标记值
            if clusterAssment[i, 0] != minIndex:
                clusterChanged = True
                clusterAssment[i, :] = minIndex, minDist**2

        ## 更新样本点中心之后的值
        for j in range(k):
            # 获取所有属于cluster j的dataset点的list
            pointsInCluster = dataSet[nonzero(clusterAssment[:, 0].A == j)[0]]
            # 求点的中心值
            centroids[j, :] = mean(pointsInCluster, axis = 0)
        loopCount += 1

    print 'Congratulations, cluster complete!'
    print '通过中心点迭代%d次'%loopCount
    return centroids, clusterAssment

# 数据展示,此处为2d点阵图
def showCluster(dataSet, k, centroids, clusterAssment):
    numSamples, dim = dataSet.shape
    if dim != 2:
        print "Sorry! I can not draw because the dimension of your data is not 2!"
        return 1

    # 分类数的各自标记
    mark = ['or', 'ob', 'og', 'ok', '^r', '+r', 'sr', 'dr', '<r', 'pr']
    if k > len(mark):
        print "Sorry! Your k is too large! please contact Zouxy"
        return 1

    # draw all samples
    for i in xrange(numSamples):
        # 获取数据属于的哪一个cluster
        markIndex = int(clusterAssment[i, 0])
        plt.plot(dataSet[i, 0], dataSet[i, 1], mark[markIndex])

    mark = ['Dr', 'Db', 'Dg', 'Dk', '^b', '+b', 'sb', 'db', '<b', 'pb']
    # 绘制中心点的图
    for i in range(k):
        plt.plot(centroids[i, 0], centroids[i, 1], mark[i], markersize = 12)

    plt.show()


def showClusterOfK(k):
    dataSet = []
    file = open("./testSet.txt")
    for line in file.readlines():
        llist = line.strip().split("\t")
        dataSet.append([float(llist[0]),float(llist[1])])

    mdataSet = mat(dataSet)
    fig = plt.figure()
    numSamples,dim = mdataSet.shape
    if dim != 2:
        print "Sorry! I can not draw because the dimension of your data is not 2!"
        return 1


    for i in range(1,k):
        centroids,data = kmeans(mdataSet,i)
        acx = fig.add_subplot(2,2,i)
        mark = ['or', 'ob', 'og', 'ok', '^r', '+r', 'sr', 'dr', '<r', 'pr']
        if i > len(mark):
            print "Sorry! Your k is too large! please contact Zouxy"
            return 1

        for e in xrange(numSamples):
            # 获取数据属于的哪一个cluster
            markIndex = int(data[e, 0])
            acx.plot(mdataSet[e, 0], mdataSet[e, 1], mark[markIndex],markersize=4)

        mark = ['Dr', 'Db', 'Dg', 'Dk', '^b', '+b', 'sb', 'db', '<b', 'pb']
        # 绘制中心点的图
        for p in range(i):
            acx.plot(centroids[p, 0], centroids[p, 1], mark[p], markersize = 10)
    plt.show()

def showClusterOf1(k):
    print "step 1: load data..."
    dataSet = []
    fileIn = open('./testSet.txt')
    for line in fileIn.readlines():
        lineArr = line.strip().split('\t')
        dataSet.append([float(lineArr[0]), float(lineArr[1])])

    ## step 2: clustering...
    print "step 2: clustering..."
    dataSet = mat(dataSet)
    centroids, clusterAssment = kmeans(dataSet, k)

    ## step 3: show the result
    print "step 3: show the result..."
    showCluster(dataSet, k, centroids, clusterAssment)


if __name__ == "__main__":
    # showClusterOf1(4)
    showClusterOfK(5)
