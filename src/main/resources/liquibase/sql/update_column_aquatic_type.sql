ALTER TABLE supermarket_finance CHANGE COLUMN cooperation_category_id aquatic_type_id bigint(20)
    COMMENT '水产类型id';

ALTER TABLE supermarket_reconciliation CHANGE COLUMN cooperation_category_id aquatic_type_id bigint(20)
    COMMENT '水产类型id';