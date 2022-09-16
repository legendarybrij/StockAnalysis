package com.brij.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity(name="stocks")
@Data
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String quarter;
	
	@Column
	private String stock;
	
	@Column
	private String date;
	
	@Column
	private String open;
	
	@Column
	private String high;
	
	@Column
	private String low;
	
	@Column
	private String close;
	
	@Column
	private String volume;
	
	@Column
	private String percent_change_price;
	
	@Column
	private String percent_change_volume_over_last_wk;
	
	@Column
	private String previous_weeks_volume;
	
	@Column
	private String next_weeks_open;
	
	@Column
	private String next_weeks_close;
	
	@Column
	private String percent_change_next_weeks_price;
	
	@Column
	private String days_to_next_dividend;
	
	@Column
	private String percent_return_next_dividend;

	public Stock(String quarter, String stock, String date, String open, String high, String low, String close,
			String volume, String percent_change_price, String percent_change_volume_over_last_wk,
			String previous_weeks_volume, String next_weeks_open, String next_weeks_close,
			String percent_change_next_weeks_price, String days_to_next_dividend, String percent_return_next_dividend) {
		super();
		this.quarter = quarter;
		this.stock = stock;
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.percent_change_price = percent_change_price;
		this.percent_change_volume_over_last_wk = percent_change_volume_over_last_wk;
		this.previous_weeks_volume = previous_weeks_volume;
		this.next_weeks_open = next_weeks_open;
		this.next_weeks_close = next_weeks_close;
		this.percent_change_next_weeks_price = percent_change_next_weeks_price;
		this.days_to_next_dividend = days_to_next_dividend;
		this.percent_return_next_dividend = percent_return_next_dividend;
	}

	public Stock(int id, String quarter, String stock, String date, String open, String high, String low, String close,
			String volume, String percent_change_price, String percent_change_volume_over_last_wk,
			String previous_weeks_volume, String next_weeks_open, String next_weeks_close,
			String percent_change_next_weeks_price, String days_to_next_dividend, String percent_return_next_dividend) {
		super();
		this.id = id;
		this.quarter = quarter;
		this.stock = stock;
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.percent_change_price = percent_change_price;
		this.percent_change_volume_over_last_wk = percent_change_volume_over_last_wk;
		this.previous_weeks_volume = previous_weeks_volume;
		this.next_weeks_open = next_weeks_open;
		this.next_weeks_close = next_weeks_close;
		this.percent_change_next_weeks_price = percent_change_next_weeks_price;
		this.days_to_next_dividend = days_to_next_dividend;
		this.percent_return_next_dividend = percent_return_next_dividend;
	}

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getPercent_change_price() {
		return percent_change_price;
	}

	public void setPercent_change_price(String percent_change_price) {
		this.percent_change_price = percent_change_price;
	}

	public String getPercent_change_volume_over_last_wk() {
		return percent_change_volume_over_last_wk;
	}

	public void setPercent_change_volume_over_last_wk(String percent_change_volume_over_last_wk) {
		this.percent_change_volume_over_last_wk = percent_change_volume_over_last_wk;
	}

	public String getPrevious_weeks_volume() {
		return previous_weeks_volume;
	}

	public void setPrevious_weeks_volume(String previous_weeks_volume) {
		this.previous_weeks_volume = previous_weeks_volume;
	}

	public String getNext_weeks_open() {
		return next_weeks_open;
	}

	public void setNext_weeks_open(String next_weeks_open) {
		this.next_weeks_open = next_weeks_open;
	}

	public String getNext_weeks_close() {
		return next_weeks_close;
	}

	public void setNext_weeks_close(String next_weeks_close) {
		this.next_weeks_close = next_weeks_close;
	}

	public String getPercent_change_next_weeks_price() {
		return percent_change_next_weeks_price;
	}

	public void setPercent_change_next_weeks_price(String percent_change_next_weeks_price) {
		this.percent_change_next_weeks_price = percent_change_next_weeks_price;
	}

	public String getDays_to_next_dividend() {
		return days_to_next_dividend;
	}

	public void setDays_to_next_dividend(String days_to_next_dividend) {
		this.days_to_next_dividend = days_to_next_dividend;
	}

	public String getPercent_return_next_dividend() {
		return percent_return_next_dividend;
	}

	public void setPercent_return_next_dividend(String percent_return_next_dividend) {
		this.percent_return_next_dividend = percent_return_next_dividend;
	}

	@Override
	public String toString() {
		return "Stock [quarter=" + quarter + ", stock=" + stock + ", date=" + date + ", open=" + open
				+ ", high=" + high + ", low=" + low + ", close=" + close + ", volume=" + volume
				+ ", percent_change_price=" + percent_change_price + ", percent_change_volume_over_last_wk="
				+ percent_change_volume_over_last_wk + ", previous_weeks_volume=" + previous_weeks_volume
				+ ", next_weeks_open=" + next_weeks_open + ", next_weeks_close=" + next_weeks_close
				+ ", percent_change_next_weeks_price=" + percent_change_next_weeks_price + ", days_to_next_dividend="
				+ days_to_next_dividend + ", percent_return_next_dividend=" + percent_return_next_dividend + "]";
	}

	
	
}
