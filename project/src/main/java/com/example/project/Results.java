package com.example.project;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Consumer;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class Results {

	public static void main(String[] args) throws FileNotFoundException, IOException, CsvValidationException  
	{  

		Map<String, List<String>> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		list.add("0");
		map.put("1",list);
		map.put("2",list);
		map.put("3",list);
		map.put("4",list);
		map.put("5",list);
		Map<String, List<String>> map1 = new HashMap<>();
		List<String> list1 = new ArrayList<>();
		int num = Integer.MAX_VALUE;
		String str = Integer.toString(num);
		list1.add("str");
		map1.put("1",list);
		map1.put("2",list);
		map1.put("3",list);
		map1.put("4",list);
		map1.put("5",list);



		int game1_quant=0;
		int game2_quant=0;
		int game3_quant=0;
		int game4_quant=0;
		int game5_quant=0;

		int game1_sum=0;
		int game2_sum=0;
		int game3_sum=0;
		int game4_sum=0;
		int game5_sum=0;
//Reading the csv file and performing the aggregations

		try (CSVReader reader = new CSVReader(new FileReader("C:\\Users\\Sai Charan\\Desktop\\test.csv"))) {
			String[] lineInArray;

			while ((lineInArray = reader.readNext()) != null) {
				List<String> l = map.get(lineInArray[0]);
				if(Integer.parseInt(lineInArray[0])==1) {
					game1_quant++;
					game1_sum+=Integer.parseInt(lineInArray[3]);
				}else if(Integer.parseInt(lineInArray[0])==2) {
					game2_quant++;
					game2_sum+=Integer.parseInt(lineInArray[3]);
				}else if(Integer.parseInt(lineInArray[0])==3) {
					game3_quant++;
					game3_sum+=Integer.parseInt(lineInArray[3]);
				}else if(Integer.parseInt(lineInArray[0])==4) {
					game4_quant++;
					game4_sum+=Integer.parseInt(lineInArray[3]);
				}else if(Integer.parseInt(lineInArray[0])==5) {
					game5_quant++;
					game5_sum+=Integer.parseInt(lineInArray[3]);
				}
				if(Integer.parseInt(l.get(0))<Integer.parseInt(lineInArray[3])) {
					List<String> li = new ArrayList<String>();
					li.add(lineInArray[3]);
					li.add(lineInArray[1]);
					map.put(lineInArray[0],li);
				}else if(Integer.parseInt(l.get(0))>Integer.parseInt(lineInArray[3])) {
					List<String> li = new ArrayList<String>();
					li.add(lineInArray[3]);
					li.add(lineInArray[1]);
					map1.put(lineInArray[0],li);
				}
			}
			System.out.print("Top 5 players by points in each of the games are: ");
			System.out.println("\n");
			for(Map.Entry<String, List<String>> entry:map.entrySet()) {
				System.out.println("game_id: "+entry.getKey()+" player_id: "+entry.getValue().get(1)+" total_points: "+entry.getValue().get(0));
			}
			System.out.println("\n");
			System.out.println("Bottom  5 players by points in each of the games are: ");
			System.out.println("\n");
			for(Map.Entry<String, List<String>> entry:map1.entrySet()) {
				System.out.println("game_id: "+entry.getKey()+" player_id: "+entry.getValue().get(1)+" total_points: "+entry.getValue().get(0));
			}

		}
		double game1_avg=game1_sum/game1_quant;
		double game2_avg=game2_sum/game2_quant;
		double game3_avg=game3_sum/game3_quant;
		double game4_avg=game4_sum/game4_quant;
		double game5_avg=game5_sum/game5_quant;
		System.out.println("\nTop 5 players in each game whose total points in a game is "
				+ "greater than the average of all players points of that game are :");
		System.out.println("\n");
		try (CSVReader reader = new CSVReader(new FileReader("C:\\Users\\Sai Charan\\Desktop\\test.csv")))
		{
			String[] lineInArray;
			List<String[]> toplist= new ArrayList<>();
			Map<String, List<String>> topplayers = new HashMap<>();
//			Using MaxHeap of size 5 to store tp 5 players in each game whose total points in 
//			a game is greater than the average of all players points of that game
			PriorityQueue<String[]> maxHeap1 = new PriorityQueue<>((a,b)->Integer.compare(Integer.parseInt(a[2]),
					Integer.parseInt(b[2])));
			PriorityQueue<String[]> maxHeap2 = new PriorityQueue<>((a,b)->Integer.compare(Integer.parseInt(a[2]),
					Integer.parseInt(b[2])));
			PriorityQueue<String[]> maxHeap3 = new PriorityQueue<>((a,b)->Integer.compare(Integer.parseInt(a[2]),
					Integer.parseInt(b[2])));
			PriorityQueue<String[]> maxHeap4 = new PriorityQueue<>((a,b)->Integer.compare(Integer.parseInt(a[2]),
					Integer.parseInt(b[2])));
			PriorityQueue<String[]> maxHeap5 = new PriorityQueue<>((a,b)->Integer.compare(Integer.parseInt(a[2]),
					Integer.parseInt(b[2])));
			while ((lineInArray = reader.readNext()) != null) {
				if(Integer.parseInt(lineInArray[0])==1) {
					if(Integer.parseInt(lineInArray[3])>game1_avg) {
						
						List<String> l= new ArrayList<>();
						l.add(lineInArray[0]);
						l.add(lineInArray[3]);
						String[] strs = {lineInArray[0],lineInArray[1],lineInArray[3]};
						maxHeap1.add(strs);
						if(maxHeap1.size()>5) {
							maxHeap1.poll();
						}
						
						topplayers.put(lineInArray[1],l);

					}
				}
				if(Integer.parseInt(lineInArray[0])==2) {	
					if(Integer.parseInt(lineInArray[3])>game2_avg) {
						List<String> l= new ArrayList<>();
						l.add(lineInArray[0]);
						l.add(lineInArray[3]);
						String[] strs = {lineInArray[0],lineInArray[1],lineInArray[3]};
						maxHeap2.add(strs);
						if(maxHeap2.size()>5) {
							maxHeap2.poll();
						}
						topplayers.put(lineInArray[1],l);
					}
				}
				if(Integer.parseInt(lineInArray[0])==3) {
					if(Integer.parseInt(lineInArray[3])>game3_avg) {
						List<String> l= new ArrayList<>();
						l.add(lineInArray[0]);
						l.add(lineInArray[3]);
						String[] strs = {lineInArray[0],lineInArray[1],lineInArray[3]};
						maxHeap3.add(strs);
						if(maxHeap3.size()>5) {
							maxHeap3.poll();
						}
						topplayers.put(lineInArray[1],l);					
					}
				}
				if(Integer.parseInt(lineInArray[0])==4) {
					if(Integer.parseInt(lineInArray[3])>game4_avg) {
						List<String> l= new ArrayList<>();
						l.add(lineInArray[0]);
						l.add(lineInArray[3]);
						String[] strs = {lineInArray[0],lineInArray[1],lineInArray[3]};
						maxHeap4.add(strs);
						if(maxHeap4.size()>5) {
							maxHeap4.poll();
						}
						topplayers.put(lineInArray[1],l);					
					}
				}
				if(Integer.parseInt(lineInArray[0])==5) {
					if(Integer.parseInt(lineInArray[3])>game5_avg) {
						List<String> l= new ArrayList<>();
						l.add(lineInArray[0]);
						l.add(lineInArray[3]);
						String[] strs = {lineInArray[0],lineInArray[1],lineInArray[3]};
						maxHeap5.add(strs);
						if(maxHeap5.size()>5) {
							maxHeap5.poll();
						}
						topplayers.put(lineInArray[1],l);					
					}
				}
			}
			while(!maxHeap1.isEmpty()) {
				String s[] = maxHeap1.poll();
				
				System.out.print("game_id: "+s[0]+" player_id: "+s[1]+" points: "+s[2]);
				
				System.out.println("\n");
			}
			while(!maxHeap2.isEmpty()) {
				String s[] = maxHeap2.poll();
				
				System.out.print("game_id: "+s[0]+" player_id: "+s[1]+" points: "+s[2]);
				
				System.out.println("\n");
			}
			while(!maxHeap3.isEmpty()) {
				String s[] = maxHeap3.poll();
				
				System.out.print("game_id: "+s[0]+" player_id: "+s[1]+" points: "+s[2]);
				
				System.out.println("\n");
			}
			while(!maxHeap4.isEmpty()) {
				String s[] = maxHeap4.poll();
				
				System.out.print("game_id: "+s[0]+" player_id: "+s[1]+" points: "+s[2]);
				
				System.out.println("\n");
			}
			while(!maxHeap5.isEmpty()) {
				String s[] = maxHeap5.poll();
				
				System.out.print("game_id: "+s[0]+" player_id: "+s[1]+" points: "+s[2]);
				
				System.out.println("\n");
			}
			

		}
	}
}