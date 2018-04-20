package com.aws.codestar.projecttemplates.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"material_id", "order_request_id"})
})
public class ToBuyMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "material_id")
    private Material material;

    @ManyToOne
    @JoinColumn(name="order_request_id")
    private OrderRequest orderRequest;

    // additional fields
    private boolean bought;
    private int amount;
}

