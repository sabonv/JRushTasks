package com.javarush.task.task30.task3008.client;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by v.usov on 10.11.2017.
 */
public class BotClient extends Client {

    public static void main(String[] args) {

        BotClient botClient = new BotClient();
        botClient.run();

    }


    public class BotSocketThread extends SocketThread{

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {

            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();

        }

        @Override
        protected void processIncomingMessage(String message) {
            super.processIncomingMessage(message);

            if (message.contains(":") && !message.split(":")[1].equals(" ")) {
                String name = message.substring(0, message.indexOf(":"));
                String textMess = message.substring(message.indexOf(":") + 2);

                switch (message.split(": ")[1]) {

                    case "дата": {
                        sendTextMessage(String.format("Информация для %s: %s", name,
                                new SimpleDateFormat("d.MM.YYYY").format(Calendar.getInstance().getTime())));
                        break;
                    }
                    case "день": {
                        sendTextMessage(String.format("Информация для %s: %s", name,
                                new SimpleDateFormat("d").format(Calendar.getInstance().getTime())));
                        break;
                    }
                    case "месяц": {
                        sendTextMessage(String.format("Информация для %s: %s", name,
                                new SimpleDateFormat("MMMM").format(Calendar.getInstance().getTime())));
                        break;
                    }
                    case "год": {
                        sendTextMessage(String.format("Информация для %s: %s", name,
                                new SimpleDateFormat("YYYY").format(Calendar.getInstance().getTime())));
                        break;
                    }
                    case "время": {
                        sendTextMessage(String.format("Информация для %s: %s", name,
                                new SimpleDateFormat("H:mm:ss").format(Calendar.getInstance().getTime())));
                        break;
                    }
                    case "час": {
                        sendTextMessage(String.format("Информация для %s: %s", name,
                                new SimpleDateFormat("H").format(Calendar.getInstance().getTime())));
                        break;
                    }
                    case "минуты": {
                        sendTextMessage(String.format("Информация для %s: %s", name,
                                new SimpleDateFormat("m").format(Calendar.getInstance().getTime())));
                        break;
                    }
                    case "секунды": {
                        sendTextMessage(String.format("Информация для %s: %s", name,
                                new SimpleDateFormat("s").format(Calendar.getInstance().getTime())));
                        break;
                    }

                }
            }
        }
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int)(Math.random()*100);
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }
}
