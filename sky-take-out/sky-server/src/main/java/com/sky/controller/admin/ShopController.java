package com.sky.controller.admin;

import com.sky.constant.RedisKeyConstant;
import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController("adminShopController")
@Slf4j
@RequestMapping("/admin/shop")
@Api(tags = "店铺相关接口")
public class ShopController {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 店铺状态设置
     * @param status
     * @return
     */
    @PutMapping("/{status}")
    @ApiOperation(("店铺状态设置"))
    public Result setStatus(@PathVariable Integer status) {
        log.info("设置店铺的营业状态为：{}", status == 1 ? "营业中" : "打烊中");

        // 保存数据到 redis
        redisTemplate.opsForValue().set(RedisKeyConstant.SHOP_STATUS, status);

        return Result.success();
    }

    @GetMapping("/status")
    @ApiOperation(("获取店铺状态"))
    public Result<Integer> getStatus() {
        // 从 redis 获取数据
        Integer status = (Integer)redisTemplate.opsForValue().get(RedisKeyConstant.SHOP_STATUS);

        log.info("获取店铺的营业状态: {}", status == 1 ? "营业中" : "打烊中");
        return Result.success(status);
    }
}
