package com.abhishek.ems.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleId implements Serializable {

    private Long userId;
    private Long roleId;

    // Constructors, Getters, Setters, hashCode, and equals
}
