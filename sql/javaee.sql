/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50505
 Source Host           : localhost
 Source Database       : javaee

 Target Server Type    : MySQL
 Target Server Version : 50505
 File Encoding         : utf-8

 Date: 01/21/2017 20:43:07 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `Teacher`
-- ----------------------------
DROP TABLE IF EXISTS `Teacher`;
CREATE TABLE `Teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` char(40) DEFAULT NULL,
  `sex` tinyint(1) DEFAULT NULL,
  `username` char(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `Teacher`
-- ----------------------------
BEGIN;
INSERT INTO `Teacher` VALUES ('5', 'zhangsan@yunzhiclub.com', '张三', '123', '1', 'zhangsan'), ('6', 'lisi@yunzhiclub.com', '李四', '234', '0', 'lisi'), ('7', 'wangwu@yunzhiclub.com', '王五', '234', '0', 'wangwu'), ('8', 'zhaoliu@yunzhiclub.com', '赵六', '234', '1', 'zhaoliu'), ('9', 'sunqi@yunzhiclub.com', 'sunqi', '12323', '0', 'sunqi'), ('10', 'maba@yunzhiclub.com', '马八', '2134', '1', 'maba'), ('11', 'zhangsi@yunzhiclub.com', '张四', '123', '1', 'zhangsi'), ('12', 'liwu@yunzhiclub.com', '李五', '324324', '0', 'liwu'), ('13', 'wangliu@yunzhiclub.com', '王六', '1232', '0', 'wangliu'), ('14', 'zhaoqi@yunzhiclub.com', '赵七', '324234', '1', 'zhaoqi'), ('15', 'sunjiu@yunzhiclub.com', '孙九', '123213', '0', 'sunjiu');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
