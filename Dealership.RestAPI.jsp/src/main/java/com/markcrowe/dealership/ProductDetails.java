/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */

package com.markcrowe.dealership;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "productdetails")
@NamedQueries(
{
	@NamedQuery(name = "ProductDetails.findAll", query = "SELECT p FROM ProductDetails p"),
	@NamedQuery(name = "ProductDetails.findByProductId", query = "SELECT p FROM ProductDetails p WHERE p.productId = :productId"),
	@NamedQuery(name = "ProductDetails.findByProduct", query = "SELECT p FROM ProductDetails p WHERE p.product = :product"),
	@NamedQuery(name = "ProductDetails.findByBrand", query = "SELECT p FROM ProductDetails p WHERE p.brand = :brand"),
	@NamedQuery(name = "ProductDetails.findByDateTime", query = "SELECT p FROM ProductDetails p WHERE p.dateTime = :dateTime"),
	@NamedQuery(name = "ProductDetails.findByUserID", query = "SELECT p FROM ProductDetails p WHERE p.userID = :userID")
})
public class ProductDetails implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "productId")
	private Integer productId;
	@Size(max = 45)
    @Column(name = "product")
	private String product;
	@Size(max = 45)
    @Column(name = "brand")
	private String brand;
	@Column(name = "dateTime")
    @Temporal(TemporalType.DATE)
	private Date dateTime;
	@Column(name = "userID")
	private Integer userID;
	public ProductDetails()
	{
	}
	public ProductDetails(Integer productId)
	{
		this.productId = productId;
	}
	public Integer getProductId()
	{
		return productId;
	}
	public void setProductId(Integer productId)
	{
		this.productId = productId;
	}
	public String getProduct()
	{
		return product;
	}
	public void setProduct(String product)
	{
		this.product = product;
	}
	public String getBrand()
	{
		return brand;
	}
	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	public Date getDateTime()
	{
		return dateTime;
	}
	public void setDateTime(Date dateTime)
	{
		this.dateTime = dateTime;
	}
	public Integer getUserID()
	{
		return userID;
	}
	public void setUserID(Integer userID)
	{
		this.userID = userID;
	}
	@Override
	public int hashCode()
	{
		int hash = 0;
		hash += (productId != null ? productId.hashCode() : 0);
		return hash;
	}
	@Override
	public boolean equals(Object object)
	{
		// TODO: Warning - this method won't work in the case the id fields are not set
		if(!(object instanceof ProductDetails))
		{
			return false;
		}
		ProductDetails other = (ProductDetails) object;
		if((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId)))
		{
			return false;
		}
		return true;
	}
	@Override
	public String toString()
	{
		return "com.markcrowe.dealership.ProductDetails[ productId=" + productId + " ]";
	}

}