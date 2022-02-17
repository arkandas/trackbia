package com.arkandas.trackbiaback.models;

import javax.persistence.*;

@Entity
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private BRole name;

    public Role(){
        super();
    }

    public Role(BRole name){
        this.name = name;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public BRole getName(){
        return name;
    }

    public void setName(BRole name){
        this.name = name;
    }
}
