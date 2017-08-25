package com.nytimes.star;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StarApplication implements ApplicationRunner{
	
	@Value("${planet.number}")
	private int planetNumber;
	public static void main(String[] args) {
		SpringApplication.run(StarApplication.class, args);
	}
	
	@Value("${planet.name}")
	private static String planetName;
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		System.out.println("about to readCSV");
		readCSV();
	}
	
	public void readCSV() throws FileNotFoundException, IOException {
        LinkedList<Point3D> points = new LinkedList<Point3D>();
        //BufferedReader br = new BufferedReader(new FileReader(planetName));
        BufferedReader br = new BufferedReader(new FileReader("/home/s/Downloads/HYG-Database-master/prac.csv"));     String line = br.readLine(); // Reading header, Ignoring
        int xPosition =18;
        int yPosition =19;
        int zPosition =20;
        BigDecimal longestDistance = new BigDecimal( Integer.MAX_VALUE);
        System.out.println("Its running");
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            String[] fields = line.split(",");
            System.out.println("In while loops");
            Point3D point = new Point3D(new BigDecimal(fields[xPosition]), new BigDecimal(fields[yPosition]),new BigDecimal(fields[zPosition]));
            
            if (points.size()<5) {
            	 System.out.println("In if loops + " + point.toString());
            	points.add(point);
            }else if(point.getDistance().compareTo(longestDistance)<0) {
                System.out.println("In if loops + " + point.toString());
            	points.add(point);
            	Collections.sort(points);
            	points.removeLast();
            	longestDistance=points.getLast().getDistance();
            	System.out.println("In if loops");
            }
        }
        br.close();
        Arrays.stream(points.toArray()).forEach(System.out::println);
    }
}
