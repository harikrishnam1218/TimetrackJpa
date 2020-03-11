package com.hcl.swipe.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="employee")
public class Employee {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eid;
	
	private String name;
	
	private String onboardloc;
	
	private String designation;
	
	private Date onboarddate;
	
	private String role;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "employee",cascade =CascadeType.ALL)

	private List<EmployeeTimeTrack> tracks = new ArrayList<EmployeeTimeTrack>();
	
	//@JoinColumn
	public List<EmployeeTimeTrack> getTracks() {
		return tracks;
	}
	public void setTracks(List<EmployeeTimeTrack> tracks) {
		this.tracks = tracks;
	}
	public Long getEid() {
		return eid;
	}
	public void setEid(Long eid) {
		this.eid = eid;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="onboardloc")
	public String getOnboardloc() {
		return onboardloc;
	}
	public void setOnboardloc(String onboardloc) {
		this.onboardloc = onboardloc;
	}
	@Column(name="designation")
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Column(name="onboarddate")
	public Date getOnboarddate() {
		return onboarddate;
	}
	public void setOnboarddate(Date onboarddate) {
		this.onboarddate = onboarddate;
	}
	@Column(name="role")
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	/*
	 * @OneToMany(fetch = FetchType.LAZY,mappedBy = "employee",cascade =
	 * CascadeType.ALL) public List<EmployeeTimeTrack> getEmployeeTimeTracks() {
	 * return employeeTimeTracks; } public void
	 * setEmployeeTimeTracks(List<EmployeeTimeTrack> employeeTimeTracks) {
	 * this.employeeTimeTracks = employeeTimeTracks; }
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
		//result = prime * result + ((employeeTimeTracks == null) ? 0 : employeeTimeTracks.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((onboarddate == null) ? 0 : onboarddate.hashCode());
		result = prime * result + ((onboardloc == null) ? 0 : onboardloc.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		/*
		 * if (employeeTimeTracks == null) { if (other.employeeTimeTracks != null)
		 * return false; } else if
		 * (!employeeTimeTracks.equals(other.employeeTimeTracks)) return false;
		 */
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (onboarddate == null) {
			if (other.onboarddate != null)
				return false;
		} else if (!onboarddate.equals(other.onboarddate))
			return false;
		if (onboardloc == null) {
			if (other.onboardloc != null)
				return false;
		} else if (!onboardloc.equals(other.onboardloc))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", onboardloc=" + onboardloc + ", designation=" + designation
				+ ", onboarddate=" + onboarddate + ", role=" + role + "]";
	}
	
	
	
}
