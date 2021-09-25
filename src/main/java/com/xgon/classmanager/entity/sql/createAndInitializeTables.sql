SHOW DATABASES;
-- 通过cmd登录数据库管理界面后，创建数据库 school
CREATE DATABASE IF NOT EXISTS school;
SHOW DATABASES;

-- 使用 school 数据库
USE school;

-- 创建学生表
-- Engine：存储引擎； CHARACTER SET：字符集【UTF8MB4，即UTF8】； COLLATE：校对集（排序规则）
DROP TABLE IF EXISTS stuparent;
DROP TABLE IF EXISTS stuclass;
DROP TABLE IF EXISTS students;
CREATE TABLE students
(
    id          INT PRIMARY KEY AUTO_INCREMENT COMMENT '学生id（学号），有序，用于替代无序的account作为主键',
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
    AUTO_INCREMENT = 10161;

-- 创建家长表（一个家长可以有多个孩子，一个孩子可以有多个家长（父亲或母亲））
DROP TABLE IF EXISTS stuparent;
DROP TABLE IF EXISTS parents;
CREATE TABLE parents
(
    id          INT PRIMARY KEY AUTO_INCREMENT COMMENT '家长id（类似学生学号，可以与学生学号相关）',
    account     CHAR(16)    NOT NULL UNIQUE COMMENT '账号',
    password    VARCHAR(20) NOT NULL COMMENT '密码',
    name        VARCHAR(25) NOT NULL COMMENT '姓名',
    phone       CHAR(11)    NOT NULL COMMENT '手机号',
    sex         CHAR(1)     NOT NULL COMMENT '性别（1 男、2 女）',
    create_time DATETIME             DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME             DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    is_deleted  CHAR(1)     NOT NULL DEFAULT 0 COMMENT '是否删除（0 未删、1 已删）'
) ENGINE INNODB
  CHARACTER SET UTF8MB4
  COLLATE utf8mb4_unicode_ci
  AUTO_INCREMENT 1101061 COMMENT '家长信息表';

-- 创建学生-家长表
DROP TABLE IF EXISTS stuparent;
CREATE TABLE stuparent
(
    id         INT PRIMARY KEY AUTO_INCREMENT COMMENT '学生-家长id（没有实际意义的id，作为有序的主键构建B+树，用于替代 学生id+班级id 唯一代表一条记录）',
    student_id INT NOT NULL COMMENT '学生id',
    parent_id  INT NOT NULL COMMENT '家长id',
    FOREIGN KEY (student_id) REFERENCES students (id) ON DELETE CASCADE,
    FOREIGN KEY (parent_id) REFERENCES parents (id) ON DELETE CASCADE -- 级联删除
) ENGINE INNODB
  CHARACTER SET UTF8MB4
  COLLATE utf8mb4_unicode_ci
  AUTO_INCREMENT 1 COMMENT '学生-家长信息表';

-- 创建班级表
DROP TABLE IF EXISTS stuclass;
DROP TABLE IF EXISTS classroom;
CREATE TABLE classroom
(
    id          INT PRIMARY KEY AUTO_INCREMENT COMMENT '班级id（可以是有序的主键，用来替代 年级+班级名称 唯一代表一条记录）',
    name        VARCHAR(25) NOT NULL COMMENT '班级名称',
    year        CHAR(6)     NOT NULL COMMENT '年级',
    create_time DATETIME             DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME             DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    is_deleted  CHAR(1)     NOT NULL DEFAULT 0 COMMENT '是否删除（0 未删、1 已删）'
) ENGINE INNODB
  CHARACTER SET UTF8MB4
  COLLATE utf8mb4_unicode_ci
  AUTO_INCREMENT 1 COMMENT '班级信息表';

-- 创建学生-班级表（过去：一个学生只有一个班级，一个班级可以有多个学生；现在：一个学生可以从属于多个班级，一个班级可以有多个学生）
DROP TABLE IF EXISTS stuclass;
CREATE TABLE stuclass
(
    id           INT PRIMARY KEY AUTO_INCREMENT COMMENT '学生-班级id',
    student_id   INT NOT NULL COMMENT '学生id', -- 过去（唯一主键）：student_id   INT NOT NULL UNIQUE COMMENT '学生id',
    classroom_id INT NOT NULL COMMENT '班级id',
    FOREIGN KEY (student_id) REFERENCES students (id) ON DELETE CASCADE,
    FOREIGN KEY (classroom_id) REFERENCES classroom (id) ON DELETE CASCADE
) ENGINE INNODB
  CHARACTER SET UTF8MB4
  COLLATE utf8mb4_unicode_ci
  AUTO_INCREMENT 1 COMMENT '学生-班级信息表';

-- 初始化学生表、家长表、班级表、学生-班级表【3条多数据即可】
INSERT INTO students (id, account, password, name, sex, id_card, create_time, update_time, is_deleted)
VALUES (101061, '111111', '123456', '张三', '1', '325412197007055415', '2021-05-12 11:20:30', '2021-05-13 11:20:30', '0'),
       (101062, '222222', '123456', '李四', '1', '325412197007055416', '2021-05-13 11:20:30', '2021-05-14 11:20:30', '0'),
       (101063, '333333', '123456', '王五', '1', '325412197007055417', '2021-05-14 11:20:30', '2021-05-15 11:20:30', '0');

UPDATE students
SET account = 'admin',
    name    = '太宰'
WHERE id = 1;

INSERT INTO parents (id, account, password, name, phone, sex, create_time, update_time, is_deleted)
VALUES (1101061, '011110', '123456', '张父', '17860529500', '1', '2021-05-12 11:20:30', '2021-05-13 11:20:30', '0'),
       (1101062, '022220', '123456', '李父', '17860529501', '1', '2021-05-13 11:20:30', '2021-05-14 11:20:30', '0'),
       (1101063, '022230', '123456', '李母', '17860529521', '1', '2021-05-13 11:20:30', '2021-05-14 11:20:30', '0'),
       (1101064, '022240', '123456', '李义父', '17860529531', '1', '2021-05-13 11:20:30', '2021-05-14 11:20:30', '0'),
       (1101065, '033330', '123456', '王父', '17860529502', '1', '2021-05-14 11:20:30', '2021-05-15 11:20:30', '0'),
       (1101066, '033331', '123456', '王母', '17860529503', '2', '2021-05-14 11:20:30', '2021-05-15 11:20:30', '0');

INSERT INTO stuparent (id, student_id, parent_id)
VALUES (1, 101061, 1101061),
       (2, 101062, 1101062),
       (3, 101063, 1101065),
       (4, 101063, 1101066)
-- ,(5, 101062, 1101063),
-- (6, 101062, 1101064)
;

INSERT INTO classroom (id, name, year, create_time, update_time, is_deleted)
VALUES (0001, '一班', '2020级', '2021-05-12 11:20:30', '2021-05-13 11:20:30', '0'),
       (0002, '二班', '2020级', '2021-05-12 11:20:30', '2021-05-13 11:20:30', '0'),
       (0003, '三班', '2021级', '2021-05-12 11:20:30', '2021-05-13 11:20:30', '0');

INSERT INTO stuclass (id, student_id, classroom_id)
VALUES (1, 101061, 0001),
       (2, 101062, 0001),
       (3, 101062, 0002),
       (4, 101063, 0002);

SELECT *
FROM students s
-- 通过学生id获取班级id（双向关系：多对多，学生id对班级id单向关系：一对多），导致获取的最终结果集会出现只有班级字段不同的记录
         LEFT OUTER JOIN stuclass sc ON sc.student_id = s.id
         LEFT OUTER JOIN classroom c ON c.id = sc.classroom_id -- 通过班级id获取班级信息（双向关系：一对一）
-- 通过学生id获取家长id（双向关系：多对多，学生id对家长id单向关系：一对多），导致获取的最终结果集会出现只有家长字段不同的记录
         LEFT OUTER JOIN stuparent sp ON sp.student_id = s.id
         LEFT OUTER JOIN parents p ON p.id = sp.parent_id -- 通过父母id获取家长信息（双向关系：一对一）
LIMIT 0, 2;
