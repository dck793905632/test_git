package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbContent;

import java.util.List;

public interface ContentService {

    //查询内容列表带分页
    EUDataGridResult selectContentList(long categoryId ,Integer page, Integer rows);
    //添加内容
    TaotaoResult insertContent(TbContent content);

    TaotaoResult upadteContent(TbContent tbContent);

    TaotaoResult deleteContentById(long id);
}
