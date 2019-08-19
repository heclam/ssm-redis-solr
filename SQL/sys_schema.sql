-- CREATE DATABASE ssm_redis DEFAULT CHARACTER SET utf8;

DROP TABLE IF EXISTS tb_item;
DROP TABLE IF EXISTS tb_user;

-- 商品表
CREATE TABLE tb_item(
  id bigint auto_increment comment '编号',
  title varchar(1000) comment '商品名称',
  price varchar(100) comment '商品价格',
  image varchar(1000) comment '商品图片',
  category varchar(1000) comment '商品标题',
  brand varchar(1000) comment '商品品牌',
  seller varchar(1000) comment '商品卖家',
  constraint pk_sys_users primary key(id)
) CHARSET=utf8 ENGINE=InnoDB;

-- 用户表
CREATE TABLE tb_user(
  id bigint auto_increment comment '编号',
  username VARCHAR(100) comment '用户名',
  password VARCHAR(100) comment '密码',
  salt VARCHAR(100) comment '盐值',
  constraint pk_sys_users primary key(id)
) CHARSET=utf8 ENGINE=InnoDB;

INSERT INTO tb_user VALUES(1, 'heclam', 'f82cfb31c19c67d4f3cc1a4837045746', 'aabff320f64f85037c45025902c24d4f');
INSERT INTO tb_user VALUES(2,'abc', 'af82008a4da5437175a6e9fbd5b9b3cf', '6f2c8c09e13c11aae634ec4a9fab3392');

