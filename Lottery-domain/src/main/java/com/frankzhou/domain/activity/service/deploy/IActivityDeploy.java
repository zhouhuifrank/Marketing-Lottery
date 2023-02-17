package com.frankzhou.domain.activity.service.deploy;

import com.frankzhou.domain.activity.model.req.ActivityConfigReq;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 活动配置接口
 * @date 2023-02-02
 */
public interface IActivityDeploy {

    /**
     * 添加活动配置：活动信息、奖品信息、策略信息、策略明细信息
     *
     * @author this.FrankZhou
     * @param configReq 活动配置请求参数
     * @return void
     */
    void createActivity(ActivityConfigReq configReq);

    /**
     * 更新活动配置：活动信息、奖品信息、策略信息、策略明细信息
     *
     * @author this.FrankZhou
     * @param configReq 活动配置请求参数
     * @return void
     */
    void updateActivity(ActivityConfigReq configReq);

    /**
     * 下载活动配置上传模板
     *
     * @author this.FrankZhou
     * @param
     * @return void
     */
    void downLoadActivityTemplate();


    /**
     * 上传填写的活动配置模板信息
     *
     * @author this.FrankZhou
     * @param
     * @return void
     */
    void uploadActivityTemplate(MultipartFile dataFile);
}
