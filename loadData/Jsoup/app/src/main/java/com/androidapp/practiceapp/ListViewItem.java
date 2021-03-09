package com.androidapp.practiceapp;

public class ListViewItem {
    private String nameStr;
    private String numberStr ;
    private String addrStr ;
    private String addrNumStr ;


    public void setName(String name) {
        nameStr = name ;
    }
    public void setNumber(String number) {
        numberStr = number ;
    }
    public void setAddr(String addr) {
        addrStr = addr ;
    }
    public void setAddrNum(String number) {
        addrNumStr = number ;
    }
    public String getName() {
        return this.nameStr ;
    }
    public String getAddr() {
        return addrStr;
    }
    public String getAddrNum() {
        return addrNumStr;
    }
    public String getNumberStr() {
        return numberStr;
    }
}