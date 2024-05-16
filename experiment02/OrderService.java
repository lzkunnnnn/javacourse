package com.experiments.experiment02;

import com.experiments.experiment02.entity.User; //用户实体类User，包含用户姓名，账户余额，地址
import com.experiments.experiment02.entity.Item; //购买项实体类Item，包含购买商品，商品的购买数量
import com.experiments.experiment02.entity.Order; //订单实体类Order，包含本次订单的用户，购买的全部商品项，本次购买总花费

import java.util.List;

public class OrderService {
    public static Order addOrder(User user, List<Item> items){
        double totalCost = 0;
        for (Item item : items){
            totalCost = totalCost + item.getQuantity()*item.getProduct().getPrice();
        }
        if(user.getBalance() > totalCost){
            Order order = new Order(user, items, totalCost);
            user.setBalance(user.getBalance() - totalCost);
            return order;
        }
        else{
            return null;
        }
    }
}
