package com.project.ad.sender;

import com.project.ad.mysql.dto.MySqlRowData;

public interface ISender {

    void sender(MySqlRowData rowData);
}
