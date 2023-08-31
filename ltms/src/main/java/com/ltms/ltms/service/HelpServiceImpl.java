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
        System.out.println("Your question has been submitted");
        return savedHelp;
    }
    @Override
    public HelpEntity updateHelp(HelpModel helpModel, Long helpId) {
        HelpEntity helpFromDB = helpRepository.findById(helpId)
                .orElseThrow();
        if (helpModel.getAnswer() != null) helpFromDB.setAnswer(helpModel.getAnswer());
        HelpEntity updatedHelp = helpRepository.save(helpFromDB);
        return updatedHelp;
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
