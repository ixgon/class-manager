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
    create_time DATETIME             DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', -- TIMESTAMP OR DATETIME
    update_time DATETIME             DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间', -- CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    is_deleted  CHAR(1)     NOT NULL DEFAULT 0 COMMENT '是否删除（0 未删、1 已删）'
) ENGINE INNODB
  CHARACTER SET UTF8MB4
  COLLATE utf8mb4_unicode_ci COMMENT '学生信息表';

-- 设置数据表的自增主键增长的起始值为1
ALTER TABLE students
    AUTO_INCREMENT = 1;

-- 创建家长表（一个家长可以有多个孩子，一个孩子可以有多个家长（父亲或母亲））
DROP TABLE IF EXISTS parents;
CREATE TABLE parents
(
    id          INT PRIMARY KEY AUTO_INCREMENT COMMENT '家长id',
    account     CHAR(16)    NOT NULL UNIQUE COMMENT '账号',
    password    VARCHAR(20) NOT NULL COMMENT '密码',
    name        VARCHAR(25) NOT NULL COMMENT '姓名',
    phone       CHAR(11)    NOT NULL COMMENT '手机号',
    student_id  INT COMMENT '学生id',
    sex         CHAR(1)     NOT NULL COMMENT '性别（1 男、2 女）',
    create_time DATETIME             DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME             DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    is_deleted  CHAR(1)     NOT NULL DEFAULT 0 COMMENT '是否删除（0 未删、1 已删）',
    FOREIGN KEY (student_id) REFERENCES students (id) ON DELETE CASCADE -- 级联删除
) ENGINE INNODB
  CHARACTER SET UTF8MB4
  COLLATE utf8mb4_unicode_ci COMMENT '家长信息表';

ALTER TABLE parents
    AUTO_INCREMENT = 1;

-- 创建班级表
DROP TABLE IF EXISTS stuclass;
DROP TABLE IF EXISTS classroom;
CREATE TABLE classroom
(
    id          INT PRIMARY KEY AUTO_INCREMENT COMMENT '班级id',
    name        VARCHAR(25) NOT NULL COMMENT '班级名称',
    year        CHAR(6)     NOT NULL COMMENT '年级',
    create_time DATETIME             DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME             DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    is_deleted  CHAR(1)     NOT NULL DEFAULT 0 COMMENT '是否删除（0 未删、1 已删）'
) ENGINE INNODB
  CHARACTER SET UTF8MB4
  COLLATE utf8mb4_unicode_ci COMMENT '班级信息表';

ALTER TABLE classroom
    AUTO_INCREMENT = 1;

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

ALTER TABLE stuclass
    AUTO_INCREMENT = 1;

-- 初始化学生表、家长表、班级表、学生-班级表【3条左右数据即可】
INSERT INTO students (id, account, password, name, sex, id_card, create_time, update_time, is_deleted)
VALUES (101061, '111111', '123456', '张三', '1', '325412197007055415', '2021-05-12 11:20:30', '2021-05-13 11:20:30', '0'),
       (101062, '222222', '123456', '李四', '1', '325412197007055416', '2021-05-13 11:20:30', '2021-05-14 11:20:30', '0'),
       (101063, '333333', '123456', '王五', '1', '325412197007055417', '2021-05-14 11:20:30', '2021-05-15 11:20:30', '0');

-- 暂时不知道是通过id(学生学号)查询还是通过account查询，id是否是自增的也不知道！！！
UPDATE students
SET account = 'admin',
    name    = '太宰'
WHERE id = 1;

INSERT INTO parents (id, account, password, name, phone, student_id, sex, create_time, update_time, is_deleted)
VALUES (201061, '011110', '123456', '张父', '17860529500', 101061, '1', '2021-05-12 11:20:30', '2021-05-13 11:20:30',
        '0'),
       (201062, '022220', '123456', '李父', '17860529501', 101062, '1', '2021-05-13 11:20:30', '2021-05-14 11:20:30',
        '0'),
       (201063, '033330', '123456', '王父', '17860529502', 101063, '1', '2021-05-14 11:20:30', '2021-05-15 11:20:30',
        '0'),
       (301063, '033331', '123456', '王母', '17860529503', 101063, '2', '2021-05-14 11:20:30', '2021-05-15 11:20:30',
        '0');

INSERT INTO classroom (id, name, year, create_time, update_time, is_deleted)
VALUES (0001, '一班', '高一', '2021-05-12 11:20:30', '2021-05-13 11:20:30', '0'),
       (0002, '二班', '高一', '2021-05-12 11:20:30', '2021-05-13 11:20:30', '0'),
       (0003, '三班', '高一', '2021-05-12 11:20:30', '2021-05-13 11:20:30', '0');

INSERT INTO stuclass (id, student_id, classroom_id)
VALUES (1, 101061, 0001),
       (2, 101062, 0001),
       (3, 101063, 0002);

SELECT *
FROM students s
         JOIN stuclass sc ON s.id = sc.student_id
         JOIN classroom c ON c.id = sc.classroom_id
         JOIN parents p ON s.id = p.student_id
LIMIT 0, 2;
