package com.itheima.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@ToString
public class Emp implements Serializable {
    private int epno;
    private String ename;
    private String job;
    private int mgr;
    private Date bir;
    private double sal;
    private double comm;
    private int depo;
}
