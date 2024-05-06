package com.jsh.erp.constants;

/**
 * @ClassName:BusinessConstants
 * @Description 业务字典类
 * @Author qiankunpingtai
 * @Date 2019-3-6 17:58
 * @Version 1.0
 **/
public class BusinessConstants {

    /**
     * 默认的日期格式
     */
    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * 一天的初始时间
     */
    public static final String DAY_FIRST_TIME = " 00:00:00";
    /**
     * 一天的结束时间
     */
    public static final String DAY_LAST_TIME = " 23:59:59";
    /**
     * 默认的分页起始页页码
     */
    public static final Integer DEFAULT_PAGINATION_PAGE_NUMBER = 1;
    /**
     * 无数据时列表返回的默认数据条数
     */
    public static final Long DEFAULT_LIST_NULL_NUMBER = 0L;
    /**
     * 默认的分页条数
     */
    public static final Integer DEFAULT_PAGINATION_PAGE_SIZE = 10;
    /**
     * 单据主表出入库类型 type 入库 出库 其它
     * depothead
     */
    public static final String DEPOTHEAD_TYPE_IN = "入库";
    public static final String DEPOTHEAD_TYPE_OUT = "出库";
    public static final String DEPOTHEAD_TYPE_OTHER = "其它";
    /**
     * 付款类型 payType //现付/预付款
     */
    public static final String PAY_TYPE_PREPAID = "预付款";
    public static final String PAY_TYPE_BY_CASH = "现付";
    /**
     * 删除标记 deleteFlag  '0'未删除 '1'已删除
     */
    public static final String DELETE_FLAG_DELETED = "1";
    public static final String DELETE_FLAG_EXISTS = "0";
    /**
     * 是否卖出 isSell  '0'未卖出 '1'已卖出
     */
    public static final String IS_SELL_SELLED = "1";
    public static final String IS_SELL_HOLD = "0";
    /**
     * 商品是否开启序列号标识enableSerialNumber  '0'未启用 '1'启用
     */
    public static final String ENABLE_SERIAL_NUMBER_ENABLED = "1";
    public static final String ENABLE_SERIAL_NUMBER_NOT_ENABLED = "0";
    /**
     * 商品是否开启批号标识enableBatchNumber  '0'未启用 '1'启用
     */
    public static final String ENABLE_BATCH_NUMBER_ENABLED = "1";
    public static final String ENABLE_BATCH_NUMBER_NOT_ENABLED = "0";
    /**
     * 单据状态 billsStatus '0'未审核 '1'审核 '2'完成采购|销售 '3'部分采购|销售 '5'驳回 '6'草稿 '9'审核中
     */
    public static final String BILLS_STATUS_UN_AUDIT = "0";
    public static final String BILLS_STATUS_AUDIT = "1";
    public static final String BILLS_STATUS_SKIPED = "2";
    public static final String BILLS_STATUS_SKIPING = "3";
    public static final String BILLS_STATUS_REJECT = "5";
    public static final String BILLS_STATUS_DRAFT = "6";
    public static final String BILLS_STATUS_UNDER_REVIEW = "9";

    /**
     * 商超订单：单据状态 billsStatus  '2'部分审核
     */
    public static final String SUPERMARKET_ORDER_STATUS_PORTION = "2";

    /**
     * 商超财务：付款状态  '0'未付款  '1'部分付款  '2'已付款
     */
    public static final String SUPERMARKET_FINANCE_PAY_STATUS_UN_AUDIT = "0";
    public static final String SUPERMARKET_FINANCE_PAY_STATUS_PORTION = "1";
    public static final String SUPERMARKET_FINANCE_PAY_STATUS_AUDIT = "2";

    /**
     * 商超财务：结款状态  '0'未结款  '1'部分结款  '2'已结款
     */
    public static final String SUPERMARKET_FINANCE_PAYMENT_STATUS_UN_AUDIT = "0";
    public static final String SUPERMARKET_FINANCE_PAYMENT_STATUS_PORTION = "1";
    public static final String SUPERMARKET_FINANCE_PAYMENT_STATUS_AUDIT = "2";
    /**
     * 通用启用禁用状态  '0'未启用 '1'启用
     */
    public static final String ENABLE_STATUS_NOT_ENABLED = "0";
    public static final String ENABLE_STATUS_ENABLE = "1";
    /**
     * 单据-采购状态 purchaseStatus '0'未采购、'2'完成采购、'3'部分采购
     */
    public static final String PURCHASE_STATUS_UN_AUDIT = "0";
    public static final String PURCHASE_STATUS_SKIPED = "2";
    public static final String PURCHASE_STATUS_SKIPING = "3";
    /**
     * 出入库分类
     * 采购、采购退货、其它、零售、销售、调拨、盘点复盘等
     */
    public static final String SUB_TYPE_PURCHASE_ORDER = "采购订单";
    public static final String SUB_TYPE_PURCHASE = "采购";
    public static final String SUB_TYPE_PURCHASE_RETURN = "采购退货";
    public static final String SUB_TYPE_CONSIGNMENT_ORDER = "寄存订单";
    public static final String SUB_TYPE_CONSIGNMENT_IN_STORAGE = "寄存入库";
    public static final String SUB_TYPE_SELF_ORDER = "自营订单";
    public static final String SUB_TYPE_SELF_IN_STORAGE = "自营入库";
    public static final String SUB_TYPE_SALE_CONSIGNMENT_ORDER = "销售寄存订单";
    public static final String SUB_TYPE_SALE_CONSIGNMENT_OUTBOUND = "销售寄存出库";
    public static final String SUB_TYPE_SALE_SELF_ORDER = "销售自营订单";
    public static final String SUB_TYPE_SELF_OUTBOUND = "销售自营出库";
    public static final String SUB_TYPE_OTHER = "其它";
    public static final String SUB_TYPE_RETAIL = "零售";
    public static final String SUB_TYPE_RETAIL_RETURN = "零售退货";
    public static final String SUB_TYPE_SALES_ORDER = "销售订单";
    public static final String SUB_TYPE_SALES = "销售";
    public static final String SUB_TYPE_SALES_RETURN = "销售退货";
    public static final String SUB_TYPE_TRANSFER = "调拨";
    public static final String SUB_TYPE_CHECK_ENTER = "盘点录入";
    public static final String SUB_TYPE_REPLAY = "盘点复盘";
    public static final String SUB_TYPE_ASSEMBLE = "组装单";
    public static final String SUB_TYPE_DISASSEMBLE = "拆卸单";

    /**
     * 财务单据分类
     * 收款、付款
     */
    public static final String TYPE_MONEY_IN = "收款";
    public static final String TYPE_MONEY_OUT = "付款";
    /**
     * 批量插入sql时最大的数据条数
     */
    public static final int BATCH_INSERT_MAX_NUMBER = 500;
    /**
     * sequence名称
     */
    //sequence返回字符串的最小长度
    public static final Long SEQ_TO_STRING_MIN_LENGTH = 10000000000L;

    //sequence返回字符串的最小数位长度(市场)
    public static final Long MARKET_SEQ_TO_STRING_MIN_LENGTH = 10L;

    //sequence长度小于基准长度时前追加基础值
    public static final String SEQ_TO_STRING_LESS_INSERT = "0";
    //单据编号
    public static final String DEPOT_NUMBER_SEQ = "depot_number_seq";
    //市场编号
    public static final String MARKET_NUMBER_SEQ = "market_number_seq";
    //供应商编号
    public static final String SUPPLIER_NUMBER_SEQ = "supplier_number_seq";
    //区县镇编号
    public static final String COUNTY_NUMBER_SEQ = "county_number_seq";
    //商超订单编号
    public static final String SUPERMARKET_ORDER_NUMBER_SEQ = "supermarket_order_number_seq";
    //商超补单编号
    public static final String SUPERMARKET_ADDED_ORDER_NUMBER_SEQ = "supermarket_added_order_number_seq";
    //商超出入库单据编号
    public static final String SUPERMARKET_DOCUMENT_NUMBER_SEQ = "supermarket_document_number_seq";
    //商超商品编号
    public static final String SUPERMARKET_MATERIAL_NUMBER_SEQ = "supermarket_material_number_seq";
    //商超财务单据编号
    public static final String SUPERMARKET_FINANCE_NUMBER_SEQ = "supermarket_finance_number_seq";
    //商超对账编号
    public static final String SUPERMARKET_RECONCILIATION_NUMBER_SEQ = "supermarket_reconciliation_number_seq";

    /**
     * create by: qiankunpingtai
     * create time: 2019/3/14 11:41
     * description:
     * 为了使用户可以自己建初始目录，设定根目录的父级目录id为-1
     */
    public static final Long MATERIAL_CATEGORY_ROOT_PARENT_ID = -1L;
    /**
     * 商品类别状态
     * 0系统默认，1启用，2删除
     */
    public static final String MATERIAL_CATEGORY_STATUS_DEFAULT = "0";
    public static final String MATERIAL_CATEGORY_STATUS_ENABLE = "1";
    public static final String MATERIAL_CATEGORY_STATUS_DELETE = "2";
    /**
     * 机构状态
     * 1未营业、2正常营业、3暂停营业、4终止营业,5已除名
     */
    public static final String ORGANIZATION_STCD_NOT_OPEN = "1";
    public static final String ORGANIZATION_STCD_OPEN = "2";
    public static final String ORGANIZATION_STCD_BUSINESS_SUSPENDED = "3";
    public static final String ORGANIZATION_STCD_BUSINESS_TERMINATED = "4";
    public static final String ORGANIZATION_STCD_REMOVED = "5";
    /**
     * 根机构父级编号
     * 根机父级构编号默认为-1
     */
    public static final String ORGANIZATION_ROOT_PARENT_NO = "-1";
    /**
     * 新增用户默认密码
     */
    public static final String USER_DEFAULT_PASSWORD = "123456";
    /**
     * 用户是否系统自带
     * 0、非系统自带，1系统自带
     */
    public static final byte USER_NOT_SYSTEM = 0;
    public static final byte USER_IS_SYSTEM = 1;
    /**
     * 用户是否为管理者
     * 0、管理者，1员工
     */
    public static final byte USER_IS_MANAGER = 0;
    public static final byte USER_NOT_MANAGER = 1;
    /**
     * 用户状态
     * 0：正常，1：删除，2封禁
     */
    public static final byte USER_STATUS_NORMAL = 0;
    public static final byte USER_STATUS_DELETE = 1;
    public static final byte USER_STATUS_BANNED = 2;
    /**
     * 日志操作
     * 新增、修改、删除、登录、导入
     */
    public static final String LOG_OPERATION_TYPE_ADD = "新增";
    public static final String LOG_OPERATION_TYPE_BATCH_ADD = "批量新增";
    public static final String LOG_OPERATION_TYPE_EDIT = "修改";
    public static final String LOG_OPERATION_TYPE_DELETE = "删除";
    public static final String LOG_OPERATION_TYPE_LOGIN = "登录";
    public static final String LOG_OPERATION_TYPE_IMPORT = "导入";
    public static final String LOG_OPERATION_TYPE_ENABLED = "更新状态";

    /**
     * 数据数量单位
     * 条
     */
    public static final String LOG_DATA_UNIT = "条";

    /**
     * 删除类型
     * 1正常删除
     * 2强制删除
     */
    public static final String DELETE_TYPE_NORMAL = "1";
    public static final String DELETE_TYPE_FORCE = "2";

    /**
     * 默认管理员账号
     */
    public static final String DEFAULT_MANAGER = "admin";

    public static final String ROLE_TYPE_PRIVATE = "个人数据";

    public static final String ROLE_TYPE_THIS_ORG = "本机构数据";

    /**
     * redis相关
     */
    //session的生命周期,秒
    public static final Long MAX_SESSION_IN_SECONDS = 60 * 60 * 24L;

    //小程序的session的生命周期,秒
    public static final Long MINI_PROGRAM_MAX_SESSION_IN_SECONDS = 100 * 60 * 60 * 24L;
    /**
     * 来源类型
     */
    public static final String ORIGIN_TYPE = "小程序";

    /**
     * 确认单据上传状态
     * 0：未上传，1：部分上传，2：全部已上传
     */
    public static final String UPLOAD_STATUS_NO = "0";
    public static final String USER_STATUS_ALL = "2";

    /**
     * 用户类型
     */
    public static final String USER_TYPE_COLD_CHAIN = "冷链";
    public static final String USER_TYPE_SUPERMARKET = "商超";
}
