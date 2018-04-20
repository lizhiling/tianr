package com.aws.codestar.projecttemplates.repositories;

import com.aws.codestar.projecttemplates.entities.Disk;
import com.aws.codestar.projecttemplates.entities.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Transactional
@Repository
public interface DiskMaterialRepository extends JpaRepository<Material, Integer> {
    List<Material> getMaterialsByDisksIn(Set<Disk> disks);
}
