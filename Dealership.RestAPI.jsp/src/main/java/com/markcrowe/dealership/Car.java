package com.markcrowe.dealership;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "car")
@NamedQueries(
		{
			@NamedQuery(name = "Car.findAll", query = "SELECT c FROM Car c"),
			@NamedQuery(name = "Car.findById", query = "SELECT c FROM Car c WHERE c.id = :id"),
			@NamedQuery(name = "Car.findByRegistrationNumber", query = "SELECT c FROM Car c WHERE c.registrationNumber = :registrationNumber"),
			@NamedQuery(name = "Car.findByValue", query = "SELECT c FROM Car c WHERE c.value = :value"),
			@NamedQuery(name = "Car.findByOwnerName", query = "SELECT c FROM Car c WHERE c.ownerName = :ownerName")
		})
public class Car implements Serializable
{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "Id")
	private Integer id;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "RegistrationNumber")
	private String registrationNumber;
	@Basic(optional = false)
	@NotNull
	@Column(name = "Value")
	private double value;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "OwnerName")
	private String ownerName;

	public Car()
	{
	}

	public Car(Integer id)
	{
		this.id = id;
	}

	public Car(Integer id, String registrationNumber, double value, String ownerName)
	{
		this.id = id;
		this.registrationNumber = registrationNumber;
		this.value = value;
		this.ownerName = ownerName;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getRegistrationNumber()
	{
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber)
	{
		this.registrationNumber = registrationNumber;
	}

	public double getValue()
	{
		return value;
	}

	public void setValue(double value)
	{
		this.value = value;
	}

	public String getOwnerName()
	{
		return ownerName;
	}

	public void setOwnerName(String ownerName)
	{
		this.ownerName = ownerName;
	}

	@Override
	public int hashCode()
	{
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object)
	{
		// TODO: Warning - this method won't work in the case the id fields are not set
		if(!(object instanceof Car))
		{
			return false;
		}
		Car other = (Car) object;
		if((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "com.markcrowe.dealership.Car[ id=" + id + " ]";
	}

}
