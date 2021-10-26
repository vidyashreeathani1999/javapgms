package com.xworkz.hospitalapp.dto;

public class AddressDTO {

	private int addressId;
	private String addressName;
	private CountryDTO country;
	

	public void setAddressId(int addressId){
		this.addressId=addressId;
		}

		public int getAddressId(){
		return addressId;
		}

		public void setAddressName(String addressName){
		this.addressName=addressName;
		}

		public String getAddressName(){
		return addressName;
		}
		
		public void setCountry(CountryDTO country){
			this.country=country;
			}

			public CountryDTO getCountry(){
			return country;
			}
		
    @Override
    public String toString() {
    	return "AddressDTO-{addressId="+this.addressId+", addressName="+this.addressName+",country="+this.country+"}";
    }
    }
