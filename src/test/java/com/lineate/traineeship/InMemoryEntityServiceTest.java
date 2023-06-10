package com.lineate.traineeship;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;


class InMemoryEntityServiceTest {
    private InMemoryEntityService inMemoryEntityService;

    @BeforeEach
    void setUp() {
        //if I use ServiceFactory, I can't access these methods to test
        // it would have to return at least a BaseEntityService to test these functions
        inMemoryEntityService = new InMemoryEntityService();
    }

    @Test
    void save() {
        Entity entity = new Entity("name");
        boolean result = inMemoryEntityService.save(entity);
        assertThat(result).isTrue();
    }

    @Test
    void getByName() {
        String name = "name";
        Entity entity = new Entity(name);
        inMemoryEntityService.save(entity);
        Entity result = inMemoryEntityService.getByName(name);
        assertThat(result.getName()).isEqualTo(name);
    }



    @Test
    void delete() {
        String name = "name";
        Entity entity = new Entity(name);
        String name1 = "name1";
        Entity entity1 = new Entity(name1);
        inMemoryEntityService.save(entity);
        inMemoryEntityService.save(entity1);
        boolean result = inMemoryEntityService.delete(entity1);
        assertThat(result).isTrue();
    }
}