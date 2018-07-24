package com.cine.news.controller;

import org.apache.log4j.Logger;

public class Test {
    private static final Logger LOG = Logger.getLogger(Test.class);

    public static void main(String[] args) {
        int[]data = {73,67,38, 33};

        for(int i = 0; i < data.length; i++){
            int multiplo = data[i] / 5;
            multiplo ++;
            LOG.info(multiplo);
            if(data[i] < 38){
                LOG.info(data[i]);
            }else {
                if(((multiplo * 5) - data[i]) < 3){
                    LOG.info(multiplo * 5);
                }else {
                    LOG.info(data[i]);
                }
            }

        }
    }


}
/*

    //apple
    long countApples = 0;
    long countOranges = 0;
        for(int i = 0; i < apples.length; i++){
        if((a + apples[i]) >= s){
        countApples++;
        }
        }

        for(int i = 0; i < oranges.length; i++){
        if((b + oranges[i]) <= t){
        countOranges++;
        }
        }
        System.out.println(countApples);
        System.out.println(countOranges);
*/