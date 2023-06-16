package com.example.basic_dictionary.dictionary_repository;

import com.example.basic_dictionary.dictionary_service.IDictionaryService;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class DictionaryRepository implements IDictionaryService {
    static HashMap<String, String> map = new HashMap<>();

    static {
        map.put("go", "đi");
        map.put("in", "trong");
        map.put("on", "trên");
        map.put("blow", "thổi");
        map.put("below", "ở dưới");
        map.put("slow", "chậm");
        map.put("low", "thấp");
        map.put("old", "cũ");
    }

    @Override
    public String translate(String word) {
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

