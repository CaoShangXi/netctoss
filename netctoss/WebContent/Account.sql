drop table account;
--�����˺���Ϣ��
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
--�����˺���Ϣ������
create sequence account_seq start with 2000;
--�����˺���Ϣ
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
 values (account_seq.nextval,1002,'ccccao','1245','1','2017-08-09','2017-09-09','2017-07-03','���Ǹ�����','562310','2020-05-03','M','��˿','163589','44562355@qq.com','���ϴ��','696368','45464','2020-12-05','666666');

insert into account(account_id,recommender_id,login_name,login_passwd,real_name,idcard_no,telephone) values (1,2,'�ų��ߵ�����','66666','����',235641,12345678911)
COMMIT;

--�鿴�����˺���Ϣ
select * from account;

--����������
rename t_account to account;
--������
alter table t_account add(bak varchar2(50) default 'login');
--�޸���
alter table t_account modify(bak varchar2(40) default 'login');
--ɾ����
alter table t_account drop(bak);
--�鿴����и���
select count(*) from user_tab_columns where table_name=upper('account');

--ɾ����ļ�¼
delete from account where account_id=1;
--���¼�¼
update account set login_passwd='20170924' where account_id=1;
--�鿴�ַ�������
select length(real_name) from account;
--ת��Ϊ��Сд��ʽ������ĸ��д����ʽ
select upper('hello'),lower('java'),initcap('bob') from dual;
--��ȡ�ַ���,����ֱ��ǽ�ȡ�ַ���ǰ��ƥ����ַ�����ȡ�ַ������ƥ����ַ�����ȡ�ַ����ұ�ƥ����ַ���
select trim('t' from 'title')as t1,ltrim('title','t')as t2,rtrim('title','l')as t3 from dual;

--��λ�������ֱ����ַ�������߻��ұ�����ַ���
select lpad(status,10,'$')as status,rpad(real_name,15,'#')as real_name from account;
--��ȡ�ַ�������,�ַ�����λ������1��ʼ��
select substr('hi Java hello',2,6) from dual;
--�����ַ�����ĳ�ַ����е�λ��
select instr('hi java hello','he')as 'index' from dual;
--��������С��
select round(45.695,2) from dual;
--��ȡС��,������������
select trunc(63.981,-1) from dual;
--ȡ��
select mod(100,30) from dual;
--ȡ�����������ֵ����Сֵ
select ceil(46.678) from dual;
select floor(45.999) from dual;
--�ȽϺ������Ƚϳ������ַ����е����ֵ����Сֵ�����������ͱ������һ��������һ�µġ�
select greatest(sysdate,'06-7��-17') from dual;
select least(45,78,32) from dual;
--��ȡָ������
select extract(hour from timestamp '2010-10-10 10:10:10') from dual;

update account set status=null where account_id=2055;
--��Ϊnull���ֶα�Ϊ��null���ֶ�
select account_id,nvl(status,'mm') from account;
--nvl2()�����������һ������Ϊ�գ���ȡ�ڶ���������ֵ�������Ϊ�գ���ȡ�ڶ���������ֵ��
select account_id,nvl2(status,'mm','haha') from account;
