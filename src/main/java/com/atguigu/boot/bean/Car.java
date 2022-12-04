package com.atguigu.boot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 只有在容器中的组件,才会拥有SpringBoot提供的强大功能
 */
//为什么要加component?
// 因为类的注入,要么用componentscan,要么在config类里用@Bean注入,car没有在config里用@Bean注入
// 如果不加@Component,则需要通过EnableConfigurationProperties与ConfigurationProperties配合使用
//@Component
@ConfigurationProperties("mycar")
public class Car {
    private String brand;
    private Integer price;

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Car() {
    }
}
