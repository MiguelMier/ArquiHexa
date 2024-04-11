package com.helloworld.examples.persistence.h2.repositories.users.update;

import com.helloworld.examples.models.User;
import com.helloworld.examples.port.out.users.update_contact_data.UpdateContactDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UpdateUserH2Repository implements UpdateContactDataRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public User getUserById(Long id) {
        String sql = "SELECT * FROM USUARIO WHERE ID = ?";
        User user = jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
        return user;
    }

    @Override
    public boolean updateUser(User user) {
        String sql = "UPDATE USUARIO SET name = ?, surname = ?, email = ?, phoneNumber=? WHERE id = ?";
        int rowsUpdated = jdbcTemplate.update(sql, user.getName(), user.getSurname(), user.getEmail(), user.getPhoneNumber(), user.getUserId());
        return rowsUpdated > 0;
    }


    public void deleteUser(Long userId) {
        int rowsUpdated = jdbcTemplate.update("DELETE FROM USUARIO WHERE ID = ? ", userId);
        if (rowsUpdated < 1) {
            throw new RuntimeException("User not found");
        }
    }
}
