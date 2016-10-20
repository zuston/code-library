#!/usr/bin/python
#coding:utf-8

import time
import redis
import json
import uuid

'''
实现一个延迟队列
基本思路：
跑一个进程将所有的延迟任务都加入到一个有序集合队列，将他们的延迟时间作为分值进行排序
另外跑一个进程定期搜索有序集合队列的分值最小的任务，查看时间点是否到了，如果要执行，则继续加入任务队列中
最后一个进程则是执行任务队列的任务
'''

# redis连接
redisConn = redis.StrictRedis(host='localhost',port=6379)
# 延迟有序队列name
delay_zset_name = 'queue:delay'
# 任务队列名字
task_queue_name = 'queue:task'
# 注册方法
callbacks = {"mail":mail,"sms":sms}

# 加入延迟队列，如果delay为0，则直接加入任务队列
def join_zset(redisConn,functionName,args,delay=0):
    identifer = str(uuid.uuid4())
    data = json.dumps([identifer,functionName,args])
    if delay>0:
        redisConn.zadd(delay_zset_name,data,time.time()+delay)
    else:
        redisConn.rpush(task_queue_name,data)
    return identifer


# 检测延迟队列，是否可以加入任务队列
def check_zset2queue():
    while True:
        items = redisConn.zrange(delay_zset_name,0,0,withscores=True)
        if not items or time.time()>items[0][1]:
            time.sleep(1)
            continue

        item = items[0][0]
        identifer,functionName,args = json.loads(item)

        # 删除队列中的，进入任务队列中
        if redisConn.zrem(delay_zset_name,item):
            redisConn.rpush(task_queue_name,item)

# 检测任务队列并且放入注册函数执行
def check_taskQueue():
    while True:
        item = redisConn.lpop(task_queue_name)
        if item is None:
            time.sleep(1)
            continue

        identifer,functionName,args = json.loads(item)
        if functionName in callbacks:
            # TODO: 可以多开线程执行，不执行耗时堵塞
            callbacks[functionName](args)


def mail():
    print "执行mail操作"

def sms():
    print "执行短信操作"


if __name__ == "__main__":
    pass
