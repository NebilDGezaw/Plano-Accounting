package com.johndoe.accounting.service.repository;

import com.johndoe.accounting.service.clientType.Type;
import com.johndoe.accounting.service.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nebil on 11/30/18.
 */
@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{
    List<Client> findByType(Type type);
}
