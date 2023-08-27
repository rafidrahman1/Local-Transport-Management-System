package com.ltms.ltms.service;

import com.ltms.ltms.entity.HelpEntity;
import com.ltms.ltms.models.HelpModel;

import java.util.List;

public interface HelpService {
    HelpEntity findHelpById(Long id);
    HelpEntity createHelp(HelpModel helpModel);
    List<HelpEntity> getHelpList();

    void deleteQuestion(Long questionId);
}
