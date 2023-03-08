package com.itheima.startmoves;

import com.itheima.moves.Uset;


import java.util.concurrent.*;


public class MovieSystem {
    public static  ExecutorService pool = new ThreadPoolExecutor(3, 5,
            5, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(5),
            Executors.defaultThreadFactory(),
           new ThreadPoolExecutor.AbortPolicy());


    public static void main(String[] args) {
        try {

            moviestret.getaSystem();
            Uset usetS = moviestret.getaSystem();
            pool.execute(usetS);//调用线程池
            //  pool.execute(usetS);
            //  pool.execute(usetS);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
