package ahiru.quackpost.service;

import ahiru.quackpost.controller.auth.AuthenticationRequest;
import ahiru.quackpost.controller.auth.AuthenticationResponse;
import ahiru.quackpost.controller.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        return null;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        return null;
    }
}
