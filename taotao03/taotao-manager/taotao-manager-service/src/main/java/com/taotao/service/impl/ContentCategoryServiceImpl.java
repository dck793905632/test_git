package com.taotao.service.impl;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
*
* 内容种类
* */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

    @Autowired
    private TbContentCategoryMapper contentCategoryMapper;
    //查询分类列表，返回Node形式集合
    @Override
    public List<EUTreeNode> getCategoryList(long parentId) {
        TbContentCategoryExample example = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
        List<EUTreeNode> resultList = new ArrayList<>();
        for (TbContentCategory tbContentCategory : list) {
            EUTreeNode node = new EUTreeNode();
            node.setId(tbContentCategory.getId());
            node.setText(tbContentCategory.getName());
            node.setState(tbContentCategory.getIsParent()?"closed":"open");
            resultList.add(node);
        }
        return resultList;
    }

    @Override
    public TaotaoResult insertContentCategory(long parentId, String name) {
        //创建TbContentCategory对象
        TbContentCategory contentCategory = new TbContentCategory();
        //补全对象内容
        contentCategory.setCreated(new Date());
        contentCategory.setUpdated(new Date());
        contentCategory.setIsParent(false);
        contentCategory.setSortOrder(1);
        contentCategory.setStatus(1);
        contentCategory.setParentId(parentId);
        contentCategory.setName(name);
        //向数据库中插入信息
        contentCategoryMapper.insert(contentCategory);
        //判断父节点
        TbContentCategory parentCat = contentCategoryMapper.selectByPrimaryKey(parentId);
        if(!parentCat.getIsParent()){
            parentCat.setIsParent(true);
            contentCategoryMapper.updateByPrimaryKey(parentCat);
        }
        return TaotaoResult.ok(contentCategory);
    }

    @Override
    public TaotaoResult deleteCategory(long id) {

        //查询当前删除分类的parentId
        TbContentCategory contentCategory = contentCategoryMapper.selectByPrimaryKey(id);
        Long parentId = contentCategory.getParentId();
        //创建父节点对象
        TbContentCategory parentCategory = contentCategoryMapper.selectByPrimaryKey(parentId);
        //判断被删除分类的父节点是否还有其他子节点
        List<TbContentCategory> list = selectParentId(parentId);
        //删除分类
        contentCategoryMapper.deleteByPrimaryKey(id);
        if(list.size()==1){
            parentCategory.setIsParent(false);
            contentCategoryMapper.updateByPrimaryKeySelective(parentCategory);
        }
        return TaotaoResult.ok();
    }

    private List<TbContentCategory> selectParentId(long parentId){
        TbContentCategoryExample example = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
        return list;
    }
    @Override
    public void updateCategory(long id, String name) {
        TbContentCategory contentCategory = new TbContentCategory();
        contentCategory.setName(name);
        contentCategory.setId(id);
        contentCategoryMapper.updateByPrimaryKeySelective(contentCategory);
    }

}
