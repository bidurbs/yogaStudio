
package com.saviour.poweryoga.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author TalakB 
 * @version 0.0.1
 */
@Entity
@Table(name = "FACULTY")

@NamedQueries({
    @NamedQuery(name = "Faculty.findAll", query = "from Faculty f")
})
public class Faculty extends Users implements Serializable{
    
    
}
