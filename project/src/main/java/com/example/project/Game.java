package com.example.project;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.github.javafaker.Faker;
import com.opencsv.CSVWriter;
//Generating  random synthetic data for the fields game_id, player_id, played_date, points
public class Game {
	
	public static int createRandomIntBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

//	Generating dates in the month of August 2021 but not on Tuesdays
	public static LocalDate createRandomDate(int startYear, int endYear) {
		int day = createRandomIntBetween(1, 31);
		int month = 8;
		int year = createRandomIntBetween(startYear, endYear);

		if(LocalDate.of(year, month, day).getDayOfWeek()==DayOfWeek.TUESDAY) {
			return LocalDate.of(year, month, day+1);
		}

		return LocalDate.of(year, month, day);
	}
// Using Faker Library to generate data
	static Faker faker = new Faker();
	static List<String[]> data = new ArrayList<String[]>();

	public static void GenerateGame(int game_id, int number_of_players) {


		System.out.println("game_id "+"player_id "+"played_date "+"points");
		for(int i=0;i<number_of_players;i++) {
			System.out.println(game_id+"-"+faker.name().firstName()
					+"-"+faker.name().lastName()+"-"+createRandomDate(2022, 2022)
					+"-"+faker.number().numberBetween(75, 200));

			
			data.add(new String[] {Integer.toString(game_id),faker.name().firstName()
					+"-"+faker.name().lastName(),createRandomDate(2022, 2022).toString(),Integer.toString(faker.number().numberBetween(75, 200))});
		}


	}

	public static void main(String[] args) throws IOException {

		Map<Integer,Integer> game_map =  new HashMap<>();
		for(int i=1;i<=5;i++) {
			game_map.put(i,faker.number().numberBetween(75, 125));
		}
//		data.add(new String[] {"game_id","player_id","played_date","points"});
		for(Map.Entry<Integer, Integer> entry: game_map.entrySet()) {
			GenerateGame(entry.getKey(),entry.getValue());	
		}
//		writing the results to a csv file
		try (CSVWriter writer = new CSVWriter(new FileWriter("C:\\Users\\Sai Charan\\Desktop\\test.csv"))) {
            writer.writeAll(data);
        }
		System.out.println(game_map);
		
	}
	
}
