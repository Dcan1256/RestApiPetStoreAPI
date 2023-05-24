package api.endpoints;

import java.util.ResourceBundle;

/**
 * Swagger URI --> https://petstore.swagger.io/v2
 *
 * Create User (POST) --> https://petstore.swagger.io/v2/user
 * Get User (GET) --> https://petstore.swagger.io/v2/user/{username}
 * Update User (PUT) --> https://petstore.swagger.io/v2/user/{username}
 * Delete User (DELETE) --> https://petstore.swagger.io/v2/user/{username}
 */
public class Routes {

    public static String base_uri="https://petstore.swagger.io/v2";
    //User Module
    public static String post_url=base_uri+"/user";
    public static String get_url=base_uri+"/user/{username}";
    public static String put_url=base_uri+"/user/{username}";
    public static String delete_url=base_uri+"/user/{username}";

    //Store Module
        // Here you will create Store Module URL's

    //Pet Module
        // Here you will create Pet module URL's
}
