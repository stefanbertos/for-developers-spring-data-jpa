package com.example.demo.service;

import com.example.demo.entity.Client;
import com.example.demo.entity.ClientPk;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.ClientStatusRepository;
import com.example.demo.vo.ClientVO;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientService {

    private final ClientRepository clientRepository;

    private final ClientStatusRepository clientStatusRepository;

    private final ModelMapper modelMapper;

    public ClientService(ClientRepository clientRepository, ClientStatusRepository clientStatusRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.clientStatusRepository = clientStatusRepository;
        this.modelMapper = modelMapper;
    }

    public List<ClientVO> findAll() {
        return clientRepository.findAll().stream()
                .map(this::convertToVO)
                .collect(Collectors.toList());
    }

    public ClientVO create(ClientVO client) {
        return convertToVO(clientRepository.save(convertToEntity(client)));
    }

    private ClientVO convertToVO(Client entity) {
        ClientVO clientVO = modelMapper.map(entity, ClientVO.class);
        clientVO.setFirstname(entity.getId().getFirstname());
        clientVO.setLastname(entity.getId().getLastname());
        clientVO.setBirthdate(entity.getId().getBirthdate());
        clientVO.setStatus(entity.getStatus() != null ? entity.getStatus().getName() : null);
        log.info("convertToVO {}", clientVO);
        return clientVO;
    }

    private Client convertToEntity(ClientVO clientVO) {
        Client entity = modelMapper.map(clientVO, Client.class);
        entity.setId(new ClientPk(clientVO.getFirstname(), clientVO.getLastname(), clientVO.getBirthdate()));
        entity.setStatus(clientStatusRepository.findByName(clientVO.getStatus()));

        log.info("convertToEntity {}", entity
        );
        return entity;
    }
}
