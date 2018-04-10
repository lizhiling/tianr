package com.aws.codestar.projecttemplates.repositories;

import com.aws.codestar.projecttemplates.entities.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface DiskMaterialRepository extends JpaRepository<Material, Integer> {

}
