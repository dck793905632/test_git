package com.taotao.service;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.utils.TaotaoResult;

import java.util.List;

public interface ContentCategoryService {
    //查询分类列表
    List<EUTreeNode> getCategoryList(long parentId);
    //添加节点
    TaotaoResult insertContentCategory(long parentId,String name);
    //删除节点
    TaotaoResult deleteCategory(long id);

    void updateCategory(long id, String name);
}
