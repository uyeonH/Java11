package thread;

public class ThreadEx9 {
    public static void main(String[] args) {
        ThreadGroup main = Thread.currentThread().getThreadGroup();
        ThreadGroup group1 = new ThreadGroup("Group1");
        ThreadGroup group2 = new ThreadGroup("Group2");

        ThreadGroup subGroup = new ThreadGroup(group1, "SubGroup1");

        group1.setMaxPriority(3);

        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {

                }
            }
        };

        new Thread(group1, r, "th1").start();
        new Thread(subGroup, r, "th2").start();
        new Thread(group2, r, "th3").start();

        System.out.println(">>List of ThreadGroup: " + main.getName()
                + ", Active ThreadGroup: " + main.activeGroupCount()
                + ", Active Thread: " + main.activeCount());

        main.list();
    }

}

