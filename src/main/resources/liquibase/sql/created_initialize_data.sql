-- ----------------------------
-- Records of jsh_user
-- ----------------------------
INSERT INTO `jsh_user` VALUES ('120', '管理员', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '0', null, null, null, null, '1', '0', '0', null, null, '0');
INSERT INTO `jsh_user` VALUES ('146', '城市佰兴', 'csbx', 'e10adc3949ba59abbe56e057f20f883e', '0', null, null, null, null, 1, 0, 0, null, null, 146);
-- ----------------------------
-- Records of jsh_role
-- ----------------------------
INSERT INTO `jsh_role` VALUES ('4', '管理员', '全部数据', null, null, null, '', null, null, '0');
INSERT INTO `jsh_role` VALUES ('10', '租户', '全部数据', null, null, '', '', null, null, '0');
-- ----------------------------
-- Records of jsh_user_business
-- ----------------------------
INSERT INTO `jsh_user_business` VALUES ('5', 'RoleFunctions', '4', '[210][225][211][241][32][33][199][242][38][41][200][201][239][202][40][232][233][197][44][203][204][205][206][212][246][207][208][209][226][227][228][229][59][235][237][244][22][21][23][220][240][247][25][24][217][218][26][194][195][31][13][1][14][243][15][234][16][18][236][245][248][198][258][259]', '[{\"funId\":13,\"btnStr\":\"1\"},{\"funId\":14,\"btnStr\":\"1\"},{\"funId\":243,\"btnStr\":\"1\"},{\"funId\":234,\"btnStr\":\"1\"},{\"funId\":16,\"btnStr\":\"1\"},{\"funId\":18,\"btnStr\":\"1\"},{\"funId\":236,\"btnStr\":\"1\"},{\"funId\":245,\"btnStr\":\"1\"},{\"funId\":22,\"btnStr\":\"1\"},{\"funId\":23,\"btnStr\":\"1\"},{\"funId\":220,\"btnStr\":\"1\"},{\"funId\":240,\"btnStr\":\"1\"},{\"funId\":247,\"btnStr\":\"1\"},{\"funId\":25,\"btnStr\":\"1\"},{\"funId\":217,\"btnStr\":\"1\"},{\"funId\":218,\"btnStr\":\"1\"},{\"funId\":26,\"btnStr\":\"1\"},{\"funId\":194,\"btnStr\":\"1\"},{\"funId\":195,\"btnStr\":\"1\"},{\"funId\":31,\"btnStr\":\"1\"},{\"funId\":241,\"btnStr\":\"1,2,7\"},{\"funId\":33,\"btnStr\":\"1,2,7\"},{\"funId\":199,\"btnStr\":\"1,2,7\"},{\"funId\":242,\"btnStr\":\"1,2,7\"},{\"funId\":41,\"btnStr\":\"1,2,7\"},{\"funId\":200,\"btnStr\":\"1,2,7\"},{\"funId\":210,\"btnStr\":\"1,2,7\"},{\"funId\":211,\"btnStr\":\"1,2,7\"},{\"funId\":197,\"btnStr\":\"1,7,2\"},{\"funId\":203,\"btnStr\":\"1,7,2\"},{\"funId\":204,\"btnStr\":\"1,7,2\"},{\"funId\":205,\"btnStr\":\"1,7,2\"},{\"funId\":206,\"btnStr\":\"1,2,7\"},{\"funId\":212,\"btnStr\":\"1,7,2\"},{\"funId\":201,\"btnStr\":\"1,2,7\"},{\"funId\":202,\"btnStr\":\"1,2,7\"},{\"funId\":40,\"btnStr\":\"1,2,7\"},{\"funId\":232,\"btnStr\":\"1,2,7\"},{\"funId\":233,\"btnStr\":\"1,2,7\"}]', null, '0');
INSERT INTO `jsh_user_business` VALUES ('38', 'UserRole', '120', '[4]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('83', 'UserRole', '146', '[10]', null, 146, '0');
INSERT INTO `jsh_user_business` VALUES ('84', 'RoleFunctions', '10', '[225][210][211][32][241][33][199][260][261][262][38][242][41][200][263][264][265][239][201][202][40][232][233][44][197][203][204][205][206][212][266][198][246][207][259][208][209][226][227][248][228][229][59][235][237][244][21][22][23][220][247][24][25][217][218][26][194][195][31][1][13][14][243][15][234][16][18][236][245][258]', '[{"funId":13,"btnStr":"1"},{"funId":14,"btnStr":"1"},{"funId":243,"btnStr":"1"},{"funId":234,"btnStr":"1"},{"funId":16,"btnStr":"1"},{"funId":18,"btnStr":"1"},{"funId":236,"btnStr":"1"},{"funId":245,"btnStr":"1"},{"funId":22,"btnStr":"1"},{"funId":23,"btnStr":"1"},{"funId":220,"btnStr":"1"},{"funId":247,"btnStr":"1"},{"funId":25,"btnStr":"1"},{"funId":217,"btnStr":"1"},{"funId":218,"btnStr":"1"},{"funId":26,"btnStr":"1"},{"funId":194,"btnStr":"1"},{"funId":195,"btnStr":"1"},{"funId":31,"btnStr":"1"},{"funId":241,"btnStr":"1,2,7"},{"funId":33,"btnStr":"1,2,7"},{"funId":199,"btnStr":"1,2,7"},{"funId":260,"btnStr":"1,2,7"},{"funId":261,"btnStr":"1,2,7"},{"funId":262,"btnStr":"1,2,7"},{"funId":242,"btnStr":"1,2,7"},{"funId":41,"btnStr":"1,2,7"},{"funId":200,"btnStr":"1,2,7"},{"funId":263,"btnStr":"1,2,7"},{"funId":264,"btnStr":"1,2,7"},{"funId":265,"btnStr":"1,2,7"},{"funId":210,"btnStr":"1,2,7"},{"funId":211,"btnStr":"1,2,7"},{"funId":197,"btnStr":"1,2,7"},{"funId":203,"btnStr":"1,2,7"},{"funId":204,"btnStr":"1,2,7"},{"funId":205,"btnStr":"1,2,7"},{"funId":206,"btnStr":"1,2,7"},{"funId":212,"btnStr":"1,2,7"},{"funId":266,"btnStr":"1,2,7"},{"funId":201,"btnStr":"1,2,7"},{"funId":202,"btnStr":"1,2,7"},{"funId":40,"btnStr":"1,2,7"},{"funId":232,"btnStr":"1,2,7"},{"funId":233,"btnStr":"1,2,7"}]', null, '0');
-- ----------------------------'
-- Records of jsh_tenant
-- ----------------------------
INSERT INTO jsh_tenant VALUES (14, 146, 'csbx', 1000000, '0', true, '2023-08-02 02:20:27', '2099-10-19 02:20:27', null);
-- ----------------------------
-- Records of jsh_sequence
-- ----------------------------
INSERT INTO `jsh_sequence` VALUES ('depot_number_seq', '1', '999999999999999999', '660', '1', '单据编号sequence');
-- ----------------------------
-- Records of jsh_function
-- ----------------------------
INSERT INTO jsh_function VALUES (1, '0001', '系统管理', '0', '/system', '/layouts/TabLayout', true, '0910', true, '电脑版', '', 'setting', '0');
INSERT INTO jsh_function VALUES (13, '000102', '角色管理', '0001', '/system/role', '/system/RoleList', false, '0130', true, '电脑版', '1', 'profile', '0');
INSERT INTO jsh_function VALUES (14, '000103', '用户管理', '0001', '/system/user', '/system/UserList', false, '0140', true, '电脑版', '1', 'profile', '0');
INSERT INTO jsh_function VALUES (15, '000104', '日志管理', '0001', '/system/log', '/system/LogList', false, '0160', true, '电脑版', '', 'profile', '0');
INSERT INTO jsh_function VALUES (16, '000105', '功能管理', '0001', '/system/function', '/system/FunctionList', false, '0166', true, '电脑版', '1', 'profile', '0');
INSERT INTO jsh_function VALUES (18, '000109', '租户管理', '0001', '/system/tenant', '/system/TenantList', false, '0167', true, '电脑版', '1', 'profile', '0');
INSERT INTO jsh_function VALUES (21, '0101', '商品管理', '0', '/material', '/layouts/TabLayout', false, '0620', true, '电脑版', null, 'shopping', '0');
INSERT INTO jsh_function VALUES (22, '010101', '商品类别', '0101', '/material/material_category', '/material/MaterialCategoryList', false, '0230', true, '电脑版', '1', 'profile', '0');
INSERT INTO jsh_function VALUES (23, '010102', '商品信息', '0101', '/material/material', '/material/MaterialList', false, '0240', true, '电脑版', '1', 'profile', '0');
INSERT INTO jsh_function VALUES (24, '0102', '基本资料', '0', '/systemA', '/layouts/TabLayout', false, '0750', true, '电脑版', null, 'appstore', '0');
INSERT INTO jsh_function VALUES (25, '01020101', '供应商信息', '0102', '/system/vendor', '/system/VendorList', false, '0260', true, '电脑版', '1', 'profile', '0');
INSERT INTO jsh_function VALUES (26, '010202', '仓库信息', '0102', '/system/depot', '/system/DepotList', false, '0270', true, '电脑版', '1', 'profile', '0');
INSERT INTO jsh_function VALUES (31, '010206', '经手人管理', '0102', '/system/person', '/system/PersonList', false, '0284', true, '电脑版', '1', 'profile', '0');
INSERT INTO jsh_function VALUES (32, '0502', '采购管理', '0', '/bill', '/layouts/TabLayout', false, '0330', true, '电脑版', '', 'retweet', '0');
INSERT INTO jsh_function VALUES (33, '050201', '自营入库', '0502', '/bill/purchase_in', '/bill/PurchaseInList', false, '0340', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (38, '0603', '销售管理', '0', '/billB', '/layouts/TabLayout', false, '0390', true, '电脑版', '', 'shopping-cart', '0');
INSERT INTO jsh_function VALUES (40, '080107', '调拨出库', '0801', '/bill/allocation_out', '/bill/AllocationOutList', false, '0807', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (41, '060303', '销售自营出库', '0603', '/bill/sale_out', '/bill/SaleOutList', false, '0394', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (44, '0704', '财务管理', '0', '/financial', '/layouts/TabLayout', false, '0450', true, '电脑版', '', 'money-collect', '0');
INSERT INTO jsh_function VALUES (59, '030101', '进销存统计', '0301', '/report/in_out_stock_report', '/report/InOutStockReport', false, '0658', true, '电脑版', '', 'profile', '0');
INSERT INTO jsh_function VALUES (194, '010204', '收支项目', '0102', '/system/in_out_item', '/system/InOutItemList', false, '0282', true, '电脑版', '1', 'profile', '0');
INSERT INTO jsh_function VALUES (195, '010205', '结算账户', '0102', '/system/account', '/system/AccountList', false, '0283', true, '电脑版', '1', 'profile', '0');
INSERT INTO jsh_function VALUES (197, '070402', '收入单', '0704', '/financial/item_in', '/financial/ItemInList', false, '0465', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (198, '0301', '报表查询', '0', '/report', '/layouts/TabLayout', false, '0570', true, '电脑版', null, 'pie-chart', '0');
INSERT INTO jsh_function VALUES (199, '050204', '自营退货', '0502', '/bill/purchase_back', '/bill/PurchaseBackList', false, '0345', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (200, '060305', '销售自营退货', '0603', '/bill/sale_back', '/bill/SaleBackList', false, '0396', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (201, '080103', '其它入库', '0801', '/bill/other_in', '/bill/OtherInList', false, '0803', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (202, '080105', '其它出库', '0801', '/bill/other_out', '/bill/OtherOutList', false, '0805', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (203, '070403', '费用结算', '0704', '/financial/item_out', '/financial/ItemOutList', false, '0470', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (204, '070404', '收款单', '0704', '/financial/money_in', '/financial/MoneyInList', false, '0475', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (205, '070405', '付款单', '0704', '/financial/money_out', '/financial/MoneyOutList', false, '0480', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (206, '070406', '转账单', '0704', '/financial/giro', '/financial/GiroList', false, '0490', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (207, '030102', '账户统计', '0301', '/report/account_report', '/report/AccountReport', false, '0610', true, '电脑版', '', 'profile', '0');
INSERT INTO jsh_function VALUES (208, '030103', '采购统计', '0301', '/report/buy_in_report', '/report/BuyInReport', false, '0620', true, '电脑版', '', 'profile', '0');
INSERT INTO jsh_function VALUES (209, '030104', '销售统计', '0301', '/report/sale_out_report', '/report/SaleOutReport', false, '0630', true, '电脑版', '', 'profile', '0');
INSERT INTO jsh_function VALUES (210, '040102', '零售出库', '0401', '/bill/retail_out', '/bill/RetailOutList', false, '0405', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (211, '040104', '零售退货', '0401', '/bill/retail_back', '/bill/RetailBackList', false, '0407', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (212, '070407', '收预付款', '0704', '/financial/advance_in', '/financial/AdvanceInList', false, '0495', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (217, '01020102', '客户信息', '0102', '/system/customer', '/system/CustomerList', false, '0262', true, '电脑版', '1', 'profile', '0');
INSERT INTO jsh_function VALUES (218, '01020103', '会员信息', '0102', '/system/member', '/system/MemberList', false, '0263', true, '电脑版', '1', 'profile', '0');
INSERT INTO jsh_function VALUES (220, '010103', '计量单位', '0101', '/system/unit', '/system/UnitList', false, '0245', true, '电脑版', '1', 'profile', '0');
INSERT INTO jsh_function VALUES (225, '0401', '零售管理', '0', '/billC', '/layouts/TabLayout', false, '0101', true, '电脑版', '', 'gift', '0');
INSERT INTO jsh_function VALUES (226, '030106', '入库明细', '0301', '/report/in_detail', '/report/InDetail', false, '0640', true, '电脑版', '', 'profile', '0');
INSERT INTO jsh_function VALUES (227, '030107', '出库明细', '0301', '/report/out_detail', '/report/OutDetail', false, '0645', true, '电脑版', '', 'profile', '0');
INSERT INTO jsh_function VALUES (228, '030108', '入库汇总', '0301', '/report/in_material_count', '/report/InMaterialCount', false, '0650', true, '电脑版', '', 'profile', '0');
INSERT INTO jsh_function VALUES (229, '030109', '出库汇总', '0301', '/report/out_material_count', '/report/OutMaterialCount', false, '0655', true, '电脑版', '', 'profile', '0');
INSERT INTO jsh_function VALUES (232, '080109', '组装单', '0801', '/bill/assemble', '/bill/AssembleList', false, '0809', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (233, '080111', '拆卸单', '0801', '/bill/disassemble', '/bill/DisassembleList', false, '0811', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (234, '000105', '系统配置', '0001', '/system/system_config', '/system/SystemConfigList', false, '0165', true, '电脑版', '1', 'profile', '0');
INSERT INTO jsh_function VALUES (235, '030110', '客户对账', '0301', '/report/customer_account', '/report/CustomerAccount', false, '0660', true, '电脑版', '', 'profile', '0');
INSERT INTO jsh_function VALUES (236, '000106', '商品属性', '0001', '/material/material_property', '/material/MaterialPropertyList', false, '0168', true, '电脑版', '1', 'profile', '0');
INSERT INTO jsh_function VALUES (237, '030111', '供应商对账', '0301', '/report/vendor_account', '/report/VendorAccount', false, '0665', true, '电脑版', '', 'profile', '0');
INSERT INTO jsh_function VALUES (239, '0801', '仓库管理', '0', '/billD', '/layouts/TabLayout', false, '0420', true, '电脑版', '', 'hdd', '0');
INSERT INTO jsh_function VALUES (241, '050202', '自营订单', '0502', '/bill/purchase_order', '/bill/PurchaseOrderList', false, '0335', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (242, '060301', '销售自营订单', '0603', '/bill/sale_order', '/bill/SaleOrderList', false, '0392', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (243, '000108', '机构管理', '0001', '/system/organization', '/system/OrganizationList', true, '0150', true, '电脑版', '1', 'profile', '0');
INSERT INTO jsh_function VALUES (244, '030112', '库存预警', '0301', '/report/stock_warning_report', '/report/StockWarningReport', false, '0670', true, '电脑版', '', 'profile', '0');
INSERT INTO jsh_function VALUES (245, '000107', '插件管理', '0001', '/system/plugin', '/system/PluginList', false, '0170', true, '电脑版', '1', 'profile', '0');
INSERT INTO jsh_function VALUES (246, '030113', '商品库存', '0301', '/report/material_stock', '/report/MaterialStock', false, '0605', true, '电脑版', '', 'profile', '0');
INSERT INTO jsh_function VALUES (247, '010105', '多属性', '0101', '/material/material_attribute', '/material/MaterialAttributeList', false, '0250', true, '电脑版', '1', 'profile', '0');
INSERT INTO jsh_function VALUES (248, '030150', '调拨明细', '0301', '/report/allocation_detail', '/report/AllocationDetail', false, '0646', true, '电脑版', '', 'profile', '0');
INSERT INTO jsh_function VALUES (258, '000112', '平台配置', '0001', '/system/platform_config', '/system/PlatformConfigList', false, '0175', true, '电脑版', '', 'profile', '0');
INSERT INTO jsh_function VALUES (259, '030105', '零售统计', '0301', '/report/retail_out_report', '/report/RetailOutReport', false, '0615', true, '电脑版', '', 'profile', '0');
INSERT INTO jsh_function VALUES (260, '050205', '寄存订单', '0502', '/bill/procurement_order_exterior', '/bill/PurchaseOrderList', false, '0350', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (261, '050206', '寄存入库', '0502', '/bill/purchase_in_exterior', '/bill/PurchaseInList', false, '0355', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (262, '050207', '寄存退货', '0502', '/bill/purchase_back_exterior', '/bill/PurchaseBackList', false, '0360', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (263, '060307', '销售寄存订单', '0603', '/bill/sale_order_exterior', '/bill/SaleOrderList', false, '0398', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (264, '060309', '销售寄存出库', '0603', '/bill/sale_out_exterior', '/bill/SaleOutList', false, '0400', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (265, '060311', '销售寄存退货', '0603', '/bill/sale_back_exterior', '/bill/SaleBackList', false, '0402', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (266, '070408', '供应商费用管理', '0704', '/financial/fee_vendor_Settlement', '/financial/VendorFees', false, '0615', true, '电脑版', '1,2,7', 'profile', '0');

-- ----------------------------
-- Records of jsh_platform_config
-- ----------------------------
INSERT INTO `jsh_platform_config` VALUES ('1', 'platform_name', '平台名称', '华夏ERP');
INSERT INTO `jsh_platform_config` VALUES ('2', 'activation_code', '激活码', '');
INSERT INTO `jsh_platform_config` VALUES ('3', 'platform_url', '官方网站', 'http://www.huaxiaerp.com/');
INSERT INTO `jsh_platform_config` VALUES ('4', 'bill_print_flag', '三联打印启用标记', '0');
INSERT INTO `jsh_platform_config` VALUES ('5', 'bill_print_url', '三联打印地址', '');
INSERT INTO `jsh_platform_config` VALUES ('6', 'pay_fee_url', '租户续费地址', '');
INSERT INTO `jsh_platform_config` VALUES ('7', 'register_flag', '注册启用标记', '1');
INSERT INTO `jsh_platform_config` VALUES ('8', 'app_activation_code', '手机端激活码', '');
INSERT INTO `jsh_platform_config` VALUES ('9', 'send_workflow_url', '发起流程地址', '');
-- ----------------------------
-- Records of settlement_method
-- ----------------------------
INSERT INTO `settlement_method` VALUES ('1', '入库结算', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '','146', '0');
INSERT INTO `settlement_method` VALUES ('2', '出库结算', '2019-12-29 12:13:01', '28', '2019-12-29 12:13:01', '28', '', '', '146', '0');
-- ----------------------------
-- Records of second_settlement_method
-- ----------------------------
INSERT INTO `second_settlement_method` VALUES ('1', '1','处置费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '', '146', '0');
INSERT INTO `second_settlement_method` VALUES ('2', '1','装卸费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('3', '1','分拣费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('4', '1','急冻费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('5', '1','加工费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('6', '1','配送费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('7', '1','其他费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('8', '1','服务费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('9', '1','包装费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('10', '1', '场地费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('11', '1', '打磨费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('12', '1', '车马费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('13', '1', '运输费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('14', '1', '物业水费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('15', '1', '物业电费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('16', '1', '叉车费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('17', '1', '降温费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('18', '1', '存储费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('19', '1', '加班费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('20', '1', '过车费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('21', '1', '订单操作费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('22', '1', '复冻费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('23', '1', '出入库费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('24', '2', '处置费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('25', '2', '装卸费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('26', '2', '分拣费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('27', '2', '急冻费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('28', '2', '加工费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('29', '2', '配送费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('30', '2', '其他费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('31', '2', '服务费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('32', '2', '包装费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('33', '2', '场地费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('34', '2', '打磨费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('35', '2', '车马费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('36', '2', '运输费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('37', '2', '物业水费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('38', '2', '物业电费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('39', '2', '叉车费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('40', '2', '降温费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('41', '2', '存储费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('42', '2', '加班费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('43', '2', '过车费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('44', '2', '订单操作费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('45', '2', '复冻费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
INSERT INTO `second_settlement_method` VALUES ('46', '2', '出入库费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '146', '0');
-- ----------------------------
-- Records of measurement
-- ----------------------------
INSERT INTO `measurement` VALUES ('1', '每天', '146', '0');
INSERT INTO `measurement` VALUES ('2', '每月', '146', '0');
-- ----------------------------
-- Records of second_measurement
-- ----------------------------
INSERT INTO `second_measurement` VALUES ('1', '1', '每托', '146', '0');
INSERT INTO `second_measurement` VALUES ('2', '1', '每吨', '146', '0');
INSERT INTO `second_measurement` VALUES ('3', '1', '每平方', '146', '0');
INSERT INTO `second_measurement` VALUES ('4', '2', '每托', '146', '0');
INSERT INTO `second_measurement` VALUES ('5', '2', '每吨', '146', '0');
INSERT INTO `second_measurement` VALUES ('6', '2', '每平方', '146', '0');


