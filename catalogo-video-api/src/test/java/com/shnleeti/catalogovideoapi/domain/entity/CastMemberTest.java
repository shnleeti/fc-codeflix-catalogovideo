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
public class CastMemberTest {


    @Test
    public void whenCreateCastMembers_themAssertsthatok(){

        UUID uuid = UUID.randomUUID();
        String castName = "CastMemberTest";


        CastMember castMember = new CastMember(castName,CastMemberType.TYPE1);

        assertNotNull(castMember);
        assertNotNull(castMember.getId());
        assertTrue(castMember.isValidUUID(castMember.getId().toString()));
        assertEquals(castName, castMember.getName());
        assertEquals(CastMemberType.TYPE1, castMember.getType());
        assertEquals(1, castMember.getType().getType());

        castMember = new CastMember(uuid,castName,CastMemberType.TYPE2);

        assertNotNull(castMember);
        assertEquals(uuid, castMember.getId());
        assertEquals(castName, castMember.getName());
        assertEquals(CastMemberType.TYPE2, castMember.getType());
        assertEquals(2, castMember.getType().getType());

    }


    @Test
    public void whenSetNameOrTypeCastMembers_themAssertsThatsOk(){

        String castName = "CastMemberTestSetters";
        String castNameChanged = "CastMemberTestChanged";


        CastMember castMember = new CastMember(castName,CastMemberType.TYPE1);
        assertEquals(castName, castMember.getName());
        assertEquals(CastMemberType.TYPE1, castMember.getType());

        castMember.setName(castNameChanged);
        castMember.setType(CastMemberType.TYPE2);

        assertEquals(castNameChanged, castMember.getName());
        assertEquals(CastMemberType.TYPE2, castMember.getType());


    }

    @Test
    public void whenSetInvalidNameOrTypeCastMembers_themAssertsThatsThrowsIllegalArgumentsException(){


        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CastMember castMember = new CastMember(null,CastMemberType.TYPE1);
        });
        assertEquals("Name is marked non-null but is null", exception.getMessage());
       
        exception = assertThrows(IllegalArgumentException.class, () -> {
            CastMember castMember = new CastMember("",CastMemberType.TYPE1);
        });
        assertEquals("Name is marked non-bank but is blank", exception.getMessage());


        exception = assertThrows(IllegalArgumentException.class, () -> {
            CastMember castMember = new CastMember("Teste1",null);
        });
        assertEquals("Type is marked non-null but is null", exception.getMessage());

    }


}
