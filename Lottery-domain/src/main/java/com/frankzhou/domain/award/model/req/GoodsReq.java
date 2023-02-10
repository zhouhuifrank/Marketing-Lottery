package com.frankzhou.domain.award.model.req;

import com.frankzhou.domain.award.model.vo.ShippingAddress;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 发货请求类
 * @date 2023-02-10
 */
@Data
@Builder
public class GoodsReq {

    private String uId;

    private Long orderId;

    private String awardId;

    private String awardName;

    private String awardContent;

    private ShippingAddress shippingAddress;

    private String extInfo;

    public GoodsReq() {

    }

    public GoodsReq(String uId,Long orderId,String awardId,String awardName,String awardContent) {
        this.uId = uId;
        this.orderId = orderId;
        this.awardId = awardId;
        this.awardName = awardName;
        this.awardContent = awardContent;
    }

    public GoodsReq(String uId,Long orderId,String awardId,String awardName,String awardContent,ShippingAddress shippingAddress) {
        this.uId = uId;
        this.orderId = orderId;
        this.awardId = awardId;
        this.awardName = awardName;
        this.awardContent = awardContent;
        this.shippingAddress = shippingAddress;
    }

    public GoodsReq(String uId,Long orderId,String awardId,String awardName,String awardContent,ShippingAddress shippingAddress,String extInfo) {
        this.uId = uId;
        this.orderId = orderId;
        this.awardId = awardId;
        this.awardName = awardName;
        this.awardContent = awardContent;
        this.shippingAddress = shippingAddress;
        this.extInfo = extInfo;
    }
}
