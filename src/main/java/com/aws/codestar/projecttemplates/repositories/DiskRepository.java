package com.aws.codestar.projecttemplates.repositories;

import com.aws.codestar.projecttemplates.entities.Disk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Set;

@Transactional
@Repository
public interface DiskRepository extends JpaRepository<Disk, Integer> {
    Set<Disk> getDisksByIdIn(Set<Integer> ids);
}
