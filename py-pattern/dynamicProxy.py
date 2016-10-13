#coding:utf-8

class computerProduce(object):
    def __init__(self):
        pass

    def produceTime(self):
        print 'the computer produce time is today'

    def computerName(self):
        print 'the name is mac'


class carProcude(object):
    def __init__(self):
        pass

    def carName(self):
        print 'the car name is Benz'

    def carTime(self):
        print 'the car produce time is today'


class dynamicProxy(object):
    def __init__(self):
        pass

    def invoke(self,instance):
        print '采用动态代理'
        return instance




if __name__ == '__main__':
    dp = dynamicProxy()
    instance = dp.invoke(carProcude())
    instance.carName()
