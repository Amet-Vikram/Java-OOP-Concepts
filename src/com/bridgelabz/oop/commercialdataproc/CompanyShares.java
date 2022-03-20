package com.bridgelabz.oop.commercialdataproc;

import java.time.LocalDateTime;

public class CompanyShares {

    Market.Symbol symbol;
    int shareCount;
    double value;
    String time;
    String date;

    LocalDateTime currentTime = LocalDateTime.now();

    public CompanyShares(Market.Symbol symbol, int shareCount) {
        this.symbol = symbol;
        this.shareCount = shareCount;
    }

    public CompanyShares(Market.Symbol symbol, int shareCount, boolean newEntry) {
        this.symbol = symbol;
        this.shareCount = shareCount;
        if(newEntry){
            setTime(currentTime);
            setDate(currentTime);
        }
    }

    void setTime(LocalDateTime currentTime){
        int hour, minute, seconds;
        hour = currentTime.getHour();
        minute = currentTime.getMinute();
        seconds = currentTime.getSecond();
        this.time = Integer.toString(hour) + ":" + Integer.toString(minute) + ":" + Integer.toString(seconds);
    }
    void setDate(LocalDateTime currentTime) {
        int date, month, year;
        date = currentTime.getDayOfMonth();
        month = currentTime.getMonthValue();
        year = currentTime.getYear();
        this.date = Integer.toString(date) + "/" + Integer.toString(month) + "/" + Integer.toString(year);
    }

    @Override
    public String toString() {
        return "CompanyShares{" +
                "symbol = " + symbol +
                ", shareCount = " + shareCount +
                ", value = " + value +
                ", Last transaction = '" + date+ " at " + time + '\'' +
                '}';
    }
    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }
}
