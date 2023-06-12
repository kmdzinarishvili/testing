package com.lineate.traineeship;

public final class ServiceFactory {
    public static UserService createUserService() {
        return new UserServiceImpl();
    }

    public static BaseEntityService createEntityService() {
        return new InMemoryEntityService();
    }

    public static BaseEntityService createEntityService(EntityRepository entityRepository) {
        return new DatabaseEntityService(entityRepository);
    }
}
