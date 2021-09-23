SHOW DATABASES;
-- 通过cmd登录数据库管理界面后，创建数据库 school
CREATE DATABASE IF NOT EXISTS school;
SHOW DATABASES;

-- 使用 school 数据库
USE school;

-- 创建学生表
-- Engine：存储引擎； CHARACTER SET：字符集【UTF8MB4，即UTF8】； COLLATE：校对集（排序规则）
DROP TABLE IF EXISTS parents;
DROP TABLE IF EXISTS stuclass;
DROP TABLE IF EXISTS students;
CREATE TABLE students
(
    id          INT PRIMARY KEY AUTO_INCREMENT COMMENT '学生id',
    account     CHAR(16)    NOT NULL UNIQUE COMMENT '账号',
    password    VARCHAR(20) NOT NULL COMMENT '密码',
    name        VARCHAR(25) NOT NULL COMMENT '姓名',
    sex         CHAR(1)     NOT NULL COMMENT '性别（1 男、2 女）',
    id_card     CHAR(18)    NOT NULL UNIQUE COMMENT '身份证号',
    create_time DATETIME    NOT NULL COMMENT '创建时间', -- TIMESTAMP OR DATETIME
    update_time DATETIME    NOT NULL COMMENT '修改时间',
    is_deleted  CHAR(1)     NOT NULL DEFAULT 0 COMMENT '是否删除（0 未删、1 已删）'
) ENGINE INNODB
  CHARACTER SET UTF8MB4
  COLLATE utf8mb4_unicode_ci COMMENT '学生信息表';

-- 创建家长表（一个家长可以有多个孩子，一个孩子可以有多个家长（父亲或母亲））
DROP TABLE IF EXISTS parents;
CREATE TABLE parents
(
    id          INT PRIMARY KEY AUTO_INCREMENT COMMENT '家长id',
    account     CHAR(16)    NOT NULL UNIQUE COMMENT '账号',
    password    VARCHAR(20) NOT NULL COMMENT '密码',
    name        VARCHAR(25) NOT NULL COMMENT '姓名',
    phone       CHAR(11)    NOT NULL COMMENT '手机号',
    student_id  INT         NOT NULL COMMENT '学生id',
    sex         CHAR(1)     NOT NULL COMMENT '性别（1 男、2 女）',
    create_time DATETIME    NOT NULL COMMENT '创建时间',
    update_time DATETIME    NOT NULL COMMENT '修改时间',
    is_deleted  CHAR(1)     NOT NULL DEFAULT 0 COMMENT '是否删除（0 未删、1 已删）',
    FOREIGN KEY (student_id) REFERENCES students (id) ON DELETE CASCADE -- 级联删除
) ENGINE INNODB
  CHARACTER SET UTF8MB4
  COLLATE utf8mb4_unicode_ci COMMENT '家长信息表';

-- 创建班级表
DROP TABLE IF EXISTS stuclass;
DROP TABLE IF EXISTS classroom;
CREATE TABLE classroom
(
    id          INT PRIMARY KEY AUTO_INCREMENT COMMENT '班级id',
    name        VARCHAR(25) NOT NULL COMMENT '班级名称',
    year        CHAR(6)     NOT NULL COMMENT '年级',
    create_time DATETIME    NOT NULL COMMENT '创建时间',
    update_time DATETIME    NOT NULL COMMENT '修改时间',
    is_deleted  CHAR(1)     NOT NULL DEFAULT 0 COMMENT '是否删除（0 未删、1 已删）'
) ENGINE INNODB
  CHARACTER SET UTF8MB4
  COLLATE utf8mb4_unicode_ci COMMENT '班级信息表';

-- 创建学生-班级表（一个学生只有一个班级，一个班级可以由多个学生）
DROP TABLE IF EXISTS stuclass;
CREATE TABLE stuclass
(
    id           INT PRIMARY KEY AUTO_INCREMENT COMMENT '学生-班级id',
    student_id   INT NOT NULL UNIQUE COMMENT '学生id',
    classroom_id INT NOT NULL COMMENT '班级id',
    FOREIGN KEY (student_id) REFERENCES students (id) ON DELETE CASCADE,
    FOREIGN KEY (classroom_id) REFERENCES classroom (id) ON DELETE CASCADE
) ENGINE INNODB
  CHARACTER SET UTF8MB4
  COLLATE utf8mb4_unicode_ci COMMENT '学生-班级信息表';
