package com.fehead.pojo;

/**
 * @Classname MessageType
 * @Description index   1       2
 *              type    异常    通知
 * @Date 2019/1/20 20:05
 * @Created by smile丶
 */
public enum MessageType {
    EXCEPTION("异常信息",1),INFOMATION("通知",2);
    private String type;
    private int index;

    MessageType(String type, int index) {
        this.type = type;
        this.index = index;
    }

    MessageType() {
    }

    public static MessageType getMessageType(int index){
        MessageType messageType= MessageType.EXCEPTION;
        for (MessageType messageType1: MessageType.values()){
            if (messageType1.getIndex()==index)
                return messageType1;
        }
        return messageType;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static String getMessageTypeNameByIndex(int index){
        return getMessageType(index).type;
    }

    public static void main(String[] args) {
        System.out.println(MessageType.getMessageTypeNameByIndex(2));
    }
}
