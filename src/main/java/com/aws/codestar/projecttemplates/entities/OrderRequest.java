package com.aws.codestar.projecttemplates.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    public enum OrderType{
        Breakfast, Lunch, Dinner
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(unique = true, updatable = false, nullable = false)
    private UUID id;

    @NotNull
    private OrderType ordertype;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date lastUpdateTime;

    @NotNull
    @ElementCollection(targetClass=Integer.class)
    private Set<Integer> disks = new HashSet<>();

    private String note;


    @OneToMany( mappedBy = "orderRequest", orphanRemoval = true,
            targetEntity = ToBuyMaterial.class, cascade = { CascadeType.ALL })
    @JsonManagedReference
    @JsonBackReference
    private List<ToBuyMaterial> materials = new LinkedList<>();
}
