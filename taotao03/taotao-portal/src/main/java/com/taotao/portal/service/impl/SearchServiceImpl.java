package com.taotao.portal.service.impl;

import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.portal.pojo.SearchResult;
import com.taotao.portal.service.SearchService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.HashMap;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {
    @Value("${SEARCH_BASE_URL}")
    String SEARCH_BASE_URL;
    @Override
    public SearchResult search(String queryString, int page) {
        //注入参数
        Map<String ,String > parms = new HashMap();
        parms.put("q",queryString);
        parms.put("page",page+"");
        //使用httpclient获取信息
        String json = HttpClientUtil.doGet(SEARCH_BASE_URL ,parms);
        //将字符串转换为java对象
        TaotaoResult result = TaotaoResult.formatToPojo(json, SearchResult.class);
        if(result.getStatus()==200){
            SearchResult searchResult = (SearchResult) result.getData();
            return searchResult;
        }
        return null;
    }
}
