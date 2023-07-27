<center>
<h1> MUSIC STREAMING API SERVICE </h1>
</center>
<center>
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-3.0.5-brightgreen.svg" />
</a>
</center>
This is a Spring Boot project for listening online music.

---
<br>

## Framework Used
* Spring Boot

---
<br>

## Language Used
* Java

---
<br>

## Data Model

* User model
```
private Integer userId;
private String userFirstName;
private String userLastName;
private String userPhoneNumber;
private String userEmail;
private String userPassword;
private Role role;
private PlayList playList;
```
* Song model
```
rivate Long songId;
private String songName;
private String singer;
private String band;
private LocalDate releaseDate;
private Playlist playlist;

```
* Playlist model
```
private Long playListId;
private String playListName;
private List<Song> songs;
```

* Admin model
```
private Long adminId;
private String adminFirstName;
private String adminLastName;
private String adminEmail;
private String adminPassword;
```

### Validation

To validate the input we get from client, we've used validation annotations that are used to enforce specific constraints on the values of the variables. These constraints ensure that the data input by the user is of the correct format and meets certain criteria.

* @Valid - In Spring Framework, the @Valid annotation is used in conjunction with @PostMapping and @PutMapping annotations, which are used to handle POST and PUT requests, respectively. When used with @PostMapping or @PutMapping, the @Valid annotation is typically applied to a method parameter annotated with @RequestBody.

* @NotEmpty: This annotation is used to validate that the annotated field is not null or empty. 

* @NotNull: This annotation is used to validate that the annotated field is not null.

* @Pattern: It is used to validate that the code field matches the regular expression pattern
---
<br>

## Data Flow

1. The user at client side sends a request to the application through the API endpoints.
2. The API receives the request and sends it to the appropriate controller method.
3. The controller method makes a call to the method in service class.

4. The method in service class builds logic and retrieves or modifies data from the database, which is in turn given to controller class
5. The controller method returns a response to the API.
6. The API sends the response back to the user.

---

<br>


## API End Points (Event)
### User
```
1. @PostMapping("signup"): user for signup 
2. @PostMapping("signin"): used for signin 
```

### Admin
```
1. @PostMapping("signup"): admin for signup 
2. @PostMapping("signin"): admin for signin 
```

### Song
```
1. @PostMapping("/add/{adminEmail}/{token}"): add songs
2. @GetMapping("song"): get all songs
3. @DeleteMapping("delete/{adminEmail}/{token}id/{songId}")
4. @PutMapping("/update/{adminEmail}/{token}")
```

### Playlist
```
1. @PostMapping("add/{userEmail}/{token}")
2. @GetMapping("{userEmail}/{token}")
3. @DeleteMapping("/{playlistId}/{userEmail}/{token}")

```
---
## DataBase Used
* SQL database
```
We have used Persistent database to implement CRUD Operations.
```
---
<br>

## Project Summary
The Music Streaming API is a Spring Boot project written in Java that enables basic functionality for playing online music. This project is built using the Spring Boot framework. 
