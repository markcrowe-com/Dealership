/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */

package com.markcrowe.dealership;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "guest")
@NamedQueries(
{
	@NamedQuery(name = "Guest.findAll", query = "SELECT g FROM Guest g"),
	@NamedQuery(name = "Guest.findByGuestId", query = "SELECT g FROM Guest g WHERE g.guestId = :guestId"),
	@NamedQuery(name = "Guest.findByGuestFname", query = "SELECT g FROM Guest g WHERE g.guestFname = :guestFname"),
	@NamedQuery(name = "Guest.findByGuestLname", query = "SELECT g FROM Guest g WHERE g.guestLname = :guestLname"),
	@NamedQuery(name = "Guest.findByGuestPhoneNum", query = "SELECT g FROM Guest g WHERE g.guestPhoneNum = :guestPhoneNum"),
	@NamedQuery(name = "Guest.findByGuestRoomNum", query = "SELECT g FROM Guest g WHERE g.guestRoomNum = :guestRoomNum")
})
public class Guest implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "guestId")
	private Integer guestId;
	@Size(max = 45)
    @Column(name = "guestFname")
	private String guestFname;
	@Size(max = 45)
    @Column(name = "guestLname")
	private String guestLname;
	@Size(max = 45)
    @Column(name = "guestPhoneNum")
	private String guestPhoneNum;
	@Column(name = "guestRoomNum")
	private Integer guestRoomNum;
	public Guest()
	{
	}
	public Guest(Integer guestId)
	{
		this.guestId = guestId;
	}
	public Integer getGuestId()
	{
		return guestId;
	}
	public void setGuestId(Integer guestId)
	{
		this.guestId = guestId;
	}
	public String getGuestFname()
	{
		return guestFname;
	}
	public void setGuestFname(String guestFname)
	{
		this.guestFname = guestFname;
	}
	public String getGuestLname()
	{
		return guestLname;
	}
	public void setGuestLname(String guestLname)
	{
		this.guestLname = guestLname;
	}
	public String getGuestPhoneNum()
	{
		return guestPhoneNum;
	}
	public void setGuestPhoneNum(String guestPhoneNum)
	{
		this.guestPhoneNum = guestPhoneNum;
	}
	public Integer getGuestRoomNum()
	{
		return guestRoomNum;
	}
	public void setGuestRoomNum(Integer guestRoomNum)
	{
		this.guestRoomNum = guestRoomNum;
	}
	@Override
	public int hashCode()
	{
		int hash = 0;
		hash += (guestId != null ? guestId.hashCode() : 0);
		return hash;
	}
	@Override
	public boolean equals(Object object)
	{
		// TODO: Warning - this method won't work in the case the id fields are not set
		if(!(object instanceof Guest))
		{
			return false;
		}
		Guest other = (Guest) object;
		if((this.guestId == null && other.guestId != null) || (this.guestId != null && !this.guestId.equals(other.guestId)))
		{
			return false;
		}
		return true;
	}
	@Override
	public String toString()
	{
		return "com.markcrowe.dealership.Guest[ guestId=" + guestId + " ]";
	}

}