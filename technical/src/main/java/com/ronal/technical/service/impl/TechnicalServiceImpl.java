package com.ronal.technical.service.impl;

import com.ronal.technical.dao.TechnicalDAO;
import com.ronal.technical.dto.ResponseDTO;
import com.ronal.technical.repository.TechnicalRepository;
import com.ronal.technical.service.TechnicalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service

public class TechnicalServiceImpl implements TechnicalService {

    private final TechnicalRepository technicalRepository;

    @Override
    public ResponseDTO<List<TechnicalDAO>> listar() {
        List<TechnicalDAO> salida = technicalRepository.findAll();
        if (CollectionUtils.isEmpty(salida)) {
            return ResponseDTO.<List<TechnicalDAO>>builder()
                    .success(Boolean.FALSE)
                    .message("No se encontraron registros")
                    .statusCode(200).build();
        }

        return ResponseDTO.<List<TechnicalDAO>>builder()
                .success(Boolean.TRUE)
                .message("Lista de todos los Técnicos")
                .response(salida)
                .statusCode(200).build();
    }

    @Override
    public ResponseDTO<TechnicalDAO> save(TechnicalDAO technicalDAO) {
        TechnicalDAO technical = technicalRepository.findByDniAndActiveTrue(technicalDAO.getDni());

        if (Objects.nonNull(technical) && technical.getDni().equals(technicalDAO.getDni())) {
            return ResponseDTO.<TechnicalDAO>builder()
                    .success(Boolean.FALSE)
                    .error("El técnico ya existe")
                    .build();
        }

        TechnicalDAO technicalSave = technicalRepository.save(technicalDAO);

        return ResponseDTO.<TechnicalDAO>builder()
                .success(Boolean.TRUE)
                .message("Technical registrado correctamente")
                .response(technicalSave)
                .build();
    }

    @Override
    public ResponseDTO<TechnicalDAO> search(Long id) {
        Optional<TechnicalDAO> salida = technicalRepository.findById(id);
        if (!salida.isPresent()) {
            return ResponseDTO.<TechnicalDAO>builder()
                    .success(Boolean.FALSE)
                    .error("No se existe un Technical con el ID: " + id)
                    .build();
        }
        return ResponseDTO.<TechnicalDAO>builder().build();
    }

    @Override
    public ResponseDTO<String> desactivar(Long id) {
        return null;
    }
}
