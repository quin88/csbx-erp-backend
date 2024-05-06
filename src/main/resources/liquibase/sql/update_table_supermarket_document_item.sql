ALTER TABLE supermarket_document
    ADD link_id bigint COMMENT '关联订单id';

ALTER TABLE supermarket_document_item
    MODIFY COLUMN sd_id BIGINT NULL COMMENT '商超单据表id',
    CHANGE COLUMN material name VARCHAR(200) NULL COMMENT '商品名称(品种)',
    MODIFY COLUMN aquatic_type VARCHAR(20) NULL COMMENT '水产类型(类别)',
    MODIFY COLUMN unit VARCHAR(50) NULL COMMENT '单位',
    MODIFY COLUMN quantity DECIMAL(24, 6) DEFAULT 0.000000 NULL COMMENT '数量',
    ADD COLUMN price DECIMAL(24, 6) DEFAULT 0.000000 NULL COMMENT '金额',
    ADD COLUMN billing_price DECIMAL(24, 6) DEFAULT 0.000000 NULL COMMENT '调整后开票金额(农户金额)',
    ADD COLUMN system_price DECIMAL(24, 6) DEFAULT 0.000000 NULL COMMENT '系统金额',
    MODIFY COLUMN delete_flag VARCHAR(1) DEFAULT '0' NULL COMMENT '删除标记',
    MODIFY COLUMN tenant_id BIGINT NULL COMMENT '租户ID';

