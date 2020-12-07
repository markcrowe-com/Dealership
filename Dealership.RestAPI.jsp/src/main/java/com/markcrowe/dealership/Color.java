package com.markcrowe.dealership;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "color")
@NamedQueries(
		{
			@NamedQuery(name = "Color.findAll", query = "SELECT c FROM Color c"),
			@NamedQuery(name = "Color.findById", query = "SELECT c FROM Color c WHERE c.id = :id"),
			@NamedQuery(name = "Color.findByName", query = "SELECT c FROM Color c WHERE c.name = :name")
		})
public class Color implements Serializable
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
	@Column(name = "Name")
	private String name;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "color")
	private Collection<CarModel> carModelCollection;

	public Color()
	{
	}

	public Color(Integer id)
	{
		this.id = id;
	}

	public Color(Integer id, String name)
	{
		this.id = id;
		this.name = name;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Collection<CarModel> getCarModelCollection()
	{
		return carModelCollection;
	}

	public void setCarModelCollection(Collection<CarModel> carModelCollection)
	{
		this.carModelCollection = carModelCollection;
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
		if(!(object instanceof Color))
		{
			return false;
		}
		Color other = (Color) object;
		if((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "com.markcrowe.dealership.Color[ id=" + id + " ]";
	}

}
