package com.taotao.rest.controller;

import com.taotao.common.utils.JsonUtils;
import com.taotao.rest.pojo.CatResult;
import com.taotao.rest.service.ItemCatSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;

@Controller
public class ItemCatController {
    
    @Autowired
    private ItemCatSercice itemCatSercice;
    
  /*  @RequestMapping(value = "/itemcat/list",produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    @ResponseBody
    public String getItemCatList(String callback){
        CatResult catResult =itemCatSercice.getItemCatList();
        //转换为json字符串
        String json = JsonUtils.objectToJson(catResult);
        String result =callback+"("+json+")";
        return result;
    }*/
  @RequestMapping("/itemcat/list")
    @ResponseBody
    public Object getItemCatList(String callback){
      CatResult catResult =itemCatSercice.getItemCatList();
      MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(catResult);
      mappingJacksonValue.setJsonpFunction( callback);
      return mappingJacksonValue;
  }
}
