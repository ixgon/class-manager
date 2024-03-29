SHOW DATABASES;
-- 通过cmd登录数据库管理界面后，创建数据库 school
CREATE DATABASE IF NOT EXISTS school;
SHOW DATABASES;

-- 使用 school 数据库
USE school;

-- 创建学生表
-- Engine：存储引擎； CHARACTER SET：字符集【UTF8MB4，即UTF8】； COLLATE：校对集（排序规则）
DROP TABLE IF EXISTS stu_parent; -- stuparent表中有外键引用了student表中的主键，所以在删除student表之前，先要删除所有引用过它的其他表
DROP TABLE IF EXISTS stu_class;
DROP TABLE IF EXISTS student;
CREATE TABLE student
(
    id          INT PRIMARY KEY AUTO_INCREMENT COMMENT '学生id（学号），有序，用于替代无序的account作为主键',
    account     CHAR(16)    NOT NULL UNIQUE COMMENT '账号',
    password    VARCHAR(20) NOT NULL COMMENT '密码',
    name        VARCHAR(25) NOT NULL COMMENT '姓名',
    sex         CHAR(1)     NOT NULL COMMENT '性别（1 男、2 女）',
    id_card     CHAR(18)    NOT NULL UNIQUE COMMENT '身份证号',
    create_time TIMESTAMP            DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', -- TIMESTAMP(推荐) OR DATETIME，解放手动使用java创建时间，由数据库自动插入和更新时间
    update_time TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',          -- CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    is_deleted  CHAR(1)     NOT NULL DEFAULT 0 COMMENT '是否删除（0 未删、1 已删）'
) ENGINE INNODB
  CHARACTER SET UTF8MB4
  COLLATE utf8mb4_unicode_ci COMMENT '学生信息表';

-- 设置数据表的自增主键增长的起始值为10161
ALTER TABLE student
    AUTO_INCREMENT = 10161;

-- 创建家长表（一个家长可以有多个孩子，一个孩子可以有多个家长（父亲或母亲））
DROP TABLE IF EXISTS stu_parent;
DROP TABLE IF EXISTS parent;
CREATE TABLE parent
(
    id          INT PRIMARY KEY AUTO_INCREMENT COMMENT '家长id（类似学生学号，可以与学生学号相关）',
    account     CHAR(16)    NOT NULL UNIQUE COMMENT '账号',
    password    VARCHAR(20) NOT NULL COMMENT '密码',
    name        VARCHAR(25) NOT NULL COMMENT '姓名',
    phone       CHAR(11)    NOT NULL COMMENT '手机号',
    sex         CHAR(1)     NOT NULL COMMENT '性别（1 男、2 女）',
    create_time TIMESTAMP            DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    is_deleted  CHAR(1)     NOT NULL DEFAULT 0 COMMENT '是否删除（0 未删、1 已删）'
) ENGINE INNODB
  CHARACTER SET UTF8MB4
  COLLATE utf8mb4_unicode_ci
  AUTO_INCREMENT 1101061 COMMENT '家长信息表';

-- 创建学生-家长表
DROP TABLE IF EXISTS `stu_parent`;
CREATE TABLE stu_parent
(
    id         INT PRIMARY KEY AUTO_INCREMENT COMMENT '学生-家长id（没有实际意义的id，作为有序的主键构建B+树，用于替代 学生id+班级id 唯一代表一条记录）',
    student_id INT NOT NULL COMMENT '学生id',
    parent_id  INT NOT NULL COMMENT '家长id',
    UNIQUE INDEX (student_id, parent_id),
    FOREIGN KEY (student_id) REFERENCES student (id) ON DELETE CASCADE,
    FOREIGN KEY (parent_id) REFERENCES parent (id) ON DELETE CASCADE -- 级联删除
) ENGINE INNODB
  CHARACTER SET UTF8MB4
  COLLATE utf8mb4_unicode_ci
  AUTO_INCREMENT 1 COMMENT '学生-家长信息表';

-- 创建班级表
-- Mybatis-Plus 不推荐使用复合主键，约定每一张表都有自己的唯一 id 主键
DROP TABLE IF EXISTS stu_class;
DROP TABLE IF EXISTS classroom;
CREATE TABLE classroom
(
    id          INT PRIMARY KEY AUTO_INCREMENT COMMENT '班级id（可以是有序的主键，用来替代 年级+班级名称 唯一代表一条记录）',
    name        VARCHAR(25) NOT NULL COMMENT '班级名称',
    year        CHAR(6)     NOT NULL COMMENT '年级',
    create_time TIMESTAMP            DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    is_deleted  CHAR(1)     NOT NULL DEFAULT 0 COMMENT '是否删除（0 未删、1 已删）'
) ENGINE INNODB
  CHARACTER SET UTF8MB4
  COLLATE utf8mb4_unicode_ci
  AUTO_INCREMENT 0001 COMMENT '班级信息表';

-- 创建学生-班级表（过去：一个学生只有一个班级，一个班级可以有多个学生；现在：一个学生可以从属于多个班级，一个班级可以有多个学生）
DROP TABLE IF EXISTS stu_class;
CREATE TABLE stu_class
(
    id           INT PRIMARY KEY AUTO_INCREMENT COMMENT '学生-班级id',
    student_id   INT NOT NULL COMMENT '学生id', -- 过去（唯一主键）：student_id   INT NOT NULL UNIQUE COMMENT '学生id',
    classroom_id INT NOT NULL COMMENT '班级id',
    UNIQUE INDEX (student_id, classroom_id),  -- 防止多次插入相同的(student_id, classroom_id)，因为并没有将这两个字段作为主键，但它们在表中是唯一的！
    FOREIGN KEY (student_id) REFERENCES student (id) ON DELETE CASCADE,
    FOREIGN KEY (classroom_id) REFERENCES classroom (id) ON DELETE CASCADE
) ENGINE INNODB
  CHARACTER SET UTF8MB4
  COLLATE utf8mb4_unicode_ci
  AUTO_INCREMENT 1 COMMENT '学生-班级信息表';

-- 初始化学生表、家长表、班级表、学生-班级表【3条多数据即可】
INSERT INTO student (id, account, password, name, sex, id_card, is_deleted)
VALUES (101061, '111111', '123456', '张三', '1', '325412197007055415', '0'),
       (101062, '222222', '123456', '李四', '1', '325412197007055416', '0'),
       (101063, '333333', '123456', '王五', '1', '325412197007055417', '0'),
       (101064, '444444', '123456', '王六', '1', '325412197007055418', '0');

UPDATE student
SET account = 'admin',
    name    = '太宰'
WHERE id = 1;

INSERT INTO parent (id, account, password, name, phone, sex, is_deleted)
VALUES (1101061, '011110', '123456', '张父', '17860529500', '1', '0'),
       (1101062, '022220', '123456', '李父', '17860529501', '1', '0'),
       (1101063, '022230', '123456', '李母', '17860529521', '2', '0'),
       (1101064, '022240', '123456', '李义父', '17860529531', '1', '0'),
       (1101065, '033330', '123456', '王父', '17860529502', '1', '0'),
       (1101066, '033331', '123456', '王母', '17860529503', '2', '0');

INSERT INTO stu_parent (id, student_id, parent_id)
VALUES (1, 101061, 1101061),
       (2, 101062, 1101062),
       (3, 101063, 1101065),
       (4, 101063, 1101066),
       (5, 101064, 1101065),
       (6, 101064, 1101066)
-- ,(7, 101062, 1101063),
-- (8, 101062, 1101064)
;

INSERT INTO classroom (id, name, year, is_deleted)
VALUES (0001, '一班', '2020级', '0'),
       (0002, '二班', '2020级', '0'),
       (0003, '三班', '2021级', '0');

INSERT INTO stu_class (id, student_id, classroom_id)
VALUES (1, 101061, 0001),
       (2, 101062, 0001),
       (3, 101062, 0002),
       (4, 101063, 0002);

SELECT *
FROM student s
-- 通过学生id获取班级id（双向关系：多对多，学生id对班级id单向关系：一对多），导致获取的最终结果集会出现只有班级字段不同的记录
         LEFT OUTER JOIN stu_class sc ON sc.student_id = s.id
         LEFT OUTER JOIN classroom c ON c.id = sc.classroom_id -- 通过班级id获取班级信息（双向关系：一对一）
-- 通过学生id获取家长id（双向关系：多对多，学生id对家长id单向关系：一对多），导致获取的最终结果集会出现只有家长字段不同的记录
         LEFT OUTER JOIN stu_parent sp ON sp.student_id = s.id
         LEFT OUTER JOIN parent p ON p.id = sp.parent_id -- 通过父母id获取家长信息（双向关系：一对一）
LIMIT 0, 2;

SELECT *
FROM classroom c
         LEFT OUTER JOIN stu_class sc ON sc.classroom_id = c.id
         LEFT OUTER JOIN student s ON s.id = sc.student_id;
