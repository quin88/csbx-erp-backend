ALTER TABLE supermarket_finance MODIFY COLUMN pay_status VARCHAR(1) DEFAULT '0'
    COMMENT '付款状态，0:未付款,1:部分付款,2:已付款';