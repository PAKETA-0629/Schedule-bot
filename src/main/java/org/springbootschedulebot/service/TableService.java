package org.springbootschedulebot.service;

import org.springbootschedulebot.model.Table;
import org.springbootschedulebot.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {

    private final TableRepository tableRepository;

    @Autowired
    public TableService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public List<Table> findAll() {
        return tableRepository.findAll();
    }

    public void create(Table table) {
        tableRepository.create(table.getName(), table.getUser().getId());
    }
}
