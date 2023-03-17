package com.ronal.technical.service;

import com.ronal.technical.dao.TechnicalDAO;
import com.ronal.technical.dto.ResponseDTO;

import java.util.List;

public interface TechnicalService {
    ResponseDTO<List<TechnicalDAO>>listar();
    ResponseDTO<TechnicalDAO> save(TechnicalDAO technicalDAO);
    ResponseDTO<TechnicalDAO> search(Long id);
    ResponseDTO<String> desactivar(Long id);
}
