
package com.saviour.poweryoga.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author TalakB 
 * @version 0.0.1
 */
@Entity
@Table(name = "ADMIN")
public class Admin extends User implements Serializable{
    
    
}