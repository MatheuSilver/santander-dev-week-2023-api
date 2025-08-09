package me.dio.service;

import me.dio.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService extends CrudService<Long, User> {
    Page<User> findByFilters(String name, String email, Pageable pageable);
}
