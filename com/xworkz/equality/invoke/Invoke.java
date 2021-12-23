package com.xworkz.equality.invoke;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.xworkz.equality.dto.CompanyDTO;
import com.xworkz.equality.dto.HockyDTO;
import com.xworkz.equality.dto.ProductDTO;



public class Invoke {

	public static void main(String[] args) {
		
		//HockyDTO
		HockyDTO hockyDTO=new HockyDTO("Ranchi Rhinos",24, 17, "Jharkhand");
		HockyDTO hockyDTO1=new HockyDTO("Delhi Waverides",29, 18, "Delhi");
		HockyDTO hockyDTO2=new HockyDTO("Ranchi Rays",50, 17, "Jharkhand");
		HockyDTO hockyDTO3=new HockyDTO("Ranchi Rhinos",30, 15, "Punjab");
		HockyDTO hockyDTO4=new HockyDTO("Kalinga Lancers",20, 30, "Odisha");
		
		Set<HockyDTO> hockyDTOs=new LinkedHashSet<HockyDTO>();
		hockyDTOs.add(hockyDTO4);
		hockyDTOs.add(hockyDTO3);
		hockyDTOs.add(hockyDTO);
		hockyDTOs.add(hockyDTO1);
		hockyDTOs.add(hockyDTO2);
		
		boolean hock=hockyDTO3.equals(hockyDTO);
		System.out.println(hock);
		Optional<HockyDTO> hocky=hockyDTOs.stream().filter((a)->a.getWins()>30).findFirst(); 
		System.out.println(hockyDTOs.size());
		System.out.println(hocky);
		System.out.println(System.lineSeparator());
		
		//ProductDTO
		ProductDTO productDTO=new ProductDTO(131, "Maruti Suzuki", "Alto", 314000.00,2);
		ProductDTO productDTO1=new ProductDTO(132, "Maruti Suzuki", "Celerio", 465700.00,2);
		ProductDTO productDTO2=new ProductDTO(133, "Nano", "CX",200000.00, 1);
		ProductDTO productDTO3=new ProductDTO(134, "Tata", "Tata Punch", 300000.00, 1);
		ProductDTO productDTO4=new ProductDTO(135, "Nano", "CX", 250000.00, 1);
		
		Set<ProductDTO> productDTOs=new LinkedHashSet<ProductDTO>();
		productDTOs.add(productDTO4);
		productDTOs.add(productDTO3);
		productDTOs.add(productDTO);
		productDTOs.add(productDTO1);
		productDTOs.add(productDTO2);
		
		boolean prod=productDTO2.equals(productDTO4);
		System.out.println(prod);
		Optional<ProductDTO> product=productDTOs.stream().filter((a)->a.getPrice()>300000.00).findFirst(); 
		System.out.println(productDTOs.size());
		System.out.println(product);
		System.out.println(System.lineSeparator());
		
		//CompanyDTO
		CompanyDTO companyDTO=new CompanyDTO(11, "KPIT", "Kishor Patil", 774300000);
		CompanyDTO companyDTO1=new CompanyDTO(12, "Cognizant", "Brain Humphries", 18500000);
		CompanyDTO companyDTO2=new CompanyDTO(13, "Capgemini", "Aiman Ezzat", 1584000000);
		CompanyDTO companyDTO3=new CompanyDTO(14, "Accenture", "Julie Sweet", 505300000);
		
		Set<CompanyDTO> companyDTOs=new LinkedHashSet<CompanyDTO>();
		companyDTOs.add(companyDTO3);
		companyDTOs.add(companyDTO);
		companyDTOs.add(companyDTO1);
		companyDTOs.add(companyDTO2);
		
		boolean comp=companyDTO2.equals(productDTO4);
		System.out.println(comp);
		Optional<CompanyDTO> company=companyDTOs.stream().filter((a)->a.getTurnOver()>18500000).findFirst(); 
		System.out.println(companyDTOs.size());
		System.out.println(company);
		System.out.println(System.lineSeparator());
	
	}
}
