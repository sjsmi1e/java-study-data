package com.fehead.mapper;

import java.util.List;
import java.util.Map;

/**
 * @author lmwis on 2019-01-28 18:54
 */
public interface MessageMapper {
    public void addAskConfMessage(String confId, String userId, String roleName, String desc);
    public List<Map<String, String>> getAskConfMessageByConfId(String ConfId);
}
