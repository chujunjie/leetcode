package qa;

import java.util.Scanner;

/**
 * 三天打鱼两天晒网
 *
 * @author chujunjie
 */
public class Main32 {

    private static final String WORK = "He is working";
    private static final String REST = "He is having a rest";
    private static final String INVALID = "Invalid input";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] split = line.split("-");
        try {
            int year = Integer.parseInt(split[0]);
            int month = Integer.parseInt(split[1]);
            int day = Integer.parseInt(split[2]);
            if (year < 1990 || month < 1 || month > 12 || day > 31) {
                System.out.println(INVALID);
            } else {
                if (day < 1 || day > getDays(year, month)) {
                    System.out.println(INVALID);
                } else {
                    judge(getAllDays(year, month, day));
                }
            }
        } catch (Exception e) {
            System.out.println(INVALID);
        }
    }

    /**
     * 判断
     *
     * @param days days
     */
    private static void judge(int days) {
        int x = days % 5;
        if (x >= 1 && x <= 3) {
            System.out.println(WORK);
        } else if (x == 4 || x == 0) {
            System.out.println(REST);
        }
    }

    /**
     * 判断闰年
     *
     * @param year year
     * @return boolean
     */
    private static boolean leapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    /**
     * 计算距离输入日期多少天
     *
     * @param year  year
     * @param month month
     * @param day   day
     * @return int
     */
    private static int getAllDays(int year, int month, int day) {
        int sum = 0;
        // 计算1990--(year-1)之间有多少天
        for (int i = 1990; i < year; i++) {
            if (leapYear(i)) {
                sum += 366;
            } else {
                sum += 365;
            }
        }

        // 计算year内多少天
        sum += getBeforeDays(year, month, day);
        return sum;
    }

    /**
     * 判断每月有几天
     *
     * @param year  year
     * @param month month
     * @return int
     */
    private static int getDays(int year, int month) {
        int days = 0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
                if (leapYear(year)) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
            default:
                break;
        }

        return days;
    }

    /**
     * 计算本年内该日期之前共有多少天
     *
     * @param year  year
     * @param month month
     * @param day   day
     * @return int
     */
    private static int getBeforeDays(int year, int month, int day) {
        int sum = 0;
        for (int i = 1; i < month; i++) {
            sum += getDays(year, i);
        }
        return sum + day;
    }
}
