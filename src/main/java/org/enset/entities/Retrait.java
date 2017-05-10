package org.enset.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

@Entity
@DiscriminatorValue("R")
@XmlType()
public class Retrait extends Operation{

}
