package ru.geekbrains.courses.kpah.hw13;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Car extends Thread implements Runnable{
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    CyclicBarrier cb;
    CountDownLatch cd;
    private static Object a = new Object();
    private static int place;
    private static HashMap<Integer, String> placeMap = new HashMap<>();
    Semaphore semaphore;

    public static HashMap<Integer, String> getPlaceMap() {
        return placeMap;
    }

    public String getCarName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier cb, CountDownLatch cd) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cb = cb;
        this.cd = cd;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            cb.await();
            cd.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        semaphore = new Semaphore(1);
        try {
            semaphore.acquire();
            if (Thread.currentThread().isAlive()) {
                place++;
                placeMap.put(place, this.name);
                System.out.println(this.name + " занял " + place + " место");
                semaphore.release();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
