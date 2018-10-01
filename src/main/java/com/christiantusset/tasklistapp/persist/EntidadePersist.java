package com.christiantusset.tasklistapp.persist;

import com.christiantusset.tasklistapp.entity.Tarefa;
import com.christiantusset.tasklistapp.services.DataService;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

public class EntidadePersist {

    @PrePersist
    public void beforeCreate(final Tarefa tarefa) {
        Date date = DataService.getCurrentDate();
        String dateToString = DataService.dateTimeToString(date);

        tarefa.setDataCriacao(dateToString);

        if (tarefa.getStatus() && (tarefa.getDataFinalizacao() == null
                || tarefa.getDataFinalizacao().isEmpty())) {
            tarefa.setDataFinalizacao(dateToString);
        }
    }

    @PreUpdate
    public void beforeUpdate(final Tarefa tarefa) {
        Date now = DataService.getCurrentDate();
        String nowAsString = DataService.dateTimeToString(now);

        tarefa.setDataEdicao(nowAsString);

        if (tarefa.getStatus() && (tarefa.getDataFinalizacao() == null
                || tarefa.getDataFinalizacao().isEmpty())) {
            tarefa.setDataFinalizacao(nowAsString);
        }
    }
}
