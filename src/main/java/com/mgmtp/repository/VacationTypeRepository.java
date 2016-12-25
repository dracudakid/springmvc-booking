package com.mgmtp.repository;

import com.mgmtp.model.VacationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationTypeRepository extends JpaRepository<VacationType, Integer> {
}
