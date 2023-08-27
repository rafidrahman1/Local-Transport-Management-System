package com.ltms.ltms.service;

import com.ltms.ltms.entity.HelpEntity;
import com.ltms.ltms.models.HelpModel;
import com.ltms.ltms.repository.HelpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HelpServiceImpl implements HelpService {
    private final HelpRepository helpRepository;
    @Override
    public HelpEntity findHelpById(Long id){return null;}

    @Override
    public HelpEntity createHelp(HelpModel helpModel){
        HelpEntity help = HelpEntity.builder()
                .question(helpModel.getQuestion())
                .build();
        HelpEntity savedHelp = helpRepository.save(help);
        return savedHelp;
    }
    @Override
    public List<HelpEntity> getHelpList(){
        List<HelpEntity> helpEntityList= helpRepository.findAll();
        return helpEntityList;
    }

    @Override
    public void deleteQuestion(Long questionId) {
        helpRepository.deleteById(questionId);
    }
}
