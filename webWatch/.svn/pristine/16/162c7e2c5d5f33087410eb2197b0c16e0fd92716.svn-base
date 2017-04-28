/*
Navicat MySQL Data Transfer

Source Server         : GYQ
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : watchdb

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-03-21 11:34:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `a_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
  `a_account` varchar(255) DEFAULT NULL COMMENT '管理员账户',
  `a_password` varchar(255) DEFAULT NULL COMMENT '管理员密码',
  `a_name` varchar(255) DEFAULT NULL COMMENT '管理员姓名',
  `a_address` varchar(255) DEFAULT NULL COMMENT '管理员地址',
  `a_phone` int(11) DEFAULT NULL COMMENT '管理员手机号',
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', '123', '123', '郭姜戈', '上海市浦东区', '1212232123');
