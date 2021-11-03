package com.shnleeti.catalogovideoapi.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CategoryTests {

    private static final String validUUID = "0f14d0ab-9605-4a62-a9e4-5ed26688389b";
    private static final String expectedCategoryName = "Category";

    @Test
    public void createCategory() {
        Category entity = new Category(expectedCategoryName);
        assertNotNull(entity);
        assertEquals(entity.getName(),expectedCategoryName);
        assertTrue(entity.isValidUUID(entity.getId().toString()));

        entity = new Category();
        assertEquals(null, entity.getName());
        assertEquals(null, entity.getId());

        entity = new Category(UUID.fromString(validUUID));
        assertNotNull(entity.getId());
        assertTrue(entity.isValidUUID(entity.getId().toString()));

        entity = new Category(UUID.fromString(validUUID), expectedCategoryName);
        assertEquals(entity.getName(),expectedCategoryName);
        assertEquals(entity.getId(),UUID.fromString(validUUID));
        assertTrue(entity.isValidUUID(entity.getId().toString()));
    }

    @Test
    public void whenSetInvalidName_expectedThrowIllegalArgumentExceptio(){
        Category entity = new Category();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            entity.setName(null);
        });

        String expectedMessage = "Name is marked non-null but is null";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

        exception = assertThrows(IllegalArgumentException.class, () -> {
            entity.setName("");
        });

        expectedMessage = "Name is marked non-blank but is blank";
        actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));



    }
}
