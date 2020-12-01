/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.walshmedia.dealership;

import java.io.Serializable;
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
import javax.validation.constraints.Size;

/**
 *
 * @author Keith
 */
@Entity
@Table(name = "carmodel")
@NamedQueries(
{
    @NamedQuery(name = "CarModel.findAll", query = "SELECT c FROM CarModel c"),
    @NamedQuery(name = "CarModel.findById", query = "SELECT c FROM CarModel c WHERE c.id = :id"),
    @NamedQuery(name = "CarModel.findByPrice", query = "SELECT c FROM CarModel c WHERE c.price = :price"),
    @NamedQuery(name = "CarModel.findByName", query = "SELECT c FROM CarModel c WHERE c.name = :name"),
    @NamedQuery(name = "CarModel.findByEngineLitres", query = "SELECT c FROM CarModel c WHERE c.engineLitres = :engineLitres")
})
public class CarModel implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Price")
    private Double price;
    @Size(max = 45)
    @Column(name = "Name")
    private String name;
    @Column(name = "EngineLitres")
    private Double engineLitres;
    @JoinColumn(name = "BodyType", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private BodyType bodyType;
    @JoinColumn(name = "CarMaker", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private CarMaker carMaker;
    @JoinColumn(name = "Color", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Color color;

    public CarModel()
    {
    }

    public CarModel(Integer id)
    {
	this.id = id;
    }

    public Integer getId()
    {
	return id;
    }

    public void setId(Integer id)
    {
	this.id = id;
    }

    public Double getPrice()
    {
	return price;
    }

    public void setPrice(Double price)
    {
	this.price = price;
    }

    public String getName()
    {
	return name;
    }

    public void setName(String name)
    {
	this.name = name;
    }

    public Double getEngineLitres()
    {
	return engineLitres;
    }

    public void setEngineLitres(Double engineLitres)
    {
	this.engineLitres = engineLitres;
    }

    public BodyType getBodyType()
    {
	return bodyType;
    }

    public void setBodyType(BodyType bodyType)
    {
	this.bodyType = bodyType;
    }

    public CarMaker getCarMaker()
    {
	return carMaker;
    }

    public void setCarMaker(CarMaker carMaker)
    {
	this.carMaker = carMaker;
    }

    public Color getColor()
    {
	return color;
    }

    public void setColor(Color color)
    {
	this.color = color;
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
	if (!(object instanceof CarModel))
	{
	    return false;
	}
	CarModel other = (CarModel) object;
	if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
	{
	    return false;
	}
	return true;
    }

    @Override
    public String toString()
    {
	return "ie.walshmedia.dealership.CarModel[ id=" + id + " ]";
    }
    
}
