-- ----------------------------
-- Records of jsh_account
-- ----------------------------
INSERT INTO `jsh_account` VALUES ('17', '账户1', 'zzz111', '100.000000', '829.000000', 'aabb', '', null, '', '63', '0');
INSERT INTO `jsh_account` VALUES ('18', '账户2', '1234131324', '200.000000', '-1681.000000', 'bbbb', '', null, '\0', '63', '0');
    -- ----------------------------
-- Records of jsh_in_out_item
-- ----------------------------
INSERT INTO `jsh_in_out_item` VALUES ('21', '快递费', '支出', '', '', null, '63', '0');
INSERT INTO `jsh_in_out_item` VALUES ('22', '房租收入', '收入', '', '', null, '63', '0');
INSERT INTO `jsh_in_out_item` VALUES ('23', '利息收入', '收入', '收入', '', null, '63', '0');

-- ----------------------------
-- Records of jsh_account_head
-- ----------------------------
INSERT INTO `jsh_account_head` VALUES ('118', '收入', '58', '16', '63', '55.000000', null, '55.000000', '17', 'SR00000000643', '2021-06-02 00:24:49', null, null, '1', '0', '63', '0');
INSERT INTO `jsh_account_head` VALUES ('119', '支出', '68', '16', '63', '-66.000000', null, '-66.000000', '17', 'ZC00000000644', '2021-06-02 00:25:01', null, null, '0', '0', '63', '0');
INSERT INTO `jsh_account_head` VALUES ('122', '转账', null, '17', '63', '-11.000000', null, '-11.000000', '17', 'ZZ00000000647', '2021-06-02 00:25:32', null, null, '0', '0', '63', '0');
INSERT INTO `jsh_account_head` VALUES ('124', '收预付款', '60', '17', '63', '80.000000', '0.000000', '80.000000', null, 'SYF00000000649', '2021-07-06 23:43:48', null, null, '0', '0', '63', '0');
INSERT INTO `jsh_account_head` VALUES ('125', '收款', '58', '17', '63', '10.000000', '0.000000', '10.000000', '17', 'SK00000000653', '2021-07-06 23:46:38', null, null, '0', '0', '63', '0');
INSERT INTO `jsh_account_head` VALUES ('126', '付款', '57', '17', '63', '-50.000000', '0.000000', '-50.000000', '17', 'FK00000000654', '2021-07-06 23:47:23', null, null, '0', '0', '63', '0');
-- ----------------------------
-- Records of jsh_account_item
-- ----------------------------
INSERT INTO `jsh_account_item` VALUES ('143', '118', null, '23', null, null, null, '55.000000', '', '63', '0');
INSERT INTO `jsh_account_item` VALUES ('144', '119', null, '21', null, null, null, '66.000000', '', '63', '0');
INSERT INTO `jsh_account_item` VALUES ('147', '122', '17', null, null, null, null, '11.000000', '', '63', '0');
INSERT INTO `jsh_account_item` VALUES ('149', '124', '17', null, null, null, null, '80.000000', '', '63', '0');
INSERT INTO `jsh_account_item` VALUES ('150', '125', null, null, '272', '20.000000', '0.000000', '10.000000', '', '63', '0');
INSERT INTO `jsh_account_item` VALUES ('151', '126', null, null, '271', '60.000000', '0.000000', '-50.000000', '', '63', '0');
-- ----------------------------
-- Records of jsh_depot
-- ----------------------------
INSERT INTO `jsh_depot` VALUES ('14', '仓库1', 'dizhi', '12.000000', '12.000000', '0', '1', '描述', '131', '', '63', '0', '');
INSERT INTO `jsh_depot` VALUES ('15', '仓库2', '地址100', '555.000000', '666.000000', '0', '2', 'dfdf', '131', '', '63', '0', '\0');
INSERT INTO `jsh_depot` VALUES ('17', '仓库3', '123123', '123.000000', '123.000000', '0', '3', '123', '131', '', '63', '0', '\0');
-- ----------------------------
-- Records of jsh_depot_head
-- ----------------------------
INSERT INTO `jsh_depot_head` VALUES ('258', '其它', '采购订单', 'CGDD00000000630', 'CGDD00000000630', '2021-06-02 00:21:54', '2021-06-02 00:21:44', '57', '63', null, null, null, '-110.000000', '现付', null, null, null, null, null, null, null, null, null, null, null, '2', '0', '0', null, '63', '0','0',null,null,null,null,null,null,null,null,null,null);
INSERT INTO `jsh_depot_head` VALUES ('259', '入库', '采购', 'CGRK00000000631', 'CGRK00000000631', '2021-06-02 00:22:23', '2021-06-02 00:22:05', '57', '63', '17', '-110.000000', null, '-110.000000', '现付', null, null, null, null, '', '', '0.000000', '0.000000', '110.000000', '0.000000', null, '0', '0', '0', 'CGDD00000000630', '63', '0','0',null,null,null,null,null,null,null,null,null,null);
INSERT INTO `jsh_depot_head` VALUES ('260', '出库', '采购退货', 'CGTH00000000632', 'CGTH00000000632', '2021-06-02 00:22:35', '2021-06-02 00:22:26', '57', '63', '17', '22.000000', null, '22.000000', '现付', null, null, null, null, null, null, '0.000000', '0.000000', '22.000000', '0.000000', null, '0', '0', '0', null, '63', '0','0',null,null,null,null,null,null,null,null,null,null);
INSERT INTO `jsh_depot_head` VALUES ('261', '其它', '销售订单', 'XSDD00000000633', 'XSDD00000000633', '2021-06-02 00:22:48', '2021-06-02 00:22:39', '58', '63', null, null, null, '44.000000', '现付', null, null, null, '', null, null, null, null, null, null, null, '2', '0', '0', null, '63', '0','0',null,null,null,null,null,null,null,null,null,null);
INSERT INTO `jsh_depot_head` VALUES ('262', '出库', '销售', 'XSCK00000000634', 'XSCK00000000634', '2021-06-02 00:23:03', '2021-06-02 00:22:54', '58', '63', '17', '44.000000', null, '44.000000', '现付', null, null, null, '', '', '', '0.000000', '0.000000', '44.000000', '0.000000', null, '0', '0', '0', 'XSDD00000000633', '63', '0','0',null,null,null,null,null,null,null,null,null,null);
INSERT INTO `jsh_depot_head` VALUES ('263', '入库', '销售退货', 'XSTH00000000635', 'XSTH00000000635', '2021-06-02 00:23:12', '2021-06-02 00:23:05', '71', '63', '17', '-22.000000', null, '-22.000000', '现付', null, null, null, '', '', '', '0.000000', '0.000000', '22.000000', '0.000000', null, '0', '0', '0', null, '63', '0','0',null,null,null,null,null,null,null,null,null,null);
INSERT INTO `jsh_depot_head` VALUES ('264', '出库', '零售', 'LSCK00000000636', 'LSCK00000000636', '2021-06-02 00:23:21', '2021-06-02 00:23:14', '60', '63', '17', '22.000000', null, '22.000000', '现付', null, null, null, null, null, null, null, null, null, null, null, '0', '0', '0', null, '63', '0','0',null,null,null,null,null,null,null,null,null,null);
INSERT INTO `jsh_depot_head` VALUES ('265', '入库', '零售退货', 'LSTH00000000637', 'LSTH00000000637', '2021-06-02 00:23:29', '2021-06-02 00:23:23', '60', '63', '17', '-22.000000', null, '-22.000000', '现付', null, null, null, null, null, null, null, null, null, null, null, '0', '0', '0', null, '63', '0','0',null,null,null,null,null,null,null,null,null,null);
INSERT INTO `jsh_depot_head` VALUES ('266', '入库', '其它', 'QTRK00000000638', 'QTRK00000000638', '2021-06-02 00:23:48', '2021-06-02 00:23:36', '57', '63', null, null, null, '-55.000000', '现付', null, null, null, null, null, null, null, null, null, null, null, '1', '0', '0', null, '63', '0','0',null,null,null,null,null,null,null,null,null,null);
INSERT INTO `jsh_depot_head` VALUES ('267', '出库', '其它', 'QTCK00000000639', 'QTCK00000000639', '2021-06-02 00:23:59', '2021-06-02 00:23:50', '58', '63', null, null, null, '30.000000', '现付', null, null, null, null, null, null, null, null, null, null, null, '0', '0', '0', null, '63', '0','0',null,null,null,null,null,null,null,null,null,null);
INSERT INTO `jsh_depot_head` VALUES ('268', '出库', '调拨', 'DBCK00000000640', 'DBCK00000000640', '2021-06-02 00:24:09', '2021-06-02 00:24:00', null, '63', null, null, null, '11.000000', '现付', null, null, null, null, null, null, null, null, null, null, null, '0', '0', '0', null, '63', '0','0',null,null,null,null,null,null,null,null,null,null);
INSERT INTO `jsh_depot_head` VALUES ('269', '其它', '组装单', 'ZZD00000000641', 'ZZD00000000641', '2021-06-02 00:24:29', '2021-06-02 00:24:11', null, '63', null, null, null, '0.000000', '现付', null, null, null, null, null, null, null, null, null, null, null, '0', '0', '0', null, '63', '0','0',null,null,null,null,null,null,null,null,null,null);
INSERT INTO `jsh_depot_head` VALUES ('270', '其它', '拆卸单', 'CXD00000000642', 'CXD00000000642', '2021-06-02 00:24:45', '2021-06-02 00:24:32', null, '63', null, null, null, '0.000000', '现付', null, null, null, null, null, null, null, null, null, null, null, '0', '0', '0', null, '63', '0','0',null,null,null,null,null,null,null,null,null,null);
INSERT INTO `jsh_depot_head` VALUES ('271', '入库', '采购', 'CGRK00000000651', 'CGRK00000000651', '2021-07-06 23:45:20', '2021-07-06 23:44:45', '57', '63', '17', '-20.000000', null, '-80.000000', '现付', null, null, null, null, '', '', '0.000000', '0.000000', '80.000000', '0.000000', null, '0', '0', '0', null, '63', '0','0',null,null,null,null,null,null,null,null,null,null);
INSERT INTO `jsh_depot_head` VALUES ('272', '出库', '销售', 'XSCK00000000652', 'XSCK00000000652', '2021-07-06 23:46:07', '2021-07-06 23:45:24', '58', '63', '17', '8.000000', null, '28.000000', '现付', null, null, null, '', '', '', '0.000000', '0.000000', '28.000000', '0.000000', null, '0', '0', '0', null, '63', '0','0',null,null,null,null,null,null,null,null,null,null);
INSERT INTO `jsh_depot_head` VALUES ('273', '入库', '采购', 'CGRK00000000658', 'CGRK00000000658', '2021-07-28 00:58:12', '2021-07-28 00:58:02', '57', '63', '17', '-60.000000', null, '-60.000000', '现付', null, null, null, null, '', '', '0.000000', '0.000000', '60.000000', '0.000000', null, '0', '0', '0', null, '63', '0','0',null,null,null,null,null,null,null,null,null,null);
INSERT INTO jsh_depot_head  VALUES (274, '入库', '寄存入库', 'DBCK00000000640', 'DBCK00000000640', '2021-06-02 00:24:09', '2021-06-02 00:24:00', null, 63, null, null, null, 11.000000, '现付', null, null, null, null, null, null, null, null, null, null, null, '0', '0', '0', null, 63, '0','0',null,null,null,null,null,null,null,null,null,null);
INSERT INTO jsh_depot_head  VALUES (275, '入库', '寄存入库', 'ZZD00000000641', 'ZZD00000000641', '2021-06-02 00:24:29', '2021-06-02 00:24:11', null, 63, null, null, null, 0.000000, '现付', null, null, null, null, null, null, null, null, null, null, null, '0', '0', '0', null, 63, '0','0',null,null,null,null,null,null,null,null,null,null);
INSERT INTO jsh_depot_head  VALUES (276, '入库', '寄存入库', 'CXD00000000642', 'CXD00000000642', '2021-06-02 00:24:45', '2021-06-02 00:24:32', null, 63, null, null, null, 0.000000, '现付', null, null, null, null, null, null, null, null, null, null, null, '0', '0', '0', null, 63, '0','0',null,null,null,null,null,null,null,null,null,null);
INSERT INTO jsh_depot_head  VALUES (277, '出库', '寄存出库', 'CGRK00000000651', 'CGRK00000000651', '2021-07-06 23:45:20', '2021-07-06 23:44:45', 57, 63, 17, -20.000000, null, -80.000000, '现付', null, null, null, null, '', '', 0.000000, 0.000000, 80.000000, 0.000000, null, '0', '0', '0', null, 63, '0','0',null,null,null,null,null,null,null,null,null,null);
INSERT INTO jsh_depot_head  VALUES (278, '出库', '寄存出库', 'XSCK00000000652', 'XSCK00000000652', '2021-07-06 23:46:07', '2021-07-06 23:45:24', 58, 63, 17, 8.000000, null, 28.000000, '现付', null, null, null, '', '', '', 0.000000, 0.000000, 28.000000, 0.000000, null, '0', '0', '0', null, 63, '0','0',null,null,null,null,null,null,null,null,null,null);
INSERT INTO jsh_depot_head  VALUES (279, '出库', '寄存出库', 'CGRK00000000658', 'CGRK00000000658', '2021-07-28 00:58:12', '2021-07-28 00:58:02', 57, 63, 17, -60.000000, null, -60.000000, '现付', null, null, null, null, '', '', 0.000000, 0.000000, 60.000000, 0.000000, null, '0', '0', '0', null, 63, '0','0',null,null,null,null,null,null,null,null,null,null);

-- ----------------------------
-- Records of jsh_depot_item
-- ----------------------------
INSERT INTO `jsh_depot_item` VALUES ('312', '258', '588', '10', '个', null, '10.000000', '10.000000', '11.000000', null, null, '110.000000', null, '14', null, null, null, null, null, null, null, null, null, '63', '0',null,null,null,null,null);
INSERT INTO `jsh_depot_item` VALUES ('313', '259', '588', '10', '个', null, '10.000000', '10.000000', '11.000000', null, null, '110.000000', null, '14', null, null, '0.000000', '110.000000', null, null, null, null, null, '63', '0',null,null,null,null,null);
INSERT INTO `jsh_depot_item` VALUES ('314', '260', '588', '10', '个', null, '2.000000', '2.000000', '11.000000', null, '11.000000', '22.000000', null, '14', null, '0.000000', '0.000000', '22.000000', null, null, null, null, null, '63', '0',null,null,null,null,null);
INSERT INTO `jsh_depot_item` VALUES ('315', '261', '588', '10', '个', null, '2.000000', '2.000000', '22.000000', null, null, '44.000000', null, '14', null, null, null, null, null, null, null, null, null, '63', '0',null,null,null,null,null);
INSERT INTO `jsh_depot_item` VALUES ('316', '262', '588', '10', '个', null, '2.000000', '2.000000', '22.000000', null, null, '44.000000', null, '14', null, null, '0.000000', '44.000000', null, null, null, null, null, '63', '0',null,null,null,null,null);
INSERT INTO `jsh_depot_item` VALUES ('317', '263', '588', '10', '个', null, '1.000000', '1.000000', '22.000000', null, '22.000000', '22.000000', null, '14', null, '0.000000', '0.000000', '22.000000', null, null, null, null, null, '63', '0',null,null,null,null,null);
INSERT INTO `jsh_depot_item` VALUES ('318', '264', '588', '10', '个', null, '1.000000', '1.000000', '22.000000', null, null, '22.000000', null, '14', null, null, null, null, null, null, null, null, null, '63', '0',null,null,null,null,null);
INSERT INTO `jsh_depot_item` VALUES ('319', '265', '588', '10', '个', null, '1.000000', '1.000000', '22.000000', null, null, '22.000000', null, '14', null, null, null, null, null, null, null, null, null, '63', '0',null,null,null,null,null);
INSERT INTO `jsh_depot_item` VALUES ('320', '266', '568', '2', '个', null, '5.000000', '5.000000', '11.000000', null, null, '55.000000', null, '14', null, null, null, null, null, null, null, null, null, '63', '0',null,null,null,null,null);
INSERT INTO `jsh_depot_item` VALUES ('321', '267', '568', '2', '个', null, '2.000000', '2.000000', '15.000000', null, null, '30.000000', null, '14', null, null, null, null, null, null, null, null, null, '63', '0',null,null,null,null,null);
INSERT INTO `jsh_depot_item` VALUES ('322', '268', '568', '2', '个', null, '1.000000', '1.000000', '11.000000', null, null, '11.000000', null, '14', '15', null, null, null, null, null, null, null, null, '63', '0',null,null,null,null,null);
INSERT INTO `jsh_depot_item` VALUES ('323', '269', '588', '10', '个', null, '1.000000', '1.000000', '0.000000', null, null, '0.000000', null, '14', null, null, null, null, '组合件', null, null, null, null, '63', '0',null,null,null,null,null);
INSERT INTO `jsh_depot_item` VALUES ('324', '269', '568', '2', '个', null, '1.000000', '1.000000', '0.000000', null, null, '0.000000', null, '14', null, null, null, null, '普通子件', null, null, null, null, '63', '0',null,null,null,null,null);
INSERT INTO `jsh_depot_item` VALUES ('325', '270', '588', '10', '个', null, '1.000000', '1.000000', '0.000000', null, null, '0.000000', null, '14', null, null, null, null, '组合件', null, null, null, null, '63', '0',null,null,null,null,null);
INSERT INTO `jsh_depot_item` VALUES ('326', '270', '568', '2', '个', null, '1.000000', '1.000000', '0.000000', null, null, '0.000000', null, '14', null, null, null, null, '普通子件', null, null, null, null, '63', '0',null,null,null,null,null);
INSERT INTO `jsh_depot_item` VALUES ('327', '271', '570', '4', '个', null, '10.000000', '10.000000', '8.000000', null, '8.000000', '80.000000', null, '14', null, '0.000000', '0.000000', '80.000000', null, null, null, null, null, '63', '0',null,null,null,null,null);
INSERT INTO `jsh_depot_item` VALUES ('328', '272', '570', '4', '个', null, '2.000000', '2.000000', '14.000000', null, '14.000000', '28.000000', null, '14', null, '0.000000', '0.000000', '28.000000', null, null, null, null, null, '63', '0',null,null,null,null,null);
INSERT INTO `jsh_depot_item` VALUES ('330', '273', '619', '37', '件', '橙色,L', '5.000000', '5.000000', '12.000000', null, '12.000000', '60.000000', null, '14', null, '0.000000', '0.000000', '60.000000', null, null, null, null, null, '63', '0',null,null,null,null,null);
INSERT INTO jsh_depot_item VALUES (331, 276, 568, 2, '个', null, 1.000000, 1.000000, 0.000000, null, null, 0.000000, null, 14, null, null, null, null, '普通子件', null, null, null, null, 63, '0', null, null, null, null, null);
INSERT INTO jsh_depot_item VALUES (332, 276, 588, 10, '个', null, 1.000000, 1.000000, 0.000000, null, null, 0.000000, null, 14, null, null, null, null, '组合件', null, null, null, null, 63, '0', null, null, null, null, null);
INSERT INTO jsh_depot_item VALUES (333, 276, 568, 2, '个', null, 1.000000, 1.000000, 0.000000, null, null, 0.000000, null, 14, null, null, null, null, '普通子件', null, null, null, null, 63, '0', null, null, null, null, null);
INSERT INTO jsh_depot_item VALUES (334, 279, 570, 4, '个', null, 10.000000, 10.000000, 8.000000, null, 8.000000, 80.000000, null, 14, null, 0.000000, 0.000000, 80.000000, null, null, null, null, null, 63, '0', null, null, null, null, null);
INSERT INTO jsh_depot_item VALUES (335, 279, 570, 4, '个', null, 2.000000, 2.000000, 14.000000, null, 14.000000, 28.000000, null, 14, null, 0.000000, 0.000000, 28.000000, null, null, null, null, null, 63, '0', null, null, null, null, null);
INSERT INTO jsh_depot_item VALUES (336, 279, 619, 37, '件', '橙色,L', 5.000000, 5.000000, 12.000000, null, 12.000000, 60.000000, null, 14, null, 0.000000, 0.000000, 60.000000, null, null, null, null, null, 63, '0', null, null, null, null, null);
-- ----------------------------
-- Records of jsh_function
-- ----------------------------

INSERT INTO `jsh_function` VALUES ('1', '0001', '系统管理', '0', '/system', '/layouts/TabLayout', '', '0910', '', '电脑版', '', 'setting', '0');
INSERT INTO `jsh_function` VALUES ('13', '000102', '角色管理', '0001', '/system/role', '/system/RoleList', '\0', '0130', '', '电脑版', '1', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('14', '000103', '用户管理', '0001', '/system/user', '/system/UserList', '\0', '0140', '', '电脑版', '1', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('15', '000104', '日志管理', '0001', '/system/log', '/system/LogList', '\0', '0160', '', '电脑版', '', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('16', '000105', '功能管理', '0001', '/system/function', '/system/FunctionList', '\0', '0166', '', '电脑版', '1', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('18', '000109', '租户管理', '0001', '/system/tenant', '/system/TenantList', '\0', '0167', '', '电脑版', '1', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('21', '0101', '商品管理', '0', '/material', '/layouts/TabLayout', '\0', '0620', '', '电脑版', null, 'shopping', '0');
INSERT INTO `jsh_function` VALUES ('22', '010101', '商品类别', '0101', '/material/material_category', '/material/MaterialCategoryList', '\0', '0230', '', '电脑版', '1', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('23', '010102', '商品信息', '0101', '/material/material', '/material/MaterialList', '\0', '0240', '', '电脑版', '1', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('24', '0102', '基本资料', '0', '/systemA', '/layouts/TabLayout', '\0', '0750', '', '电脑版', null, 'appstore', '0');
INSERT INTO `jsh_function` VALUES ('25', '01020101', '供应商信息', '0102', '/system/vendor', '/system/VendorList', '\0', '0260', '', '电脑版', '1', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('26', '010202', '仓库信息', '0102', '/system/depot', '/system/DepotList', '\0', '0270', '', '电脑版', '1', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('31', '010206', '经手人管理', '0102', '/system/person', '/system/PersonList', '\0', '0284', '', '电脑版', '1', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('32', '0502', '采购管理', '0', '/bill', '/layouts/TabLayout', '\0', '0330', '', '电脑版', '', 'retweet', '0');
INSERT INTO `jsh_function` VALUES ('33', '050201', '自营入库', '0502', '/bill/purchase_in', '/bill/PurchaseInList', '\0', '0340', '', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('38', '0603', '销售管理', '0', '/billB', '/layouts/TabLayout', '\0', '0390', '', '电脑版', '', 'shopping-cart', '0');
INSERT INTO `jsh_function` VALUES ('40', '080107', '调拨出库', '0801', '/bill/allocation_out', '/bill/AllocationOutList', '\0', '0807', '', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('41', '060303', '销售自营出库', '0603', '/bill/sale_out', '/bill/SaleOutList', '\0', '0394', '', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('44', '0704', '财务管理', '0', '/financial', '/layouts/TabLayout', '\0', '0450', '', '电脑版', '', 'money-collect', '0');
INSERT INTO `jsh_function` VALUES ('59', '030101', '进销存统计', '0301', '/report/in_out_stock_report', '/report/InOutStockReport', '\0', '0658', '', '电脑版', '', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('194', '010204', '收支项目', '0102', '/system/in_out_item', '/system/InOutItemList', '\0', '0282', '', '电脑版', '1', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('195', '010205', '结算账户', '0102', '/system/account', '/system/AccountList', '\0', '0283', '', '电脑版', '1', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('197', '070402', '收入单', '0704', '/financial/item_in', '/financial/ItemInList', '\0', '0465', '', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('198', '0301', '报表查询', '0', '/report', '/layouts/TabLayout', '\0', '0570', '', '电脑版', null, 'pie-chart', '0');
INSERT INTO `jsh_function` VALUES ('199', '050204', '自营退货', '0502', '/bill/purchase_back', '/bill/PurchaseBackList', '\0', '0345', '', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('200', '060305', '销售自营退货', '0603', '/bill/sale_back', '/bill/SaleBackList', '\0', '0396', '', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('201', '080103', '其它入库', '0801', '/bill/other_in', '/bill/OtherInList', '\0', '0803', '', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('202', '080105', '其它出库', '0801', '/bill/other_out', '/bill/OtherOutList', '\0', '0805', '', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('203', '070403', '支出单', '0704', '/financial/item_out', '/financial/ItemOutList', '\0', '0470', '', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('204', '070404', '收款单', '0704', '/financial/money_in', '/financial/MoneyInList', '\0', '0475', '', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('205', '070405', '付款单', '0704', '/financial/money_out', '/financial/MoneyOutList', '\0', '0480', '', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('206', '070406', '转账单', '0704', '/financial/giro', '/financial/GiroList', '\0', '0490', '', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('207', '030102', '账户统计', '0301', '/report/account_report', '/report/AccountReport', '\0', '0610', '', '电脑版', '', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('208', '030103', '采购统计', '0301', '/report/buy_in_report', '/report/BuyInReport', '\0', '0620', '', '电脑版', '', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('209', '030104', '销售统计', '0301', '/report/sale_out_report', '/report/SaleOutReport', '\0', '0630', '', '电脑版', '', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('210', '040102', '零售出库', '0401', '/bill/retail_out', '/bill/RetailOutList', '\0', '0405', '', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('211', '040104', '零售退货', '0401', '/bill/retail_back', '/bill/RetailBackList', '\0', '0407', '', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('212', '070407', '收预付款', '0704', '/financial/advance_in', '/financial/AdvanceInList', '\0', '0495', '', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('217', '01020102', '客户信息', '0102', '/system/customer', '/system/CustomerList', '\0', '0262', '', '电脑版', '1', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('218', '01020103', '会员信息', '0102', '/system/member', '/system/MemberList', '\0', '0263', '', '电脑版', '1', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('220', '010103', '计量单位', '0101', '/system/unit', '/system/UnitList', '\0', '0245', '', '电脑版', '1', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('225', '0401', '零售管理', '0', '/billC', '/layouts/TabLayout', '\0', '0101', '', '电脑版', '', 'gift', '0');
INSERT INTO `jsh_function` VALUES ('226', '030106', '入库明细', '0301', '/report/in_detail', '/report/InDetail', '\0', '0640', '', '电脑版', '', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('227', '030107', '出库明细', '0301', '/report/out_detail', '/report/OutDetail', '\0', '0645', '', '电脑版', '', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('228', '030108', '入库汇总', '0301', '/report/in_material_count', '/report/InMaterialCount', '\0', '0650', '', '电脑版', '', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('229', '030109', '出库汇总', '0301', '/report/out_material_count', '/report/OutMaterialCount', '\0', '0655', '', '电脑版', '', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('232', '080109', '组装单', '0801', '/bill/assemble', '/bill/AssembleList', '\0', '0809', '', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('233', '080111', '拆卸单', '0801', '/bill/disassemble', '/bill/DisassembleList', '\0', '0811', '', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('234', '000105', '系统配置', '0001', '/system/system_config', '/system/SystemConfigList', '\0', '0165', '', '电脑版', '1', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('235', '030110', '客户对账', '0301', '/report/customer_account', '/report/CustomerAccount', '\0', '0660', '', '电脑版', '', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('236', '000106', '商品属性', '0001', '/material/material_property', '/material/MaterialPropertyList', '\0', '0168', '', '电脑版', '1', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('237', '030111', '供应商对账', '0301', '/report/vendor_account', '/report/VendorAccount', '\0', '0665', '', '电脑版', '', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('239', '0801', '仓库管理', '0', '/billD', '/layouts/TabLayout', '\0', '0420', '', '电脑版', '', 'hdd', '0');
INSERT INTO `jsh_function` VALUES ('241', '050202', '自营订单', '0502', '/bill/purchase_order', '/bill/PurchaseOrderList', '\0', '0335', '', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('242', '060301', '销售自营订单', '0603', '/bill/sale_order', '/bill/SaleOrderList', '\0', '0392', '', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('243', '000108', '机构管理', '0001', '/system/organization', '/system/OrganizationList', '', '0150', '', '电脑版', '1', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('244', '030112', '库存预警', '0301', '/report/stock_warning_report', '/report/StockWarningReport', '\0', '0670', '', '电脑版', '', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('245', '000107', '插件管理', '0001', '/system/plugin', '/system/PluginList', '\0', '0170', '', '电脑版', '1', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('246', '030113', '商品库存', '0301', '/report/material_stock', '/report/MaterialStock', '\0', '0605', '', '电脑版', '', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('247', '010105', '多属性', '0101', '/material/material_attribute', '/material/MaterialAttributeList', '\0', '0250', '', '电脑版', '1', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('248', '030150', '调拨明细', '0301', '/report/allocation_detail', '/report/AllocationDetail', '\0', '0646', '', '电脑版', '', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('258', '000112', '平台配置', '0001', '/system/platform_config', '/system/PlatformConfigList', '\0', '0175', '', '电脑版', '', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('259', '030105', '零售统计', '0301', '/report/retail_out_report', '/report/RetailOutReport', '\0', '0615', '', '电脑版', '', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('260', '050205', '寄存订单', '0502', '/bill/procurement_order_exterior', '/bill/ProcurementOrderExterior', '\0', '0350', '', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('261', '050206', '寄存入库', '0502', '/bill/purchase_in_exterior', '/bill/ProcurementOrderExteriorList', '\0', '0355', '', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('262', '050207', '寄存退货', '0502', '/bill/purchase_back_exterior', '/bill/ProcurementBackList', '\0', '0360', '', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('263', '060307', '销售寄存订单', '0603', '/bill/sale_order_exterior', '/bill/SaleOrderListExterior', '\0', '0398', '', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('264', '060309', '销售寄存出库', '0603', '/bill/sale_out_exterior', '/bill/SaleOutListExterior', '\0', '0400', '', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('265', '060311', '销售寄存退货', '0603', '/bill/sale_back_exterior', '/bill/SaleBackListExterior', '\0', '0402', '', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `jsh_function` VALUES ('266', '070408', '供应商费用管理', '0704', '/financial/payment_records', '/financial/PaymentRecords', '\0', '0615', '', '电脑版', '1,2,7', 'profile', '0');

# INSERT INTO `jsh_function` VALUES ('33', '050201', '采购入库', '0502', '/bill/purchase_in', '/bill/PurchaseInList', '\0', '0340', '', '电脑版', '1,2,7', 'profile', '0');

-- ----------------------------
-- Records of jsh_material
-- ----------------------------
INSERT INTO `jsh_material` VALUES ('568', '17', '商品1', '制1', 'sp1', '', '', '个', '', null, null, null, null, '', '', '', '', '0', '0', '63', '0', '68', '2');
INSERT INTO `jsh_material` VALUES ('569', '17', '商品2', '', 'sp2', '', '', '只', '', null, null, null, null, '', '', '', '', '0', '0', '63', '0', '68', '2');
INSERT INTO `jsh_material` VALUES ('570', '17', '商品3', '', 'sp3', '', '', '个', '', null, null, null, null, '', '', '', '', '0', '0', '63', '0', '68', '2');
INSERT INTO `jsh_material` VALUES ('577', null, '商品8', '', 'sp8', '', '', '', '', null, '15', null, null, '', '', '', '', '0', '0', '63', '0', '68', '2');
INSERT INTO `jsh_material` VALUES ('579', '21', '商品17', '', 'sp17', '', '', '', '', null, '15', null, null, '', '', '', '', '0', '0', '63', '0', '68', '2');
INSERT INTO `jsh_material` VALUES ('586', '17', '序列号商品测试', '', 'xlh123', '', '', '个', '', null, null, null, null, '', '', '', '', '1', '0', '63', '0', '68', '2');
INSERT INTO `jsh_material` VALUES ('587', '17', '商品test1', '南通中远', '', 'test1', '', '个', '', null, null, null, null, '', '', '', '', '0', '0', '63', '0', '68', '2');
INSERT INTO `jsh_material` VALUES ('588', '21', '商品200', 'fafda', 'weqwe', '300ml', '红色', '个', 'aaaabbbbb', null, null, null, null, '', '', '', '', '0', '0', '63', '0', '68', '2');
INSERT INTO `jsh_material` VALUES ('619', null, '衣服', null, null, null, null, '件', null, '', null, null, null, '', null, null, null, '0', '0', '63', '0', '68', '2');
-- ----------------------------
-- Records of jsh_material_attribute
-- ----------------------------
INSERT INTO `jsh_material_attribute` VALUES ('1', '多颜色', '红色|橙色|黄色|绿色|蓝色|紫色', '63', '0');
INSERT INTO `jsh_material_attribute` VALUES ('2', '多尺寸', 'S|M|L|XL|XXL|XXXL', '63', '0');
INSERT INTO `jsh_material_attribute` VALUES ('3', '自定义1', '小米|华为', '63', '0');
INSERT INTO `jsh_material_attribute` VALUES ('4', '自定义2', null, '63', '0');
INSERT INTO `jsh_material_attribute` VALUES ('5', '自定义3', null, '63', '0');
INSERT INTO `jsh_material_attribute` VALUES ('6', '设置属性', '外购|销售|内部生产|劳务', '63', '0');
-- ----------------------------
-- Records of jsh_material_category
-- ----------------------------
INSERT INTO `jsh_material_category` VALUES ('17', '目录1', null, null, '11', 'wae12', 'eee', '2019-04-10 22:18:12', '2021-02-17 15:11:35', '63', '0');
INSERT INTO `jsh_material_category` VALUES ('21', '目录2', null, '17', '22', 'ada112', 'ddd', '2020-07-20 23:08:44', '2020-07-20 23:08:44', '63', '0');
-- ----------------------------
-- Records of jsh_material_current_stock
-- ----------------------------
INSERT INTO `jsh_material_current_stock` VALUES ('19', '588', '14', '7.000000', '63', '0');
INSERT INTO `jsh_material_current_stock` VALUES ('20', '568', '14', '2.000000', '63', '0');
INSERT INTO `jsh_material_current_stock` VALUES ('21', '568', '15', '1.000000', '63', '0');
INSERT INTO `jsh_material_current_stock` VALUES ('22', '570', '14', '8.000000', '63', '0');
INSERT INTO `jsh_material_current_stock` VALUES ('23', '619', '14', '5.000000', '63', '0');
INSERT INTO `jsh_material_current_stock` VALUES ('24', '619', '15', '0.000000', '63', '0');
INSERT INTO `jsh_material_current_stock` VALUES ('25', '619', '17', '0.000000', '63', '0');
-- ----------------------------
-- Records of jsh_material_extend
-- ----------------------------
INSERT INTO `jsh_material_extend` VALUES ('1', '587', '1000', '个', null, '11.000000', '22.000000', '22.000000', '22.000000', '1', '2020-02-20 23:22:03', 'jsh', 'jsh', '1595263657135', '63', '0');
INSERT INTO `jsh_material_extend` VALUES ('2', '568', '1001', '个', null, '11.000000', '15.000000', '15.000000', '15.000000', '1', '2020-02-20 23:44:57', 'jsh', 'jsh', '1595265439418', '63', '0');
INSERT INTO `jsh_material_extend` VALUES ('3', '569', '1002', '只', null, '10.000000', '15.000000', '15.000000', '13.000000', '1', '2020-02-20 23:45:15', 'jsh', 'jsh', '1582213514731', '63', '0');
INSERT INTO `jsh_material_extend` VALUES ('4', '570', '1003', '个', null, '8.000000', '15.000000', '14.000000', '13.000000', '1', '2020-02-20 23:45:37', 'jsh', 'jsh', '1587657604430', '63', '0');
INSERT INTO `jsh_material_extend` VALUES ('5', '577', '1004', '个', null, '10.000000', '20.000000', '20.000000', '20.000000', '1', '2020-02-20 23:46:36', 'jsh', 'jsh', '1582213596494', '63', '0');
INSERT INTO `jsh_material_extend` VALUES ('6', '577', '1005', '箱', null, '120.000000', '240.000000', '240.000000', '240.000000', '0', '2020-02-20 23:46:36', 'jsh', 'jsh', '1582213596497', '63', '0');
INSERT INTO `jsh_material_extend` VALUES ('7', '579', '1006', '个', null, '20.000000', '30.000000', '30.000000', '30.000000', '1', '2020-02-20 23:47:04', 'jsh', 'jsh', '1595264270458', '63', '0');
INSERT INTO `jsh_material_extend` VALUES ('8', '579', '1007', '箱', null, '240.000000', '360.000000', '360.000000', '360.000000', '0', '2020-02-20 23:47:04', 'jsh', 'jsh', '1595264270466', '63', '0');
INSERT INTO `jsh_material_extend` VALUES ('9', '586', '1008', '个', null, '12.000000', '15.000000', '15.000000', '15.000000', '1', '2020-02-20 23:47:23', 'jsh', 'jsh', '1595254981896', '63', '0');
INSERT INTO `jsh_material_extend` VALUES ('10', '588', '1009', '个', null, '11.000000', '22.000000', '22.000000', '22.000000', '1', '2020-07-21 00:58:15', 'jsh', 'jsh', '1614699799073', '63', '0');
INSERT INTO `jsh_material_extend` VALUES ('36', '619', '1014', '件', '橙色,M', '12.000000', '15.000000', '14.000000', null, '1', '2021-07-28 01:00:20', 'jsh', 'jsh', '1627405220316', '63', '0');
INSERT INTO `jsh_material_extend` VALUES ('37', '619', '1015', '件', '橙色,L', '12.000000', '15.000000', '14.000000', null, '0', '2021-07-28 01:00:20', 'jsh', 'jsh', '1627405220327', '63', '0');
INSERT INTO `jsh_material_extend` VALUES ('38', '619', '1016', '件', '绿色,M', '12.000000', '15.000000', '14.000000', null, '0', '2021-07-28 01:00:20', 'jsh', 'jsh', '1627405220336', '63', '0');
INSERT INTO `jsh_material_extend` VALUES ('39', '619', '1017', '件', '绿色,L', '12.000000', '15.000000', '14.000000', null, '0', '2021-07-28 01:00:20', 'jsh', 'jsh', '1627405220346', '63', '0');
-- ----------------------------
-- Records of jsh_material_property
-- ----------------------------
INSERT INTO `jsh_material_property` VALUES ('1', '制造商', '', '01', '制造商', '0');
INSERT INTO `jsh_material_property` VALUES ('2', '自定义1', '', '02', '自定义1', '0');
INSERT INTO `jsh_material_property` VALUES ('3', '自定义2', '', '03', '自定义2', '0');
INSERT INTO `jsh_material_property` VALUES ('4', '自定义3', '', '04', '自定义3', '0');
-- ----------------------------
-- Records of jsh_msg
-- ----------------------------
INSERT INTO `jsh_msg` VALUES ('2', '标题1', '内容1', '2019-09-10 00:11:39', '类型1', '63', '2', '63', '0');
-- ----------------------------
-- Records of jsh_organization
-- ----------------------------
INSERT INTO `jsh_organization` VALUES ('12', '001', '测试机构', null, '2', 'aaaa2', '2019-12-28 12:13:01', '2019-12-28 12:13:01', '63', '0');
INSERT INTO `jsh_organization` VALUES ('13', 'jg1', '机构1', '12', '3', '', '2020-07-21 00:09:57', '2020-07-21 00:10:22', '63', '0');
INSERT INTO `jsh_organization` VALUES ('14', '12', '机构2', '13', '4', '', '2020-07-21 22:45:42', '2021-02-15 22:18:30', '63', '0');
-- ----------------------------
-- Records of jsh_orga_user_rel
-- ----------------------------
INSERT INTO `jsh_orga_user_rel` VALUES ('10', '13', '131', '2', '0', '2019-12-28 12:13:15', '63', '2021-03-18 22:33:19', '63', '63');
INSERT INTO `jsh_orga_user_rel` VALUES ('11', '12', '63', '15', '0', '2020-09-13 18:42:45', '63', '2021-03-19 00:11:40', '63', '63');
INSERT INTO `jsh_orga_user_rel` VALUES ('12', '13', '135', '9', '0', '2021-03-18 22:24:25', '63', '2021-03-19 00:09:23', '63', '63');
INSERT INTO `jsh_orga_user_rel` VALUES ('13', '13', '134', '1', '0', '2021-03-18 22:31:39', '63', '2021-03-18 23:59:55', '63', '63');
INSERT INTO `jsh_orga_user_rel` VALUES ('14', '22', '133', '22', '0', '2021-03-18 22:31:44', '63', '2021-03-18 22:32:04', '63', '63');
INSERT INTO `jsh_orga_user_rel` VALUES ('15', '12', '144', null, '0', '2021-03-19 00:00:40', '63', '2021-03-19 00:08:07', '63', '63');
INSERT INTO `jsh_orga_user_rel` VALUES ('16', '12', '145', null, '0', '2021-03-19 00:03:44', '63', '2021-03-19 00:03:44', '63', '63');
-- ----------------------------
-- Records of jsh_person
-- ----------------------------
INSERT INTO `jsh_person` VALUES ('14', '业务员', '小李', '', null, '63', '0');
INSERT INTO `jsh_person` VALUES ('15', '仓管员', '小军', '', null, '63', '0');
INSERT INTO `jsh_person` VALUES ('16', '财务员', '小夏', '', null, '63', '0');
INSERT INTO `jsh_person` VALUES ('17', '财务员', '小曹', '', null, '63', '0');
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
-- Records of jsh_role
-- ----------------------------
INSERT INTO `jsh_role` VALUES ('4', '管理员', '全部数据', null, null, null, '', null, null, '0');
INSERT INTO `jsh_role` VALUES ('10', '租户', '全部数据', null, null, '', '', null, null, '0');
INSERT INTO `jsh_role` VALUES ('16', '销售经理', '全部数据', null, null, 'ddd', '', null, '63', '0');
INSERT INTO `jsh_role` VALUES ('17', '销售代表', '个人数据', null, null, 'rrr', '', null, '63', '0');
-- ----------------------------
-- Records of jsh_sequence
-- ----------------------------
INSERT INTO `jsh_sequence` VALUES ('depot_number_seq', '1', '999999999999999999', '660', '1', '单据编号sequence');
-- ----------------------------
-- Records of jsh_serial_number
-- ----------------------------
INSERT INTO `jsh_serial_number` VALUES ('105', '586', '14', '12312323423223', '0', 'abab', '0', '2019-12-28 12:14:39', '63', '2020-07-21 00:30:32', '63', null, null, '63');
INSERT INTO `jsh_serial_number` VALUES ('108', '586', '14', '3215952626621201', '0', '', '0', '2020-07-21 00:31:02', '63', '2020-07-21 00:31:02', '63', null, null, '63');
INSERT INTO `jsh_serial_number` VALUES ('109', '586', '14', '3215952626621202', '0', '', '0', '2020-07-21 00:31:02', '63', '2020-07-21 00:31:02', '63', null, null, '63');
-- ----------------------------
-- Records of jsh_supplier
-- ----------------------------
INSERT INTO `jsh_supplier` VALUES ('57', '供应商1', '小军', '12345678', '', '', null, '供应商', '', '0.000000', '0.000000', '0.000000', '0.000000', '4.000000', '', '15000000000', '地址1', '', '', '', '12.000000', null, '63', '0','','','','','',null,null,0,'');
INSERT INTO `jsh_supplier` VALUES ('58', '客户1', '小李', '12345678', '', '', null, '客户', '', '0.000000', '0.000000', '0.000000', '-100.000000', null, '', '', '', '', '', '', '12.000000', null, '63', '0','','','','','',null,null,0,'');
INSERT INTO `jsh_supplier` VALUES ('59', '客户2', '小陈', '', '', '', null, '客户', '', '0.000000', '0.000000', '0.000000', '0.000000', null, '', '', '', '', '', '', null, null, '63', '0','','','','','',null,null,0,'');
INSERT INTO `jsh_supplier` VALUES ('60', '12312666', '小曹', '', '', '', null, '会员', '', '970.000000', '0.000000', '0.000000', null, null, '', '13000000000', '', '', '', '', null, null, '63', '0','','','','','',null,null,0,'');
INSERT INTO `jsh_supplier` VALUES ('68', '供应商3', '晓丽', '12345678', '', 'fasdfadf', null, '供应商', '', '0.000000', '0.000000', '0.000000', '0.000000', '-35.000000', '', '13000000000', 'aaaa', '1341324', '', '', '13.000000', null, '63', '0','','','','','',null,null,0,'');
INSERT INTO `jsh_supplier` VALUES ('71', '客户3', '小周', '', '', '', null, '客户', '', '0.000000', '0.000000', '0.000000', '0.000000', null, '', '', '', '', '', '', null, null, '63', '0','','','','','',null,null,0,'');
INSERT INTO `jsh_supplier` VALUES ('74', '供应商5', '小季', '77779999', '', '', null, '供应商', '', '0.000000', '0.000000', '5.000000', '0.000000', '5.000000', '', '15806283912', '', '', '', '', '3.000000', null, '63', '0','','','','','',null,null,0,'');
-- ----------------------------
-- Records of jsh_system_config
-- ----------------------------
INSERT INTO `jsh_system_config` VALUES ('11', '公司test', '小李', '地址1', '12345678', null, null, '注：本单为我公司与客户约定账期内结款的依据，由客户或其单位员工签字生效，并承担法律责任。', '0', '0', '1', '0', '0', '', '0', '1', '63', '0');
-- ----------------------------
-- Records of jsh_tenant
-- ----------------------------
INSERT INTO `jsh_tenant` VALUES ('13', '63', 'jsh', '2000', '1', '', '2021-02-17 23:19:17', '2099-02-17 23:19:17', null);
-- ----------------------------
-- Records of jsh_unit
-- ----------------------------
INSERT INTO `jsh_unit` VALUES ('15', '个/(箱=12个)', '个', '箱', null, null, '12.000', null, null, '', '63', '0');
INSERT INTO `jsh_unit` VALUES ('19', '个/(盒=15个)', '个', '盒', null, null, '15.000', null, null, '', '63', '0');
INSERT INTO `jsh_unit` VALUES ('20', '盒/(箱=8盒)', '盒', '箱', null, null, '8.000', null, null, '', '63', '0');
INSERT INTO `jsh_unit` VALUES ('21', '瓶/(箱=12瓶)', '瓶', '箱', null, null, '12.000', null, null, '', '63', '0');
-- ----------------------------
-- Records of jsh_user
-- ----------------------------
INSERT INTO `jsh_user` VALUES ('63', '测试用户', 'jsh', 'e10adc3949ba59abbe56e057f20f883e', '0', '主管', null, '666666@qq.com', '1123123123132', '1', '1', '0', '', null, '63');
INSERT INTO `jsh_user` VALUES ('120', '管理员', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '0', null, null, null, null, '1', '0', '0', null, null, '0');
INSERT INTO `jsh_user` VALUES ('131', 'test123', 'test123', 'e10adc3949ba59abbe56e057f20f883e', '0', '总监', null, '7777777@qq.com', '', '1', '0', '0', '', null, '63');
-- ----------------------------
-- Records of jsh_user_business
-- ----------------------------

INSERT INTO `jsh_user_business` VALUES ('5', 'RoleFunctions', '4', '[210][225][211][241][32][33][199][242][38][41][200][201][239][202][40][232][233][197][44][203][204][205][206][212][246][207][208][209][226][227][228][229][59][235][237][244][22][21][23][220][240][247][25][24][217][218][26][194][195][31][13][1][14][243][15][234][16][18][236][245][248][198][258][259]', '[{\"funId\":13,\"btnStr\":\"1\"},{\"funId\":14,\"btnStr\":\"1\"},{\"funId\":243,\"btnStr\":\"1\"},{\"funId\":234,\"btnStr\":\"1\"},{\"funId\":16,\"btnStr\":\"1\"},{\"funId\":18,\"btnStr\":\"1\"},{\"funId\":236,\"btnStr\":\"1\"},{\"funId\":245,\"btnStr\":\"1\"},{\"funId\":22,\"btnStr\":\"1\"},{\"funId\":23,\"btnStr\":\"1\"},{\"funId\":220,\"btnStr\":\"1\"},{\"funId\":240,\"btnStr\":\"1\"},{\"funId\":247,\"btnStr\":\"1\"},{\"funId\":25,\"btnStr\":\"1\"},{\"funId\":217,\"btnStr\":\"1\"},{\"funId\":218,\"btnStr\":\"1\"},{\"funId\":26,\"btnStr\":\"1\"},{\"funId\":194,\"btnStr\":\"1\"},{\"funId\":195,\"btnStr\":\"1\"},{\"funId\":31,\"btnStr\":\"1\"},{\"funId\":241,\"btnStr\":\"1,2,7\"},{\"funId\":33,\"btnStr\":\"1,2,7\"},{\"funId\":199,\"btnStr\":\"1,2,7\"},{\"funId\":242,\"btnStr\":\"1,2,7\"},{\"funId\":41,\"btnStr\":\"1,2,7\"},{\"funId\":200,\"btnStr\":\"1,2,7\"},{\"funId\":210,\"btnStr\":\"1,2,7\"},{\"funId\":211,\"btnStr\":\"1,2,7\"},{\"funId\":197,\"btnStr\":\"1,7,2\"},{\"funId\":203,\"btnStr\":\"1,7,2\"},{\"funId\":204,\"btnStr\":\"1,7,2\"},{\"funId\":205,\"btnStr\":\"1,7,2\"},{\"funId\":206,\"btnStr\":\"1,2,7\"},{\"funId\":212,\"btnStr\":\"1,7,2\"},{\"funId\":201,\"btnStr\":\"1,2,7\"},{\"funId\":202,\"btnStr\":\"1,2,7\"},{\"funId\":40,\"btnStr\":\"1,2,7\"},{\"funId\":232,\"btnStr\":\"1,2,7\"},{\"funId\":233,\"btnStr\":\"1,2,7\"}]', null, '0');
INSERT INTO `jsh_user_business` VALUES ('6', 'RoleFunctions', '5', '[22][23][25][26][194][195][31][33][200][201][41][199][202]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('7', 'RoleFunctions', '6', '[22][23][220][240][25][217][218][26][194][195][31][59][207][208][209][226][227][228][229][235][237][210][211][241][33][199][242][41][200][201][202][40][232][233][197][203][204][205][206][212]', '[{\"funId\":\"33\",\"btnStr\":\"4\"}]', null, '0');
INSERT INTO `jsh_user_business` VALUES ('9', 'RoleFunctions', '7', '[168][13][12][16][14][15][189][18][19][132]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('10', 'RoleFunctions', '8', '[168][13][12][16][14][15][189][18][19][132][22][23][25][26][27][157][158][155][156][125][31][127][126][128][33][34][35][36][37][39][40][41][42][43][46][47][48][49][50][51][52][53][54][55][56][57][192][59][60][61][62][63][65][66][68][69][70][71][73][74][76][77][79][191][81][82][83][85][89][161][86][176][165][160][28][134][91][92][29][94][95][97][104][99][100][101][102][105][107][108][110][111][113][114][116][117][118][120][121][131][135][123][122][20][130][146][147][138][148][149][153][140][145][184][152][143][170][171][169][166][167][163][164][172][173][179][178][181][182][183][186][187][247]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('11', 'RoleFunctions', '9', '[168][13][12][16][14][15][189][18][19][132][22][23][25][26][27][157][158][155][156][125][31][127][126][128][33][34][35][36][37][39][40][41][42][43][46][47][48][49][50][51][52][53][54][55][56][57][192][59][60][61][62][63][65][66][68][69][70][71][73][74][76][77][79][191][81][82][83][85][89][161][86][176][165][160][28][134][91][92][29][94][95][97][104][99][100][101][102][105][107][108][110][111][113][114][116][117][118][120][121][131][135][123][122][20][130][146][147][138][148][149][153][140][145][184][152][143][170][171][169][166][167][163][164][172][173][179][178][181][182][183][186][187][188]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('12', 'UserRole', '1', '[5]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('13', 'UserRole', '2', '[6][7]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('14', 'UserDepot', '2', '[1][2][6][7]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('15', 'UserDepot', '1', '[1][2][5][6][7][10][12][14][15][17]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('16', 'UserRole', '63', '[10]', null, '63', '0');
INSERT INTO `jsh_user_business` VALUES ('18', 'UserDepot', '63', '[14][15]', null, '63', '0');
INSERT INTO `jsh_user_business` VALUES ('19', 'UserDepot', '5', '[6][45][46][50]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('20', 'UserRole', '5', '[5]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('21', 'UserRole', '64', '[13]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('22', 'UserDepot', '64', '[1]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('23', 'UserRole', '65', '[5]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('24', 'UserDepot', '65', '[1]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('25', 'UserCustomer', '64', '[5][2]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('26', 'UserCustomer', '65', '[6]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('27', 'UserCustomer', '63', '[58]', null, '63', '0');
INSERT INTO `jsh_user_business` VALUES ('28', 'UserDepot', '96', '[7]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('29', 'UserRole', '96', '[6]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('30', 'UserRole', '113', '[10]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('32', 'RoleFunctions', '10', '[210][225][211][241][32][33][199][242][38][41][200][201][239][202][40][232][233][197][44][203][204][205][206][212][246][207][208][209][226][227][228][229][59][235][237][244][22][21][23][220][240][247][25][24][217][218][26][194][195][31][13][14][243][15][234][248][198][259]', '[{\"funId\":13,\"btnStr\":\"1\"},{\"funId\":14,\"btnStr\":\"1\"},{\"funId\":243,\"btnStr\":\"1\"},{\"funId\":234,\"btnStr\":\"1\"},{\"funId\":22,\"btnStr\":\"1\"},{\"funId\":23,\"btnStr\":\"1\"},{\"funId\":220,\"btnStr\":\"1\"},{\"funId\":240,\"btnStr\":\"1\"},{\"funId\":247,\"btnStr\":\"1\"},{\"funId\":25,\"btnStr\":\"1\"},{\"funId\":217,\"btnStr\":\"1\"},{\"funId\":218,\"btnStr\":\"1\"},{\"funId\":26,\"btnStr\":\"1\"},{\"funId\":194,\"btnStr\":\"1\"},{\"funId\":195,\"btnStr\":\"1\"},{\"funId\":31,\"btnStr\":\"1\"},{\"funId\":241,\"btnStr\":\"1,2,7\"},{\"funId\":33,\"btnStr\":\"1,2,7\"},{\"funId\":199,\"btnStr\":\"1,7,2\"},{\"funId\":242,\"btnStr\":\"1,2,7\"},{\"funId\":41,\"btnStr\":\"1,2,7\"},{\"funId\":200,\"btnStr\":\"1,2,7\"},{\"funId\":210,\"btnStr\":\"1,2,7\"},{\"funId\":211,\"btnStr\":\"1,2,7\"},{\"funId\":197,\"btnStr\":\"1,2,7\"},{\"funId\":203,\"btnStr\":\"1,7,2\"},{\"funId\":204,\"btnStr\":\"1,7,2\"},{\"funId\":205,\"btnStr\":\"1,2,7\"},{\"funId\":206,\"btnStr\":\"1,7,2\"},{\"funId\":212,\"btnStr\":\"1,2,7\"},{\"funId\":201,\"btnStr\":\"1,2,7\"},{\"funId\":202,\"btnStr\":\"1,2,7\"},{\"funId\":40,\"btnStr\":\"1,2,7\"},{\"funId\":232,\"btnStr\":\"1,2,7\"},{\"funId\":233,\"btnStr\":\"1,2,7\"}]', null, '0');
INSERT INTO `jsh_user_business` VALUES ('34', 'UserRole', '115', '[10]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('35', 'UserRole', '117', '[10]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('36', 'UserDepot', '117', '[8][9]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('37', 'UserCustomer', '117', '[52]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('38', 'UserRole', '120', '[4]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('41', 'RoleFunctions', '12', '', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('48', 'RoleFunctions', '13', '[59][207][208][209][226][227][228][229][235][237][210][211][241][33][199][242][41][200]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('51', 'UserRole', '74', '[10]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('52', 'UserDepot', '121', '[13]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('54', 'UserDepot', '115', '[13]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('56', 'UserCustomer', '115', '[56]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('57', 'UserCustomer', '121', '[56]', null, null, '0');
INSERT INTO `jsh_user_business` VALUES ('67', 'UserRole', '131', '[17]', null, '63', '0');
INSERT INTO `jsh_user_business` VALUES ('68', 'RoleFunctions', '16', '[210]', null, '63', '0');
INSERT INTO `jsh_user_business` VALUES ('69', 'RoleFunctions', '17', '[210][211][241][33][199][242][41][200][201][202][40][232][233][197][203][204][205][206][212]', '[{\"funId\":\"241\",\"btnStr\":\"1,2\"},{\"funId\":\"33\",\"btnStr\":\"1,2\"},{\"funId\":\"199\",\"btnStr\":\"1,2\"},{\"funId\":\"242\",\"btnStr\":\"1,2\"},{\"funId\":\"41\",\"btnStr\":\"1,2\"},{\"funId\":\"200\",\"btnStr\":\"1,2\"},{\"funId\":\"210\",\"btnStr\":\"1,2\"},{\"funId\":\"211\",\"btnStr\":\"1,2\"},{\"funId\":\"197\",\"btnStr\":\"1\"},{\"funId\":\"203\",\"btnStr\":\"1\"},{\"funId\":\"204\",\"btnStr\":\"1\"},{\"funId\":\"205\",\"btnStr\":\"1\"},{\"funId\":\"206\",\"btnStr\":\"1\"},{\"funId\":\"212\",\"btnStr\":\"1\"},{\"funId\":\"201\",\"btnStr\":\"1,2\"},{\"funId\":\"202\",\"btnStr\":\"1,2\"},{\"funId\":\"40\",\"btnStr\":\"1,2\"},{\"funId\":\"232\",\"btnStr\":\"1,2\"},{\"funId\":\"233\",\"btnStr\":\"1,2\"}]', '63', '0');
INSERT INTO `jsh_user_business` VALUES ('83', 'UserRole', '146', '[16]', null, '63', '0');
-- ----------------------------
-- Records of payment_records
-- ----------------------------
INSERT INTO payment_records  VALUES (1, 68, '供应商3', '001', 100.000000, null, '小林第一次充值', '2','2023-07-06 20:42:47',  '63',null,null,'0', '63');
INSERT INTO payment_records  VALUES (2, 68, '供应商3', '001', 100.000000, null, '小林第二次充值', '2','2023-07-07 20:42:47',  '63',null,null,'0', '63');
INSERT INTO payment_records  VALUES (3, 68, '供应商3', '001', 100.000000, null, '小林第三次充值', '0','2023-07-08 20:42:47',  '63',null,null,'0', '63');
INSERT INTO payment_records  VALUES (4, 74, '供应商5', '002', 100.000000, null, '小王第一次充值', '2','2023-07-06 20:42:47',  '63',null,null,'0', '63');
INSERT INTO payment_records  VALUES (5, 74, '供应商5', '002', 100.000000, null, '小王第二次充值', '2','2023-07-07 20:42:47',  '63',null,null,'0', '63');
INSERT INTO payment_records  VALUES (6, 74, '供应商5', '002', 100.000000, null, '小王第三次充值', '0','2023-07-08 20:42:47',  '63',null,null,'0', '63');
-- ----------------------------
-- Records of balance_records
-- ----------------------------
INSERT INTO balance_records  VALUES (1, 68, 200.000000,'0', '63');
INSERT INTO balance_records  VALUES (2, 74, 200.000000,'0', '63');
-- ----------------------------
-- Records of price_details
-- ----------------------------
INSERT INTO price_details VALUES (17, 'n0001', 123, null, null, '搬运费', 100.000000, 200.000000, 2, '按天', '按吨', '0', '备注1', '2023-07-22 05:23:44', 63, null, null, '0', null);
INSERT INTO price_details VALUES (18, 'n0001', 74, null, null, '加工费', 150.000000, 300.000000, 2, '按月', '按吨', '0', '备注2', '2023-07-22 05:23:44', 63, null, null, '0', null);

-- ----------------------------
-- Records of price_receipts
-- ----------------------------
INSERT INTO price_receipts VALUES (1, '01111', 74, '111111', 800.000000, '2023-07-20 10:06:30', '测试用户', null, null, '0', 63);
INSERT INTO price_receipts VALUES (2, '02222', 74, '222222', 950.000000, '2023-07-20 10:06:30', '测试用户', null, null, '0', 63);

-- ----------------------------
-- Records of settlement_method
-- ----------------------------
INSERT INTO `settlement_method` VALUES ('1', '入库结算', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '','63', '0');
INSERT INTO `settlement_method` VALUES ('2', '出库结算', '2019-12-29 12:13:01', '28', '2019-12-29 12:13:01', '28', '', '', '63', '0');

-- ----------------------------
-- Records of second_settlement_method
-- ----------------------------
INSERT INTO `second_settlement_method` VALUES ('1', '1','处置费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '', '63', '0');
INSERT INTO `second_settlement_method` VALUES ('2', '1','装卸费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('3', '1','分拣费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('4', '1','急冻费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('5', '1','加工费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('6', '1','配送费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('7', '1','其他费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('8', '1','服务费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('9', '1','包装费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('10', '1', '场地费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('11', '1', '打磨费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('12', '1', '车马费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('13', '1', '运输费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('14', '1', '物业水费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('15', '1', '物业电费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('16', '1', '叉车费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('17', '1', '降温费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('18', '1', '存储费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('19', '1', '加班费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('20', '1', '过车费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('21', '1', '订单操作费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('22', '1', '复冻费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('23', '1', '出入库费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('24', '2', '处置费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('25', '2', '装卸费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('26', '2', '分拣费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('27', '2', '急冻费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('28', '2', '加工费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('29', '2', '配送费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('30', '2', '其他费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('31', '2', '服务费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('32', '2', '包装费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('33', '2', '场地费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('34', '2', '打磨费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('35', '2', '车马费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('36', '2', '运输费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('37', '2', '物业水费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('38', '2', '物业电费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('39', '2', '叉车费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('40', '2', '降温费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('41', '2', '存储费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('42', '2', '加班费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('43', '2', '过车费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('44', '2', '订单操作费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('45', '2', '复冻费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');
INSERT INTO `second_settlement_method` VALUES ('46', '2', '出入库费', '2019-12-28 12:13:01', '18', '2019-12-28 12:13:01', '18', '', '',  '63', '0');

-- ----------------------------
-- Records of measurement
-- ----------------------------
INSERT INTO `measurement` VALUES ('1', '每天', '63', '0');
INSERT INTO `measurement` VALUES ('2', '每月', '63', '0');

-- ----------------------------
-- Records of second_measurement
-- ----------------------------
INSERT INTO `second_measurement` VALUES ('1', '1', '每托', '63', '0');
INSERT INTO `second_measurement` VALUES ('2', '1', '每吨', '63', '0');
INSERT INTO `second_measurement` VALUES ('3', '1', '每平方', '63', '0');
INSERT INTO `second_measurement` VALUES ('4', '2', '每托', '63', '0');
INSERT INTO `second_measurement` VALUES ('5', '2', '每吨', '63', '0');
INSERT INTO `second_measurement` VALUES ('6', '2', '每平方', '63', '0');