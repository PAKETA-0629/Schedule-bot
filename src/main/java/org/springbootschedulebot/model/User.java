package org.springbootschedulebot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private Long id;
    @Column(name = "user_name")
    private String name;
    @Nullable
    @Column(name = "state")
    private String state;
    @Nullable
    @Column(name = "stage")
    private Long stage;
}
