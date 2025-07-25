package com.gaurav.JournalApp.service;

import com.gaurav.JournalApp.advices.GlobalExceptionHandler;
import com.gaurav.JournalApp.dto.JournalDto;
import com.gaurav.JournalApp.entities.JournalEntity;
import com.gaurav.JournalApp.repository.JournalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class JournalService {

    private final JournalRepository journalRepository;
    private final ModelMapper modelMapper;

    public JournalService(JournalRepository journalRepository,ModelMapper modelMapper) {
        this.journalRepository = journalRepository;
        this.modelMapper=modelMapper;
    }


    public List<JournalDto> getAllJournal() {

        List<JournalEntity> journalEntity=journalRepository.findAll();
        return journalEntity.stream()
                .map(journal -> modelMapper.map(journal,JournalDto.class))
                .collect(Collectors.toList());
    }

    public Boolean isExist(Long id){
        return journalRepository.existsById(id);
    }

    public JournalDto getById(Long id){
        if(!isExist(id))throw new NoSuchElementException("Not Found journal by this Id : " + id);
        JournalEntity journalEntity=journalRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Journal not found for ID: " + id));
        return modelMapper.map(journalEntity,JournalDto.class);

    }

    public JournalDto createJournal(JournalDto input) {
        JournalEntity journalEntity=modelMapper.map(input,JournalEntity.class);
        JournalEntity createdJournal=journalRepository.save(journalEntity);
        return modelMapper.map(createdJournal,JournalDto.class);

    }

    public JournalDto updateJournal(JournalDto input,Long id) {
        if(!isExist(id))throw new NoSuchElementException("Not Found journal by this Id : " + id);
        JournalEntity journalEntity=modelMapper.map(input,JournalEntity.class);
        journalEntity.setId(id);
        journalRepository.save(journalEntity);
        return modelMapper.map(journalEntity,JournalDto.class);

    }

    public JournalDto partialUpdateJournal(Map<String,String> map, Long id){
        JournalEntity journalEntity = journalRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Journal not found with id: " + id));

        map.forEach((field,value)->{
            Field fieldForUpdate= (Field) ReflectionUtils.findField(JournalEntity.class,field);
            fieldForUpdate.setAccessible(true);
            ReflectionUtils.setField(fieldForUpdate,journalEntity,value);
        });
        journalRepository.save(journalEntity);
        return modelMapper.map(journalEntity,JournalDto.class);
    }


    public Boolean deleteById(Long id) {
        if(!isExist(id))throw new NoSuchElementException("Not Found journal bu this Id : " + id);
        journalRepository.deleteById(id);
        return true;
    }


}
