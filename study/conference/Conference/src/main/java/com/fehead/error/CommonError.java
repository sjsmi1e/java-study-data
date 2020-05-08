package com.fehead.error;

/**
 * @author lmwis on 2019-01-31 13:00
 */
public interface CommonError {
    public int getErrCode();
    public String getErrMsg();
    public CommonError setErrMsg(String errMsg);
}
