/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.businesslogic.model;

import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author simonicsanett
 */
@XmlSeeAlso({Operator.class, Administrator.class, CrewMember.class})
public abstract class Employee extends User {
    
}
