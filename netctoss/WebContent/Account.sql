drop table account;
--创建账号信息表
create table account(
 	account_id		number(9) constraint account_id_pk primary key,
 	recommender_id	number(9),
 	login_name		varchar2(30)  not null,
 	login_passwd	varchar2(30) not null,
 	status			char(1),
 	create_date		date	 default sysdate,
 	pause_date		date,
 	close_date		date,
 	real_name		varchar2(20)	not null,
 	idcard_no		char(18)		not null,
 	birthdate		date,
 	gender	    char(1),
 	occupation		varchar2(50),
 	telephone		varchar2(15) not null,
 	email			varchar2(50),
 	mailaddress		varchar2(200),
 	zipcode			char(6),
 	qq				varchar2(15),
 	last_login_time	  	date,
 	last_login_ip		varchar2(15)
);
--创建账号信息表序列
create sequence account_seq start with 2000;
--插入账号信息
ALTER SESSION SET NLS_DATE_FORMAT = 'yyyy mm dd hh24:mi:ss';
INSERT INTO ACCOUNT(ACCOUNT_ID,RECOMMENDER_ID,LOGIN_NAME,LOGIN_PASSWD,STATUS,CREATE_DATE,
     REAL_NAME,BIRTHDATE,IDCARD_NO,TELEPHONE)
VALUES(1005,NULL,'taiji001','256528',1,'2008 03 15','zhangsanfeng','19430225','410381194302256528',13669351234);

INSERT INTO ACCOUNT(ACCOUNT_ID,RECOMMENDER_ID,LOGIN_NAME,LOGIN_PASSWD,STATUS,CREATE_DATE,
REAL_NAME,BIRTHDATE,IDCARD_NO,TELEPHONE)
VALUES(1010,NULL,'xl18z60','190613',1,'2009 01 10','guojing','19690319','330682196903190613',13338924567);

INSERT INTO ACCOUNT(ACCOUNT_ID,RECOMMENDER_ID,LOGIN_NAME,LOGIN_PASSWD,STATUS,CREATE_DATE,
REAL_NAME,BIRTHDATE,IDCARD_NO,TELEPHONE)
VALUES(1011,1010,'dgbf70','270429',1,'2009 03 01','huangrong','19710827','330902197108270429',13637811357);

INSERT INTO ACCOUNT(ACCOUNT_ID,RECOMMENDER_ID,LOGIN_NAME,LOGIN_PASSWD,STATUS,CREATE_DATE,
REAL_NAME,BIRTHDATE,IDCARD_NO,TELEPHONE)
VALUES(1015,1005,'mjjzh64','041115',1,'2010 03 12','zhangwuji','19890604','610121198906041115',13572952468);

INSERT INTO ACCOUNT(ACCOUNT_ID,RECOMMENDER_ID,LOGIN_NAME,LOGIN_PASSWD,STATUS,CREATE_DATE,
REAL_NAME,BIRTHDATE,IDCARD_NO,TELEPHONE)
VALUES(1018,1011,'jmdxj00','010322',1,'2011 01 01','guofurong','199601010322','350581200201010322',18617832562);

INSERT INTO ACCOUNT(ACCOUNT_ID,RECOMMENDER_ID,LOGIN_NAME,LOGIN_PASSWD,STATUS,CREATE_DATE,
REAL_NAME,BIRTHDATE,IDCARD_NO,TELEPHONE)
VALUES(1019,1011,'ljxj90','310346',1,'2012 02 01','luwushuang','19930731','320211199307310346',13186454984);

INSERT INTO ACCOUNT(ACCOUNT_ID,RECOMMENDER_ID,LOGIN_NAME,LOGIN_PASSWD,STATUS,CREATE_DATE,
REAL_NAME,BIRTHDATE,IDCARD_NO,TELEPHONE)
VALUES(1020,NULL,'kxhxd20','012115',1,'2012 02 20','weixiaobao','20001001','321022200010012115',13953410078);

INSERT INTO ACCOUNT(ACCOUNT_ID,RECOMMENDER_ID,LOGIN_NAME,LOGIN_PASSWD,STATUS,CREATE_DATE,
REAL_NAME,BIRTHDATE,IDCARD_NO,TELEPHONE)
VALUES(1021,NULL,'kxhxd21','012116',1,'2012 02 20','zhangsan','20001002','321022200010012116',13953410079);
INSERT INTO ACCOUNT(ACCOUNT_ID,RECOMMENDER_ID,LOGIN_NAME,LOGIN_PASSWD,STATUS,CREATE_DATE,
REAL_NAME,BIRTHDATE,IDCARD_NO,TELEPHONE)
VALUES(1022,NULL,'kxhxd22','012117',1,'2012 02 20','lisi','20001003','321022200010012117',13953410080);
INSERT INTO ACCOUNT(ACCOUNT_ID,RECOMMENDER_ID,LOGIN_NAME,LOGIN_PASSWD,STATUS,CREATE_DATE,
REAL_NAME,BIRTHDATE,IDCARD_NO,TELEPHONE)
VALUES(1023,NULL,'kxhxd23','012118',1,'2012 02 20','wangwu','20001004','321022200010012118',13953410081);
INSERT INTO ACCOUNT(ACCOUNT_ID,RECOMMENDER_ID,LOGIN_NAME,LOGIN_PASSWD,STATUS,CREATE_DATE,
REAL_NAME,BIRTHDATE,IDCARD_NO,TELEPHONE)
VALUES(1024,NULL,'kxhxd24','012119',1,'2012 02 20','zhouliu','20001005','321022200010012119',13953410082);
INSERT INTO ACCOUNT(ACCOUNT_ID,RECOMMENDER_ID,LOGIN_NAME,LOGIN_PASSWD,STATUS,CREATE_DATE,
REAL_NAME,BIRTHDATE,IDCARD_NO,TELEPHONE)
VALUES(1025,NULL,'kxhxd25','012120',1,'2012 02 20','maqi','20001006','321022200010012120',13953410083);

insert into account(account_id,recommender_id,login_name,login_passwd,status,create_date,pause_date,close_date,real_name,idcard_no,birthdate,gender,occupation,telephone,email,mailaddress,zipcode,qq,last_login_time,last_login_ip)
 values (account_seq.nextval,1002,'ccccao','1245','1','2017-08-09','2017-09-09','2017-07-03','就是个笨蛋','562310','2020-05-03','M','屌丝','163589','44562355@qq.com','云南大道','696368','45464','2020-12-05','666666');

insert into account(account_id,recommender_id,login_name,login_passwd,real_name,idcard_no,telephone) values (1,2,'放长线钓大鱼','66666','张三',235641,12345678911)
COMMIT;

--查看所有账号信息
select * from account;

--重命名表名
rename t_account to account;
--增加列
alter table t_account add(bak varchar2(50) default 'login');
--修改列
alter table t_account modify(bak varchar2(40) default 'login');
--删除列
alter table t_account drop(bak);
--查看表的列个数
select count(*) from user_tab_columns where table_name=upper('account');

--删除表的记录
delete from account where account_id=1;
--更新记录
update account set login_passwd='20170924' where account_id=1;
--查看字符串长度
select length(real_name) from account;
--转换为大小写形式或首字母大写的形式
select upper('hello'),lower('java'),initcap('bob') from dual;
--截取字符串,下面分别是截取字符串前后匹配的字符，截取字符串左边匹配的字符，截取字符串右边匹配的字符。
select trim('t' from 'title')as t1,ltrim('title','t')as t2,rtrim('title','l')as t3 from dual;

--补位函数：分别在字符串的左边或右边添加字符串
select lpad(status,10,'$')as status,rpad(real_name,15,'#')as real_name from account;
--截取字符串函数,字符串首位计数从1开始。
select substr('hi Java hello',2,6) from dual;
--给定字符串在某字符串中的位置
select instr('hi java hello','he')as 'index' from dual;
--四舍五入小数
select round(45.695,2) from dual;
--截取小数,不做四舍五入
select trunc(63.981,-1) from dual;
--取余
select mod(100,30) from dual;
--取给定数的最大值或最小值
select ceil(46.678) from dual;
select floor(45.999) from dual;
--比较函数，比较出给定字符串中的最大值和最小值，但数据类型必须跟第一个参数是一致的。
select greatest(sysdate,'06-7月-17') from dual;
select least(45,78,32) from dual;
--提取指定数据
select extract(hour from timestamp '2010-10-10 10:10:10') from dual;

update account set status=null where account_id=2055;
--将为null的字段变为非null的字段
select account_id,nvl(status,'mm') from account;
--nvl2()函数，如果第一个参数为空，则取第二个参数的值；如果不为空，则取第二个参数的值。
select account_id,nvl2(status,'mm','haha') from account;
