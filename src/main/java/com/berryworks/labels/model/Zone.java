package com.berryworks.labels.model;

public class Zone {

    private String line1;
    private String line2;
    private String line3;
    private String line4;

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getLine3() {
        return line3;
    }

    public void setLine3(String line3) {
        this.line3 = line3;
    }

    public String getLine4() {
        return line4;
    }

    public void setLine4(String line4) {
        this.line4 = line4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Zone)) return false;

        Zone zone = (Zone) o;

        if (getLine1() != null ? !getLine1().equals(zone.getLine1()) : zone.getLine1() != null) return false;
        if (getLine2() != null ? !getLine2().equals(zone.getLine2()) : zone.getLine2() != null) return false;
        if (getLine3() != null ? !getLine3().equals(zone.getLine3()) : zone.getLine3() != null) return false;
        return getLine4() != null ? getLine4().equals(zone.getLine4()) : zone.getLine4() == null;
    }

    @Override
    public int hashCode() {
        int result = getLine1() != null ? getLine1().hashCode() : 0;
        result = 31 * result + (getLine2() != null ? getLine2().hashCode() : 0);
        result = 31 * result + (getLine3() != null ? getLine3().hashCode() : 0);
        result = 31 * result + (getLine4() != null ? getLine4().hashCode() : 0);
        return result;
    }
}
