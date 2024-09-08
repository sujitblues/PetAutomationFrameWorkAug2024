package api.endPoints;

public class Routes {
	
			public static String BaseUrl="https://petstore.swagger.io";
			//Create user
			public static String createUser=BaseUrl+"/v2/user";
			//Get user
			public static String getUser=BaseUrl+"/v2/user/{username}";
			//update user
			public static String updateUser=BaseUrl+"/v2/user/{username}";
			//Delete user
			public static String deleteUser=BaseUrl+"/v2/user/{username}";

			
			//Create pet
			public static String createPet=BaseUrl+"/v2/pet";
			//Get pet
			public static String getPet=BaseUrl+"/v2/pet/{petId}";
			//update pet
			public static String updatePet=BaseUrl+"/v2/pet/{petId}";
			//Delete pet
			public static String deletePet=BaseUrl+"/v2/pet/{petId}";
}
