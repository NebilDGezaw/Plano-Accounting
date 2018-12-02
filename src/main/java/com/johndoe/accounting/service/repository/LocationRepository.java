package com.johndoe.accounting.service.repository;

import com.johndoe.accounting.service.model.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nebil on 11/30/18.
 */
@Repository
public interface LocationRepository extends CrudRepository<Location, Long>{
}
