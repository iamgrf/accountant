package com.accountant.service;

import com.accountant.pojo.po.ConsumePO;
import com.accountant.util.PageUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConsumeServiceTest {

    /*@Test
    public void add(){
        for (int i = 10; i < 30; i++) {
            ConsumeService consumeService = new ConsumeService();
            List<ConsumePO> consumePOs = new ArrayList<>();
            ConsumePO consumePO = new ConsumePO();
            consumePO.setTypeId("1");
            consumePO.setUserId("1");
            consumePO.setItem("西红柿");
            consumePO.setAmount(String.valueOf(Math.random() * 100));
            consumePO.setConsumer("向渊");
            consumePO.setConsumeDate("2017-11-"+i);
            consumePO.setConsumeAddress("西乡");
            consumePOs.add(consumePO);
            Map<String, Object> result = consumeService.add(consumePO);
            System.out.println(result);
        }
    }

    @Test
    public void list(){
        ConsumeService consumeService = new ConsumeService();
        Map<String, Object> result = consumeService.list(new PageUtil());
        System.out.println(result);
    }*/

}
