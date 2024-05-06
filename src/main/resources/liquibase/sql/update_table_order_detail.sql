ALTER TABLE order_detail
    MODIFY COLUMN bank_name VARCHAR(100) null comment '开户银行名称',
    MODIFY COLUMN account_name VARCHAR(100) null comment '账户名称';

