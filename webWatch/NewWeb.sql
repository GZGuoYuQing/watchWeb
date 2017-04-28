/*
Navicat MySQL Data Transfer

Source Server         : GYQ
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : watchdb

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-04-23 19:47:08
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
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_brand
-- ----------------------------
INSERT INTO `p_brand` VALUES ('1', '宝珀');
INSERT INTO `p_brand` VALUES ('2', '宝玑');
INSERT INTO `p_brand` VALUES ('3', '万国');
INSERT INTO `p_brand` VALUES ('4', '劳力士');
INSERT INTO `p_brand` VALUES ('5', '欧米茄');
INSERT INTO `p_brand` VALUES ('6', '卡地亚');
INSERT INTO `p_brand` VALUES ('7', '真力时');
INSERT INTO `p_brand` VALUES ('8', '宇舶');
INSERT INTO `p_brand` VALUES ('9', '爱彼');
INSERT INTO `p_brand` VALUES ('10', '积家');
INSERT INTO `p_brand` VALUES ('11', '雅克德罗');
INSERT INTO `p_brand` VALUES ('12', '万宝龙');
INSERT INTO `p_brand` VALUES ('13', '百达翡丽');
INSERT INTO `p_brand` VALUES ('14', '江诗丹顿');
INSERT INTO `p_brand` VALUES ('15', '雅典');
INSERT INTO `p_brand` VALUES ('16', '芝柏');
INSERT INTO `p_brand` VALUES ('17', '格拉苏蒂');
INSERT INTO `p_brand` VALUES ('18', '法穆兰');
INSERT INTO `p_brand` VALUES ('19', '百年灵');
INSERT INTO `p_brand` VALUES ('20', '沛纳海');
INSERT INTO `p_brand` VALUES ('21', '萧邦');
INSERT INTO `p_brand` VALUES ('22', '诺莫斯');
INSERT INTO `p_brand` VALUES ('23', '理查德米勒');
INSERT INTO `p_brand` VALUES ('24', '帝舵');
INSERT INTO `p_brand` VALUES ('25', '浪琴');
INSERT INTO `p_brand` VALUES ('26', '天梭');
INSERT INTO `p_brand` VALUES ('27', '美度');
INSERT INTO `p_brand` VALUES ('28', '精工');
INSERT INTO `p_brand` VALUES ('29', '梅花');
INSERT INTO `p_brand` VALUES ('30', '泰格豪雅');
INSERT INTO `p_brand` VALUES ('31', '摩凡陀');
INSERT INTO `p_brand` VALUES ('32', '香奈儿');
INSERT INTO `p_brand` VALUES ('33', '古驰');
INSERT INTO `p_brand` VALUES ('34', '范思哲');
INSERT INTO `p_brand` VALUES ('35', '阿玛尼');
INSERT INTO `p_brand` VALUES ('36', '卡西欧');
INSERT INTO `p_brand` VALUES ('37', 'CK');
INSERT INTO `p_brand` VALUES ('38', '亨利伦敦');
INSERT INTO `p_brand` VALUES ('39', '施华洛世奇');
INSERT INTO `p_brand` VALUES ('40', '丹尼尔惠灵顿');
INSERT INTO `p_brand` VALUES ('41', '路易威登');
INSERT INTO `p_brand` VALUES ('42', '普拉达');
INSERT INTO `p_brand` VALUES ('43', '迪奥');
INSERT INTO `p_brand` VALUES ('44', '蔻驰');
INSERT INTO `p_brand` VALUES ('45', '登喜路');
INSERT INTO `p_brand` VALUES ('46', '爱马仕');
INSERT INTO `p_brand` VALUES ('47', '万斯');
INSERT INTO `p_brand` VALUES ('48', '耐克');
INSERT INTO `p_brand` VALUES ('49', '卡帕');
INSERT INTO `p_brand` VALUES ('50', '匡威');
INSERT INTO `p_brand` VALUES ('51', '彪马');
INSERT INTO `p_brand` VALUES ('52', '锐步');
INSERT INTO `p_brand` VALUES ('53', '亚瑟士');
INSERT INTO `p_brand` VALUES ('54', '乔丹');
INSERT INTO `p_brand` VALUES ('55', '新百伦');
INSERT INTO `p_brand` VALUES ('56', '斯凯奇');
INSERT INTO `p_brand` VALUES ('57', '阿迪达斯');

-- ----------------------------
-- Table structure for p_core
-- ----------------------------
DROP TABLE IF EXISTS `p_core`;
CREATE TABLE `p_core` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '机芯ID',
  `c_des` varchar(255) DEFAULT NULL COMMENT '机芯型号',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_core
-- ----------------------------
INSERT INTO `p_core` VALUES ('1', '瑞士ETA2892机芯');
INSERT INTO `p_core` VALUES ('2', '瑞士ETA2824-2机芯');
INSERT INTO `p_core` VALUES ('3', '瑞士ETA6497机芯');
INSERT INTO `p_core` VALUES ('4', '瑞士ETA7750机芯');
INSERT INTO `p_core` VALUES ('5', '瑞士Cal.98245机芯');
INSERT INTO `p_core` VALUES ('6', '真力时Elite6150机芯');
INSERT INTO `p_core` VALUES ('7', '5255顶级同轴陀飞轮机芯');
INSERT INTO `p_core` VALUES ('8', '原装瑞士石英机芯');
INSERT INTO `p_core` VALUES ('9', '原装日本石英机芯');
INSERT INTO `p_core` VALUES ('10', '西铁城8521机芯');
INSERT INTO `p_core` VALUES ('11', '同轴西铁城8400机芯');
INSERT INTO `p_core` VALUES ('12', '西铁城82S7机芯');
INSERT INTO `p_core` VALUES ('13', '西铁城8215机芯');
INSERT INTO `p_core` VALUES ('14', '西铁城9100机芯');
INSERT INTO `p_core` VALUES ('15', '西铁城9015机芯');
INSERT INTO `p_core` VALUES ('16', '西铁城8219机芯');
INSERT INTO `p_core` VALUES ('17', '沛纳海P.9010机芯');
INSERT INTO `p_core` VALUES ('18', '沛纳海P.9001机芯');
INSERT INTO `p_core` VALUES ('19', '沛纳海P.9000机芯');
INSERT INTO `p_core` VALUES ('20', '原版劳力士3255机芯');
INSERT INTO `p_core` VALUES ('21', '原版劳力士3136机芯');
INSERT INTO `p_core` VALUES ('22', '改装浪琴Cal.L687机芯');
INSERT INTO `p_core` VALUES ('23', '海鸥2824机芯');
INSERT INTO `p_core` VALUES ('24', '海鸥2892机芯');
INSERT INTO `p_core` VALUES ('25', '海鸥6497机芯');
INSERT INTO `p_core` VALUES ('26', '海鸥1730机芯');
INSERT INTO `p_core` VALUES ('27', '海鸥2836机芯');
INSERT INTO `p_core` VALUES ('28', '2');

-- ----------------------------
-- Table structure for p_material
-- ----------------------------
DROP TABLE IF EXISTS `p_material`;
CREATE TABLE `p_material` (
  `m_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '材质ID',
  `m_des` varchar(255) DEFAULT NULL COMMENT '材质描述',
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_material
-- ----------------------------
INSERT INTO `p_material` VALUES ('1', '纳米塑料表壳');
INSERT INTO `p_material` VALUES ('2', '不锈钢表壳');
INSERT INTO `p_material` VALUES ('3', '钨钢表壳');
INSERT INTO `p_material` VALUES ('4', '陶瓷表壳');
INSERT INTO `p_material` VALUES ('5', '钛合金表壳');
INSERT INTO `p_material` VALUES ('6', '碳纤维表壳');
INSERT INTO `p_material` VALUES ('7', '定制包金表壳');
INSERT INTO `p_material` VALUES ('8', '316L精钢表壳');
INSERT INTO `p_material` VALUES ('9', '904L精钢表壳');
INSERT INTO `p_material` VALUES ('10', '定制玫瑰金表壳');
INSERT INTO `p_material` VALUES ('11', '1');
INSERT INTO `p_material` VALUES ('12', '2');

-- ----------------------------
-- Table structure for p_origin
-- ----------------------------
DROP TABLE IF EXISTS `p_origin`;
CREATE TABLE `p_origin` (
  `o_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '产地',
  `o_des` varchar(255) DEFAULT '中国' COMMENT '产地',
  PRIMARY KEY (`o_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_origin
-- ----------------------------
INSERT INTO `p_origin` VALUES ('1', '香港');
INSERT INTO `p_origin` VALUES ('2', '台湾');
INSERT INTO `p_origin` VALUES ('3', '日本');
INSERT INTO `p_origin` VALUES ('4', '中国');
INSERT INTO `p_origin` VALUES ('5', '德国');
INSERT INTO `p_origin` VALUES ('6', '英国');
INSERT INTO `p_origin` VALUES ('7', '法国');
INSERT INTO `p_origin` VALUES ('8', '澳大利亚');

-- ----------------------------
-- Table structure for p_style
-- ----------------------------
DROP TABLE IF EXISTS `p_style`;
CREATE TABLE `p_style` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '风格ID',
  `s_des` varchar(255) DEFAULT NULL COMMENT '风格',
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_style
-- ----------------------------
INSERT INTO `p_style` VALUES ('1', '休闲');
INSERT INTO `p_style` VALUES ('2', '商务');
INSERT INTO `p_style` VALUES ('3', '欧美');
INSERT INTO `p_style` VALUES ('4', '潜水');
INSERT INTO `p_style` VALUES ('5', '时尚');
INSERT INTO `p_style` VALUES ('6', '复古');
INSERT INTO `p_style` VALUES ('7', '运动');
INSERT INTO `p_style` VALUES ('8', '朋克');

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
  `w_des` varchar(11000) DEFAULT NULL COMMENT '手表描述',
  `m_id` int(11) DEFAULT NULL COMMENT '表壳材质ID',
  `w_lens` varchar(100) DEFAULT '蓝宝石镜面' COMMENT '表镜材质',
  `w_function` varchar(255) DEFAULT NULL COMMENT '手表功能',
  `c_id` int(11) DEFAULT NULL COMMENT '手表机芯型号ID',
  `o_id` int(100) DEFAULT '1' COMMENT '机芯产地',
  `w_image` varchar(600) DEFAULT NULL COMMENT '手表图片路径',
  `s_id` int(11) DEFAULT NULL COMMENT '手表风格',
  `w_title` varchar(60) DEFAULT NULL COMMENT '手表标题',
  `w_image1` varchar(600) DEFAULT NULL COMMENT '图片',
  `w_image2` varchar(600) DEFAULT NULL COMMENT '图片',
  `w_image3` varchar(600) DEFAULT NULL COMMENT '图片',
  `w_image4` varchar(600) DEFAULT NULL COMMENT '图片',
  `w_image5` varchar(600) DEFAULT NULL COMMENT '图片',
  `w_image6` varchar(600) DEFAULT NULL COMMENT '图片',
  `w_image7` varchar(600) DEFAULT NULL COMMENT '图片',
  `w_image8` varchar(600) DEFAULT NULL COMMENT '图片',
  `w_table` varchar(255) DEFAULT NULL COMMENT '手表标签',
  `w_video` varchar(600) DEFAULT NULL COMMENT '手表视频',
  PRIMARY KEY (`w_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_watch
-- ----------------------------

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
  `a_phone` varchar(11) DEFAULT NULL COMMENT '管理员手机号',
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', '123', 'ICy5YqxZB1uWSwcVLSNLcA==', '管理员', '中国香港', '18370949034');

-- ----------------------------
-- Table structure for t_forum
-- ----------------------------
DROP TABLE IF EXISTS `t_forum`;
CREATE TABLE `t_forum` (
  `f_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `f_image` varchar(1000) DEFAULT NULL COMMENT '主图',
  `f_date` datetime DEFAULT NULL COMMENT '发帖时间',
  `f_des` varchar(20000) DEFAULT NULL COMMENT '主题',
  `f_title` varchar(255) DEFAULT NULL COMMENT '标题',
  `a_id` int(11) DEFAULT NULL COMMENT '发帖管理员',
  `f_video` varchar(500) DEFAULT NULL COMMENT '插入视频',
  `t_id` int(11) DEFAULT NULL COMMENT '帖子类型ID',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_forum
-- ----------------------------

-- ----------------------------
-- Table structure for t_leather
-- ----------------------------
DROP TABLE IF EXISTS `t_leather`;
CREATE TABLE `t_leather` (
  `l_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '皮具Id',
  `l_title` varchar(255) DEFAULT NULL COMMENT '皮具标题',
  `l_table` varchar(255) DEFAULT NULL COMMENT '皮具打折信息',
  `l_des` varchar(10000) DEFAULT NULL COMMENT '皮具表述',
  `b_id` int(11) DEFAULT NULL COMMENT '品牌ID',
  `m_id` int(11) DEFAULT NULL COMMENT '材质Id',
  `o_id` int(11) DEFAULT NULL COMMENT '产地Id',
  `s_id` int(11) DEFAULT NULL COMMENT '风格Id',
  `l_price` decimal(10,0) DEFAULT NULL COMMENT '皮具价格',
  `l_type` varchar(255) DEFAULT NULL COMMENT '皮具类型，型号',
  `l_video` varchar(255) DEFAULT NULL COMMENT '皮具视频',
  `l_image` varchar(255) DEFAULT NULL COMMENT '皮具主图',
  `l_image1` varchar(255) DEFAULT NULL,
  `l_image2` varchar(255) DEFAULT NULL,
  `l_image3` varchar(255) DEFAULT NULL,
  `l_image4` varchar(255) DEFAULT NULL,
  `l_image5` varchar(255) DEFAULT NULL,
  `l_image6` varchar(255) DEFAULT NULL,
  `l_image7` varchar(255) DEFAULT NULL,
  `l_image8` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`l_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_leather
-- ----------------------------

-- ----------------------------
-- Table structure for t_shose
-- ----------------------------
DROP TABLE IF EXISTS `t_shose`;
CREATE TABLE `t_shose` (
  `sh_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '鞋子Id',
  `sh_title` varchar(255) DEFAULT NULL COMMENT '鞋子标题',
  `sh_table` varchar(255) DEFAULT NULL COMMENT '鞋子打折信息',
  `sh_des` varchar(12222) DEFAULT NULL COMMENT '鞋子描述',
  `b_id` int(11) DEFAULT NULL COMMENT '品牌Id',
  `m_id` int(11) DEFAULT NULL COMMENT '材质Id',
  `o_id` int(11) DEFAULT NULL COMMENT '产地Id',
  `s_id` int(11) DEFAULT NULL COMMENT '风格Id',
  `sh_price` decimal(10,0) DEFAULT NULL COMMENT '鞋子价格',
  `sh_type` varchar(255) DEFAULT NULL COMMENT '鞋子款式',
  `sh_video` varchar(255) DEFAULT NULL COMMENT '鞋子视频',
  `sh_image` varchar(255) DEFAULT NULL COMMENT '鞋子主图',
  `sh_image1` varchar(255) DEFAULT NULL,
  `sh_image2` varchar(255) DEFAULT NULL,
  `sh_image3` varchar(255) DEFAULT NULL,
  `sh_image4` varchar(255) DEFAULT NULL,
  `sh_image5` varchar(255) DEFAULT NULL,
  `sh_image6` varchar(255) DEFAULT NULL,
  `sh_image7` varchar(255) DEFAULT NULL,
  `sh_image8` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sh_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_shose
-- ----------------------------

-- ----------------------------
-- Table structure for t_type
-- ----------------------------
DROP TABLE IF EXISTS `t_type`;
CREATE TABLE `t_type` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '帖子类型ID',
  `t_des` varchar(255) NOT NULL COMMENT '贴子类型',
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_type
-- ----------------------------
INSERT INTO `t_type` VALUES ('1', '复刻手表贴');
INSERT INTO `t_type` VALUES ('2', '复刻鞋子贴');
INSERT INTO `t_type` VALUES ('3', '复刻皮具贴');
INSERT INTO `t_type` VALUES ('4', '手表知识贴');
INSERT INTO `t_type` VALUES ('5', '手表售后帖');
