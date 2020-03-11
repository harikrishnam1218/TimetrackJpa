package com.hcl.swipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.swipe.model.EmployeeTimeTrack;
@Repository
public interface TimeTrackAuditRepo extends JpaRepository<EmployeeTimeTrack, Long>{

}
