package api.endpoints;

/* swagger url: https://petstore.swagger.io/
 * create user (Post): https://petstore.swagger.io/#/user/createUser
 * Get user (Get): https://petstore.swagger.io/#/user/getUserByName
 * Update user (Put) : https://petstore.swagger.io/#/user/updateUser
 * Delete user (Delete): https://petstore.swagger.io/#/user/deleteUser
 */

public class Routes {
 public static String base_url = "https://petstore.swagger.io/v2" ;
 
 
//user module
 public static String post_url = "base_url" + "/user";
 public static String get_url = "base_url" + "/user/{username}";
 public static String put_url = "base_url" + "/user/{username}";
 public static String delete_url = "base_url" + "/user/{username}";
 
 
 
 //pet module
 public static String addpet_url = "base_url" + "/pet";
 public static String updatepet_url = "base_url" + "/pet/{petname}";
 public static String deletepet_url = "base_url" + "/pet/{petid}";
 
 
 
}
