package com.sky.service;

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    /**
     * 添加购物车
     *
     * @param shoppingCartDTO
     */
    void addShoppingCart(ShoppingCartDTO shoppingCartDTO);

    /**
     * 展示购物车
     *
     * @return
     */
    List<ShoppingCart> list();

    /**
     * 清空购物车
     *
     * @param userId
     */
    void clean(Long userId);

    /**
     * 删除购物车某商品
     *
     * @param shoppingCartDTO
     */
    void subShoppingCart(ShoppingCartDTO shoppingCartDTO);
}
