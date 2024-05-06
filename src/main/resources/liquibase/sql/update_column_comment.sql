-- ----------------------------
-- 修改审核状态字段释义，统一为：0:未审核,1:已审核,5:驳回,9:审核中
-------------------------------
ALTER TABLE jsh_depot_head
    MODIFY COLUMN status VARCHAR(1) COMMENT '状态，0未审核、1已审核、2完成采购|销售、3部分采购|销售、4未入库、5、驳回、6、草稿、9审核中';

ALTER TABLE jsh_material
    MODIFY COLUMN approval_status VARCHAR(1) COMMENT '审核状态：0:未审核,1:已审核,5:驳回,6:草稿,9:审核中';

ALTER TABLE jsh_supplier
    MODIFY COLUMN check_status VARCHAR(1) COMMENT '审核状态：0:未审核,1:已审核,5:驳回,6:草稿,9:审核中';

ALTER TABLE supplier_extend
    MODIFY COLUMN check_status VARCHAR(1) COMMENT '审核状态：0:未审核,1:已审核,5:驳回,6:草稿,9:审核中';

ALTER TABLE payment_records
    MODIFY COLUMN approval_status VARCHAR(1) COMMENT '审核状态：0:未审核,1:已审核,5:驳回,6:草稿,9:审核中';

ALTER TABLE price_details
    MODIFY COLUMN status VARCHAR(1) COMMENT '审核状态：0:未审核,1:已审核,5:驳回,6:草稿,9:审核中';

ALTER TABLE price_receipts
    MODIFY COLUMN status VARCHAR(1) COMMENT '审核状态：0:未审核,1:已审核,5:驳回,6:草稿,9:审核中';

ALTER TABLE wxmini_user
    MODIFY COLUMN open_id VARCHAR(50) COMMENT '用户唯一标识';