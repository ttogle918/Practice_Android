package com.androidapp.lottedelivery;

public class RecyclerItem {
    private int position;
    private String nameStr;
    private String addrStr;
    private String areaStr;
    private int areaCode;
    private String amount;
    private String t_start = "";
    private String t_end = "";
    private boolean isComplete = false;     // true : 도착완료-> 배송완료로 바꾸기,

    public boolean isComplete() {   return isComplete;  }
    public void setComplete(boolean complete) { isComplete = complete; }
    public int getPosition() { return position; }
    public void setPosition(int position) { this.position = position;    }
    public String getNameStr() {
        return nameStr;
    }

    public void setNameStr(String nameStr) {
        this.nameStr = nameStr;
    }

    public String getAddrStr() {
        return addrStr;
    }

    public void setAddrStr(String addrStr) {
        this.addrStr = addrStr;
    }

    public String getAreaStr() {
        return areaStr;
    }

    public void setAreaStr(String areaStr) {
        this.areaStr = areaStr;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getT_start() {
        return t_start;
    }

    public void setT_start(String t_start) {
        this.t_start = t_start;
    }

    public String getT_end() {
        return t_end;
    }

    public void setT_end(String t_end) {
        this.t_end = t_end;
    }
}
