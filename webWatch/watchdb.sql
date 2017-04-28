/*
Navicat MySQL Data Transfer

Source Server         : GYQ
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : watchdb

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-03-20 20:17:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for p_brand
-- ----------------------------
DROP TABLE IF EXISTS `p_brand`;
CREATE TABLE `p_brand` (
  `b_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '品牌ID',
  `b_des` varchar(255) DEFAULT NULL COMMENT '手表品牌',
  PRIMARY KEY (`b_id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_brand
-- ----------------------------
INSERT INTO `p_brand` VALUES ('1', '劳力士');
INSERT INTO `p_brand` VALUES ('2', '欧米茄');
INSERT INTO `p_brand` VALUES ('3', '万国');
INSERT INTO `p_brand` VALUES ('4', '百达翡丽');
INSERT INTO `p_brand` VALUES ('5', '朗格');
INSERT INTO `p_brand` VALUES ('6', '宝珀');
INSERT INTO `p_brand` VALUES ('7', '江诗丹顿');
INSERT INTO `p_brand` VALUES ('8', '宝玑');
INSERT INTO `p_brand` VALUES ('9', '积家');
INSERT INTO `p_brand` VALUES ('10', '爱彼');
INSERT INTO `p_brand` VALUES ('11', '卡地亚');
INSERT INTO `p_brand` VALUES ('12', '伯爵');
INSERT INTO `p_brand` VALUES ('13', '里查德米尔');
INSERT INTO `p_brand` VALUES ('14', '格拉苏蒂');
INSERT INTO `p_brand` VALUES ('15', '帕玛强尼');
INSERT INTO `p_brand` VALUES ('16', '芝柏');
INSERT INTO `p_brand` VALUES ('17', '雅典');
INSERT INTO `p_brand` VALUES ('18', '法穆兰');
INSERT INTO `p_brand` VALUES ('19', '雅克德罗');
INSERT INTO `p_brand` VALUES ('20', '宝格丽');
INSERT INTO `p_brand` VALUES ('21', '真力时');
INSERT INTO `p_brand` VALUES ('22', '宇舶');
INSERT INTO `p_brand` VALUES ('23', '沛纳海');
INSERT INTO `p_brand` VALUES ('24', '百年灵');
INSERT INTO `p_brand` VALUES ('25', '萧邦');
INSERT INTO `p_brand` VALUES ('26', '昆仑');
INSERT INTO `p_brand` VALUES ('27', '伯莱士');
INSERT INTO `p_brand` VALUES ('28', '浪琴');
INSERT INTO `p_brand` VALUES ('29', '万宝龙');
INSERT INTO `p_brand` VALUES ('30', '泰格豪雅');
INSERT INTO `p_brand` VALUES ('31', '帝舵');
INSERT INTO `p_brand` VALUES ('32', 'NOMOS');
INSERT INTO `p_brand` VALUES ('33', '爱马仕');
INSERT INTO `p_brand` VALUES ('34', '迪奥');
INSERT INTO `p_brand` VALUES ('35', '香奈儿');
INSERT INTO `p_brand` VALUES ('36', '古驰');
INSERT INTO `p_brand` VALUES ('37', '蒂芙尼');
INSERT INTO `p_brand` VALUES ('38', '美度');
INSERT INTO `p_brand` VALUES ('39', '天梭');
INSERT INTO `p_brand` VALUES ('40', '摩凡陀');
INSERT INTO `p_brand` VALUES ('41', '精工');

-- ----------------------------
-- Table structure for p_core
-- ----------------------------
DROP TABLE IF EXISTS `p_core`;
CREATE TABLE `p_core` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '机芯ID',
  `c_des` varchar(255) DEFAULT NULL COMMENT '机芯型号',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_core
-- ----------------------------
INSERT INTO `p_core` VALUES ('1', '瑞士ETA2892机芯');
INSERT INTO `p_core` VALUES ('2', '瑞士ETA2824-2机芯');
INSERT INTO `p_core` VALUES ('3', '瑞士ETA6497机芯');
INSERT INTO `p_core` VALUES ('4', '瑞士ETA7750机芯');
INSERT INTO `p_core` VALUES ('5', '改装浪琴Cal.L687机芯');
INSERT INTO `p_core` VALUES ('6', '海鸥仿ETA2824机芯');
INSERT INTO `p_core` VALUES ('7', ' 海鸥仿ETA2836-1机芯');

-- ----------------------------
-- Table structure for p_material
-- ----------------------------
DROP TABLE IF EXISTS `p_material`;
CREATE TABLE `p_material` (
  `m_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '材质ID',
  `m_des` varchar(255) DEFAULT NULL COMMENT '材质描述',
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_material
-- ----------------------------
INSERT INTO `p_material` VALUES ('1', '361L精钢表壳');
INSERT INTO `p_material` VALUES ('2', '904L精钢表壳');
INSERT INTO `p_material` VALUES ('3', '陶瓷表壳');
INSERT INTO `p_material` VALUES ('4', '玫瑰金表壳');
INSERT INTO `p_material` VALUES ('5', '钛合金表壳');
INSERT INTO `p_material` VALUES ('6', '包金表壳');
INSERT INTO `p_material` VALUES ('7', '镀金表壳');

-- ----------------------------
-- Table structure for p_origin
-- ----------------------------
DROP TABLE IF EXISTS `p_origin`;
CREATE TABLE `p_origin` (
  `o_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '产地',
  `o_des` varchar(255) DEFAULT '中国' COMMENT '产地',
  PRIMARY KEY (`o_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_origin
-- ----------------------------
INSERT INTO `p_origin` VALUES ('1', '中国');
INSERT INTO `p_origin` VALUES ('2', '瑞士');
INSERT INTO `p_origin` VALUES ('3', '日本');
INSERT INTO `p_origin` VALUES ('4', '台湾');
INSERT INTO `p_origin` VALUES ('5', '香港');

-- ----------------------------
-- Table structure for p_style
-- ----------------------------
DROP TABLE IF EXISTS `p_style`;
CREATE TABLE `p_style` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '风格ID',
  `s_des` varchar(255) DEFAULT NULL COMMENT '风格',
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_style
-- ----------------------------
INSERT INTO `p_style` VALUES ('1', '休闲');
INSERT INTO `p_style` VALUES ('2', '商务');
INSERT INTO `p_style` VALUES ('3', '潜水');
INSERT INTO `p_style` VALUES ('4', '时尚');
INSERT INTO `p_style` VALUES ('5', '运动');
INSERT INTO `p_style` VALUES ('6', '古典');

-- ----------------------------
-- Table structure for p_watch
-- ----------------------------
DROP TABLE IF EXISTS `p_watch`;
CREATE TABLE `p_watch` (
  `w_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '手表ID',
  `b_id` int(11) DEFAULT NULL COMMENT '手表品牌ID',
  `w_price` double DEFAULT NULL COMMENT '手表价格',
  `w_type` varchar(100) DEFAULT '男款' COMMENT '手表款式',
  `w_size` int(11) DEFAULT NULL COMMENT '表盘大小',
  `w_colour` varchar(100) DEFAULT NULL COMMENT '表盘颜色',
  `w_des` varchar(600) DEFAULT NULL COMMENT '手表描述',
  `m_id` int(11) DEFAULT NULL COMMENT '表壳材质ID',
  `w_lens` varchar(100) DEFAULT '蓝宝石镜面' COMMENT '表镜材质',
  `w_function` varchar(255) DEFAULT NULL COMMENT '手表功能',
  `c_id` int(11) DEFAULT NULL COMMENT '手表机芯型号ID',
  `o_id` int(100) DEFAULT '1' COMMENT '机芯产地',
  `w_image` varchar(600) DEFAULT NULL COMMENT '手表图片路径',
  `s_id` int(11) DEFAULT NULL COMMENT '手表风格',
  `w_title` varchar(60) DEFAULT NULL COMMENT '手表标题',
  PRIMARY KEY (`w_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_watch
-- ----------------------------
INSERT INTO `p_watch` VALUES ('1', '2', '2333', '男款', '34', '香槟金', '很吊的手表', '2', '蓝宝石镜面', '潜水商务各种', '3', '2', '/ccss', '3', '欧米茄星座');
