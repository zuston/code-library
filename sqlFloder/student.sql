-- 食堂消费记录
-- 食堂一顿平均消费
select avg(amount) as consumer,b.BUSINESSNAME from transaction a left join terminal b on a.TERMID=b.TERMID where (b.BUSINESSNAME like "%食堂%" or b.businessname like "%清真%") and a.amount > 0.5 group by b.BUSINESSNAME;
-- 最高消费
select avg(t.amo),t.name from (select max(amount) as amo,a.stuempno as no,b.BUSINESSNAME as name from transaction a left join terminal b on a.TERMID=b.TERMID where (b.BUSINESSNAME like "%食堂%" or b.businessname like "%清真%") and a.amount > 0.5 group by a.stuempno,b.businessname) t group by t.name;
-- 最低消费
select avg(t.amo),t.name from (select min(amount) as amo,a.stuempno as no,b.BUSINESSNAME as name from transaction a left join terminal b on a.TERMID=b.TERMID where (b.BUSINESSNAME like "%食堂%" or b.businessname like "%清真%") and a.amount > 0.5 group by a.stuempno,b.businessname) t group by t.name;


-- 图书馆数据查询
-- 全体平均次数
select avg(c) from (select count(*) as c from library group by stuempno) t;
-- 奖学金学生平均次数
select avg(c) from (select count(*) as c from library l inner join prize_code p on l.stuempno=p.stuempno group by l.stuempno) t;
-- 退学生平均次数
select avg(c) from (select count(*) as c from library l inner join tuixue_code p on l.stuempno=p.stuempno group by l.stuempno) t;


-- 4月全体平均次数
select avg(c) from (select count(*) as c from library where VisitTime<='20160430' group by stuempno) t;
-- 5月全体平均次数
select avg(c) from (select count(*) as c from library where VisitTime between '20160501'and '20160531' group by stuempno) t;
-- 6月全体平均次数
select avg(c) from (select count(*) as c from library where VisitTime between '20160601'and '20160630' group by stuempno) t;

-- 4月奖学金学生平均次数
select avg(c) from (select count(*) as c from library l inner join prize_code p on l.stuempno=p.stuempno where VisitTime<='20160430' group by l.stuempno) t;
-- 5月奖学金学生平均次数
select avg(c) from (select count(*) as c from library l inner join prize_code p on l.stuempno=p.stuempno where VisitTime between '20160501'and '20160531' group by l.stuempno) t;
-- 6月奖学金学生平均次数
select avg(c) from (select count(*) as c from library l inner join prize_code p on l.stuempno=p.stuempno where VisitTime between '20160601'and '20160630' group by l.stuempno) t;


-- 4月退学生平均次数
select avg(c) from (select count(*) as c from library l inner join tuixue_code p on l.stuempno=p.stuempno where VisitTime<='20160430' group by l.stuempno) t;
-- 5月退学生平均次数
select avg(c) from (select count(*) as c from library l inner join tuixue_code p on l.stuempno=p.stuempno where VisitTime between '20160501'and '20160531' group by l.stuempno) t;
-- 6月退学生平均次数
select avg(c) from (select count(*) as c from library l inner join tuixue_code p on l.stuempno=p.stuempno where VisitTime between '20160601'and '20160630' group by l.stuempno) t;
