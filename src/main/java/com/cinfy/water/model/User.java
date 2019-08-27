/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cinfy.water.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author j.pathak
 */
@Entity
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "password")
    private String password;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name = "updated_by")
    private Integer updatedBy;
      
    
    @Column(name = "device_token")
    private String deviceToken;
    
    @Column(name = "path")
    private String path;
    
    @Column(name = "deleted")
    private Boolean deleted;
    
    @Transient
    MultipartFile fileAttachment; 
 
    @JoinColumn(name = "circle_id", referencedColumnName = "id")
    @ManyToOne
    private MCircle circleId;
    
    @JoinColumn(name = "designation_id", referencedColumnName = "id")
    @ManyToOne
    private MDesignation designationId;
    
    @JoinColumn(name = "division_id", referencedColumnName = "id")
    @ManyToOne
    private MDivision divisionId;
    
    @JoinColumn(name = "lavel_id", referencedColumnName = "id")
    @ManyToOne
    private MUserLavel lavelId;

    @JsonIgnore
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    @ManyToOne
    private User parentId;
    
    @JoinColumn(name = "role", referencedColumnName = "id")
    @ManyToOne
    private MRole role;

    @JsonIgnore
    @JoinColumn(name = "supervisor_id", referencedColumnName = "id")
    @ManyToOne
    private User supervisorId;
    
    @JoinColumn(name = "systems_admin_type_id", referencedColumnName = "id")
    @ManyToOne
    private SystemsAdminType systemsAdminTypeId;
    
    @JoinColumn(name = "zone_id", referencedColumnName = "id")
    @ManyToOne
    private MZone zoneId;
    
    

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public MultipartFile getFileAttachment() {
		return fileAttachment;
	}

	public void setFileAttachment(MultipartFile fileAttachment) {
		this.fileAttachment = fileAttachment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public MCircle getCircleId() {
		return circleId;
	}

	public void setCircleId(MCircle circleId) {
		this.circleId = circleId;
	}

	public MDesignation getDesignationId() {
		return designationId;
	}

	public void setDesignationId(MDesignation designationId) {
		this.designationId = designationId;
	}

	public MDivision getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(MDivision divisionId) {
		this.divisionId = divisionId;
	}

	public MUserLavel getLavelId() {
		return lavelId;
	}

	public void setLavelId(MUserLavel lavelId) {
		this.lavelId = lavelId;
	}

	public User getParentId() {
		return parentId;
	}

	public void setParentId(User parentId) {
		this.parentId = parentId;
	}

	public MRole getRole() {
		return role;
	}

	public void setRole(MRole role) {
		this.role = role;
	}

	public User getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(User supervisorId) {
		this.supervisorId = supervisorId;
	}

	public SystemsAdminType getSystemsAdminTypeId() {
		return systemsAdminTypeId;
	}

	public void setSystemsAdminTypeId(SystemsAdminType systemsAdminTypeId) {
		this.systemsAdminTypeId = systemsAdminTypeId;
	}

	public MZone getZoneId() {
		return zoneId;
	}

	public void setZoneId(MZone zoneId) {
		this.zoneId = zoneId;
	}

   
    
}
