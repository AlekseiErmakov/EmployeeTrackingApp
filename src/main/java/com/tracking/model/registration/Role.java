package com.tracking.model.registration;

import com.tracking.model.tabel.AbstractEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "app_role")
@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
public class Role extends AbstractEntity implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_role_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    @Transient
    private Set<AppUser> users = new HashSet<>();

    @Override
    public String getAuthority() {
        return name;
    }
}
