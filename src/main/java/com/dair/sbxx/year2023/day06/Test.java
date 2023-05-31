package com.dair.sbxx.year2023.day06;

/**
 * @author Dair
 * @since
 */
public class Test {
    public static void main(String[] args) {
        String sb1 = new StringBuilder().append("是").append("的").toString();
        String sb2 = new StringBuilder().append("是").append("的").toString();
        String sb = new StringBuilder().append("ja").append("va").toString();
        System.out.println(sb1.intern() == sb1);
        System.out.println(sb2.intern() == sb2);
    }
}
