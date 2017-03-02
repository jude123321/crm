package edu.ts.entity;

/**
 * Created by jose on 2017/3/2.
 */
public class Staff {
    private String sLoginId;
    private String sPassword;

    public String getsLoginId() {
        return sLoginId;
    }

    public void setsLoginId(String sLoginId) {
        this.sLoginId = sLoginId;
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }
}
