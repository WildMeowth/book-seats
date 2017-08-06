CREATE TABLE `bs_user` (
  `bs_user_id` varchar(100) NOT NULL COMMENT '用户ID',
  `bs_user_name` varchar(100) DEFAULT NULL COMMENT '用户名',
  `bs_user_password` varchar(100) DEFAULT NULL COMMENT '密码',
  `bs_user_token` varchar(100) DEFAULT NULL COMMENT '令牌',
  PRIMARY KEY (`bs_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `bs_user` (bs_user_id,bs_user_name,bs_user_password) VALUES('admin','admin','2625eadfbe7fa3168f8e9cafa28aaa44'); 
INSERT INTO `bs_user` (bs_user_id,bs_user_name,bs_user_password) VALUES('201303090216','mzh','2625eadfbe7fa3168f8e9cafa28aaa44'); 
INSERT INTO `bs_user` (bs_user_id,bs_user_name,bs_user_password) VALUES('201303090201','Andy','2625eadfbe7fa3168f8e9cafa28aaa44'); 
INSERT INTO `bs_user` (bs_user_id,bs_user_name,bs_user_password) VALUES('201303090202','brain','2625eadfbe7fa3168f8e9cafa28aaa44'); 
INSERT INTO `bs_user` (bs_user_id,bs_user_name,bs_user_password) VALUES('201303090203','colin','2625eadfbe7fa3168f8e9cafa28aaa44'); 
INSERT INTO `bs_user` (bs_user_id,bs_user_name,bs_user_password) VALUES('201303090204','diego','2625eadfbe7fa3168f8e9cafa28aaa44');  
INSERT INTO `bs_user` (bs_user_id,bs_user_name,bs_user_password) VALUES('201303090205','evan','2625eadfbe7fa3168f8e9cafa28aaa44'); 



create table bs_userinfo(
    bs_user_id varchar(100) DEFAULT NULL COMMENT '用户ID',
    bs_user_title varchar(100) DEFAULT NULL COMMENT '用户身份'
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

INSERT INTO `bs_userinfo` VALUES('201303090201','student');
INSERT INTO `bs_userinfo` VALUES('201303090202','student');
INSERT INTO `bs_userinfo` VALUES('201303090203','student');
INSERT INTO `bs_userinfo` VALUES('201303090204','student');
INSERT INTO `bs_userinfo` VALUES('201303090205','student');
INSERT INTO `bs_userinfo` VALUES('201303090216','student');
INSERT INTO `bs_userinfo` VALUES('admin','admin');

create table bs_userforseat(
    bs_seat_id varchar(100) NOT NULL COMMENT '座位ID',
    bs_user_id varchar(100) DEFAULT NULL COMMENT '用户ID',
    bs_seat_time varchar(100) DEFAULT NULL COMMENT '预定日期',
    bs_status varchar(100) NULL COMMENT '履约状态'
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 


INSERT INTO `bs_userforseat` VALUES('4_4','201303090216','201705010810','已履约'); 
INSERT INTO `bs_userforseat` VALUES('4_1','201303090216','201710011012','未履约'); 
INSERT INTO `bs_userforseat` VALUES('6_4','201303090216','201706011214','未履约'); 
INSERT INTO `bs_userforseat` VALUES('4_4','201303090216','201708011012','未履约');  
INSERT INTO `bs_userforseat` VALUES('4_4','201303090216','201709231416','未履约'); 
INSERT INTO `bs_userforseat` VALUES('4_4','201303090216','201709211618','未履约'); 

INSERT INTO `bs_userforseat` VALUES('4_4','201303090201','201707201618','未履约');
INSERT INTO `bs_userforseat` VALUES('4_4','201303090201','201708141618','未履约'); 
INSERT INTO `bs_userforseat` VALUES('4_5','201303090201','201709211618','未履约'); 

INSERT INTO `bs_userforseat` VALUES('4_4','201303090202','201708090810','未履约'); 
INSERT INTO `bs_userforseat` VALUES('4_4','201303090202','201709041618','未履约'); 
INSERT INTO `bs_userforseat` VALUES('4_4','201303090202','201708111416','未履约'); 
INSERT INTO `bs_userforseat` VALUES('4_4','201303090202','201709251820','未履约');  
INSERT INTO `bs_userforseat` VALUES('1_7','201303090202','201709211618','未履约'); 

INSERT INTO `bs_userforseat` VALUES('4_4','201303090203','201709101214','未履约'); 
INSERT INTO `bs_userforseat` VALUES('4_4','201303090203','201708231416','未履约');
INSERT INTO `bs_userforseat` VALUES('4_4','201303090203','201709121416','未履约'); 
INSERT INTO `bs_userforseat` VALUES('4_4','201303090203','201709151820','未履约');  
INSERT INTO `bs_userforseat` VALUES('3_7','201303090203','201709211618','未履约'); 

INSERT INTO `bs_userforseat` VALUES('4_4','201303090204','201709081214','未履约');
INSERT INTO `bs_userforseat` VALUES('4_4','201303090204','201707011012','未履约'); 
INSERT INTO `bs_userforseat` VALUES('4_4','201303090204','201709131416','未履约');  
INSERT INTO `bs_userforseat` VALUES('4_4','201303090204','201709161820','未履约');   
INSERT INTO `bs_userforseat` VALUES('8_10','201303090204','201709211618','未履约'); 


commit;