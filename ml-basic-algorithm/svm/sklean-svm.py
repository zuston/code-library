#coding:utf-8
from sklearn import datasets,svm
import matplotlib.pyplot as plt
import numpy as np

print 'loading the datasets'
ds = []
labels = []
fileIn = open('./testSet.txt')
for line in fileIn.readlines():
	lineArr = line.strip().split('\t')
	ds.append([float(lineArr[0]), float(lineArr[1])])
	labels.append(float(lineArr[2]))

# 作为训练集
training_ds = ds[:60]
training_labels = labels[:60]

# 作为测试集
predict_ds = ds[80:]
predict_labels = labels[80:]

print 'the machine is training...'
clf = svm.NuSVC()
clf.fit(training_ds,training_labels)

print 'the machine is predicting test'
resList = []
for oneds in predict_ds:
    labels = clf.predict([oneds])
    resList.append(labels[0])

correctCount = 0
for i in range(len(predict_labels)):
    if predict_labels[i]==resList[i]:
        correctCount += 1

print "正确率："+str(float(correctCount)/len(predict_labels)*100)+"%"
print len(clf.support_vectors_)
print clf.support_vectors_
print clf.support_
print len(clf.support_)
