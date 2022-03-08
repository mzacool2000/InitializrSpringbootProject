package com.example.myCar.converter;

import org.apache.commons.logging.LogFactory;

import java.util.List;
import org.apache.commons.logging.Log;


public abstract class Converter<M extends Object, E extends Object>{

    public abstract E modelToEntity(M m);
    public abstract M entityToModel(E e);
    public abstract List<E> modelsToEntities(List<M> m);
    public abstract List<M> entitiesToModels(List<E> e);
    protected Log log;
    public Converter() {
        this.log = LogFactory.getLog(getClass());
    }
}
