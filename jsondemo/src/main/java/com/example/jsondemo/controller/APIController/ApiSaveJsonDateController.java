package com.example.jsondemo.controller.APIController;

import org.hibernate.type.descriptor.java.ClassJavaType;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.jsondemo.config.APIProperties;
import com.example.jsondemo.entity.Comment;
import com.example.jsondemo.entity.Post;
import com.example.jsondemo.entity.User;
import com.example.jsondemo.service.CommentService;
import com.example.jsondemo.service.PostService;
import com.example.jsondemo.service.UserService;
import com.example.jsondemo.service.APIService.APIService;
import com.example.jsondemo.utils.EntityType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.Spring;
import com.example.jsondemo.exception.*;

@RestController
@RequestMapping("/api/sql")
@Slf4j
public class ApiSaveJsonDateController {
  private final String API_URL = "https://jsonplaceholder.typicode.com/users";
  private Logger logger =
      Logger.getLogger(ApiSaveJsonDateController.class.getName());


  private final String JPI_API_URL =
      "https://jsonplaceholder.typicode.com/users";

  private final APIService apiService;

  public ApiSaveJsonDateController(APIService apiService) {
    this.apiService = apiService;
  }



  /*
   * @JsonProperty private String jsonDataApi;
   */
  /*
   * @GetMapping("/fetch-data-and-save") public ResponseEntity<String> fetchDataAndSave(
   * 
   * @RequestParam("property") String apiName) {
   * 
   * try {
   * 
   * List<User> entities = jsonService.parseJsonFormAPI(apiName, User.class);
   * 
   * logger.info("Calling API {}" + entities.toString());
   * 
   * if (!entities.isEmpty()) { jsonService.saveEntities(entities); log.info("try1"); return ResponseEntity.ok("Saved list of entities"); } else { log.info("try2");
   * 
   * return ResponseEntity.ok("No entities to save"); }
   * 
   * } catch (Exception e) { log.info("try4");
   * 
   * return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR) .body("Error: " + e.getMessage()); } }
   */

  /*
   * @PostMapping("/alluser") public ResponseEntity<?> uploadAllUserDataToSQL(
   * 
   * @RequestParam("property") String property) {
   * 
   * 
   * // String url = UriComponentsBuilder // .fromHttpUrl(properties.getPropertyString("users")).scheme("https") // .build().toUriString(); // log.info("url: " + url); // RestTemplate restTemplate = new
   * RestTemplate(); // restTemplate.setUriTemplateHandler( // new DefaultUriBuilderFactory("https://api.example.com")); try {
   * 
   * APIProperties properties = new APIProperties();
   * 
   * String url = properties.getPropertyString(property); log.info("Controll url: " + url); RestTemplate restTemplate = new RestTemplate();
   * 
   * 
   * User[] allUsers = restTemplate.getForObject(url, User[].class);
   * 
   * assert allUsers != null; List<User> allUsersList = Arrays.asList(allUsers); userService.saveAllUsers(allUsersList);
   * 
   * return ResponseEntity .ok("Saved all users to SQL database" + allUsersList);
   * 
   * 
   * } catch (Exception e) { return ResponseEntity.internalServerError().body(e.getMessage()); } }
   */

  @PostMapping("/fetch-and-save/by")
  public ResponseEntity<String> fetchAndSaveData(
      @RequestParam("prop") String apiName
      ) {

    try {

      List<?> entities = apiService.fetchAndParseData(apiName);

      // Save entities
      apiService.saveEntities( apiName,entities);
      String entitiesAsString = convertEntitiesToString(entities);
      // Return entities in response body
      return ResponseEntity.ok("saved into db" +entitiesAsString);

    } catch (MissingApiException e) {
      // API not found error
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

    } catch (ApiException e) {
      // Handle generic API exception
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(e.getMessage());

    } catch (JsonParsingException e) {
      // Handle JSON parsing error
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

    } catch (InvalidEntityTypeException e) {
      // Handle invalid entity type
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

  }

  private String convertEntitiesToString(List<?> entities) {
    // Implement your logic to convert the list of entities to a String
    // This logic depends on the structure of your entities and how you want to represent them as a String
    // For example, you can use JSON serialization or any other format that suits your needs.
    // Here's a simple example using Jackson ObjectMapper to serialize the entities to JSON:
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.writeValueAsString(entities);
    } catch (JsonProcessingException e) {
      throw new JsonParsingException("Error converting entities to JSON");
    }
  }

}
// Save methods

