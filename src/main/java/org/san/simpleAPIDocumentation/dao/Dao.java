package org.san.simpleAPIDocumentation.dao;

import java.util.Collection;

public interface Dao <T>{
	void create(T ob);
    T read(Long id);
    void update(T ob);
    void delete(Long id);
    Collection<T> all();
}
