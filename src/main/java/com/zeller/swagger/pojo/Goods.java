package com.zeller.swagger.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel("商品实体")
public class Goods {
    @ApiModelProperty("商品id")
    private String id;
    @ApiModelProperty("商品名称")
    private String name;
    @ApiModelProperty("商品价格")
    private float price;
}
