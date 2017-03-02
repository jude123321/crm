package edu.ts.entity;

import java.util.Date;

/**
 * Created by jose on 2017/3/2.
 */
public class Customer {
    private int cId;

    private String cName;

    private int cGender;

    private Date cBirth;

    private String cTel;

    private String cMail;

    private String cPic;

    private String cScore;

    private String cPassword;

    //web注册
    public Customer(String cName, int cGender, Date cBirth, String cTel, String cMail, String cScore, String cPassword) {
        this.cName = cName;
        this.cGender = cGender;
        this.cBirth = cBirth;
        this.cTel = cTel;
        this.cMail = cMail;
        this.cScore = cScore;
        this.cPassword = cPassword;
    }

    //微信注册
    public Customer(String cName, int cGender, Date cBirth, String cTel, String cMail, String cPic, String cScore, String cPassword) {
        this.cName = cName;
        this.cGender = cGender;
        this.cBirth = cBirth;
        this.cTel = cTel;
        this.cMail = cMail;
        this.cPic = cPic;
        this.cScore = cScore;
        this.cPassword = cPassword;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getcGender() {
        return cGender;
    }

    public void setcGender(int cGender) {
        this.cGender = cGender;
    }

    public Date getcBirth() {
        return cBirth;
    }

    public void setcBirth(Date cBirth) {
        this.cBirth = cBirth;
    }

    public String getcTel() {
        return cTel;
    }

    public void setcTel(String cTel) {
        this.cTel = cTel;
    }

    public String getcMail() {
        return cMail;
    }

    public void setcMail(String cMail) {
        this.cMail = cMail;
    }

    public String getcScore() {
        return cScore;
    }

    public void setcScore(String cScore) {
        this.cScore = cScore;
    }

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }
}
