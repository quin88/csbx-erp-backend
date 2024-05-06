-- ----------------------------
-- 字段扩容
-------------------------------
ALTER TABLE jsh_depot
    MODIFY COLUMN name VARCHAR(50) null comment '仓库名称',
    MODIFY COLUMN remark VARCHAR(200) null comment '备注',
    MODIFY COLUMN address VARCHAR(100) null comment '仓库地址';
