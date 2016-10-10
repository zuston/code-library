#!/usr/bin/python
# -*- coding:utf-8 -*-

# py实现单例模式，适用于维持唯一一个数据库连接等
class singleton(object):
    __instance = None
    def __init__(self):
        pass

    def __new__(cls,*kw,**args):
        if singleton.__instance is None:
            singleton.__instance = object.__new__(cls,*kw,**args)
            print 'create the new instance'
        return singleton.__instance


if __name__ == '__main__':
    s1 = singleton()
    s2 = singleton()
