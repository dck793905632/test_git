package com.taotao.rest.solrj;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.io.IOException;

public class solrjTest {
    @Test
    public void solrInputTest() throws IOException, SolrServerException {
        //创建solr服务
        SolrServer solrServer = new HttpSolrServer("http://192.168.25.133:8080/solr");
        //创建文档对象
        SolrInputDocument document = new SolrInputDocument();
        //输入文档信息
        document.addField("id","test001");
        document.addField("item_title","测试");
        document.addField("item_price",123456);
        //把文档写入服务
        solrServer.add(document);
        //提交文档
        solrServer.commit();
    }
    @Test
    public void deleteSolr() throws Exception{
        SolrServer solrServer = new HttpSolrServer("http://192.168.25.133:8080/solr");
        solrServer.deleteByQuery("*:*");
        solrServer.commit();
    }
    @Test
    public void query()throws  Exception{
        //创建solr服务
        SolrServer solrServer = new HttpSolrServer("http://192.168.25.133:8080/solr");
        //设置查询调价
        SolrQuery query = new SolrQuery();
        query.setQuery("*:*");
        query.setStart(20);
        query.setRows(50);
        //执行查询
        QueryResponse response = solrServer.query(query);
        //获取查询结果
        SolrDocumentList solrDocumentList = response.getResults();
        //获取查询到的总条数
        System.out.println("总条数="+solrDocumentList.getNumFound());
        for (SolrDocument solrDocument  : solrDocumentList) {
            System.out.println(solrDocument.get("id"));
            System.out.println(solrDocument.get("item_title"));
            System.out.println(solrDocument.get("item_price"));
            System.out.println(solrDocument.get("item_image"));
        }
    }
}
