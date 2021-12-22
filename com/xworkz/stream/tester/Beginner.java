package com.xworkz.stream.tester;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.xworkz.stream.dto.CafeDTO;
import com.xworkz.stream.dto.HeadPhoneDTO;
import com.xworkz.stream.dto.RiverDTO;
import com.xworkz.stream.dto.TempleDTO;
import com.xworkz.stream.dto.ZooDTO;

public class Beginner {

	public static void main(String[] args) {
		
		//CafeDTO
		CafeDTO cafeDTO=new CafeDTO(1,"Maddys Katti","Rajajinagar",3.9f);
		CafeDTO cafeDTO1=new CafeDTO(2,"Shri Raghavendra","Navarang",4.4f);
		CafeDTO cafeDTO2=new CafeDTO(3,"Sri Shankar","Kuvempu Road",3.8f);
		CafeDTO cafeDTO3=new CafeDTO(4,"Burnout","Infsntry Road",2.3f);
		CafeDTO cafeDTO4=new CafeDTO(5,"Kaffee Klatsch","Rajarathnam Road",4.9f);
		
		System.out.println("Cafe Details");
		Stream<CafeDTO> cafeDTOs=Stream.of(cafeDTO,cafeDTO1,cafeDTO2,cafeDTO3,cafeDTO4);
		         cafeDTOs
				.filter((a)->a.getRating()>3)
				.sorted((p1,p2)->p2.getName().compareTo(p1.getName()))
				.collect(Collectors.toList()).forEach((a)->System.out.println(a));
		         System.out.println(System.lineSeparator());
	
		
		         
		//ZooDTO
		ZooDTO zooDTO=new ZooDTO(41,"Sri Chamarajendra Zoological Gardens","Mysuru",0);
		ZooDTO zooDTO1=new ZooDTO(42,"Shimoga Zoo & Safari","Thevara Koppa",0);
		ZooDTO zooDTO2=new ZooDTO(43,"Government Aquarium","Bengaluru",10);
		ZooDTO zooDTO3=new ZooDTO(44,"Kudremukh Mini Zoo","India",200);
		ZooDTO zooDTO4=new ZooDTO(45,"Bannerghatta Biological Park","Bengaluru",100);
		
		System.out.println("Zoo Details");
		
		Stream<ZooDTO> zooDTOs=Stream.of(zooDTO,zooDTO1,zooDTO2,zooDTO3,zooDTO4);	
		         zooDTOs
				.sorted((p1,p2)->p2.getTicketPrice().compareTo(p1.getTicketPrice()))
				.collect(Collectors.toList()).forEach((a)->System.out.println(a));
		         System.out.println(System.lineSeparator());
		     	
		
		//HeadPhoneDTO
		HeadPhoneDTO headPhoneDTO=new HeadPhoneDTO(11,"Philips","Wired","shb8750nc", 399);
		HeadPhoneDTO headPhoneDTO1=new HeadPhoneDTO(12,"Boat","Wireless","rokerz 510", 599);
		HeadPhoneDTO headPhoneDTO2=new HeadPhoneDTO(13,"OnePlus buds","Wireless","1091100041 type-c", 2995);
		HeadPhoneDTO headPhoneDTO3=new HeadPhoneDTO(14,"Noise Unisex Blue Solid","Wireless","VS103", 1499);
		HeadPhoneDTO headPhoneDTO4=new HeadPhoneDTO(15,"Apple","Wireless","Apple Airpods 2", 1199);
		System.out.println("HeadPhone Details");
		
		Stream<HeadPhoneDTO> headPhoneDTOs=Stream.of(headPhoneDTO,headPhoneDTO1,headPhoneDTO2,headPhoneDTO3,headPhoneDTO4);	
		 headPhoneDTOs
				.sorted((p1,p2)->p1.getId().compareTo(p2.getId()))
				.collect(Collectors.toList()).forEach((a)->System.out.println(a));
		 
		System.out.println("Collect only model");
		 Stream<HeadPhoneDTO> headPhoneDTOs1=Stream.of(headPhoneDTO,headPhoneDTO1,headPhoneDTO2,headPhoneDTO3,headPhoneDTO4);	
		 headPhoneDTOs1
				.sorted((p1,p2)->p1.getBrand().compareTo(p2.getBrand()))
				.map((e)->e.getModel())
				.collect(Collectors.toList()).forEach((a)->System.out.println(a));
		 System.out.println(System.lineSeparator());
		
		
		//RiverDTO
		RiverDTO riverDTO=new RiverDTO(31,"Kaveri","Karnataka",805,4);
		RiverDTO riverDTO1=new RiverDTO(32,"Ganges","Uttara Pradesh",2525,5);
		RiverDTO riverDTO2=new RiverDTO(33,"Krishna","Karnataka",1400,9);
		RiverDTO riverDTO3=new RiverDTO(34,"Tungabhadra","Karnataka",431,5);
		RiverDTO riverDTO4=new RiverDTO(35,"Yamuna","Uttara Pradesh",387,13);
		
		System.out.println("River Details");
		Stream<RiverDTO> riverDTOs=Stream.of(riverDTO,riverDTO1,riverDTO2,riverDTO3,riverDTO4);	
		 riverDTOs
				.filter((a)->a.getLength()>500)
				.sorted((a1,a2)->a2.getNoOfDams().compareTo(a1.getNoOfDams()))
				.collect(Collectors.toList()).forEach((a)->System.out.println(a));
		 
		 System.out.println("Ascending Order in dams");
		Stream<RiverDTO> riverDTOs1=Stream.of(riverDTO,riverDTO1,riverDTO2,riverDTO3,riverDTO4);	
		 riverDTOs1
				.sorted((a1,a2)->a1.getNoOfDams().compareTo(a2.getNoOfDams()))
				.collect(Collectors.toList()).forEach((a)->System.out.println(a));
            System.out.println(System.lineSeparator());
		          
           
            
		//TempleDTO
		TempleDTO templeDTO=new TempleDTO(21,"Sree Virupaksha","Hampi","Shiva",14000);
		TempleDTO templeDTO1=new TempleDTO(22,"Brahma Jinalaya","Lakkundi","Mahavira", 12400);
		TempleDTO templeDTO2=new TempleDTO(23,"Sri Chamundeshwari","Mysore","Chamundeshwari", 9000);
		TempleDTO templeDTO3=new TempleDTO(24,"Shri Banashankari Shakti ","Badami","Shakambhari", 8000);
		TempleDTO templeDTO4=new TempleDTO(25,"Shree Renuka Yellamma Devi","Saundatti","Yellamma", 7000);
		
		System.out.println("Temple Details");
		Stream<TempleDTO> templeDTOs=Stream.of(templeDTO,templeDTO1,templeDTO2,templeDTO3,templeDTO4);	
		
		templeDTOs
		.filter((a)->a.getVisitorsPerDay()>10000)
		.sorted((a1,a2)->a2.getVisitorsPerDay().compareTo(a1.getVisitorsPerDay()))
		.collect(Collectors.toList()).forEach((a)->System.out.println(a));
         System.out.println(System.lineSeparator());
	
    
	}

	
}
