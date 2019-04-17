package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/*
* 内容
*
* */
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private TbContentMapper contentMapper;

    @Value("${REST_BASE_URL}")
    String REST_BASE_URL;
    @Value("${REST_CONTENT_SYNC_URL}")
    String REST_CONTENT_SYNC_URL;

    //查询内容带分页
    @Override
    public EUDataGridResult selectContentList(long categoryId, Integer page, Integer rows) {
        //根据categoryId查询信息
        TbContentExample example = new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        //执行sql语句
        PageHelper.startPage(page,rows);
        List<TbContent> list = contentMapper.selectByExample(example);
        //获取分页信息
        PageInfo<TbContent> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        //补全EU信息
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setTotal(total);
        euDataGridResult.setRows(list);
        return euDataGridResult;
    }

    //添加内容
    @Override
    public TaotaoResult insertContent(TbContent content) {
        //补全TbContent对象内容
        content.setCreated(new Date());
        content.setUpdated(new Date());
        //执行sql语句
        contentMapper.insert(content);
        //对redis操作
        try {
            //HttpClientUtil.doGet("http://localhost:8081/rest/cache/sync/content/"+content.getCategoryId());
            HttpClientUtil.doGet(REST_BASE_URL+REST_CONTENT_SYNC_URL+content.getCategoryId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TaotaoResult.ok();
    }

    //修改内容
    @Override
    public TaotaoResult upadteContent(TbContent tbContent) {
        tbContent.setUpdated(new Date());
        contentMapper.updateByPrimaryKeySelective(tbContent);
        //对redis操作
        try {
            //HttpClientUtil.doGet("http://localhost:8081/rest/cache/sync/content/"+content.getCategoryId());
            HttpClientUtil.doGet(REST_BASE_URL+REST_CONTENT_SYNC_URL+tbContent.getCategoryId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TaotaoResult.ok();
    }

    //删除内容
    @Override
    public TaotaoResult deleteContentById(long id) {
        contentMapper.deleteByPrimaryKey(id);
        TbContent content = contentMapper.selectByPrimaryKey(id);
        //对redis操作
        try {
            //HttpClientUtil.doGet("http://localhost:8081/rest/cache/sync/content/"+content.getCategoryId());
            HttpClientUtil.doGet(REST_BASE_URL+REST_CONTENT_SYNC_URL+content.getCategoryId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TaotaoResult.ok();
    }

}
