package com.soin.sgrm.utils;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

public class JsonSheet<E> implements Serializable{
	
	private int draw;
	private int recordsTotal;
	private int recordsFiltered;
	private List<E> data;
	
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public int getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public List<E> getData() {
		return data;
	}
	public void setData(List<E>data) {
		this.data = data;
	}
	
}
