package com.zeller.swagger.controller;

import com.zeller.swagger.pojo.Goods;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/mall")
@Api(tags = "商品分类", description = "会员商品浏览记录管理")
public class SwaggerController {

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String hello(){
        return "test";
    }

    @ApiOperation("通过id获取商品信息")
    @RequestMapping(value="/getGoodsInfo",method = RequestMethod.POST)
    public String getGoodsInfo(String id){
        return "商品"+id;
    }

    @ApiOperation("分页查询品牌列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Goods> listBrand(@RequestParam(value = "pageNum", defaultValue = "1")
                                                        @ApiParam("页码") String pageNum,
                                 @RequestParam(value = "pageSize", defaultValue = "3")
                                                        @ApiParam("每页数量") String pageSize) {
        ArrayList<Goods> list = new ArrayList<>();
        Goods goods = new Goods("1","goods1",22.5f);
        list.add(goods);
        return list;
    }
}