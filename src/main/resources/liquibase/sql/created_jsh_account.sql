-- ----------------------------
-- Table structure for jsh_account
-- ----------------------------
CREATE TABLE `jsh_account` (
                               `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                               `name` varchar(50) DEFAULT NULL COMMENT '名称',
                               `serial_no` varchar(50) DEFAULT NULL COMMENT '编号',
                               `initial_amount` decimal(24,6) DEFAULT NULL COMMENT '期初金额',
                               `current_amount` decimal(24,6) DEFAULT NULL COMMENT '当前余额',
                               `remark` varchar(100) DEFAULT NULL COMMENT '备注',
                               `enabled` bit(1) DEFAULT NULL COMMENT '启用',
                               `sort` varchar(10) DEFAULT NULL COMMENT '排序',
                               `is_default` bit(1) DEFAULT NULL COMMENT '是否默认',
                               `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
                               `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='账户信息';


-- ----------------------------
-- Table structure for jsh_account_head
-- ----------------------------
CREATE TABLE `jsh_account_head` (
                                    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                    `type` varchar(50) DEFAULT NULL COMMENT '类型(支出/收入/收款/付款/转账)',
                                    `organ_id` bigint(20) DEFAULT NULL COMMENT '单位Id(收款/付款单位)',
                                    `hands_person_id` bigint(20) DEFAULT NULL COMMENT '经手人id',
                                    `creator` bigint(20) DEFAULT NULL COMMENT '操作员',
                                    `change_amount` decimal(24,6) DEFAULT NULL COMMENT '变动金额(优惠/收款/付款/实付)',
                                    `discount_money` decimal(24,6) DEFAULT NULL COMMENT '优惠金额',
                                    `total_price` decimal(24,6) DEFAULT NULL COMMENT '合计金额',
                                    `account_id` bigint(20) DEFAULT NULL COMMENT '账户(收款/付款)',
                                    `bill_no` varchar(50) DEFAULT NULL COMMENT '单据编号',
                                    `bill_time` datetime DEFAULT NULL COMMENT '单据日期',
                                    `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
                                    `file_name` varchar(500) DEFAULT NULL COMMENT '附件名称',
                                    `status` varchar(1) DEFAULT NULL COMMENT '状态，0未审核、1已审核、9审核中',
                                    `source` varchar(1) DEFAULT '0' COMMENT '单据来源，0-pc，1-手机',
                                    `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
                                    `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
                                    PRIMARY KEY (`id`),
                                    KEY `FK9F4C0D8DB610FC06` (`organ_id`),
                                    KEY `FK9F4C0D8DAAE50527` (`account_id`),
                                    KEY `FK9F4C0D8DC4170B37` (`hands_person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8 COMMENT='财务主表';


-- ----------------------------
-- Table structure for jsh_account_item
-- ----------------------------
CREATE TABLE `jsh_account_item` (
                                    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                    `header_id` bigint(20) NOT NULL COMMENT '表头Id',
                                    `account_id` bigint(20) DEFAULT NULL COMMENT '账户Id',
                                    `in_out_item_id` bigint(20) DEFAULT NULL COMMENT '收支项目Id',
                                    `bill_id` bigint(20) DEFAULT NULL COMMENT '单据id',
                                    `need_debt` decimal(24,6) DEFAULT NULL COMMENT '应收欠款',
                                    `finish_debt` decimal(24,6) DEFAULT NULL COMMENT '已收欠款',
                                    `each_amount` decimal(24,6) DEFAULT NULL COMMENT '单项金额',
                                    `remark` varchar(100) DEFAULT NULL COMMENT '单据备注',
                                    `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
                                    `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
                                    PRIMARY KEY (`id`),
                                    KEY `FK9F4CBAC0AAE50527` (`account_id`),
                                    KEY `FK9F4CBAC0C5FE6007` (`header_id`),
                                    KEY `FK9F4CBAC0D203EDC5` (`in_out_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=152 DEFAULT CHARSET=utf8 COMMENT='财务子表';


-- ----------------------------
-- Table structure for jsh_depot
-- ----------------------------
CREATE TABLE `jsh_depot` (
                             `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                             `name` varchar(20) DEFAULT NULL COMMENT '仓库名称',
                             `address` varchar(50) DEFAULT NULL COMMENT '仓库地址',
                             `warehousing` decimal(24,6) DEFAULT NULL COMMENT '仓储费',
                             `truckage` decimal(24,6) DEFAULT NULL COMMENT '搬运费',
                             `type` int(10) DEFAULT NULL COMMENT '类型',
                             `sort` varchar(10) DEFAULT NULL COMMENT '排序',
                             `remark` varchar(100) DEFAULT NULL COMMENT '描述',
                             `principal` bigint(20) DEFAULT NULL COMMENT '负责人',
                             `enabled` bit(1) DEFAULT NULL COMMENT '启用',
                             `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
                             `delete_Flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
                             `is_default` bit(1) DEFAULT NULL COMMENT '是否默认',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='仓库表';


-- ----------------------------
-- Table structure for jsh_depot_head
-- ----------------------------
CREATE TABLE `jsh_depot_head` (
                                  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                  `type` varchar(50) DEFAULT NULL COMMENT '类型(出库/入库)',
                                  `sub_type` varchar(50) DEFAULT NULL COMMENT '出入库分类',
                                  `default_number` varchar(50) DEFAULT NULL COMMENT '初始票据号',
                                  `number` varchar(50) DEFAULT NULL COMMENT '票据号',
                                  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                  `oper_time` datetime DEFAULT NULL COMMENT '出入库时间',
                                  `organ_id` bigint(20) DEFAULT NULL COMMENT '供应商id',
                                  `creator` bigint(20) DEFAULT NULL COMMENT '操作员',
                                  `account_id` bigint(20) DEFAULT NULL COMMENT '账户id',
                                  `change_amount` decimal(24,6) DEFAULT NULL COMMENT '变动金额(收款/付款)',
                                  `back_amount` decimal(24,6) DEFAULT NULL COMMENT '找零金额',
                                  `total_price` decimal(24,6) DEFAULT NULL COMMENT '合计金额',
                                  `pay_type` varchar(50) DEFAULT NULL COMMENT '付款类型(现金、记账等)',
                                  `bill_type` varchar(50) DEFAULT NULL COMMENT '单据类型',
                                  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
                                  `file_name` varchar(500) DEFAULT NULL COMMENT '附件名称',
                                  `sales_man` varchar(50) DEFAULT NULL COMMENT '业务员（可以多个）',
                                  `account_id_list` varchar(50) DEFAULT NULL COMMENT '多账户ID列表',
                                  `account_money_list` varchar(200) DEFAULT NULL COMMENT '多账户金额列表',
                                  `discount` decimal(24,6) DEFAULT NULL COMMENT '优惠率',
                                  `discount_money` decimal(24,6) DEFAULT NULL COMMENT '优惠金额',
                                  `discount_last_money` decimal(24,6) DEFAULT NULL COMMENT '优惠后金额',
                                  `other_money` decimal(24,6) DEFAULT NULL COMMENT '销售或采购费用合计',
                                  `deposit` decimal(24,6) DEFAULT NULL COMMENT '订金',
                                  `status` varchar(1) DEFAULT NULL COMMENT '状态，0未审核、1已审核、2完成采购|销售、3部分采购|销售、4未入库、9审核中',
                                  `purchase_status` varchar(1) DEFAULT NULL COMMENT '采购状态，0未采购、2完成采购、3部分采购',
                                  `source` varchar(1) DEFAULT '0' COMMENT '单据来源，0-pc，1-手机',
                                  `link_number` varchar(50) DEFAULT NULL COMMENT '关联订单号',
                                  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
                                  `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
                                  PRIMARY KEY (`id`),
                                  KEY `FK2A80F214B610FC06` (`organ_id`),
                                  KEY `FK2A80F214AAE50527` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=274 DEFAULT CHARSET=utf8 COMMENT='单据主表';


-- ----------------------------
-- Table structure for jsh_depot_item
-- ----------------------------
CREATE TABLE `jsh_depot_item` (
                                  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                  `header_id` bigint(20) NOT NULL COMMENT '表头Id',
                                  `material_id` bigint(20) NOT NULL COMMENT '商品Id',
                                  `material_extend_id` bigint(20) DEFAULT NULL COMMENT '商品扩展id',
                                  `material_unit` varchar(20) DEFAULT NULL COMMENT '商品计量单位',
                                  `sku` varchar(50) DEFAULT NULL COMMENT '多属性',
                                  `oper_number` decimal(24,6) DEFAULT NULL COMMENT '数量',
                                  `basic_number` decimal(24,6) DEFAULT NULL COMMENT '基础数量，如kg、瓶',
                                  `unit_price` decimal(24,6) DEFAULT NULL COMMENT '单价',
                                  `purchase_unit_price` decimal(24,6) DEFAULT NULL COMMENT '采购单价',
                                  `tax_unit_price` decimal(24,6) DEFAULT NULL COMMENT '含税单价',
                                  `all_price` decimal(24,6) DEFAULT NULL COMMENT '金额',
                                  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
                                  `depot_id` bigint(20) DEFAULT NULL COMMENT '仓库ID',
                                  `another_depot_id` bigint(20) DEFAULT NULL COMMENT '调拨时，对方仓库Id',
                                  `tax_rate` decimal(24,6) DEFAULT NULL COMMENT '税率',
                                  `tax_money` decimal(24,6) DEFAULT NULL COMMENT '税额',
                                  `tax_last_money` decimal(24,6) DEFAULT NULL COMMENT '价税合计',
                                  `material_type` varchar(20) DEFAULT NULL COMMENT '商品类型',
                                  `sn_list` varchar(2000) DEFAULT NULL COMMENT '序列号列表',
                                  `batch_number` varchar(100) DEFAULT NULL COMMENT '批号',
                                  `expiration_date` datetime DEFAULT NULL COMMENT '有效日期',
                                  `link_id` bigint(20) DEFAULT NULL COMMENT '关联明细id',
                                  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
                                  `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
                                  PRIMARY KEY (`id`),
                                  KEY `FK2A819F475D61CCF7` (`material_id`),
                                  KEY `FK2A819F474BB6190E` (`header_id`),
                                  KEY `FK2A819F479485B3F5` (`depot_id`),
                                  KEY `FK2A819F47729F5392` (`another_depot_id`)
) ENGINE=InnoDB AUTO_INCREMENT=331 DEFAULT CHARSET=utf8 COMMENT='单据子表';


-- ----------------------------
-- Table structure for jsh_function
-- ----------------------------
CREATE TABLE `jsh_function` (
                                `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                `number` varchar(50) DEFAULT NULL COMMENT '编号',
                                `name` varchar(50) DEFAULT NULL COMMENT '名称',
                                `parent_number` varchar(50) DEFAULT NULL COMMENT '上级编号',
                                `url` varchar(100) DEFAULT NULL COMMENT '链接',
                                `component` varchar(100) DEFAULT NULL COMMENT '组件',
                                `state` bit(1) DEFAULT NULL COMMENT '收缩',
                                `sort` varchar(50) DEFAULT NULL COMMENT '排序',
                                `enabled` bit(1) DEFAULT NULL COMMENT '启用',
                                `type` varchar(50) DEFAULT NULL COMMENT '类型',
                                `push_btn` varchar(50) DEFAULT NULL COMMENT '功能按钮',
                                `icon` varchar(50) DEFAULT NULL COMMENT '图标',
                                `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
                                PRIMARY KEY (`id`),
                                UNIQUE KEY `url` (`url`)
) ENGINE=InnoDB AUTO_INCREMENT=260 DEFAULT CHARSET=utf8 COMMENT='功能模块表';


-- ----------------------------
-- Table structure for jsh_in_out_item
-- ----------------------------
CREATE TABLE `jsh_in_out_item` (
                                   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                   `name` varchar(50) DEFAULT NULL COMMENT '名称',
                                   `type` varchar(20) DEFAULT NULL COMMENT '类型',
                                   `remark` varchar(100) DEFAULT NULL COMMENT '备注',
                                   `enabled` bit(1) DEFAULT NULL COMMENT '启用',
                                   `sort` varchar(10) DEFAULT NULL COMMENT '排序',
                                   `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
                                   `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='收支项目';


-- ----------------------------
-- Table structure for jsh_log
-- ----------------------------
CREATE TABLE `jsh_log` (
                           `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                           `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
                           `operation` varchar(500) DEFAULT NULL COMMENT '操作模块名称',
                           `client_ip` varchar(200) DEFAULT NULL COMMENT '客户端IP',
                           `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                           `status` tinyint(4) DEFAULT NULL COMMENT '操作状态 0==成功，1==失败',
                           `content` varchar(1000) DEFAULT NULL COMMENT '详情',
                           `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
                           PRIMARY KEY (`id`),
                           KEY `FKF2696AA13E226853` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7559 DEFAULT CHARSET=utf8 COMMENT='操作日志';

-- ----------------------------
-- Records of jsh_log
-- ----------------------------

-- ----------------------------
-- Table structure for jsh_material
-- ----------------------------
CREATE TABLE `jsh_material` (
                                `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                `category_id` bigint(20) DEFAULT NULL COMMENT '产品类型id',
                                `name` varchar(100) DEFAULT NULL COMMENT '名称',
                                `mfrs` varchar(50) DEFAULT NULL COMMENT '制造商',
                                `model` varchar(100) DEFAULT NULL COMMENT '型号',
                                `standard` varchar(100) DEFAULT NULL COMMENT '规格',
                                `color` varchar(50) DEFAULT NULL COMMENT '颜色',
                                `unit` varchar(50) DEFAULT NULL COMMENT '单位-单个',
                                `remark` varchar(500) DEFAULT NULL COMMENT '备注',
                                `img_name` varchar(500) DEFAULT NULL COMMENT '图片名称',
                                `unit_id` bigint(20) DEFAULT NULL COMMENT '计量单位Id',
                                `expiry_num` int(10) DEFAULT NULL COMMENT '保质期天数',
                                `weight` decimal(24,6) DEFAULT NULL COMMENT '基础重量(kg)',
                                `enabled` bit(1) DEFAULT NULL COMMENT '启用 0-禁用  1-启用',
                                `other_field1` varchar(50) DEFAULT NULL COMMENT '自定义1',
                                `other_field2` varchar(50) DEFAULT NULL COMMENT '自定义2',
                                `other_field3` varchar(50) DEFAULT NULL COMMENT '自定义3',
                                `enable_serial_number` varchar(1) DEFAULT '0' COMMENT '是否开启序列号，0否，1是',
                                `enable_batch_number` varchar(1) DEFAULT '0' COMMENT '是否开启批号，0否，1是',
                                `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
                                `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
                                PRIMARY KEY (`id`),
                                KEY `FK675951272AB6672C` (`category_id`),
                                KEY `UnitId` (`unit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=620 DEFAULT CHARSET=utf8 COMMENT='产品表';

-- ----------------------------
-- Table structure for jsh_material_attribute
-- ----------------------------
CREATE TABLE `jsh_material_attribute` (
                                          `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                          `attribute_name` varchar(50) DEFAULT NULL COMMENT '属性名',
                                          `attribute_value` varchar(500) DEFAULT NULL COMMENT '属性值',
                                          `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
                                          `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
                                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='产品属性表';


-- ----------------------------
-- Table structure for jsh_material_category
-- ----------------------------
CREATE TABLE `jsh_material_category` (
                                         `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                         `name` varchar(50) DEFAULT NULL COMMENT '名称',
                                         `category_level` smallint(6) DEFAULT NULL COMMENT '等级',
                                         `parent_id` bigint(20) DEFAULT NULL COMMENT '上级id',
                                         `sort` varchar(10) DEFAULT NULL COMMENT '显示顺序',
                                         `serial_no` varchar(100) DEFAULT NULL COMMENT '编号',
                                         `remark` varchar(1024) DEFAULT NULL COMMENT '备注',
                                         `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                         `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                         `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
                                         `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
                                         PRIMARY KEY (`id`),
                                         KEY `FK3EE7F725237A77D8` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='产品类型表';


-- ----------------------------
-- Table structure for jsh_material_current_stock
-- ----------------------------
CREATE TABLE `jsh_material_current_stock` (
                                              `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                              `material_id` bigint(20) DEFAULT NULL COMMENT '产品id',
                                              `depot_id` bigint(20) DEFAULT NULL COMMENT '仓库id',
                                              `current_number` decimal(24,6) DEFAULT NULL COMMENT '当前库存数量',
                                              `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
                                              `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
                                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='产品当前库存';


-- ----------------------------
-- Table structure for jsh_material_extend
-- ----------------------------
CREATE TABLE `jsh_material_extend` (
                                       `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                       `material_id` bigint(20) DEFAULT NULL COMMENT '商品id',
                                       `bar_code` varchar(50) DEFAULT NULL COMMENT '商品条码',
                                       `commodity_unit` varchar(50) DEFAULT NULL COMMENT '商品单位',
                                       `sku` varchar(50) DEFAULT NULL COMMENT '多属性',
                                       `purchase_decimal` decimal(24,6) DEFAULT NULL COMMENT '采购价格',
                                       `commodity_decimal` decimal(24,6) DEFAULT NULL COMMENT '零售价格',
                                       `wholesale_decimal` decimal(24,6) DEFAULT NULL COMMENT '销售价格',
                                       `low_decimal` decimal(24,6) DEFAULT NULL COMMENT '最低售价',
                                       `default_flag` varchar(1) DEFAULT '1' COMMENT '是否为默认单位，1是，0否',
                                       `create_time` datetime DEFAULT NULL COMMENT '创建日期',
                                       `create_serial` varchar(50) DEFAULT NULL COMMENT '创建人编码',
                                       `update_serial` varchar(50) DEFAULT NULL COMMENT '更新人编码',
                                       `update_time` bigint(20) DEFAULT NULL COMMENT '更新时间戳',
                                       `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
                                       `delete_Flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
                                       PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='产品价格扩展';


-- ----------------------------
-- Table structure for jsh_material_initial_stock
-- ----------------------------
CREATE TABLE `jsh_material_initial_stock` (
                                              `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                              `material_id` bigint(20) DEFAULT NULL COMMENT '产品id',
                                              `depot_id` bigint(20) DEFAULT NULL COMMENT '仓库id',
                                              `number` decimal(24,6) DEFAULT NULL COMMENT '初始库存数量',
                                              `low_safe_stock` decimal(24,6) DEFAULT NULL COMMENT '最低库存数量',
                                              `high_safe_stock` decimal(24,6) DEFAULT NULL COMMENT '最高库存数量',
                                              `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
                                              `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
                                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=205 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='产品初始库存';

-- ----------------------------
-- Records of jsh_material_initial_stock
-- ----------------------------

-- ----------------------------
-- Table structure for jsh_material_property
-- ----------------------------
CREATE TABLE `jsh_material_property` (
                                         `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                         `native_name` varchar(50) DEFAULT NULL COMMENT '原始名称',
                                         `enabled` bit(1) DEFAULT NULL COMMENT '是否启用',
                                         `sort` varchar(10) DEFAULT NULL COMMENT '排序',
                                         `another_name` varchar(50) DEFAULT NULL COMMENT '别名',
                                         `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
                                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='产品扩展字段表';


-- ----------------------------
-- Table structure for jsh_msg
-- ----------------------------
CREATE TABLE `jsh_msg` (
                           `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                           `msg_title` varchar(100) DEFAULT NULL COMMENT '消息标题',
                           `msg_content` varchar(500) DEFAULT NULL COMMENT '消息内容',
                           `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                           `type` varchar(20) DEFAULT NULL COMMENT '消息类型',
                           `user_id` bigint(20) DEFAULT NULL COMMENT '接收人id',
                           `status` varchar(1) DEFAULT NULL COMMENT '状态，1未读 2已读',
                           `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
                           `delete_Flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='消息表';


-- ----------------------------
-- Table structure for jsh_organization
-- ----------------------------
CREATE TABLE `jsh_organization` (
                                    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                    `org_no` varchar(20) DEFAULT NULL COMMENT '机构编号',
                                    `org_abr` varchar(20) DEFAULT NULL COMMENT '机构简称',
                                    `parent_id` bigint(20) DEFAULT NULL COMMENT '父机构id',
                                    `sort` varchar(20) DEFAULT NULL COMMENT '机构显示顺序',
                                    `remark` varchar(500) DEFAULT NULL COMMENT '备注',
                                    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                    `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
                                    `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
                                    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='机构表';


-- ----------------------------
-- Table structure for jsh_orga_user_rel
-- ----------------------------
CREATE TABLE `jsh_orga_user_rel` (
                                     `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                     `orga_id` bigint(20) NOT NULL COMMENT '机构id',
                                     `user_id` bigint(20) NOT NULL COMMENT '用户id',
                                     `user_blng_orga_dspl_seq` varchar(20) DEFAULT NULL COMMENT '用户在所属机构中显示顺序',
                                     `delete_flag` char(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
                                     `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                     `creator` bigint(20) DEFAULT NULL COMMENT '创建人',
                                     `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                     `updater` bigint(20) DEFAULT NULL COMMENT '更新人',
                                     `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
                                     PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='机构用户关系表';


-- ----------------------------
-- Table structure for jsh_person
-- ----------------------------
CREATE TABLE `jsh_person` (
                              `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                              `type` varchar(20) DEFAULT NULL COMMENT '类型',
                              `name` varchar(50) DEFAULT NULL COMMENT '姓名',
                              `enabled` bit(1) DEFAULT NULL COMMENT '启用',
                              `sort` varchar(10) DEFAULT NULL COMMENT '排序',
                              `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
                              `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='经手人表';


-- ----------------------------
-- Table structure for jsh_platform_config
-- ----------------------------
CREATE TABLE `jsh_platform_config` (
                                       `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                       `platform_key` varchar(100) DEFAULT NULL COMMENT '关键词',
                                       `platform_key_info` varchar(100) DEFAULT NULL COMMENT '关键词名称',
                                       `platform_value` varchar(200) DEFAULT NULL COMMENT '值',
                                       PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='平台参数';


-- ----------------------------
-- Table structure for jsh_role
-- ----------------------------
CREATE TABLE `jsh_role` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                            `name` varchar(50) DEFAULT NULL COMMENT '名称',
                            `type` varchar(50) DEFAULT NULL COMMENT '类型',
                            `price_limit` varchar(50) DEFAULT NULL COMMENT '价格屏蔽 1-屏蔽采购价 2-屏蔽零售价 3-屏蔽销售价',
                            `value` varchar(200) DEFAULT NULL COMMENT '值',
                            `description` varchar(100) DEFAULT NULL COMMENT '描述',
                            `enabled` bit(1) DEFAULT NULL COMMENT '启用',
                            `sort` varchar(10) DEFAULT NULL COMMENT '排序',
                            `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
                            `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='角色表';


-- ----------------------------
-- Table structure for jsh_sequence
-- ----------------------------
CREATE TABLE `jsh_sequence` (
                                `seq_name` varchar(50) NOT NULL COMMENT '序列名称',
                                `min_value` bigint(20) NOT NULL COMMENT '最小值',
                                `max_value` bigint(20) NOT NULL COMMENT '最大值',
                                `current_val` bigint(20) NOT NULL COMMENT '当前值',
                                `increment_val` int(11) NOT NULL DEFAULT '1' COMMENT '增长步数',
                                `remark` varchar(500) DEFAULT NULL COMMENT '备注',
                                PRIMARY KEY (`seq_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='单据编号表';


-- ----------------------------
-- Table structure for jsh_serial_number
-- ----------------------------
CREATE TABLE `jsh_serial_number` (
                                     `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                     `material_id` bigint(20) DEFAULT NULL COMMENT '产品表id',
                                     `depot_id` bigint(20) DEFAULT NULL COMMENT '仓库id',
                                     `serial_number` varchar(64) DEFAULT NULL COMMENT '序列号',
                                     `is_sell` varchar(1) DEFAULT '0' COMMENT '是否卖出，0未卖出，1卖出',
                                     `remark` varchar(1024) DEFAULT NULL COMMENT '备注',
                                     `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
                                     `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                     `creator` bigint(20) DEFAULT NULL COMMENT '创建人',
                                     `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                     `updater` bigint(20) DEFAULT NULL COMMENT '更新人',
                                     `in_bill_no` varchar(50) DEFAULT NULL COMMENT '入库单号',
                                     `out_bill_no` varchar(50) DEFAULT NULL COMMENT '出库单号',
                                     `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
                                     PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8 COMMENT='序列号表';


-- ----------------------------
-- Table structure for jsh_supplier
-- ----------------------------
CREATE TABLE `jsh_supplier` (
                                `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                `supplier` varchar(255) NOT NULL COMMENT '供应商名称',
                                `contacts` varchar(100) DEFAULT NULL COMMENT '联系人',
                                `phone_num` varchar(30) DEFAULT NULL COMMENT '联系电话',
                                `email` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
                                `description` varchar(500) DEFAULT NULL COMMENT '备注',
                                `isystem` tinyint(4) DEFAULT NULL COMMENT '是否系统自带 0==系统 1==非系统',
                                `type` varchar(20) DEFAULT NULL COMMENT '类型',
                                `enabled` bit(1) DEFAULT NULL COMMENT '启用',
                                `advance_in` decimal(24,6) DEFAULT '0.000000' COMMENT '预收款',
                                `begin_need_get` decimal(24,6) DEFAULT NULL COMMENT '期初应收',
                                `begin_need_pay` decimal(24,6) DEFAULT NULL COMMENT '期初应付',
                                `all_need_get` decimal(24,6) DEFAULT NULL COMMENT '累计应收',
                                `all_need_pay` decimal(24,6) DEFAULT NULL COMMENT '累计应付',
                                `fax` varchar(30) DEFAULT NULL COMMENT '传真',
                                `telephone` varchar(30) DEFAULT NULL COMMENT '手机',
                                `address` varchar(50) DEFAULT NULL COMMENT '地址',
                                `tax_num` varchar(50) DEFAULT NULL COMMENT '纳税人识别号',
                                `bank_name` varchar(50) DEFAULT NULL COMMENT '开户行',
                                `account_number` varchar(50) DEFAULT NULL COMMENT '账号',
                                `tax_rate` decimal(24,6) DEFAULT NULL COMMENT '税率',
                                `sort` varchar(10) DEFAULT NULL COMMENT '排序',
                                `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
                                `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8 COMMENT='供应商/客户信息表';


-- ----------------------------
-- Table structure for jsh_system_config
-- ----------------------------
CREATE TABLE `jsh_system_config` (
                                     `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                     `company_name` varchar(50) DEFAULT NULL COMMENT '公司名称',
                                     `company_contacts` varchar(20) DEFAULT NULL COMMENT '公司联系人',
                                     `company_address` varchar(50) DEFAULT NULL COMMENT '公司地址',
                                     `company_tel` varchar(20) DEFAULT NULL COMMENT '公司电话',
                                     `company_fax` varchar(20) DEFAULT NULL COMMENT '公司传真',
                                     `company_post_code` varchar(20) DEFAULT NULL COMMENT '公司邮编',
                                     `sale_agreement` varchar(500) DEFAULT NULL COMMENT '销售协议',
                                     `depot_flag` varchar(1) DEFAULT '0' COMMENT '仓库启用标记，0未启用，1启用',
                                     `customer_flag` varchar(1) DEFAULT '0' COMMENT '客户启用标记，0未启用，1启用',
                                     `minus_stock_flag` varchar(1) DEFAULT '0' COMMENT '负库存启用标记，0未启用，1启用',
                                     `purchase_by_sale_flag` varchar(1) DEFAULT '0' COMMENT '以销定购启用标记，0未启用，1启用',
                                     `multi_level_approval_flag` varchar(1) DEFAULT '0' COMMENT '多级审核启用标记，0未启用，1启用',
                                     `multi_bill_type` varchar(200) DEFAULT NULL COMMENT '流程类型，可多选',
                                     `force_approval_flag` varchar(1) DEFAULT '0' COMMENT '强审核启用标记，0未启用，1启用',
                                     `update_unit_price_flag` varchar(1) DEFAULT '1' COMMENT '更新单价启用标记，0未启用，1启用',
                                     `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
                                     `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
                                     PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='系统参数';


-- ----------------------------
-- Table structure for jsh_tenant
-- ----------------------------
CREATE TABLE `jsh_tenant` (
                              `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                              `tenant_id` bigint(20) DEFAULT NULL COMMENT '用户id',
                              `login_name` varchar(255) DEFAULT NULL COMMENT '登录名',
                              `user_num_limit` int(11) DEFAULT NULL COMMENT '用户数量限制',
                              `type` varchar(1) DEFAULT '0' COMMENT '租户类型，0免费租户，1付费租户',
                              `enabled` bit(1) DEFAULT b'1' COMMENT '启用 0-禁用  1-启用',
                              `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                              `expire_time` datetime DEFAULT NULL COMMENT '到期时间',
                              `remark` varchar(500) DEFAULT NULL COMMENT '备注',
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='租户';


-- ----------------------------
-- Table structure for jsh_unit
-- ----------------------------
CREATE TABLE `jsh_unit` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                            `name` varchar(50) DEFAULT NULL COMMENT '名称，支持多单位',
                            `basic_unit` varchar(50) DEFAULT NULL COMMENT '基础单位',
                            `other_unit` varchar(50) DEFAULT NULL COMMENT '副单位',
                            `other_unit_two` varchar(50) DEFAULT NULL COMMENT '副单位2',
                            `other_unit_three` varchar(50) DEFAULT NULL COMMENT '副单位3',
                            `ratio` decimal(24,3) DEFAULT NULL COMMENT '比例',
                            `ratio_two` decimal(24,3) DEFAULT NULL COMMENT '比例2',
                            `ratio_three` decimal(24,3) DEFAULT NULL COMMENT '比例3',
                            `enabled` bit(1) DEFAULT NULL COMMENT '启用',
                            `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
                            `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='多单位表';


-- ----------------------------
-- Table structure for jsh_user
-- ----------------------------
CREATE TABLE `jsh_user` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                            `username` varchar(255) NOT NULL COMMENT '用户姓名--例如张三',
                            `login_name` varchar(255) NOT NULL COMMENT '登录用户名',
                            `password` varchar(50) DEFAULT NULL COMMENT '登陆密码',
                            `leader_flag` varchar(1) DEFAULT '0' COMMENT '是否经理，0否，1是',
                            `position` varchar(200) DEFAULT NULL COMMENT '职位',
                            `department` varchar(255) DEFAULT NULL COMMENT '所属部门',
                            `email` varchar(100) DEFAULT NULL COMMENT '电子邮箱',
                            `phonenum` varchar(100) DEFAULT NULL COMMENT '手机号码',
                            `ismanager` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否为管理者 0==管理者 1==员工',
                            `isystem` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否系统自带数据 ',
                            `Status` tinyint(4) DEFAULT '0' COMMENT '状态，0：正常，1：删除，2封禁',
                            `description` varchar(500) DEFAULT NULL COMMENT '用户描述信息',
                            `remark` varchar(500) DEFAULT NULL COMMENT '备注',
                            `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=146 DEFAULT CHARSET=utf8 COMMENT='用户表';


-- ----------------------------
-- Table structure for jsh_user_business
-- ----------------------------
CREATE TABLE `jsh_user_business` (
                                     `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                     `type` varchar(50) DEFAULT NULL COMMENT '类别',
                                     `key_id` varchar(50) DEFAULT NULL COMMENT '主id',
                                     `value` varchar(10000) DEFAULT NULL COMMENT '值',
                                     `btn_str` varchar(2000) DEFAULT NULL COMMENT '按钮权限',
                                     `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
                                     `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
                                     PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8 COMMENT='用户/角色/模块关系表';

