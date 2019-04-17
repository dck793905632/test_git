package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
/*
* 产品规格参数
* */
@Service
public class ItemParamServiceImpl implements ItemParamService {

    @Autowired
    private TbItemParamMapper itemParamMapper;

    @Override
    public TaotaoResult getItemParamByCid(Long cid) {
        TbItemParamExample example = new TbItemParamExample();
        TbItemParamExample.Criteria criteria = example.createCriteria();
        criteria.andItemCatIdEqualTo(cid);
        List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
        //System.out.println(list);
        if(list!=null&&list.size()>0){
            return TaotaoResult.ok(list.get(0));
        }
     /*   TbItemParam param = itemParamMapper.selectByPrimaryKey(cid);
        Long id = Long.valueOf(560);
        TbItemParam param1 = itemParamMapper.selectByPrimaryKey(id);
        System.out.println(param1);
        System.out.println(cid);
        System.out.println(param);
        if(param!=null){
            return TaotaoResult.ok(param);
        }*/
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult insertItemParam(TbItemParam itemParam) {
        //补全
        itemParam.setCreated(new Date());
        itemParam.setUpdated(new Date());
        itemParamMapper.insertSelective(itemParam);
        return TaotaoResult.ok();
    }
    //查询列表带分页
    @Override
    public EUDataGridResult getItemParamList(Integer page, Integer rows) {
        //创建EU对象
        EUDataGridResult result = new EUDataGridResult();
        //执行sql语句
        TbItemParamExample example = new TbItemParamExample();

        //获取分页信息
        PageHelper.startPage(page,rows);//放在执行的sql语句之前可以拦截SQL语句，插入limit条件
        List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);

        //创建info对象
        PageInfo<TbItemParam> pageInfo = new PageInfo<>(list);
        //获取总条数
        long total = pageInfo.getTotal();
        //补全分页信息
        result.setTotal(total);
        result.setRows(list);
        return result;
    }

    //删除
    @Override
    public TaotaoResult deleteItemParams(long id) {
        itemParamMapper.deleteByPrimaryKey(id);
        return TaotaoResult.ok();
    }
}
