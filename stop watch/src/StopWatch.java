import java.util.Scanner;

public class StopWatch {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Menu();
        scanner.close();
    }

    static void Menu() {
        System.out.println("S = seg -> 10s = 10 seconds");
        System.out.println("M = min -> 1m = 1 minute");
        System.out.println("H = hour -> 1h = 1 hour");
        System.out.println("D = day -> 1d = 1 day");
        System.out.println("0 = Exit");
        System.out.println("How many minutes do you want to count?");

        String date = scanner.nextLine().toLowerCase();
        char type = date.charAt(date.length() - 1);
        int time = Integer.parseInt(date.substring(0, date.length() - 1));
        int multiplier = 1;

        switch (type) {
            case 's':
                multiplier = 1000;
                break;
            case 'm':
                multiplier = 1000 * 60;
                break;
            case 'h':
                multiplier = 1000 * 3600;
                break;
            case 'd':
                multiplier = 1000 * 86400;
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                Menu();
                return;
        }

        preStart(time * multiplier);
    }

    static void preStart(int time) {
        System.out.println("Ready...");
        sleep(1000);

        System.out.println("Set...");
        sleep(1000);

        System.out.println("Go...");
        sleep(1500);

        start(time);
    }

    static void start(int time) {
        int currentTime = 0;

        while (currentTime != time) {
            currentTime++;
            System.out.println(currentTime);
            sleep(1000);
        }

    }

    static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void sleep(int milliseconds) {
        long endTime = System.currentTimeMillis() + milliseconds;
        while (System.currentTimeMillis() < endTime) {
            @SuppressWarnings("unused")
            int dummy = 0;
        }
    }


}
