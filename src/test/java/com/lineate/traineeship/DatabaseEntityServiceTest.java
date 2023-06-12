package com.lineate.traineeship;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DatabaseEntityServiceTest {
    private BaseEntityService databaseEntityService;
    private EntityRepository entityRepository;

    @BeforeEach
    void setUp() {
        entityRepository = mock(EntityRepository.class);
        databaseEntityService = ServiceFactory.createEntityService(entityRepository);
    }
    @Test
    void save() {
        Entity entity = new Entity("test");
        when(entityRepository.save(new Entity("test"))).thenReturn(true);
        boolean result = databaseEntityService.save(entity);
        assertThat(result).isEqualTo(entityRepository.save(entity));
    }


    @Test
    void getByName() {
        String name = "test";
        Entity entity = new Entity(name);
        when(entityRepository.getByName(name)).thenReturn(entity);
        Entity result = databaseEntityService.getByName(name);
        assertThat(result.getName()).isEqualTo(name);
    }



    @Test
    void delete() {
        Entity entity = new Entity("test");
        when(entityRepository.delete(entity)).thenReturn(true);
        boolean result = databaseEntityService.delete(entity);
        assertThat(result).isTrue();
    }
}