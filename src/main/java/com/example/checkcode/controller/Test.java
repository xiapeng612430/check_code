package com.example.checkcode.controller;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by xianpeng.xia
 * on 2019-06-23 12:15
 */
public class Test {

    static ThreadLocalRandom  random = ThreadLocalRandom.current();

    public static void main(String[] args) {
        while (true){
            int index = random.nextInt(36);
        }
    }
}
