package com.ltms.ltms.controller;
import com.ltms.ltms.entity.HelpEntity;
import com.ltms.ltms.models.HelpModel;
import com.ltms.ltms.service.HelpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/help")
@RequiredArgsConstructor

public class HelpController {
    private final HelpService helpService;
    @GetMapping("/all")
    public ResponseEntity<List<HelpEntity>> getAllHelp(){
        List<HelpEntity> allHelp = helpService.getHelpList();
        return new ResponseEntity<>(allHelp, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<HelpEntity> getHelpByID(long helpID){
        return null;
    }
    @PostMapping("/create")

    public ResponseEntity<HelpEntity> createHelp(@RequestBody HelpModel helpModel) {
        HelpEntity helpEntity = helpService.createHelp(helpModel);
        return new ResponseEntity<>(helpEntity, HttpStatus.OK);
    }
    @PutMapping("/update/{helpId}")
    public ResponseEntity<HelpEntity> updateHelp(@RequestBody HelpModel helpModel, @PathVariable Long helpId){
        HelpEntity helpEntity = helpService.updateHelp(helpModel, helpId);
        return new ResponseEntity<>(helpEntity, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{questionId}")
    public ResponseEntity<Object> deleteMapping(@PathVariable Long questionId){
        helpService.deleteQuestion(questionId);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

}
