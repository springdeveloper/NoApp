package com.app.npr.model.lead;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.app.npr.dao.genric.JPAEntity;

@Entity
@Table(name="lead_source_master")
public class LeadSource extends JPAEntity<Serializable>{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="lead_source_gkey")
	private Integer id;
	@Column(name="led_source_name")
	private String source_name;
	@Column(name="lead_soure_description")
	private String source_description;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSource_name() {
		return source_name;
	}
	public void setSource_name(String source_name) {
		this.source_name = source_name;
	}
	public String getSource_description() {
		return source_description;
	}
	public void setSource_description(String source_description) {
		this.source_description = source_description;
	}
	
}
