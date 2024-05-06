-- ----------------------------
-- 修改初始化数据（测试账户）
UPDATE `second_settlement_method`
SET settlement_id = '3'
WHERE id BETWEEN 47 AND 69;
-- ----------------------------
UPDATE `second_settlement_method`
SET settlement_id = '4'
WHERE id BETWEEN 70 AND 92;
-- ----------------------------
UPDATE `second_measurement`
SET measurement_id = '5'
WHERE id BETWEEN 13 AND 15;
-- ----------------------------
UPDATE `second_measurement`
SET measurement_id = '6'
WHERE id BETWEEN 16 AND 18;
-- ----------------------------
UPDATE `second_measurement`
SET measurement_id = '7'
WHERE id BETWEEN 19 AND 21;
-- ----------------------------
UPDATE `second_measurement`
SET measurement_id = '8'
WHERE id BETWEEN 22 AND 24;

