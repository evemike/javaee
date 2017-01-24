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

 Date: 01/23/2017 19:56:52 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `Teacher`
-- ----------------------------
DROP TABLE IF EXISTS `Teacher`;
CREATE TABLE `Teacher` (
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` char(40) DEFAULT NULL,
  `sex` tinyint(1) DEFAULT NULL,
  `username` char(20) DEFAULT NULL,
  `teacherId` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`teacherId`),
  KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `Teacher`
-- ----------------------------
BEGIN;
INSERT INTO `Teacher` VALUES ('lisi@yunzhiclub.com', '李四', '234', '0', 'lisi', '1'), ('wangwu@yunzhiclub.com', '王五', '234', '0', 'wangwu', '2'), ('zhaoliu@yunzhiclub.com', '赵六', '234', '1', 'zhaoliu', '3'), ('sunqi@yunzhiclub.com', 'sunqi', '12323', '0', 'sunqi', '4'), ('maba@yunzhiclub.com', '马八', '2134', '1', 'maba', '5'), ('zhangsi@yunzhiclub.com', '张四', '123', '1', 'zhangsi', '6'), ('liwu@yunzhiclub.com', '李五', '324324', '0', 'liwu', '7'), ('wangliu@yunzhiclub.com', '王六', '1232', '0', 'wangliu', '8'), ('zhaoqi@yunzhiclub.com', '赵七', '324234', '1', 'zhaoqi', '9'), ('sunjiu@yunzhiclub.com', '孙九', '123213', '0', 'sunjiu', '10'), ('zhangsan@yunzhiclub.com', '张三', '1231', '1', 'zhangsan', '11');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
