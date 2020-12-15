package ru.dolinini.SimpleDB.Dao;

import java.util.List;

public interface Dao <R> {

    public R findById(int id);
    public List<R> findAll();
    public void update(R r);
    public void save(R r);
    public void delete(R r);


}
