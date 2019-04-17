package com.taotao.service;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbItem;

import java.util.List;

public interface ItemCatService {
    //查询树节点
    List<EUTreeNode> getItemCatList(long parentId);

}
