package com.ljj.springboot_read_write_separation.bean;

import com.ljj.springboot_read_write_separation.enums.DBTypeEnum;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: ljj
 * @Date: 2019/9/10 15:13
 * @Description:
 */
public class DBContextHolder {
    private static final ThreadLocal<DBTypeEnum> contextHolder = new ThreadLocal<>();
    private static final AtomicInteger counter = new AtomicInteger(-1);
    private static final int SINGLE_SLAVE = 2;
    private static final int MAX_NUMBER = 9999;

    public static void set(DBTypeEnum dbType){
        contextHolder.set(dbType);
    }

    public static DBTypeEnum get(){
        return contextHolder.get();
    }

    public static void master(){
        set(DBTypeEnum.MASTER);
        System.out.println("切换到master");
    }

    public static void slave(){
        //如果有2个slave，则通过轮询的方式设置slave
        if(DBTypeEnum.values().length > SINGLE_SLAVE){
            int index = counter.getAndIncrement() % 2;
            if(counter.get() > MAX_NUMBER){
                counter.set(-1);
            }
            if(index == 0){
                set(DBTypeEnum.SLAVE);
                System.out.println("切换到slave");
            }else{
                //set(DBTypeEnum.SLAVE2);
                //System.out.println("切换到slave2");
            }
        }else{
            set(DBTypeEnum.SLAVE);
            System.out.println("切换到slave");
        }

    }
}
