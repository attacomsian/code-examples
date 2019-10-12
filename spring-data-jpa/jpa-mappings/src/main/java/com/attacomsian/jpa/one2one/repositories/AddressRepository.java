package com.attacomsian.jpa.one2one.repositories;

import com.attacomsian.jpa.one2one.domains.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
