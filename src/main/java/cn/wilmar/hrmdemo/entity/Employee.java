package cn.wilmar.hrmdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class Employee {
    //    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "employee_name")
    private String employeeName;
    @Column(name = "job_num")
    private String jobNum;
    @Column(name = "entry_time")
    private Date entryTime;
    private BigDecimal salary;
        @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "department_id")
//    @JsonIgnoreProperties("employees")
    private Department department;
    @ManyToOne
    @JsonIgnoreProperties("employees")
    private Job job;
    private String boss;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeName='" + employeeName + '\'' +
                ", jobNum='" + jobNum + '\'' +
                ", entryTime=" + entryTime +
                ", salary=" + salary +
                ", department=" + department +
                ", boss='" + boss + '\'' +
                '}';
    }
}
