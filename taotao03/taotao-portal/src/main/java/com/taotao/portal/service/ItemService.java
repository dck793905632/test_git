package com.taotao.portal.service;

import com.taotao.portal.pojo.ItemInfo;

public interface ItemService {
    ItemInfo getItem(long itemId);
    String getItemDescById(long itemId);
    String getItemParam(long itemId);
}
