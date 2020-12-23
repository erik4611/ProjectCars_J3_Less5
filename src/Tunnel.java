import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    private Semaphore semWait;
    //Семафор, ограничивающий максимальное число машин в туннеле

    public Tunnel(int carCount) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.semWait = new Semaphore(carCount/2);
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
