# NEWS API REST
Spring + PostgreSQL + Maven

1) Create PostgreSQL database -> "script_db_news" file
2) Open "src/main/resources/application.properties" and modify according your PostgreSQL connection
3) Run application

# FEED
## Get all feeds
```
GET http://localhost:8080/feeds
```
# NEWS
## Get all news
```
GET http://localhost:8080/news
```
## Get new with id 1
```
GET http://localhost:8080/news/1
```
## Get news from all feeds with pagination (first page with 3 news)
```
GET http://localhost:8080/news/0/3
```
## Get all news from feed with id 1
```
GET http://localhost:8080/feeds/1/news
```
## Get news from feed with id 1 with pagination (first page with 3 news)
```
GET http://localhost:8080/feeds/1/news/0/3
```
# IMAGES
## Get all images from new with id 1
```
GET http://localhost:8080/news/1/images
```
# APPLICATION PROPERTIES
## Get time property (interval time in catch new news)
```
GET http://localhost:8080/properties/time
```

## Set time property (interval time in catch new news) to 10 seconds
```
PUT http://localhost:8080/properties/time/10
```
