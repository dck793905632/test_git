package com.taotao.common.pojo;

import java.util.List;

public class EUDataGridResult {
    private Long total;//返回eu格式
    private List<?> rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
