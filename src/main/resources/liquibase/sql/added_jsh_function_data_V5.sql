insert into `jsh_function` values ('302', '110104', '个人补单', '1101', '/supermarket/supplemental_order', '/supermarket/SupplementalOrderList', false, '1208', true, '电脑版', '1,2,7', 'profile', '0');
insert into `jsh_function` values ('303', '110105', '商超对账', '1101', '/supermarket/supermarket_reconciliation', '/supermarket/ReconciliationList', false, '1209', true, '电脑版', '1,2,7', 'profile', '0');
insert into `jsh_function` values ('304', '090110', '补单审核', '0901', '/check/check_supplemental_order', '/check/CheckSupplementalOrder', false, '0911', true, '电脑版', '1,2,7', 'profile', '0');
insert into `jsh_function` values ('305', '090111', '付款审核', '0901', '/check/check_supermarket_payment', '/check/CheckSupermarketPayment', false, '0912', true, '电脑版', '1,2,7', 'profile', '0');
insert into `jsh_function` values ('306', '110106', '商超财务', '1101', '/supermarket/supermarket_finance', '/supermarket/SupermarketFinanceList', false, '1210', true, '电脑版', '1,2,7', 'profile', '0');

UPDATE jsh_function SET url='/system/cost', component='/system/costList' WHERE id = 299;
