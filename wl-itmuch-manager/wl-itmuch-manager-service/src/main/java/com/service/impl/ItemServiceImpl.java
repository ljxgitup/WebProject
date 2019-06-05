package com.service.impl;

import com.mapper.TbItemMapper;
import com.pojo.TbItem;
import com.pojo.TbItemExample;
import com.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper itemMapper;
    @Override
    public TbItem getItemById(Long itemId) {
        TbItemExample example=new TbItemExample();
        TbItemExample.Criteria criteria=example.createCriteria();
        criteria.andIdEqualTo(itemId);
        List<TbItem> list=itemMapper.selectByExample(example);
        TbItem item=null;
        if (list!=null&&list.size()>0){
            item=list.get(0);
        }
        return item;
    }
}
