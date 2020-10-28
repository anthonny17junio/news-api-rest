package com.news.api.news;

import com.news.api.news.controller.ApplicationPropertiesController;
import com.news.api.news.controller.FeedController;
import com.news.api.news.controller.ImageController;
import com.news.api.news.controller.NewController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApiApplicationTests {

	//Check all endpoints return 200 status
	@Autowired
	private ApplicationPropertiesController applicationPropertiesController;

	@Autowired
	private FeedController feedController;

	@Autowired
	private ImageController imageController;

	@Autowired
	private NewController newController;

	//FEEDS
	@Test
	void getAllFeeds() {
		feedController.getAll();
	}

	//NEWS
	@Test
	void getAllNews() {
		newController.getAll();
	}

	@Test
	void getNew() {
		newController.getNew(1L);
	}

	@Test
	void getNewsPaginatedOK() {
		newController.getAllPaginated(0, 1);
	}

	@Test
	void getNewsPaginatedKO() {
		//Throw error when try get pagination with 0 items
		Exception exception = assertThrows(Exception.class, () -> newController.getAllPaginated(0, 0));
		assertEquals(IllegalArgumentException.class, exception.getClass());
	}

	@Test
	void getNewsByFeed() {
		newController.getNewsByFeed(0L);
	}

	@Test
	void getNewsByFeedPaginatedOK() {
		newController.getNewsByFeedPaginated(0L, 0, 1);
	}

	@Test
	void getNewsByFeedPaginatedKO() {
		//Throw error when try get pagination with 0 items
		Exception exception = assertThrows(Exception.class,
				() -> newController.getNewsByFeedPaginated(0L, 0, 0));
		assertEquals(IllegalArgumentException.class, exception.getClass());
	}

	//IMAGES
	@Test
	void getImagesByNew() {
		imageController.getAllImages(0L);
	}

	//PROPERTIES
	@Test
	void getSecondsProperties() {
		assertTrue(applicationPropertiesController.getSeconds() > 0);
	}

	@Test
	void setSecondsPropertiesValueKO() {
		//Throw error when try set time == -1
		Exception exception = assertThrows(Exception.class, () -> applicationPropertiesController.setTime(-1));
		assertEquals(IllegalArgumentException.class, exception.getClass());
	}

	@Test
	void setSecondsPropertiesValueOK() {
		applicationPropertiesController.setTime(1);
	}
}
