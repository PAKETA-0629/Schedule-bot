package org.springbootschedulebot.model;

import com.vladmihalcea.hibernate.type.array.ListArrayType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@TypeDef(name = "list-array", typeClass = ListArrayType.class)
@javax.persistence.Table(name = "custom_schedule")
@NoArgsConstructor
@AllArgsConstructor
public class Table {

    @Id
    private Long id;
    @Column(name = "table_name")
    private String name;
    @Type(type = "list-array")
    @Column(name = "names", columnDefinition = "data[]")
    private List<String> names;
    @Type(type = "list-array")
    @Column(name = "keys", columnDefinition = "data[]")
    private List<String> keys;
    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "id")
    private User user;
}
