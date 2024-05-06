INSERT INTO jsh_function VALUES (280, '1101', '商超管理', '0', '/supermarket', '/layouts/TabLayout', false, '1201', true, '电脑版', '1,2,7', 'shop ', '0');
INSERT INTO jsh_function VALUES (281, '110101', '市场管理', '1101', '/supermarket/market', '/supermarket/MarketList', false, '1202', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (282, '110102', '产地信息', '1101', '/supermarket/county', '/supermarket/CountyList', false, '1203', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (283, '110103', '签名管理', '1101', '/supermarket/signature', '/supermarket/SignatureList', false, '1204', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (284, '110104', '商超订单', '1101', '/supermarket/supermarket_order', '/supermarket/SupermarketOrderList', false, '1205', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (285, '110105', '商超入库', '1101', '/supermarket/in_warehouse', '/supermarket/InWarehouseList', false, '1206', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (286, '110106', '商超出库', '1101', '/supermarket/out_warehouse', '/supermarket/OutWarehouseList', false, '1207', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (287, '01020102', '供应商(冷链)', '01020101', '/system/vendor/cold_chain', '/system/VendorList/ColdChainList', false, '0261', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (288, '01020103', '供应商(商超)', '01020101', '/system/vendor/super_market', '/system/VendorList/SupermarketList', false, '0262', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (289, '01010101', '类别(冷链)', '010101', '/material/material_category/cold_chain', '/material/MaterialCategoryList/ColdChainList', false, '0231', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (290, '01010102', '类别(商超)', '010101', '/material/material_category/super_market', '/material/MaterialCategoryList/SupermarketList', false, '0232', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (291, '01010201', '商品信息(冷链)', '010102', '/material/material/cold_chain', '/material/MaterialList/ColdChainList', false, '0241', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (292, '01010202', '商品信息(商超)', '010102', '/material/material/super_market', '/material/MaterialList/SupermarketList', false, '0242', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (293, '090109', '商超订单审核', '0901', '/check/check_supermarket', '/check/CheckSupermarketList', false, '1009', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (294, '09010601', '商品审核(冷链)', '090106', '/check/check_item/cold_chain', '/check/CheckItemList/ColdChainList', false, '1006', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (295, '09010602', '商品审核(商超)', '090106', '/check/check_item/super_market', '/check/CheckItemList/SupermarketList', false, '1006', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (296, '09010701', '供应商审核(冷链)', '090107', '/check/check_supplier/cold_chain', '/check/CheckSupplierList/ColdChainList', false, '1007', true, '电脑版', '1,2,7', 'profile', '0');
INSERT INTO jsh_function VALUES (297, '09010702', '供应商审核(商超)', '090107', '/check/check_supplier/super_market', '/check/CheckSupplierList/SupermarketList', false, '1007', true, '电脑版', '1,2,7', 'profile', '0');

UPDATE jsh_function SET name='调拨管理' WHERE id=40;
UPDATE jsh_function SET component='/layouts/TabLayoutSecond',push_btn = null WHERE id=22;
UPDATE jsh_function SET component='/layouts/TabLayoutSecond',push_btn = null WHERE id=23;
UPDATE jsh_function SET component='/layouts/TabLayoutSecond',push_btn = null WHERE id=25;
UPDATE jsh_function SET push_btn = null WHERE id=269;
UPDATE jsh_function SET push_btn = null WHERE id=278;

UPDATE jsh_function SET component='/layouts/TabLayoutSecond',push_btn = null WHERE id=275;
UPDATE jsh_function SET component='/layouts/TabLayoutSecond',push_btn = null WHERE id=276;

ALTER TABLE jsh_user_business MODIFY COLUMN btn_str VARCHAR(10000);