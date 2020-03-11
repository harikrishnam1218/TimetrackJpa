package com.hcl.swipe.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="timetrackaudit")
public class EmployeeTimeTrack {

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tid;
	
	@NotNull(message = "Name Should not be Null")
	private String name;
	
	private Date date ;
	
	private String status;
	
	private Date swipein;
	
	private Date swipeout;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="eid")
	private Employee employee;
	
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="date")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Column(name="status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name="swipein")
	public Date getSwipein() {
		return swipein;
	}
	public void setSwipein(Date swipein) {
		this.swipein = swipein;
	}
	@Column(name="swipeout")
	public Date getSwipeout() {
		return swipeout;
	}
	public void setSwipeout(Date swipeout) {
		this.swipeout = swipeout;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((swipein == null) ? 0 : swipein.hashCode());
		result = prime * result + ((swipeout == null) ? 0 : swipeout.hashCode());
		result = prime * result + tid;
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
		EmployeeTimeTrack other = (EmployeeTimeTrack) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (swipein == null) {
			if (other.swipein != null)
				return false;
		} else if (!swipein.equals(other.swipein))
			return false;
		if (swipeout == null) {
			if (other.swipeout != null)
				return false;
		} else if (!swipeout.equals(other.swipeout))
			return false;
		if (tid != other.tid)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "EmployeeTimeTrack [tid=" + tid + ", name=" + name + ", date=" + date + ", status=" + status
				+ ", swipein=" + swipein + ", swipeout=" + swipeout + ", employee=" + employee + "]";
	}
	

	}
