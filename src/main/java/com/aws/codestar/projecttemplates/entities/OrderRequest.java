package com.aws.codestar.projecttemplates.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

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

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateTime = new Date(System.currentTimeMillis());

    @NotNull
    @ElementCollection(targetClass=Integer.class)
    private Set<Integer> disks = new HashSet<>();

    private String note;
}
