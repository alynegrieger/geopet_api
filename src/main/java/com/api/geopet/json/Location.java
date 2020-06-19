package com.api.geopet.json;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location implements Serializable {

	private static final long serialVersionUID = -6474523098271357888L;

	@Column(name = "lat")
	private String lat;

	@Column(name = "lng")
	private String lng;

}
