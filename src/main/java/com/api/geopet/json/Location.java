package com.api.geopet.json;

import java.io.Serializable;

import javax.persistence.Column;

public class Location implements Serializable {

	private static final long serialVersionUID = -6474523098271357888L;

	
	@Column(name="lat")
	private Integer lat;

	@Column(name="lng")
	private Integer lng;

	public Integer getLng() {
		return lng;
	}

	public Integer getLat() {
		return lat;
	}

	public void setLat(Integer lat) {
		this.lat = lat;
	}

	public void setLng(Integer lng) {
		this.lng = lng;
	}
}
