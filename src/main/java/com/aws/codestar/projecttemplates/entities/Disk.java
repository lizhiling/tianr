package com.aws.codestar.projecttemplates.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
public class Disk {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private int id;

    @NotNull
    private String name;
    private String description;
    private String img;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY)
    @JoinTable(name = "disk_material",
            joinColumns = {
                    @JoinColumn(
                            name = "disk_id",
                            referencedColumnName = "id"
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "material_id",
                            referencedColumnName = "id"
                    )
            }
    )
    @JsonManagedReference
    @JsonBackReference
    @JsonIgnoreProperties("disks")
    private Set<Material> materials = new HashSet<>();
}
