package com.gaurav.JournalApp.controller;

import com.gaurav.JournalApp.dto.JournalDto;
import com.gaurav.JournalApp.service.JournalService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/journal")
public class JournalController {

    private final JournalService journalService;

    public JournalController(JournalService journalService){
        this.journalService=journalService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<JournalDto>> getAllJournal(){
        List<JournalDto> journalDto=journalService.getAllJournal();
        return new ResponseEntity<>(journalDto,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JournalDto> getById(@PathVariable Long id){
        JournalDto journalDto=journalService.getById(id);
        return new ResponseEntity<>(journalDto,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<JournalDto> createJournal(@RequestBody @Valid JournalDto input){
        JournalDto journalDto =journalService.createJournal(input);
        return new ResponseEntity<>(journalDto,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JournalDto> updateJournal(@RequestBody @Valid JournalDto input, @PathVariable Long id){
        JournalDto journalDto=journalService.updateJournal(input,id);
        return new ResponseEntity<>(journalDto,HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<JournalDto> partialUpdateJournal(@RequestBody Map<String,String> map,Long id){
        JournalDto journalDto=journalService.partialUpdateJournal(map,id);
        return new ResponseEntity<>(journalDto,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(journalService.deleteById(id),HttpStatus.OK);
    }


}
