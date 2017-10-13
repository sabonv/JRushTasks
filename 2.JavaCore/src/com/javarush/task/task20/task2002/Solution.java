package com.javarush.task.task20.task2002;


import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File your_file_name = File.createTempFile("your_file_name", null);

            String your_file_name = "c:\\Users\\v.usov\\IdeaProjects\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2002\\test1.txt";
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

            User user1 = new User();
            User user2 = new User();

            //user1.setFirstName("Use1 FirstName");
            //user1.setLastName("User1 LastName");
            //user1.setBirthDate(new Date());
            //user1.setMale(false);
            //user1.setCountry(User.Country.RUSSIA);

            //user2.setFirstName("User2 FirstName");
            //user2.setLastName("User2 LastName");
            //user2.setBirthDate(new Date());
            //user2.setMale(true);
            //user2.setCountry(User.Country.UKRAINE);

            javaRush.users.add(user1);
            javaRush.users.add(user2);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод

            PrintWriter writer = new PrintWriter(outputStream);

            String isAssets = this.users.size() != 0 ? "yes" :  "no";
            writer.println(isAssets);

            if(isAssets.equals("yes")) {

                for (User user: users) {

                    if(user.getFirstName() != null) writer.println(user.getFirstName());
                    else writer.println("null");

                    if(user.getLastName() != null) writer.println(user.getLastName());
                    else writer.println("null");

                    if(user.getBirthDate() != null) writer.println(user.getBirthDate().getTime());
                    else writer.println("null");

                    writer.println(user.isMale());

                    if(user.getCountry() != null) writer.println(user.getCountry().getDisplayedName());
                    else writer.println("null");

                }

            }

            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод

            BufferedReader fileR = new BufferedReader(new InputStreamReader(inputStream));

            if(fileR.readLine().equals("yes")){

                while(fileR.ready()) {
                    User tempUser = new User();
                    String tempLine = "";

                    if((tempLine = fileR.readLine()).equals("null")) tempUser.setFirstName(null);
                    else tempUser.setFirstName(tempLine);

                    if((tempLine = fileR.readLine()).equals("null")) tempUser.setLastName(null);
                    else tempUser.setLastName(tempLine);

                    if((tempLine = fileR.readLine()).equals("null")) tempUser.setBirthDate(null);
                    else tempUser.setBirthDate(new Date(Long.valueOf(tempLine)));

                    tempUser.setMale(Boolean.valueOf(fileR.readLine()));

                    if((tempLine = fileR.readLine()).equals("null")) tempUser.setCountry(null);
                    else {

                        switch (tempLine) {

                            case ("Ukraine") : {
                                tempUser.setCountry(User.Country.UKRAINE);
                                break;
                            }
                            case ("Russia") : {
                                tempUser.setCountry(User.Country.RUSSIA);
                                break;
                            }
                            case ("Other") : {
                                tempUser.setCountry(User.Country.OTHER);
                                break;
                            }
                        }

                    }

                    this.users.add(tempUser);

                }

            }



            fileR.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
