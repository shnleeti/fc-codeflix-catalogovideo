package com.shnleeti.catalogovideoapi.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class VideoTest {

    private static final DecimalFormat decimalFormat = new DecimalFormat("#.##");
    private static final UUID videoId = UUID.randomUUID();
    private static final String title = "Video Title";
    private static final String description = "Video Description";
    private static final Integer yearLaunched = 2021;
    private static final String rating = "Good";
    private static final Float duration = Float.valueOf(decimalFormat.format(180));

    @Test
    public void whenCreateVideo_thenAssertsThatFillFields(){

       
        Video video = new Video(videoId,title,description,yearLaunched,true);
        assertNotNull(video);
        assertNotNull(video.getId());
        assertEquals(videoId, video.getId());
        assertEquals(title, video.getTitle());
        assertEquals(description,video.getDescription());
        assertEquals(yearLaunched, video.getYearLaunched());
        assertTrue(video.getOpened());
        assertTrue(video.isOpened());
        assertNull(video.getRating());
        assertNull(video.getDuration());
        assertNotNull(video.getCategories());
        assertNotNull(video.getGenres());
        assertNotNull(video.getCastMembers());

        video = new Video(title,description,yearLaunched,true);
        assertNotNull(video);
        assertNotNull(video.getId());
        assertEquals(title, video.getTitle());
        assertEquals(description,video.getDescription());
        assertEquals(yearLaunched, video.getYearLaunched());
        assertTrue(video.getOpened());
        assertTrue(video.isOpened());
        assertNull(video.getRating());
        assertNull(video.getDuration());
        assertNotNull(video.getCategories());
        assertNotNull(video.getGenres());
        assertNotNull(video.getCastMembers());

        video = new Video(title,description,yearLaunched,true,rating,duration);
        assertNotNull(video);
        assertNotNull(video.getId());
        assertEquals(title, video.getTitle());
        assertEquals(description,video.getDescription());
        assertEquals(yearLaunched, video.getYearLaunched());
        assertTrue(video.getOpened());
        assertTrue(video.isOpened());
        assertEquals(rating, video.getRating());
        assertEquals(duration, video.getDuration());
        assertNotNull(video.getCategories());
        assertNotNull(video.getGenres());
        assertNotNull(video.getCastMembers());

        video = new Video(title,description,yearLaunched,duration);
        assertNotNull(video);
        assertNotNull(video.getId());
        assertEquals(title, video.getTitle());
        assertEquals(description,video.getDescription());
        assertEquals(yearLaunched, video.getYearLaunched());
        assertFalse(video.getOpened());
        assertFalse(video.isOpened());
        assertNull(video.getRating());
        assertEquals(duration, video.getDuration());
        assertNotNull(video.getCategories());
        assertNotNull(video.getGenres());
        assertNotNull(video.getCastMembers());

    }

    @Test
    public void whenSetValidCategoriesOrAddRemoveCategory_thenAssertsThatValid(){

        Video video = new Video(videoId,title,description,yearLaunched,true);
        List<Category> categories = new ArrayList<>();
        Category category = new Category("Category 1");
        Category category2 = new Category("Category 2");
        categories.add(category);
        video.setCategories(categories);

        assertTrue(video.getCategories().size() == 1);
        assertTrue(video.getCategories().contains(category));

        video.addCategory(category2);
        assertTrue(video.getCategories().size() == 2);
        assertTrue(video.getCategories().contains(category2));

        video.removeCategory(category);
        assertTrue(video.getCategories().size() == 1);
        assertFalse(video.getCategories().contains(category));

        video.removeCategory(category2);
        assertTrue(video.getCategories().size() == 0);
        assertFalse(video.getCategories().contains(category2));
    }

    @Test
    public void whenSetCategoriesNullOrAddRemoveCategoryNull_thenAssertsThatThrowIllegalArgumentException(){

        Video video = new Video(videoId,title,description,yearLaunched,true);
    
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            video.setCategories(null);
        });

        assertEquals("categories is marked non-null but is null", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            video.addCategory(null);
        });

        assertEquals("category is marked non-null but is null", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            video.removeCategory(null);
        });

        assertEquals("category is marked non-null but is null", exception.getMessage());

    }

    @Test
    public void whenSetValidGenresOrAddRemoveGenre_thenAssertsThatValid(){

        Video video = new Video(videoId,title,description,yearLaunched,true);
        List<Genre> genres = new ArrayList<>();
        Genre genre = new Genre("Genre 1");
        Genre genre2 = new Genre("Genre 2");
    
        genres.add(genre);
        video.setGenres(genres);

        assertTrue(video.getGenres().size() == 1);
        assertTrue(video.getGenres().contains(genre));

        video.addGenre(genre2);
        assertTrue(video.getGenres().size() == 2);
        assertTrue(video.getGenres().contains(genre2));

        video.removeGenre(genre);
        assertTrue(video.getGenres().size() == 1);
        assertFalse(video.getGenres().contains(genre));

        video.removeGenre(genre2);
        assertTrue(video.getGenres().size() == 0);
        assertFalse(video.getGenres().contains(genre2));

    }

    @Test
    public void whenSetGenresNullOrAddRemoveGenreNull_thenAssertsThatThrowIllegalArgumentException(){

        Video video = new Video(videoId,title,description,yearLaunched,true);
    
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            video.setGenres(null);
        });

        assertEquals("genres is marked non-null but is null", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            video.addGenre(null);
        });

        assertEquals("genre is marked non-null but is null", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            video.removeGenre(null);
        });

        assertEquals("genre is marked non-null but is null", exception.getMessage());

    }
    

    @Test
    public void whenSetValidCastMembersOrAddRemoveCastMember_thenAssertsThatValid(){

        Video video = new Video(videoId,title,description,yearLaunched,true);
        List<CastMember> castMembers= new ArrayList<>();
        CastMember castMember = new CastMember("CastMember1",CastMemberType.TYPE1);
        CastMember castMember2 = new CastMember("CastMember2",CastMemberType.TYPE2);
       
        castMembers.add(castMember);
        video.setCastMembers(castMembers);

        assertTrue(video.getCastMembers().size() == 1);
        assertTrue(video.getCastMembers().contains(castMember));

        video.addCastMembers(castMember2);
        assertTrue(video.getCastMembers().size() == 2);
        assertTrue(video.getCastMembers().contains(castMember2));

        video.removeCastMembers(castMember);
        assertTrue(video.getCastMembers().size() == 1);
        assertFalse(video.getCastMembers().contains(castMember));

        video.removeCastMembers(castMember2);
        assertTrue(video.getCastMembers().size() == 0);
        assertFalse(video.getCastMembers().contains(castMember2));

    }

    @Test
    public void whenSetCastMembersNullOrAddRemoveCastMemberNull_thenAssertsThatThrowIllegalArgumentException(){

        Video video = new Video(videoId,title,description,yearLaunched,true);
    
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            video.setCastMembers(null);
        });

        assertEquals("castMembers is marked non-null but is null", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            video.addCastMembers(null);
        });

        assertEquals("castMember is marked non-null but is null", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            video.removeCastMembers(null);
        });

        assertEquals("castMember is marked non-null but is null", exception.getMessage());

    }

    @Test
    public void whenSetNullOrBlankTitle_thenThrowsIllegalArgumentException(){

        // Video video = new Video(videoId,title,description,yearLaunched,true);
    
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Video video = new Video(videoId,null,description,yearLaunched,true);
        });

        assertEquals("title is marked non-null but is null", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            Video video = new Video(videoId,"",description,yearLaunched,true);
        });

        assertEquals("title is marked non-blank but is blank", exception.getMessage());
    }

    @Test
    public void whenSetYearLaunchedIsOlderThanCurrentYear_thenThrowsIllegalArgumentException(){

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Video video = new Video(videoId,title,description,Calendar.getInstance().get(Calendar.YEAR) + 1,true);
        });

        assertEquals("yearLaunched is greater than currentYear", exception.getMessage());

    }
}
