package com.aws.codestar.projecttemplates.repositories;

import com.aws.codestar.projecttemplates.entities.Material;
import com.aws.codestar.projecttemplates.entities.OrderRequest;
import com.aws.codestar.projecttemplates.entities.ToBuyMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ToBuyMaterialRepository extends JpaRepository<ToBuyMaterial, Long> {
    ToBuyMaterial getByOrderRequestAndMaterial(OrderRequest orderRequest, Material material);
}
