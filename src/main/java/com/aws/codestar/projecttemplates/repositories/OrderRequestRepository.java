package com.aws.codestar.projecttemplates.repositories;

import com.aws.codestar.projecttemplates.entities.OrderRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Transactional
@Repository
public interface OrderRequestRepository extends JpaRepository<OrderRequest, UUID> {

}
