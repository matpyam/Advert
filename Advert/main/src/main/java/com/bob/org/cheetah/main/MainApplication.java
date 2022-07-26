package com.bob.org.cheetah.main;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;


@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
		//READ JSON FROM FILE
		String abc = readFileFromResources("data.json");
		People p = jSONToObjeRecepients(abc);
		tryTest(p);
	}


	public static void tryTest(People p){

		try {
			String bigStr = "";
			List<String> result = new ArrayList<String>();

			for(int i =0;i< p.getRecipients().size(); i++){
				Users p1 = p.getRecipients().get(i);
				if ((i+1) == p.getRecipients().size()) continue;

					for (int j=1;j < p.getRecipients().size(); j++) {
						Users p2 = p.getRecipients().get(j);
						//always compare new list
						//need to clone list before compare
						//clone first
						List<String> taglist1 = new ArrayList<String>();
						taglist1.addAll(p1.getTags());
						
						//clone second
						List<String> taglist2 = new ArrayList<String>();
						taglist2.addAll(p2.getTags());

						//compare different id only
						//save if got >= 2 same elements
						if (p1.getId() != p2.getId()){
							taglist1.retainAll(taglist2);
							if(taglist1.size() >= 2) {
							// construst string to print
							//add into list
								bigStr += p1.getName() + "," + p2.getName() + "-" + taglist1 + " | ";
								String savestr = p1.getName() + "," + p2.getName() + "-" + taglist1 + " | ";
								result.add(savestr);
							}
						} 
					}	
			}
			//System.out.println(bigStr);

			System.out.println(result);
		} catch (Exception e) {
			//TODO: handle exception
			e.printStackTrace();
		}
	}

	public static String readFileFromResources(String filename) {
		try {
			URL resource = MainApplication.class.getClassLoader().getResource(filename);  
			byte[] bytes = Files.readAllBytes(Paths.get(resource.toURI()));  
			return new String(bytes);  
		} catch (Exception e) {
			//TODO: handle exception
		}
		return "";
	}
	
	public static People jSONToObjeRecepients(String jsonString) {
		try {
			Gson gson = new Gson();
			People people = gson.fromJson(jsonString, People.class);
    		return people;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}	
}
