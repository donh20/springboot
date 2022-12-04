package com.atguigu.boot;

import ch.qos.logback.core.db.DBHelper;
import com.atguigu.boot.bean.Car;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import com.atguigu.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 主程序类,主配置类
 * @SpringBootApplication: 告诉SpringBoot这是一个SpringBoot应用
 */
//@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.atguigu.boot")
public class MainApplication {
    public static void main(String[] args) {
        //1. 返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        //2. 查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        //3. 从容器中获取组件
//        Pet tom1 = run.getBean("tom", Pet.class);
//        Pet tom2 = run.getBean("tom", Pet.class);
//        System.out.println("组件: "+ (tom1==tom2));
//
//        //com.atguigu.boot.config.MyConfig$$EnhancerBySpringCGLIB
//        MyConfig bean = run.getBean(MyConfig.class);
//
//        System.out.println(bean);
//        // 如果@Configuration(proxyBeanMethods = ture),则获取到的就是代理对象
//        // 代理对象调用方法时,springboot总会检查这个组件是否在容器中.如果有,就不会再实例化一次.
//        // 即,保持组件单实例
//        User user01 = bean.user01();
//        User user02 = bean.user01();
//        System.out.println(user02 == user01);
//
//        User user = run.getBean("user01", User.class);
//        Pet tom01 = run.getBean("tom",Pet.class);
//        System.out.println("用户的宠物: "+ (user.getPet() == tom01));
//
//        //获取组件
//        String[] beanNamesForType = run.getBeanNamesForType(User.class);
//        System.out.println("==============");
//        for (String s : beanNamesForType) {
//            System.out.println(s);
//        }
//        String[] bean1 = run.getBeanNamesForType(DBHelper.class);
//        for (String s : bean1) {
//            System.out.println(s);
//        }

        boolean tom = run.containsBean("tom");
        System.out.println("容器中是否有Tom组件: " + tom);

        boolean user01 = run.containsBean("user01");
        System.out.println("容器中是否有user01组件: "+ user01);

        boolean tom22 = run.containsBean("tom22");
        System.out.println("容器中是否有tom22组件: "+ tom22);

        boolean haha = run.containsBean("haha");
        System.out.println("容器中是否有haha组件: "+ haha);

        boolean hehe = run.containsBean("hehe");
        System.out.println("容器中是否有hehe组件: "+ hehe);

        String[] beanNamesForType = run.getBeanNamesForType(Car.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
            boolean car = run.containsBean(s);
            System.out.println("容器中是否有mycar组件: " + car);
        }
    }
}
