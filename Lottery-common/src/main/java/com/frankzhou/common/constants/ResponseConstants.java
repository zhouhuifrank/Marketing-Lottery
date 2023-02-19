package com.frankzhou.common.constants;

/**
* @Author: this.FrankZhou
* @Description: 系统响应码
* @DateTime: 2023/1/6 11:19
*/
public class ResponseConstants {

    public static ResponseCode SUCCESS = new ResponseCode("200","请求成功");

    public static ResponseCode UNKNOWN_ERROR = new ResponseCode("301","未知错误");

    public static ResponseCode ILLEGAL_PARAMS = new ResponseCode("302","非法参数");

    public static ResponseCode INDEX_DUPLICATED = new ResponseCode("303","主键冲突");

    public static ResponseCode SYSTEM_ERROR = new ResponseCode("304","系统异常");

    public static ResponseCode DB_QUERY_NO_DATA = new ResponseCode("601","数据库未查询到数据");

    public static ResponseCode DB_INSERT_COUNT_ERROR = new ResponseCode("602","数据库插入错误");

    public static ResponseCode DB_UPDATE_COUNT_ERROR = new ResponseCode("603","数据库更新错误");

    public static ResponseCode DB_DELETE_COUNT_ERROR = new ResponseCode("604","数据库删除错误");

    public static ResponseCode LOSING_DRAW = new ResponseCode("800","没有中奖");

    public static ResponseCode RULE_ERROR = new ResponseCode("801","量化人群规则执行失败");

    public static ResponseCode NOT_CONSUMED_TAKE = new ResponseCode("802","未消费活动领取记录");

    public static ResponseCode NO_STOCK = new ResponseCode("803","数据库无库存");

    public static ResponseCode DISTRIBUTED_LOCK_ERROR = new ResponseCode("804","分布式锁获取失败");

    public static ResponseCode DRAW_ERROR = new ResponseCode("805","抽奖执行失败");
}
