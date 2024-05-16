package com.experiments.experiment02;

import com.experiments.experiment02.entity.User; //用户实体类User，包含用户姓名，账户余额，地址
import com.experiments.experiment02.entity.Item; //购买项实体类Item，包含购买商品，商品的购买数量
import com.experiments.experiment02.entity.Product; //商品实体类Product，包含商品名称，商品价格
import com.experiments.experiment02.entity.Order; //订单实体类Order，包含本次订单的用户，购买的全部商品项，本次购买总花费

import java.util.List;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        User user = new User("李阳", 2000, "Nefu");
        Product product1 = new Product("Sony耳机", 999);
        Product product2 = new Product("白象方便面", 5);

        List<Item> items = new ArrayList<>();
        items.add(new Item(product1, 1));
        items.add(new Item(product2, 100));

        Order order = OrderService.addOrder(user, items);
        if(order == null){
            System.out.println("余额不足");
        }
        else {
            System.out.println("商品总额：" + order.getTotalCost());
            System.out.println("用户余额：" + user.getBalance());
            System.out.println("快递地址：" + user.getAddress());
        }
    }
}
