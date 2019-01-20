package cn.wilmar.hrmdemo.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Department {
    //    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "depart_name")
    private String departName;
    @Column(name = "depart_code")
    private String departCode;
    @Column(name = "create_time")
    private Date createTime;

    @Override
    public String toString() {
        return "DepartmentRepository{" +
                "id=" + id +
                ", departName='" + departName + '\'' +
                ", departCode='" + departCode + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
