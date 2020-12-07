package ie.walshmedia.dealership;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "bodytype")
@NamedQueries(
		{
			@NamedQuery(name = "BodyType.findAll", query = "SELECT b FROM BodyType b"),
			@NamedQuery(name = "BodyType.findById", query = "SELECT b FROM BodyType b WHERE b.id = :id"),
			@NamedQuery(name = "BodyType.findByName", query = "SELECT b FROM BodyType b WHERE b.name = :name")
		})
public class BodyType implements Serializable
{

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "Id")
	private Integer id;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "Name")
	private String name;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "bodyType")
	private Collection<CarModel> carModelCollection;

	public BodyType()
	{
	}

	public BodyType(Integer id)
	{
		this.id = id;
	}

	public BodyType(Integer id, String name)
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
		if(!(object instanceof BodyType))
		{
			return false;
		}
		BodyType other = (BodyType) object;
		if((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "ie.walshmedia.dealership.BodyType[ id=" + id + " ]";
	}

}
