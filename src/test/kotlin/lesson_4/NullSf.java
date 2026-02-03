package lesson_4;

public class NullSf {

    private void lolkek() {
        String str = null;
        String str2 = "Hello, World!";

        if (str != null) {
            System.out.println(str.length());
            System.out.println("String is null");
        } else {
            System.out.println("String is not null");
            System.out.println("Not null...");
        }

        str2 = str2 + str;
    }
}
