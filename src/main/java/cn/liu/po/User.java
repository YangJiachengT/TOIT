package cn.liu.po;

import java.util.Date;

public class User {
    private String id;

    private String userName;

    private String userRealName;

    private String userPassword;

    private String pwdSalt;

    private String userType = "1";

    private Date createDate;

    private String lastestLoginIp;

    private Date lastestLoginTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName == null ? null : userRealName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getPwdSalt() {
        return pwdSalt;
    }

    public void setPwdSalt(String pwdSalt) {
        this.pwdSalt = pwdSalt == null ? null : pwdSalt.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getLastestLoginIp() {
        return lastestLoginIp;
    }

    public void setLastestLoginIp(String lastestLoginIp) {
        this.lastestLoginIp = lastestLoginIp;
    }

    public Date getLastestLoginTime() {
        return lastestLoginTime;
    }

    public void setLastestLoginTime(Date lastestLoginTime) {
        this.lastestLoginTime = lastestLoginTime;
    }
}