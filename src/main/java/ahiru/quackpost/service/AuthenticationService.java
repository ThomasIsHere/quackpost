package ahiru.quackpost.service;

import ahiru.quackpost.controller.auth.AuthenticationRequest;
import ahiru.quackpost.controller.auth.AuthenticationResponse;
import ahiru.quackpost.controller.auth.RegisterRequest;
import ahiru.quackpost.model.Role;
import ahiru.quackpost.model.Token;
import ahiru.quackpost.model.TokenType;
import ahiru.quackpost.model.User;
import ahiru.quackpost.repository.ITokenRepository;
import ahiru.quackpost.repository.IUserRepository;
import ahiru.quackpost.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final IUserRepository userRepository;
    private final ITokenRepository tokenRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var user = User.builder()
                .firstname(registerRequest.getFirstname())
                .lastname(registerRequest.getLastname())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();

        var savedUser = userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        saveUserToken(savedUser, jwtToken);

        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );

        var user = userRepository.findByEmail(authenticationRequest.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);

        saveUserToken(user, jwtToken);

        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user_id(user.getId())
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();

        tokenRepository.save(token);
    }
}
