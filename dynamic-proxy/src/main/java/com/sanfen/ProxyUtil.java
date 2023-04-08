package com.sanfen;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理工具类
 *
 * @author HeJin
 * @version 1.0
 * @since 2023/04/08 11:28
 */
public class ProxyUtil {

    /**
     * 创建明星的代理对象
     *
     * @param bigStar 被代理的明星对象
     * @return 给明星创建的代理
     */
    public static Star createProxy(BigStar bigStar) {
        return (Star) Proxy.newProxyInstance(
                ProxyUtil.class.getClassLoader(),
                new Class[]{Star.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 代理干的事情
                        if ("sing".equals(method.getName())) {
                            System.out.println("准备话筒 收钱");
                        } else if ("dance".equals(method.getName())) {
                            System.out.println("准备场地 收钱");
                        }

                        // 去找真正的大明星唱歌或者跳舞
                        return method.invoke(bigStar, args);
                    }
                });
    }

}
