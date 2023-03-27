package com.example.DreamCatch.controller;

import com.example.DreamCatch.model.Dream;
import com.example.DreamCatch.model.DreamDTO;
import com.example.DreamCatch.service.DreamService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
;import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/dream")
@CrossOrigin(origins = "http://localhost:3000")
public class DreamController {

    @Autowired
    private DreamService dreamService;

    @PostMapping("/add")
    public String add(@RequestBody DreamDTO dreamDTO){
        dreamService.saveDream(dreamDTO);
        return "New dream is added";
    }
}
