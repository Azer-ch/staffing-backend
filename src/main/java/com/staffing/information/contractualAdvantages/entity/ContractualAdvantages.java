package com.staffing.information.contractualAdvantages.entity;

import com.staffing.information.param.entity.Param;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contractual_advantages")
public class ContractualAdvantages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Param> paramList = new ArrayList<>();

    public ContractualAdvantages() {
    }

    public ContractualAdvantages(List<Param> paramList) {
        this.paramList = paramList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Param> getParamList() {
        return paramList;
    }

    public void setParamList(List<Param> paramList) {
        this.paramList = paramList;
    }
    public void addParam(Param param) {
        this.paramList.add(param);
    }

    @Override
    public String toString() {
        return "ContractualAdvantages{" +
                "id=" + id +
                ", paramList=" + paramList +
                '}';
    }
}
