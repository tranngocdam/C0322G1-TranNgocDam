package com.service.impl;


import com.service.IDistionaryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DistionaryServiceImpl implements IDistionaryService {
    Map<String,String> map = new HashMap<>();
    {
        map.put("book","sách");
        map.put("eat","ăn");
        map.put("libarary","thư viện" );
        map.put("laptop","máy tính" );
        map.put("sleep","ngủ");
    }

    @Override
    public String checkWord(String word) {
        for (Map.Entry<String, String> m: map.entrySet()) {
            if (word.equals(m.getKey())){
                return m.getValue();
            }
        }
        return "not found";
    }
}
