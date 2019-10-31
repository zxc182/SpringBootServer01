package com.initspringboot.vueboot.util;

import tk.mybatis.mapper.genid.GenId;

import java.util.UUID;

/**
 * @author
 * @version JDK1.8.0_171
 * @date on  2019/3/27 11:37
 * @description V1.0
 */
public class UUIdGenId implements GenId<String> {
    @Override
    public  String genId(String s, String s1) {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void main(String[] args) {
        UUIdGenId g =new UUIdGenId();
        System.err.println(g.genId("1","2"));
    }
}
