-- 食堂消费记录
-- 食堂一顿平均消费
select avg(amount) as consumer,b.BUSINESSNAME from transaction a left join terminal b on a.TERMID=b.TERMID where (b.BUSINESSNAME like "%食堂%" or b.businessname like "%清真%") and a.amount > 0.5 group by b.BUSINESSNAME;
+--------------------+-----------------------------------+
| consumer           | BUSINESSNAME                      |
+--------------------+-----------------------------------+
|  8.600165801950231 | 中快食堂                          |
|   7.03128920732857 | 吾悦食堂                          |
| 4.9062008031066915 | 吾馨食堂                          |
| 5.7223345816252476 | 尔美一楼食堂                      |
| 10.162504215224176 | 尔美二楼食堂                      |
|                  5 | 尔美教授食堂                      |
|   5.32774431027734 | 山明食堂                          |
| 3.1248004726516583 | 延长一食堂早班                    |
|   7.98895922401475 | 延长一食堂梅陇                    |
|  8.131710284024447 | 延长三食堂一楼卤味                |
|  5.301760719138024 | 延长三食堂一楼面条                |
|                  5 | 延长三食堂三楼                    |
|  9.482627295189033 | 延长三食堂二楼中式                |
|   6.67334760683988 | 延长三食堂二楼沙县小吃            |
|  7.407454757550669 | 延长五食堂一楼午晚餐              |
| 12.076796066494964 | 延长五食堂二楼                    |
|  8.564409414408775 | 延长清真新                        |
| 7.8062621073379885 | 延长第二食堂                      |
|  6.287258405318606 | 得月食堂                          |
|  8.546033076000269 | 得福食堂                          |
|  46.29542875157629 | 招待食堂                          |
|  9.062718201338916 | 新闸路C楼食堂                     |
|  5.293654710026995 | 水秀食堂                          |
|  6.867079287727309 | 留香食堂                          |
|  4.863054904486548 | 益新食堂                          |
|   5.64529656740931 | 良友食堂                          |
+--------------------+-----------------------------------+

-- 最高消费
select avg(t.amo),t.name from (select max(amount) as amo,a.stuempno as no,b.BUSINESSNAME as name from transaction a left join terminal b on a.TERMID=b.TERMID where (b.BUSINESSNAME like "%食堂%" or b.businessname like "%清真%") and a.amount > 0.5 group by a.stuempno,b.businessname) t group by t.name;
+--------------------+-----------------------------------+
| avg(t.amo)         | name                              |
+--------------------+-----------------------------------+
|  8.925231585150254 | 中快食堂                          |
|  8.722751147842033 | 吾悦食堂                          |
|  7.606522611049829 | 吾馨食堂                          |
|  7.790546571991252 | 尔美一楼食堂                      |
|  9.902273004730649 | 尔美二楼食堂                      |
|                  5 | 尔美教授食堂                      |
|  7.553868178184758 | 山明食堂                          |
|  5.391000368686238 | 延长一食堂早班                    |
|  8.726297658452824 | 延长一食堂梅陇                    |
|  8.733484478548927 | 延长三食堂一楼卤味                |
|  7.237452547452464 | 延长三食堂一楼面条                |
|                  5 | 延长三食堂三楼                    |
|  9.811347905282318 | 延长三食堂二楼中式                |
|  8.230953575909659 | 延长三食堂二楼沙县小吃            |
|   8.44517767377362 | 延长五食堂一楼午晚餐              |
| 12.312073208243616 | 延长五食堂二楼                    |
|  8.897808711270727 | 延长清真新                        |
|  8.888826642125805 | 延长第二食堂                      |
|   8.09059695898924 | 得月食堂                          |
|  8.961172569596283 | 得福食堂                          |
|  55.63397502601457 | 招待食堂                          |
|  9.761505016722394 | 新闸路C楼食堂                     |
|  7.478130866064741 | 水秀食堂                          |
|  8.192032441723068 | 留香食堂                          |
|  7.233077214436557 | 益新食堂                          |
|  7.876793347902631 | 良友食堂                          |
+--------------------+-----------------------------------+

-- 最低消费
select avg(t.amo),t.name from (select min(amount) as amo,a.stuempno as no,b.BUSINESSNAME as name from transaction a left join terminal b on a.TERMID=b.TERMID where (b.BUSINESSNAME like "%食堂%" or b.businessname like "%清真%") and a.amount > 0.5 group by a.stuempno,b.businessname) t group by t.name;
+--------------------+-----------------------------------+
| avg(t.amo)         | name                              |
+--------------------+-----------------------------------+
|  8.399830288744841 | 中快食堂                          |
|  6.439753902662923 | 吾悦食堂                          |
| 2.9311330592600973 | 吾馨食堂                          |
|   5.61874813533023 | 尔美一楼食堂                      |
|  8.946692354646753 | 尔美二楼食堂                      |
|                  5 | 尔美教授食堂                      |
|  4.243786062059382 | 山明食堂                          |
| 2.6105223055181015 | 延长一食堂早班                    |
|  7.985172244697866 | 延长一食堂梅陇                    |
|  8.273121730031374 | 延长三食堂一楼卤味                |
|  4.961968031968028 | 延长三食堂一楼面条                |
|                  5 | 延长三食堂三楼                    |
|  7.533222387812545 | 延长三食堂二楼中式                |
|  5.834224173985763 | 延长三食堂二楼沙县小吃            |
|  7.254818859421103 | 延长五食堂一楼午晚餐              |
| 12.050227622270064 | 延长五食堂二楼                    |
|  8.804135608441864 | 延长清真新                        |
|  7.554753249741236 | 延长第二食堂                      |
|  5.226909197986938 | 得月食堂                          |
|  6.546471359860078 | 得福食堂                          |
| 52.587148803329875 | 招待食堂                          |
|  6.945317725752509 | 新闸路C楼食堂                     |
|  3.734573195142497 | 水秀食堂                          |
|  5.312434203459015 | 留香食堂                          |
|  3.666697689518889 | 益新食堂                          |
|  5.427663770587801 | 良友食堂                          |
+--------------------+-----------------------------------+


-- 图书馆数据查询
-- 全体平均次数
select avg(c) from (select count(*) as c from library group by stuempno) t;
+---------+
| avg(c)  |
+---------+
| 17.2905 |
+---------+

-- 奖学金学生平均次数
select avg(c) from (select count(*) as c from library l inner join prize_code p on l.stuempno=p.stuempno group by l.stuempno) t;
+---------+
| avg(c)  |
+---------+
| 41.6952 |
+---------+

-- 退学生平均次数
select avg(c) from (select count(*) as c from library l inner join tuixue_code p on l.stuempno=p.stuempno group by l.stuempno) t;
+--------+
| avg(c) |
+--------+
| 5.2727 |
+--------+


-- 4月全体平均次数
select avg(c) from (select count(*) as c from library where VisitTime<='20160430' group by stuempno) t;
+--------+
| avg(c) |
+--------+
| 8.3121 |
+--------+

-- 5月全体平均次数
select avg(c) from (select count(*) as c from library where VisitTime between '20160501'and '20160531' group by stuempno) t;
+--------+
| avg(c) |
+--------+
| 9.0661 |
+--------+

-- 6月全体平均次数
select avg(c) from (select count(*) as c from library where VisitTime between '20160601'and '20160630' group by stuempno) t;
+--------+
| avg(c) |
+--------+
| 6.4663 |
+--------+


-- 4月奖学金学生平均次数
select avg(c) from (select count(*) as c from library l inner join prize_code p on l.stuempno=p.stuempno where VisitTime<='20160430' group by l.stuempno) t;
+---------+
| avg(c)  |
+---------+
| 15.5999 |
+---------+

-- 5月奖学金学生平均次数
select avg(c) from (select count(*) as c from library l inner join prize_code p on l.stuempno=p.stuempno where VisitTime between '20160501'and '20160531' group by l.stuempno) t;
+---------+
| avg(c)  |
+---------+
| 19.4955 |
+---------+

-- 6月奖学金学生平均次数
select avg(c) from (select count(*) as c from library l inner join prize_code p on l.stuempno=p.stuempno where VisitTime between '20160601'and '20160630' group by l.stuempno) t;
+---------+
| avg(c)  |
+---------+
| 13.7737 |
+---------+


-- 4月退学生平均次数
select avg(c) from (select count(*) as c from library l inner join tuixue_code p on l.stuempno=p.stuempno where VisitTime<='20160430' group by l.stuempno) t;
+--------+
| avg(c) |
+--------+
| 2.8571 |
+--------+

-- 5月退学生平均次数
select avg(c) from (select count(*) as c from library l inner join tuixue_code p on l.stuempno=p.stuempno where VisitTime between '20160501'and '20160531' group by l.stuempno) t;
+--------+
| avg(c) |
+--------+
| 2.5000 |
+--------+

-- 6月退学生平均次数
select avg(c) from (select count(*) as c from library l inner join tuixue_code p on l.stuempno=p.stuempno where VisitTime between '20160601'and '20160630' group by l.stuempno) t;
+--------+
| avg(c) |
+--------+
| 3.0000 |
+--------+
