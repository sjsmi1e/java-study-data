package com.fehead.error;

/**
 * @author lmwis on 2019-01-31 13:12
 */
//装饰器模式业务异常类实现
public class BusinessException extends Exception implements CommonError {

    private CommonError commonError;

    //接受EmBusinessError的传参用户构造业务异常
    public BusinessException(CommonError commonError){
        //对应Exception的构造方法会有一些自身的初始化
        super();
        this.commonError = commonError;
    }

    //接受自定义errMsg方式构造业务异常
    public BusinessException(CommonError commonError,String errMsg){
        //对应Exception的构造方法会有一些自身的初始化
        super();
        this.commonError = commonError;
        this.commonError.setErrMsg(errMsg);
    }


    @Override
    public int getErrCode() {
        return this.commonError.getErrCode();
    }

    @Override
    public String getErrMsg() {
        return this.commonError.getErrMsg();
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.commonError.setErrMsg(errMsg);
        return this;
    }
}
