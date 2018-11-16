create table product(
	code char(4) primary key,
	name varchar(20) not null
);

insert into product values
('A001', '�Ƹ޸�ī��'), ('A002', 'īǪġ��'),
('A003', '�������'), ('A004', '����������'),
('B001', '���⽦��ũ'), ('B002', '�ĸ�������'),
('B003', '�Ϻ���'), ('B004', '���̽�����');

select * from product;


create table sale(
	no int(11) auto_increment primary key,
	code char(4),
	price int(11) not null,
	saleCnt int(11) not null,
	marginRate int(11) not null,
	foreign key (code) references product(code)
);

insert into sale(code, price, saleCnt, marginRate) values
('A001', 4500, 150, 10),
('A002', 3800, 140, 15),
('B001', 5200, 250, 12),
('B002', 4300, 110, 11);

insert into sale(code, price, saleCnt, marginRate) values ('B001', 4500, 150, 10);
delete from sale;
truncate table sale;
select * from sale;

call price_rank(true);

