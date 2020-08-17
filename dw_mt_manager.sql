/*
SQLyog Professional v12.08 (64 bit)
MySQL - 5.7.26-log : Database - dw_mt_manager
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dw_mt_manager` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `dw_mt_manager`;

/*Table structure for table `col_manager` */

DROP TABLE IF EXISTS `col_manager`;

CREATE TABLE `col_manager` (
  `col_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '字段主键编号',
  `col_name` varchar(45) NOT NULL COMMENT '字段名称',
  `col_type` varchar(45) NOT NULL COMMENT '字段类型',
  `col_comment` varchar(45) DEFAULT NULL COMMENT '字段注释',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `enable_flag` int(11) DEFAULT '1' COMMENT '是否有效软删除标识（1：有效，0：无效）',
  `tb_id` int(11) NOT NULL COMMENT '数仓表主键编号',
  PRIMARY KEY (`col_id`),
  KEY `fk_col_manager_tb_manager1_idx` (`tb_id`),
  CONSTRAINT `fk_col_manager_tb_manager1` FOREIGN KEY (`tb_id`) REFERENCES `tb_manager` (`tb_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据仓库-字段管理';

/*Table structure for table `dw_db_manager` */

DROP TABLE IF EXISTS `dw_db_manager`;

CREATE TABLE `dw_db_manager` (
  `dw_db_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '数据库主键',
  `db_name` varchar(128) NOT NULL COMMENT '库名',
  `db_comment` varchar(256) DEFAULT NULL COMMENT '注释',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `enable_flag` int(11) DEFAULT '1' COMMENT '是否有效软删除标识（1：有效，0：无效）',
  PRIMARY KEY (`dw_db_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据仓库-数据库管理';

/*Table structure for table `src_manager` */

DROP TABLE IF EXISTS `src_manager`;

CREATE TABLE `src_manager` (
  `src_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '数据源主键',
  `src_name` varchar(45) NOT NULL COMMENT '数据源名称',
  `src_comment` varchar(45) DEFAULT NULL COMMENT '数据源注释',
  `src_access_type` int(11) NOT NULL DEFAULT '1' COMMENT '数据源访问类型（1：JDBC   2：http   3：其他）',
  `src_type` int(11) NOT NULL DEFAULT '1' COMMENT '数据源类型(1: 内部数据源 2：外部数据源)，hive以外的都是外部',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `enable_flag` int(11) DEFAULT '1' COMMENT '是否有效软删除标识（1：有效，0：无效）',
  PRIMARY KEY (`src_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据源管理';

/*Table structure for table `src_param_manager` */

DROP TABLE IF EXISTS `src_param_manager`;

CREATE TABLE `src_param_manager` (
  `src_param_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `src_param_name` varchar(128) NOT NULL COMMENT '数据源参数名称',
  `src_param_value` varchar(128) DEFAULT NULL COMMENT '数据源参数值',
  `src_param_comment` varchar(512) DEFAULT NULL COMMENT '数据源参数注释',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `enable_flag` int(11) DEFAULT '1' COMMENT '是否有效软删除标识（1：有效，0：无效）',
  `src_id` int(11) NOT NULL COMMENT '数据源主键',
  PRIMARY KEY (`src_param_id`),
  KEY `fk_param_manager_db_manager1_idx` (`src_id`),
  CONSTRAINT `fk_param_manager_db_manager1` FOREIGN KEY (`src_id`) REFERENCES `src_manager` (`src_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据源参数管理';

/*Table structure for table `sys_param_manager` */

DROP TABLE IF EXISTS `sys_param_manager`;

CREATE TABLE `sys_param_manager` (
  `sys_param_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `sys_param_name` varchar(128) NOT NULL COMMENT '参数名称',
  `sys_param_value` varchar(128) DEFAULT NULL COMMENT '参数值',
  `sys_param_comment` varchar(45) DEFAULT NULL COMMENT '参数注释',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `enable_flag` int(11) DEFAULT '1' COMMENT '是否有效软删除标识（1：有效，0：无效）',
  PRIMARY KEY (`sys_param_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统参数管理';

/*Table structure for table `task_manager` */

DROP TABLE IF EXISTS `task_manager`;

CREATE TABLE `task_manager` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '任务主键ID',
  `task_type` int(11) NOT NULL COMMENT '任务类型（1：数据同步任务 2：ETL处理任务  3：数据导出任务 4:ETL建表任务）',
  `script_type` int(11) NOT NULL DEFAULT '1' COMMENT '脚本类型（1：sql    2：shell）',
  `task_name` varchar(128) NOT NULL COMMENT '任务中文名称',
  `task_comment` varchar(128) NOT NULL COMMENT '任务注释',
  `task_context` text COMMENT '任务内容',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `enable_flag` int(11) DEFAULT '1' COMMENT '是否有效软删除标识（1：有效，0：无效）',
  `tb_id` int(11) NOT NULL COMMENT '数据表主键编号',
  `src_id` int(11) DEFAULT NULL COMMENT '数据源主键',
  PRIMARY KEY (`task_id`),
  KEY `fk_task_manager_tb_manager1_idx` (`tb_id`),
  KEY `FK_Reference_5` (`src_id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`src_id`) REFERENCES `src_manager` (`src_id`),
  CONSTRAINT `fk_task_manager_tb_manager1` FOREIGN KEY (`tb_id`) REFERENCES `tb_manager` (`tb_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据仓库-任务管理';

/*Table structure for table `tb_manager` */

DROP TABLE IF EXISTS `tb_manager`;

CREATE TABLE `tb_manager` (
  `tb_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '数仓表主键编号',
  `dw_db_id` int(11) NOT NULL COMMENT '数据库主键',
  `tb_com_format` varchar(45) NOT NULL COMMENT '存储压缩格式',
  `tb_name` varchar(45) NOT NULL COMMENT '表名',
  `tb_comment` varchar(45) DEFAULT NULL COMMENT '表备注',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `enable_flag` int(11) DEFAULT '1' COMMENT '是否有效软删除标识（1：有效，0：无效）',
  PRIMARY KEY (`tb_id`),
  KEY `FK_Reference_4` (`dw_db_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`dw_db_id`) REFERENCES `dw_db_manager` (`dw_db_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据仓库-表管理';

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
