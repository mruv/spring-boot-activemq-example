
package com.mruv.activemqconf.domain.repository;

import com.mruv.activemqconf.domain.model.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser, Long>{
    // no redefination required
}
