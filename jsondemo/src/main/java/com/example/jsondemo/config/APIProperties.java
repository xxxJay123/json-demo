package com.example.jsondemo.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.jsondemo.utils.Protocol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Component
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class APIProperties {

  @Value(value = "${api.jsonplaceholder.domain}")
  private String domain;

  @Value(value = "${api.jsonplaceholder.endpoints.users}")
  private String userEndpoint;

  @Value(value = "${api.jsonplaceholder.endpoints.posts}")
  private String postsEndpoint;

  @Value(value = "${api.jsonplaceholder.endpoints.comments}")
  private String commentsEndpoint;

  @Value(value = "${api.jsonplaceholder.endpoints.albums}")
  private String albumsEndpoint;

  @Value(value = "${api.jsonplaceholder.endpoints.photos}")
  private String photosEndpoint;

  @Value(value = "${api.jsonplaceholder.endpoints.todos}")
  private String todosEndpoint;


  public String getProperty(String property) {
    return getPropertyString(property);
  }

  public String getPropertyString(String property) {
    APIProperties properties = new APIProperties();
    String url = null;

    if (property == null || property.isEmpty()) {
      throw new IllegalArgumentException("Property cannot be null or empty");
    }

    if (property.equalsIgnoreCase("users")) {

      url = UriComponentsBuilder.newInstance()//
          .scheme("https")// .scheme("https")
          .host("jsonplaceholder.typicode.com")//
          .path("users")//
          .build()//
          .toUriString();//
      log.info("Properties class url:" + url);
      System.out.println(domain + userEndpoint);
      return url;

    } else if (property.equalsIgnoreCase("posts")) {
      url = UriComponentsBuilder.newInstance()//
          .scheme("https")// .scheme("https")
          .host("jsonplaceholder.typicode.com")//
          .path("posts")//
          .build()//
          .toUriString();//
      log.info("Properties class url:" + url);
      return url;
    }else if (property.equalsIgnoreCase("comments")) {
      url = UriComponentsBuilder.newInstance()//
          .scheme("https")// .scheme("https")
          .host("jsonplaceholder.typicode.com")//
          .path("comments")//
          .build()//
          .toUriString();//
      log.info("Properties class url:" + url);
      return url;
    }else if (property.equalsIgnoreCase("albums")) {
      url = UriComponentsBuilder.newInstance()//
          .scheme("https")// .scheme("https")
          .host("jsonplaceholder.typicode.com")//
          .path("albums")//
          .build()//
          .toUriString();//
      log.info("Properties class url:" + url);
      return url;
    }else if (property.equalsIgnoreCase("photos")) {
      url = UriComponentsBuilder.newInstance()//
          .scheme("https")// .scheme("https")
          .host("jsonplaceholder.typicode.com")//
          .path("photos")//
          .build()//
          .toUriString();//
      log.info("Properties class url:" + url);
      return url;
    }else if (property.equalsIgnoreCase("todos")) {
      url = UriComponentsBuilder.newInstance()//
          .scheme("https")// .scheme("https")
          .host("jsonplaceholder.typicode.com")//
          .path("todos")//
          .build()//
          .toUriString();//
      log.info("Properties class url:" + url);
      return url;
    }
       else {
      throw new IllegalArgumentException("Unsupported property: " + property);
    }
  }

  /*
   * case "posts": return domain + postsEndpoint; case "comments": return domain + commentsEndpoint; case "albums": return domain + albumsEndpoint; case "photos": return domain + photosEndpoint; case
   * "todos": return domain + todosEndpoint;
   */


}

