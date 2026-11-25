package com.Project.MyStore.services;

import com.Project.MyStore.repositories.AppUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AppUserServiceTests {
    @Mock
    private AppUserRepository repo;

    @InjectMocks
    private AppUserService service;

    @Test
    void throwsWhenEmailIsNotFound() {
        when(repo.findByEmail("missing@example.com")).thenReturn(null);

        assertThrows(
                UsernameNotFoundException.class,
                () -> service.loadUserByUsername("missing@example.com")
        );
    }
}
