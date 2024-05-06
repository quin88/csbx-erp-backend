ALTER TABLE supermarket_added_order
    CHANGE COLUMN supermarket_order_id link_id BIGINT(20) COMMENT '商超订单id',
    CHANGE COLUMN supermarket_order_number link_number VARCHAR(100) COMMENT '商超订单编号';
