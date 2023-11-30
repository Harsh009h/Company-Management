package com.example.demo.service;
import com.example.demo.entity.Client;

import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService{

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClientss(){
        List<Client> clientList = clientRepository.getClients();
        return clientList;
    }

    public boolean addClient(Client client){
        int result = clientRepository.createClient(client);
        return result > 0 ? true : false;
    }

    public Client getBookByIsbn(String isbn) {
        return clientRepository.getClientByIsbn(isbn);
    }

    public boolean updateClient(Client client) {
        int result = clientRepository.updateClient(client);
        return result > 0 ? true : false;
    }

    public boolean deleteClientk(int clientId) {
        int result = clientRepository.deleteClientk(clientId);
        return result > 0 ? true : false;
    }
}

