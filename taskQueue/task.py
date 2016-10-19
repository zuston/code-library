#coding:utf-8
# 实现一个可以监视用户的提供的过个队列，并从多个已知的已回调函数里面。

import redis
import os
import sys
import json

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

def worker_watch_queue(data,callbacks=[]):
    pass

def work_function_email():
    pass

def work_function_sms():
    pass


if __name__ == "__main__":
    rd = redisTaskQueue()
    data = {
        "email":"jinxi32@163.com",
        "age":32,
        "name":"zuston"
    }
    print rd.push(data)
    jsonD = rd.pop()
    print jsonD