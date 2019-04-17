package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbItemParam;

public interface ItemParamService {
    TaotaoResult getItemParamByCid(Long cid);
    TaotaoResult insertItemParam(TbItemParam itemParam);
    //查询列表带分页
    EUDataGridResult getItemParamList(Integer page,Integer rows);
    //删除产品规格参数
    TaotaoResult deleteItemParams(long id);
}
