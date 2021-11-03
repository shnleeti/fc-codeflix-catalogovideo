package com.shnleeti.catalogovideoapi.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class GenreTest {

    private static final String genreName = "Genre test";
    private static final UUID genreUUID = UUID.randomUUID();
    private static List<Category> categories;

    @BeforeAll
    public static void init(){
        categories = new ArrayList<>();
        Category category1 = new Category("CategoryTest1");
        Category category2 = new Category("CategoryTest2");
        categories.add(category1);
        categories.add(category2);
    }

    @Test
    public void whenCreateGenre_themExpectedSuccess(){

        Genre genre =  new Genre();
        assertNotNull(genre);
        assertNull(genre.getName());
        assertNotNull(genre.getCategories());
        assertTrue(genre.getCategories().isEmpty());

        genre = new Genre(genreUUID,genreName);
        assertEquals(genreName, genre.getName());
        assertEquals(genreUUID, genre.getId());

        genre = new Genre(genreName,categories);
        assertNotNull(genre.getId());
        assertEquals(genreName,genre.getName());
        assertEquals(categories, genre.getCategories());

        genre = new Genre(genreUUID,genreName,categories);
        assertEquals(genreName, genre.getName());
        assertEquals(genreUUID, genre.getId());
        assertEquals(categories, genre.getCategories());


    }

    @Test
    public void whenSetGenreName_thenAssertionNameIsValidOrThrowsIllegalArgumentsException(){
        Genre genre = new Genre();

        genre.setName(genreName);
        assertEquals(genreName, genre.getName());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            genre.setName(null);
        });
        assertEquals("Name is marked non-null but is null", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            genre.setName("");
        });
        assertEquals("Name is marked non-blank but is blank", exception.getMessage());
        

    }

    @Test
    public void whenSetCategories_thenAssertionIsValidOrThrowsIllegalArgumentsException(){
        Genre genre = new Genre();
        
        genre.setCategories(categories);
        assertEquals(categories, genre.getCategories());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            genre.setCategories(null);
        });

        assertEquals("Categories is marked non-null but is null", exception.getMessage());

    }

    @Test
    public void whenAddCategories_thenAssertionIsValidOrThrowsIllegalArgumentsException(){
        Genre genre = new Genre();
        
        genre.setCategories(categories);
        
        assertEquals(categories, genre.getCategories());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            genre.setCategories(null);
        });

        assertEquals("Categories is marked non-null but is null", exception.getMessage());

    }

    @Test
    public void whenAddRemoveCategories_thenAssertThatIsValid(){
        Genre genre = new Genre("Genre whenAddRemoveCategories");
        assertTrue(genre.getCategories().isEmpty());
        
        Category category = new Category("Category to stay");
        Category categoryToRemove = new Category("Category do remove");
        
        genre.addCategory(category);
        assertTrue(genre.getCategories().contains(category));
        assertTrue(genre.getCategories().size() == 1);

        genre.addCategory(categoryToRemove);
        assertTrue(genre.getCategories().contains(category));
        assertTrue(genre.getCategories().contains(categoryToRemove));
        assertTrue(genre.getCategories().size() == 2);

        genre.removeCategory(categoryToRemove);
        assertTrue(genre.getCategories().contains(category));
        assertFalse(genre.getCategories().contains(categoryToRemove));
        assertTrue(genre.getCategories().size() == 1);

    }

    @Test
    public void whenAddRemoveCategories_thenAssertionThatThrowsIllegalArgumentsException(){
        Genre genre = new Genre("Genre whenAddRemoveCategories");
        assertTrue(genre.getCategories().isEmpty());
        
        Category category = new Category("Category to stay");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            genre.addCategory(null);
        });
       
        assertTrue(genre.getCategories().size() == 0);
        assertEquals("Category is marked non-null but is null", exception.getMessage());

        genre.addCategory(category);
        exception = assertThrows(IllegalArgumentException.class, () -> {
            genre.removeCategory(null);
        });
       
        assertTrue(genre.getCategories().size() == 1);
        assertEquals("Category is marked non-null but is null", exception.getMessage());



        


    }

    
}
