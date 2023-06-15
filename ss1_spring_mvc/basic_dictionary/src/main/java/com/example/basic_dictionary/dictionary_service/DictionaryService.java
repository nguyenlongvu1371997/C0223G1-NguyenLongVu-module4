package com.example.basic_dictionary.dictionary_service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class DictionaryService implements IDictionaryService {
    @Override
    public String translate(String word) {
        HashMap<String, String> map = new HashMap<>();
        map.put("go", "đi");
        map.put("in", "trong");
        map.put("on", "trên");
        map.put("blow", "thổi");
        map.put("below", "ở dưới");
        map.put("slow", "chậm");
        map.put("low", "thấp");
        map.put("old", "cũ");
        String word1 = "";
        for (String s : map.keySet()) {
            if (s.equals(word)) {
                word1 = map.get(s);
                return word1;
            }
        }
        return "không tìm thấy";
    }
}
