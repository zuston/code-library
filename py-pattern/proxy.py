#!/usr/bin/env python
# -*- coding:utf-8 -*-

# 延迟加载
class factoryBase(object):
    def __init__(self):
        pass

    def eat(self):
        print 'this the factoryBase function'

class factory(factoryBase):
    def __init__(self):
        pass

    def eat(self):
        print 'this is the factory function '


class proxy(factoryBase):
    def __init__(self):
        pass

    def eat(self):
        print 'this is the proxy function'
        fac = factory()
        fac.eat()


if __name__ == '__main__':
    pro = proxy()
    pro.eat()
