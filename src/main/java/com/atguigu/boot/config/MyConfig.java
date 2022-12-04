package com.atguigu.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.atguigu.boot.bean.Car;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

/**
 * 1. 配置类里面使用@Bean标注方法上给容器注册组件,默认也是单实例的
 * 2. 配置类本身也是组件
 * 3. proxyBeanMethods: 是否代理bean的方法
 * Full(proxyBeanMethods = true) 配置类里给容器注册组件的方法在外部调用时,每次都会去容器里找组件
 * Lite(proxyBeanMethods = false)容器里不会保留代理对象,每次调用都会产生新的组件
 * 解决的是组件依赖问题:
 * 比如user要养一个pet,给容器中注册组件用户(user),user想要在容器中找到之前注册的pet,如果用false模式,
 *
 * 4. 还可以通过Import给容器导入组件
 * @Import({User.class, DBHelper.class})
 * 给容器中自动创建出这两个组件,默认组件的名字就是全类名
 */
//@ConditionalOnBean(name = "tom")
@ConditionalOnMissingBean(name = "tom")
@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = false)  //告诉springboot这是一个配置类 等同于配置文件
@ImportResource("classpath:beans.xml")
@EnableConfigurationProperties(Car.class) //开启属性配置功能
//1. 开启Car的配置绑定功能(@ConfigurationProperties("mycar"))
//2. 把Car这个组件自动注册到容器中
public class MyConfig {
    /**
     * 外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
     * @return
     */

    @Bean //给容器中添加组件,以方法名作为组件的id.返回类型就是组件类型,返回的值就是组件在容器中的实例
    public User user01(){
        //user组件依赖pet组件
        //如果proxyBeanMethods是true,则user下的pet就是容器里的pet
        User zhangsan = new User("zhangsan", 18);
        zhangsan.setPet(tomcatPet());
        return zhangsan;
    }

    @Bean("tom2")
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }
}
