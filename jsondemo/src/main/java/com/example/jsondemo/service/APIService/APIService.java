package com.example.jsondemo.service.APIService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.print.DocFlavor.READER;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.jsondemo.config.APIProperties;
import com.example.jsondemo.entity.Album;
import com.example.jsondemo.entity.Comment;
import com.example.jsondemo.entity.Photo;
import com.example.jsondemo.entity.Post;
import com.example.jsondemo.entity.ToDos;
import com.example.jsondemo.entity.User;
import com.example.jsondemo.service.AlbumService;
import com.example.jsondemo.service.CommentService;
import com.example.jsondemo.service.PhotoService;
import com.example.jsondemo.service.PostService;
import com.example.jsondemo.service.TodoService;
import com.example.jsondemo.service.UserService;
import com.example.jsondemo.utils.EntityType;

@Service
public class APIService {

  private final UserService userService;
  private final PostService postService;
  private final CommentService commentService;
  private final AlbumService albumService;
  private final PhotoService photoService;
  private final TodoService todoService;


  public APIService(UserService userService, PostService postService,
      CommentService commentService, AlbumService albumService,
      PhotoService photoService, TodoService todoService) {
    this.userService = userService;
    this.postService = postService;
    this.commentService = commentService;
    this.albumService = albumService;
    this.photoService = photoService;
    this.todoService = todoService;
    // Initialize other service dependencies if needed
  }

  public List<?> fetchAndParseData(String apiName) {
    APIProperties properties = new APIProperties();
    String apiUrl = properties.getPropertyString(apiName);
    RestTemplate restTemplate = new RestTemplate();

    switch (apiName.toUpperCase()) {
      case "USER":
        User[] users = restTemplate.getForObject(apiUrl, User[].class);
        return Arrays.asList(users);
      case "POSTS":
        Post[] posts = restTemplate.getForObject(apiUrl, Post[].class);
        return Arrays.asList(posts);
      case "COMMENTS":
        Comment[] comments = restTemplate.getForObject(apiUrl, Comment[].class);
        return Arrays.asList(comments);
      case "ALBUMS":
        Album[] albums = restTemplate.getForObject(apiUrl, Album[].class);
        return Arrays.asList(albums);
      case "PHOTOS":
        Photo[] photos = restTemplate.getForObject(apiUrl, Photo[].class);
        return Arrays.asList(photos);
      case "TODOS":
        ToDos[] todos = restTemplate.getForObject(apiUrl, ToDos[].class);
        return Arrays.asList(todos);
      default:
        throw new IllegalArgumentException(
            "Unsupported entity type: " + apiName);
    }

  }



  public void saveEntities(String apiName, List<?> entities) {
    switch (apiName.toUpperCase()) {
      case "USERS":
        userService.saveAllUsers((List<User>) entities);
        break;
      case "POSTS":
        postService.saveAllPosts((List<Post>) entities);
        break;
      case "COMMENTS":
        commentService.saveAllComments((List<Comment>) entities);
        break;
      case "ALBUMS":
        albumService.saveAllAlbums((List<Album>) entities);
        break; // Add break statement here
      case "PHOTOS":
        photoService.saveAllPhotos((List<Photo>) entities);
        break; // Add break statement here
      case "TODOS":
        todoService.saveAllToDos((List<ToDos>) entities);
        break; // Add break statement here
      default:
        throw new IllegalArgumentException(
            "Unsupported entity type: " + apiName);
    }
  }
}

