package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj2) {
            synchronized (obj1) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception {
        //do something here

        Thread thread1 = new Thread(){
            @Override
            public void run() {
                solution.someMethodWithSynchronizedBlocks(o1,o2); // 3. Пытаемся выполнить метод someMethodWithSynchronizedBlocks
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                synchronized (o2) { // 6. Если у этой нити получилось заблочить о2, значит порядок в методе someMethodWithSynchronizedBlocks - ВЕРНЫЙ
                    Thread.currentThread().interrupt();
                }
            }
        };

        synchronized (o1) {  // 1. Лочим о1
            thread1.start(); // 2. Запускаем thread1
            while (true) {
                if (thread1.getState() == Thread.State.BLOCKED) { // 4. Ждем, когда thread1 заблочится и выходим из while
                    break;
                }
            }

            thread2.start(); // 5. Запускаем thread2
            while (!thread2.isInterrupted()) { // 7. Пока нить thread2 работает, проверяем ее состояние
                Thread.State ts = thread2.getState();
                if (ts != Thread.State.RUNNABLE) { // 8. Нас интересует любое состояние, кроме RUNNABLE
                    if (ts == Thread.State.BLOCKED) { // 9. Отловили BLOCKED у thread2, значит заблокированны оба
                        // обекта о1 и о2 и порядок блокировки в методе
                        // someMethodWithSynchronizedBlocks - НЕ ВЕРНЫЙ
                        return false;
                    } else {                        // 10. Если нить thread2 сменила свое состояние с RUNNABLE на
                        // любое другое кроме BLOCKED (в нашем случае, скорее всего
                        // TERMINATED), значит объект о2 на заблокирован. Следовательно,
                        // порядок блокировки в методе someMethodWithSynchronizedBlocks - ВЕРНЫЙ
                        return true;
                    }
                }
            }
        }

        return true;




        //return false;
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isNormalLockOrder(solution, o1, o2));
    }
}
