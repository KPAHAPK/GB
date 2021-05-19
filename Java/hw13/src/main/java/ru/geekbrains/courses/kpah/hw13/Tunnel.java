package ru.geekbrains.courses.kpah.hw13;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    Semaphore semaphore;

    public Tunnel(Semaphore semaphore) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.semaphore = semaphore;
    }

    @Override
    public void go(Car c) {
        try {
            try {
                semaphore.acquire();
                System.out.println(c.getCarName() + " готовится к этапу(ждет): " + description);
                System.out.println(c.getCarName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getCarName() + " закончил этап: " + description);
                semaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
