#!/usr/bin/python
#coding:utf-8
# 实现一个可以监视用户的提供的过个队列，并从多个已知的已回调函数里面调用
# 实现多重多线程调用任务队列

import redis
import os
import sys
import json
import random
import time
import threading

# redis中的队列操作
class redisTaskQueue(object):
    def __init__(self):
        self.redisConn = redis.StrictRedis(host='localhost',port=6379)

    def push(self,data={}):
        if len(data)==0:
            return False
        try:
            self.redisConn.rpush("queue",json.dumps(data))
            return True
        except Exception:
            return False

    def pop(self):
        data = self.redisConn.lpop("queue")
        return json.loads(data)

# 执行的注册方法
def worker_watch_queue(data,callbacks,count):
    print "当前为%d个任务："%count
    functionName = data["function"]
    if functionName in callbacks:
        callbacks[functionName]()

# email动作方法
def email():
    print "this is the email function"

# sms动作方法
def sms():
    time.sleep(10)
    print "this is the sms function"


# 主循环，监测任务队列的任务，并且放入注册方法中执行
def loopTest():
    rd = redisTaskQueue()
    count = 0
    callbacks = {
        "email":email,
        "sms":sms
    }
    while True:
        data = {
            "function":"sms",
            "id":random.random()
        }
        # print "插入结果:"+str(rd.push()
        rd.push(data)
        count = count+1
        dres = rd.pop()
        # TODO: 需要对于执行完的线程进行下一个任务的执行
        if count<=5:
            startThreading(dres,callbacks,count)
        else:
            if listenThreading() is True:
                count = 1
                continue
    print 'everything is over'

# 开启多线程执行注册方法
def startThreading(dres,callbacks,count):
    t = threading.Thread(target=worker_watch_queue,args=(dres,callbacks,count))
    t.start()


# 监听线程数量
def listenThreading():
    number = threading.active_count()
    if number>=5:
        print "当前线程数%d"%number
        time.sleep(5)
        listenThreading()
    else:
        return True

if __name__ == "__main__":
    loopTest()
