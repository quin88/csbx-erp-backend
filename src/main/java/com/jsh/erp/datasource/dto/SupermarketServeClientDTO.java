package com.jsh.erp.datasource.dto;

import com.jsh.erp.datasource.entities.SupermarketServeClient;

import java.util.List;

public class SupermarketServeClientDTO {

    private List<SupermarketServeClient> serveClients;

    private String deleteId;

    public List<SupermarketServeClient> getServeClients() {
        return serveClients;
    }

    public void setServeClients(List<SupermarketServeClient> serveClients) {
        this.serveClients = serveClients;
    }

    public String getDeleteId() {
        return deleteId;
    }

    public void setDeleteId(String deleteId) {
        this.deleteId = deleteId;
    }
}