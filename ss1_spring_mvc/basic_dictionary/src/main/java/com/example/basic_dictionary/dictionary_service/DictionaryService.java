package com.example.basic_dictionary.dictionary_service;

import com.example.basic_dictionary.dictionary_repository.DictionaryRepository;
import com.example.basic_dictionary.dictionary_repository.IDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    DictionaryRepository dictionaryRepository;

    @Override
    public String translate(String word) {
        return dictionaryRepository.translate(word);
    }
}
