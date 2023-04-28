package com.project.ad.mysql.listener;

import com.github.shyiko.mysql.binlog.event.EventType;
import com.project.ad.mysql.constant.Constant;
import com.project.ad.mysql.constant.OpType;
import com.project.ad.mysql.dto.BinlogRowData;
import com.project.ad.mysql.dto.MySqlRowData;
import com.project.ad.mysql.dto.TableTemplate;
import com.project.ad.mysql.listener.AggregationListener;
import com.project.ad.mysql.listener.Ilistener;
import com.project.ad.sender.ISender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 增量数据处理器 */
@Slf4j
@Component
public class IncrementListener implements Ilistener {

//    @Resource(name = "") //kafkaSender
//    private ISender sender;
    @Resource(name = "indexSender")     // 根据name选择注入
    private ISender sender;
    @Resource(name = "kafkaSender")
    private ISender senderKafka;    //kafka投递，

    private final AggregationListener aggregationListener;

    @Autowired
    public IncrementListener(AggregationListener aggregationListener) {
        this.aggregationListener = aggregationListener;
    }

    @Override
    @PostConstruct
    public void register() {
        log.info("IncrementListener register db and table info");
        Constant.table2Db.forEach((k, v) ->
                aggregationListener.register(v, k, this));
    }

    @Override
    public void onEvent(BinlogRowData eventData) {
        TableTemplate table = eventData.getTable();
        EventType eventType = eventData.getEventType();

        // 包装成最后需要投递的数据
        MySqlRowData rowData = new MySqlRowData();

        rowData.setTableName(table.getTableName());
        rowData.setLevel(eventData.getTable().getLevel());
        OpType opType = OpType.to(eventType);
        rowData.setOpType(opType);

        // 取出模板中该操作对应的字段列表
        List<String> fieldList = table.getOpTypeFieldSetMap().get(opType);
        if (null == fieldList) {
            log.warn("{} not support for {}", opType, table.getTableName());
            return;
        }

        for (Map<String, String> afterMap : eventData.getAfter()) {

            Map<String, String> _afterMap = new HashMap<>();

            for (Map.Entry<String, String> entry : afterMap.entrySet()) {

                String colName = entry.getKey();
                String colValue = entry.getValue();

                _afterMap.put(colName, colValue);
            }

            rowData.getFieldValueMap().add(_afterMap);
        }
//        senderKafka.sender(rowData);
        sender.sender(rowData);
    }
}