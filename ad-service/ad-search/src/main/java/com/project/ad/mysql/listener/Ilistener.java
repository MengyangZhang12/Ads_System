package com.project.ad.mysql.listener;

import com.project.ad.mysql.dto.BinlogRowData;
/**
 * 监听器
 */
public interface Ilistener {
    /**
     * 对应不同表定义不同的数据更新方法,即注册不同的监听器.
     */
    void register();
    /**
     * 事件监听
     *
     * @param eventData 对应于源码中的Event对象.
     */
    void onEvent(BinlogRowData eventData);
}
