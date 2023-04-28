package com.project.ad.service;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.DeleteRowsEventData;
import com.github.shyiko.mysql.binlog.event.EventData;
import com.github.shyiko.mysql.binlog.event.UpdateRowsEventData;
import com.github.shyiko.mysql.binlog.event.WriteRowsEventData;

import java.io.IOException;

/**
 * 解析Binlog
 */
public class BinlogServiceTest {
    /*
WriteRowsEventData{tableId=117, includedColumns={0, 1, 2, 3, 4, 5, 6, 7}, rows=[
    [10, 1, plan, 1, Fri Mar 24 17:45:10 PDT 2023, Fri Mar 24 17:45:14 PDT 2023, Wed Dec 31 16:00:00 PST 1969, Wed Dec 31 16:00:00 PST 1969]

    // Fri Mar 24 17:45:14 PDT 2023
     */
    public static void main(String[] args) throws IOException {
        BinaryLogClient client = new BinaryLogClient(
                "127.0.0.1",
                3306,
                "root",
                "mysql73706"
        );
        /**
         * 可以配置client直接去读取哪一个binlog
         * 如果不配置，默认读取最新的
         */
        // client.setBinlogFilename();
        /**
         * 设置从哪一个位置开始监听
         * 默认从最新的位置监听
         */
        // client.setBinlogPosition();

        client.registerEventListener(event -> {
            EventData data = event.getData();
            if (data instanceof UpdateRowsEventData) {
                System.out.println("----------Update----------");
                System.out.println(data.toString());
            } else if (data instanceof WriteRowsEventData) {
                System.out.println("----------Write----------");
                System.out.println(data.toString());
            } else if (data instanceof DeleteRowsEventData) {
                System.out.println("----------Delete----------");
                System.out.println(data.toString());
            }
        });

        client.connect();
    }
}
