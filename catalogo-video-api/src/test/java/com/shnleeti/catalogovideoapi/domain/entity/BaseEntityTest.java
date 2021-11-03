package com.shnleeti.catalogovideoapi.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
public class BaseEntityTest {

    private static final String validUUID = "0f14d0ab-9605-4a62-a9e4-5ed26688389b";
    
    @Test
    public void whenSetIdWithSuccess(){
        BaseEntity baseEntity = new BaseEntity();

        UUID uuid = UUID.randomUUID();
        baseEntity.setId(uuid);
        assertNotNull(baseEntity);
        assertEquals(baseEntity.getId(), uuid);
    }

    @Test
    public void whenSetIdThrowsIllegalArgumentException_themAssertionSucceds(){
        BaseEntity baseEntity = new BaseEntity();
    
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            baseEntity.setId(null);
        });

        String expectedMessage = "Id is marked non-null but is null";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenCallIsValidUUID_themAssertionSucceds(){
        BaseEntity baseEntity = new BaseEntity();

        assertTrue(baseEntity.isValidUUID(baseEntity.generateUUID().toString()));
        assertTrue(baseEntity.isValidUUID(UUID.randomUUID().toString()));
        assertTrue(baseEntity.isValidUUID(validUUID));
    }

    @Test
    public void whenCallIsValidUUID_themAssertionIsNotValid(){
        BaseEntity baseEntity = new BaseEntity();

        assertFalse(baseEntity.isValidUUID(null));
        assertFalse(baseEntity.isValidUUID("abc"));
          
    }
}
