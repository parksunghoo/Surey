package kr.ac.dgist.surey.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class TimeController {

    private int year; //연
    private int month; //월
    private int day; //일

    /**
     * int 타입의 연, 월, 일을 매개변수로 하여 Date타입으로 반환하는 함수
     * JDK 1.8이전
     * */
    public Date set_date(int year, int month, int day) {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);

        Date date = cal.getTime();
        return date;
    }

    /**
     * int 타입의 연, 월, 일을 매개변수로 하여 String 타입으로 반환하는 함수
     * JDK 1.8이전
     * */
    public String set_date_string(int year, int month, int day) {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);

        Date theDate = cal.getTime();

        //long 타입으로 변환
        long long_time = theDate.getTime();

        //Timestamp 타입으로 변환
        Timestamp ts = new Timestamp(long_time);

        //포맷변환후 String타입으로 변환
        SimpleDateFormat  birth_date = new SimpleDateFormat("yyyy-MM-dd");
        String birth_date_string = birth_date.format(long_time);

        return birth_date_string;
    }

    /**
     * int 타입의 연, 월, 일을 매개변수로 하여 LocalDate 타입으로 반환하는 함수
     * JDK 1.8이후 LocalDate 활용
     * */
    public LocalDate set_date_localdate(int year, int month, int day) {

        LocalDate localdate = LocalDate.of(year, month, day);

        return localdate;
    }

    //현재 시간 반환 long
    public long current_datetime() {
        Date current_datetime = new Date();
        long current_time_long = current_datetime.getTime();
        System.out.println("수정전 현재시간(date) : " + current_datetime);
        System.out.println("수정전 현재시간 : " + current_time_long);


        //fortest
        String current_time_string = String.valueOf(current_time_long);
        System.out.println("수정전 현재시간_String : " + current_time_string);
        int size = current_time_string.length();
        System.out.println("수정전 현재시간_String_size : " + size);
        int cut_length = 3;

        current_time_string = current_time_string.substring(0, size - cut_length);

        long current_time_long_trim = Long.parseLong(current_time_string);
        System.out.println("수정후 현재시간 : " + current_time_long_trim);

        return current_time_long_trim;
    }

//    //현재시간 반환 yyyy-MM-dd HH:mm:ss
//    public String current_datetime_format() {
//        Date current_datetime = new Date();
//        current_time_long = current_datetime.getTime();
//        SimpleDateFormat current_datetime_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String current_time_string = current_datetime_format.format(current_time_long);
//        return current_time_string;
//    }

    //long을 매개 변수로 입력하고 현재시간 반환 YYYY-MM-dd HH:mm:ss
    public String current_datetime_format(long current_time_long) {
        Date current_datetime = new Date();
        current_time_long = current_datetime.getTime();
        SimpleDateFormat current_datetime_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String current_time_string = current_datetime_format.format(current_time_long);
        return current_time_string;
    }

/*
    public java.sql.Date set_sql_date(int year, int month, int day) {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);

        java.sql.Date sql_date = new java.sql.Date(cal.getTime().getTime());

//        Date theDate = cal.getTime();
        return sql_date; //String 으로 리턴?
    }
*/
}
