package com.mengyunzhi.javaee.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Klass")
public class Klass implements IdEntity {

	/**
	 *  班级
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name="idGenerator",strategy="native")
	@GeneratedValue(generator="idGenerator")
	private Long klassId;

	private String name;
	
	@ManyToOne
	@JoinColumn(name="teacherId")
	private Teacher teacher = new Teacher();
	
	public Long getKlassId() {
        return klassId;
    }

    public void setKlassId(Long klassId) {
        this.klassId = klassId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    
	public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
       
    public Long getTeacherId() {
        return (Long) this.teacher.getId();
    }
    
    public void setTeacherId(Long teacherId) {
        this.teacher.setId(teacherId);
    }

    public Klass() {

	}

    public Klass(String name, long teacherId) {
		this.name = name;
		this.teacher.setId(teacherId);
	}


	/**
	 * @see com.mengyunzhi.javaee.entity.IdEntity#getId()
	 */
	public Serializable getId() {
		return this.getKlassId();
	}


	/**
	 * @see com.mengyunzhi.javaee.entity.IdEntity#setId(java.io.Serializable)
	 */
	public void setId(Serializable id) {
	    this.setKlassId((Long) id); 
	}

    @Override
    public String toString() {
        return "Klass [klassId=" + klassId + ", name=" + name + ", teacher="
                + teacher + "]";
    }

}
